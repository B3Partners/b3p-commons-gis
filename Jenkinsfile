timestamps {

    properties([
        [$class: 'jenkins.model.BuildDiscarderProperty', strategy: [$class: 'LogRotator',
            artifactDaysToKeepStr: '8',
            artifactNumToKeepStr: '3',
            daysToKeepStr: '15',
            numToKeepStr: '5']
        ]]);

    final def jdks = ['OpenJDK11', 'JDK8']

    node {
        jdks.eachWithIndex { jdk, indexOfJdk ->
            final String jdkTestName = jdk.toString()

            withEnv(["JAVA_HOME=${ tool jdkTestName }", "PATH+MAVEN=${tool 'Maven CURRENT'}/bin:${env.JAVA_HOME}/bin"]) {

                stage('Prepare') {
                    checkout scm
                }

                stage('Build') {
                    echo "Building branch: ${env.BRANCH_NAME}"
                    sh "mvn install -B -V -e -fae -q --global-toolchains .jenkins/toolchains.xml"
                }

                stage('Test') {
                    echo "Running unit tests"
                    sh "mvn -e test -B --global-toolchains .jenkins/toolchains.xml"
                }

                if (jdkTestName == 'OpenJDK11') {
                    stage("cleanup Java 11 packages") {
                        echo "Verwijder de Java 11 build artifacts uit lokale repo"
                        sh "mvn build-helper:remove-project-artifact"
                    }
                }
            }
        }

        withEnv(["JAVA_HOME=${ tool 'JDK8' }", "PATH+MAVEN=${tool 'Maven CURRENT'}/bin:${env.JAVA_HOME}/bin"]) {
            stage('Publish Test Results') {
                junit allowEmptyResults: true, testResults: '**/target/surefire-reports/TEST-*.xml, **/target/failsafe-reports/TEST-*.xml'
            }

            stage('OWASP Dependency Check') {
                echo "Uitvoeren OWASP dependency check"
                sh "mvn org.owasp:dependency-check-maven:check"
                dependencyCheckPublisher failedNewCritical: 1, unstableNewHigh: 1, unstableNewLow: 1, unstableNewMedium: 1
            }
        }
    }
}

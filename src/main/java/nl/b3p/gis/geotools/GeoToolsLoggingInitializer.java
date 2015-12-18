/**
 * $Id$
 */

package nl.b3p.gis.geotools;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.geotools.util.logging.Logging;

/**
 * Configureer in web.xml als:
    <listener>
        <listener-class>nl.b3p.gis.geotools.GeoToolsLoggingInitializer</listener-class>
    </listener>
 *
 * Voorbeeld log4j.properties:
log4j.logger.org.geotools=WARN
log4j.logger.org.geotools.data.wfs=ERROR
log4j.logger.org.geotools.factory=ERROR
 */
public class GeoToolsLoggingInitializer implements ServletContextListener{
    private static final Log log = LogFactory.getLog(GeoToolsLoggingInitializer.class);
    public void contextInitialized(ServletContextEvent sce) {
        log.info("Setting up log4j fot geotools");
        try{
            Logging.ALL.setLoggerFactory("org.geotools.util.logging.Log4JLoggerFactory");
        }catch (Exception e){
            log.error("While setting log4j for geotools",e);
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        
    }
    
}

/**
 * $Id$
 */
package nl.b3p.gis.geotools;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.geotools.factory.GeoTools;
import org.geotools.util.logging.Logging;

/**
 * Configureer in web.xml als: <br> {@code
 * <listener>
 * <listener-class>nl.b3p.gis.geotools.GeoToolsLoggingInitializer</listener-class>
 * </listener>
 * }
 * <br>
 * Voorbeeld log4j.properties: <br> {@code
 * log4j.logger.org.geotools=WARN
 * log4j.logger.org.geotools.data.wfs=ERROR
 * log4j.logger.org.geotools.factory=ERROR
 * }
 */
public class GeoToolsLoggingInitializer implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        try {
            GeoTools.init();
            Logging.ALL.setLoggerFactory("org.geotools.util.logging.Log4JLoggerFactory");
        } catch (ClassNotFoundException | IllegalArgumentException e) {
            sce.getServletContext().log(e, "Omzetten GeoTools logger is mislukt.");
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        org.geotools.util.WeakCollectionCleaner.DEFAULT.exit();
    }

}

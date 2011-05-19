/*
 * $Id$
 */

package nl.b3p.gis.geotools;

import it.geosolutions.imageio.gdalframework.GDALUtilities;
import java.lang.reflect.Field;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Make sure System.loadLibrary("gdaljni") is only called once, even if a
 * webapplication is reloaded and GDALUtilities.init is reset to false
 *
 * WARNING: HACK
 *
 * Probably requires a security manager permission
 *
 * @author matthijsln
 */
public class GDALLoaderServlet extends HttpServlet {

    private static final String SYSTEM_PROPERTY_NAME = GDALLoaderServlet.class.getName() + ".GDAL_LOADED";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        String context = null;

        try {
            if(!"true".equals(System.getProperty(SYSTEM_PROPERTY_NAME))) {
                context = "calling GDALUtilities.loadGDAL()";
                config.getServletContext().log("GDAL native library not loaded for this JVM, calling GDALUtilities.loadGDAL()");

                GDALUtilities.loadGDAL();

                System.setProperty(SYSTEM_PROPERTY_NAME, "true");
            } else {
                context = "setting GDALUtilities.init and GDALUtilities.properties to true using reflection (requires security manager permission)" ;

                config.getServletContext().log("GDAL native library was already loaded for this JVM, setting GDALUtilities' init and available properties to true");

                Field init = GDALUtilities.class.getDeclaredField("init");
                init.setAccessible(true);
                init.setBoolean(null, true);
                Field available = GDALUtilities.class.getDeclaredField("available");
                available.setAccessible(true);
                available.setBoolean(null, true);

                config.getServletContext().log("GDALUtilities properies set");
            }
            boolean isAvailable = GDALUtilities.isGDALAvailable();
            config.getServletContext().log("GDALUtilities.isAvailable(): " + isAvailable);
        } catch (Exception e) {
            throw new ServletException("Exception " + context + ": " + e.getClass() + ": " + e.getMessage(), e);
        }
    }

    @Override
    public String getServletInfo() {
        return "GDALLoaderServlet; loaded=" + "true".equals(System.getProperty(SYSTEM_PROPERTY_NAME));
    }
}

package nl.b3p.ogc.sld;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Boy de Wit
 */
public class SldWriter {

    private static final Log logFile = LogFactory.getLog(SldWriter.class);

    public String createNamedLayerStringForSld(SldUserStyle[] userStyles, String namedLayerName) {
        String xml = "";

        if (userStyles.length < 1) {
            return xml;
        }

        xml += "<sld:NamedLayer>";
        xml += "<sld:Name>" + namedLayerName + "</sld:Name>";

        for (int i = 0; i < userStyles.length; i++) {
            SldUserStyle sldUserStyle = userStyles[i];

            xml += sldUserStyle.getSldPart();
        }

        xml += "</sld:NamedLayer>";

        return xml;
    }

    public void createSld(String xmlPart, HttpServletResponse response) throws IOException {
        String xml = createSldString(xmlPart);

        PrintWriter writer = response.getWriter();
        try {            
            String filename = "test.xml";
            String mimeType = "application/xml";

            response.setContentType(mimeType);
            response.setHeader("Content-Disposition", "attachment; filename=" + filename);

            writer.write(xml);
            writer.flush();
        } catch (Exception ex) {
            logFile.error("Fout tijdens maken sld: ", ex);
        } finally {
            writer.close();
        }
    }

    private String createSldString(String xmlPart) {
        String xml = "";

        xml += getSldHeader();
        xml += xmlPart;
        xml += getSldFooter();

        return xml;
    }

    private String getSldHeader() {
        return "<sld:StyledLayerDescriptor"
                + " xmlns=\"http://www.opengis.net/sld\""
                + " xmlns:ogc=\"http://www.opengis.net/ogc\""
                + " xmlns:xlink=\"http://www.w3.org/1999/xlink\""
                + " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""
                + " xsi:schemaLocation=\"http://www.opengis.net/sld http://schemas.opengis.net/sld/1.0.0/StyledLayerDescriptor.xsd\""
                + " version=\"1.0.0\""
                + ">";
    }

    private String getSldFooter() {
        return "</sld:StyledLayerDescriptor>";
    }
}

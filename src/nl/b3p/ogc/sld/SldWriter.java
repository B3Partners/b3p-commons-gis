package nl.b3p.ogc.sld;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.xpath.XPathExpressionException;
import nl.b3p.wms.capabilities.Style;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;

/**
 *
 * @author Boy de Wit
 */
public class SldWriter {

    private static final Log logFile = LogFactory.getLog(SldWriter.class);

    public String createNamedLayerStringForSld(List<SldUserStyle> userStyles, String namedLayerName) {
        String xml = "";

        if (userStyles.size() < 1) {
            return xml;
        }

        xml += "<NamedLayer>";
        xml += "<Name>" + namedLayerName + "</Name>";

        for (SldUserStyle sldUserStyle : userStyles) {
            xml += sldUserStyle.getSldPart();
        }

        xml += "</NamedLayer>";

        return xml;
    }

    public String createSLDWithKBStyles(List<Style> kbStyles) throws UnsupportedEncodingException, IOException, XPathExpressionException, Exception{        
        StringBuffer result = new StringBuffer();
        result.append(getSldHeader());
        for (Style kbStyle : kbStyles){
            List<SldUserStyle> sldStyles= new ArrayList<SldUserStyle>();
            Document doc=SldReader.getDocument(kbStyle.getSldPart(),"UTF-8");
            sldStyles.add(new SldUserStyle(doc.getDocumentElement()));
            String namedLayer=createNamedLayerStringForSld(sldStyles,kbStyle.getLayer().getName());
            result.append(namedLayer);
        }
        result.append(getSldFooter());        
        return result.toString();
    }
    
    public String createSLD(List<SldNamedLayer> namedLayers){
        StringBuffer xml = new StringBuffer();
        for (SldNamedLayer snl : namedLayers){
            //xml.append(createNamedLayerStringForSld(snl.getUserStyles()));
            xml.append(snl.getSldPart());
        }
        return createSldString(xml.toString());
    }
    /*public void createSld(String xmlPart, HttpServletResponse response) throws IOException {
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
    }*/

    private String createSldString(String xmlPart) {
        String xml = "";

        xml += getSldHeader();
        xml += xmlPart;
        xml += getSldFooter();

        return xml;
    }

    private String getSldHeader() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<StyledLayerDescriptor"
                + " xmlns=\"http://www.opengis.net/sld\""
                + " xmlns:ogc=\"http://www.opengis.net/ogc\""
                + " xmlns:xlink=\"http://www.w3.org/1999/xlink\""
                + " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""
                + " xsi:schemaLocation=\"http://www.opengis.net/sld http://schemas.opengis.net/sld/1.0.0/StyledLayerDescriptor.xsd\""
                + " version=\"1.0.0\""
                + ">";
    }

    private String getSldFooter() {
        return "</StyledLayerDescriptor>";
    }

}

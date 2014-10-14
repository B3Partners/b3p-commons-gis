package nl.b3p.ogc.sld;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.xpath.XPathExpressionException;
import nl.b3p.commons.xml.DocumentHelper;
import nl.b3p.wms.capabilities.Style;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author Boy de Wit
 */
public class SldWriter {

    private static final Log logFile = LogFactory.getLog(SldWriter.class);

    public List<SldNamedLayer> createNamedLayersWithKBStyles(List<Style> kbStyles) throws UnsupportedEncodingException, IOException, XPathExpressionException, Exception{        
        List<SldNamedLayer> namedLayers= new ArrayList<SldNamedLayer>();
        for (Style kbStyle : kbStyles){
            List<SldNode> sldStyles= new ArrayList<SldNode>();            
            if (kbStyle.getSldConstraints()!=null){
                Document docConstriant=SldReader.getDocument(kbStyle.getSldConstraints(),"UTF-8");
                sldStyles.add(new SldLayerFeatureConstraints(docConstriant.getDocumentElement()));                
            }
            Document doc=SldReader.getDocument(kbStyle.getSldPart(),"UTF-8");
            String nodeName = doc.getDocumentElement().getNodeName();
            if (nodeName.toLowerCase().indexOf("namedstyle")!=-1){
                sldStyles.add(new SldNamedStyle(doc.getDocumentElement()));
            }else{
                sldStyles.add(new SldUserStyle(doc.getDocumentElement()));
            }
            SldNamedLayer snl = new SldNamedLayer(sldStyles,kbStyle.getLayer().getName());
            namedLayers.add(snl);
        }        
        return namedLayers;
    }

    public String createSLD(List<SldNamedLayer> namedLayers) throws Exception{
        return createSLD(namedLayers, "1.1.0");
    }

    public String createSLD(List<SldNamedLayer> namedLayers, String version) throws Exception{
        Document sldDoc = SldReader.getDocument(SldNode.getSldNodeString(version), "UTF-8");
        for (SldNamedLayer snl : namedLayers){
            Node snlNode = snl.getNode();
            Node importedNode = sldDoc.importNode(snlNode, true);
            sldDoc.getFirstChild().appendChild(importedNode);
        }
        return DocumentHelper.document2String(sldDoc);
    }
}

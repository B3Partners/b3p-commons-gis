/*
 * B3pGMLReader.java
 *
 * Created on 9 oktober 2007, 13:31
 *
 * Autor: Roy
 */

package nl.b3p.wfs.readers;

import com.vividsolutions.jump.feature.FeatureCollection;
import com.vividsolutions.jump.feature.FeatureDataset;
import com.vividsolutions.jump.io.GMLInputTemplate;
import com.vividsolutions.jump.io.GMLReader;
import com.vividsolutions.jump.io.ParseException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Roy
 */
public class B3pGMLReader extends GMLReader{
    
    /** Creates a new instance of B3pGMLReader */
    public B3pGMLReader() {
        super();
    }
    /*
     *
     */
    public FeatureCollection readWFSUrl(String wfsGetFeatureUrl) throws MalformedURLException, IOException, ParseException, Exception{
        URL url = new URL(wfsGetFeatureUrl);
        URLConnection conn=url.openConnection();
        InputStreamReader isr=new InputStreamReader(conn.getInputStream());                
        String template="<?xml version='1.0' encoding='UTF-8'?><JCSGMLInputTemplate>"+
                "<CollectionElement>wfs:FeatureCollection</CollectionElement>" +
                "<FeatureElement>gml:featureMember</FeatureElement>" +
                "<GeometryElement>ms:msGeometry</GeometryElement>" +
                "<ColumnDefinitions>" +
                "<column><name>ts</name><type>STRING</type><valueelement elementname=\"ms:ts\"/><valuelocation position=\"body\"/></column>" +
                "<column><name>ts_naam</name><type>STRING</type><valueelement elementname=\"ms:ts_naam\"/><valuelocation position=\"body\"/></column>" +
                "</ColumnDefinitions>" +
                "</JCSGMLInputTemplate>";
        //GMLInputTemplate git = createGMLInputTemplateFromWFS("");
        GMLInputTemplate git = new GMLInputTemplate();
        git.load(new StringReader(template));
        setInputTemplate(git);
        FeatureCollection fcAll=read(isr);
        isr.close();
        return fcAll;
    }
    /**/
   /* public GMLInputTemplate createGMLInputTemplateFromWFS(String wfsDescribeFeatureType){
                
    }*/
    
}

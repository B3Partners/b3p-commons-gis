/*
 * B3P Commons GIS is a library with commonly used classes for OGC
 * reading and writing. Included are wms, wfs, gml, csv and other
 * general helper classes and extensions.
 *
 * Copyright 2005 - 2008 B3Partners BV
 * 
 * This file is part of B3P Commons GIS.
 * 
 * B3P Commons GIS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * B3P Commons GIS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with B3P Commons GIS.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * WFSTransactionResponse.java
 *
 * Created on May 16, 2008, 9:32 AM
 *
 * Vergelijkbare klasse als OGCRequest.java maar dan om de response mee te verwerken die
 * de serviceprviders stuurt na een request.
 */
package nl.b3p.ogc.utils;

import java.util.List;
import org.exolab.castor.xml.Unmarshaller;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author Chris
 */
public class WFSTransactionResponse extends OGCResponse implements OGCConstants {

    private nl.b3p.xml.wfs.v100.transaction.TransactionResult newTransactionResponseV100;
    private nl.b3p.xml.wfs.v110.TransactionResponse newTransactionResponseV110;

    
     public void rebuildResponse(Document doc, OGCRequest request, String prefix) throws Exception {
        Element element = (Element) doc.getDocumentElement();
        this.httpHost = request.getUrlWithNonOGCparams();
        findNameSpace(doc);
        Unmarshaller um;
        Object o;
 
        version = request.getFinalVersion();

        if (version.equalsIgnoreCase(OGCConstants.WFS_VERSION_100)) {
            um = new Unmarshaller(nl.b3p.xml.wfs.v100.transaction.TransactionResult.class);
            o = um.unmarshal(element);
            nl.b3p.xml.wfs.v100.transaction.TransactionResult transactionResponse = (nl.b3p.xml.wfs.v100.transaction.TransactionResult) o;

            newTransactionResponseV100 = replaceTransactionResponseV100Url(transactionResponse, prefix);
        } else {
            um = new Unmarshaller(nl.b3p.xml.wfs.v110.TransactionResponse.class);
            o = um.unmarshal(element);
            nl.b3p.xml.wfs.v110.TransactionResponse transactionResponse = (nl.b3p.xml.wfs.v110.TransactionResponse) o;

            newTransactionResponseV110 = replaceTransactionResponseV110Url(transactionResponse, prefix);
        }
        
        setUsableResponse(true);
    }

    public nl.b3p.xml.wfs.v100.transaction.TransactionResult replaceTransactionResponseV100Url(nl.b3p.xml.wfs.v100.transaction.TransactionResult transactionResponse, String prefix) {
        /* Niet helemaal duidelijk of er aan de respons xml nog wat moet gebeuren */
        return transactionResponse;
    }

    public nl.b3p.xml.wfs.v110.TransactionResponse replaceTransactionResponseV110Url(nl.b3p.xml.wfs.v110.TransactionResponse transactionResponse, String prefix) {
        /* Niet helemaal duidelijk of er aan de respons xml nog wat moet gebeuren */
        return transactionResponse;
    }

    public String getResponseBody(List<SpLayerSummary> layers, OGCRequest ogcrequest, String encoding) {
        Object castorObject = null;
        
        if (!this.isUsableResponse()) {
            if (this.hasWfsV100ErrorResponse()) {
                return this.getWfsV100ErrorResponseBody(encoding);
            } else if (this.hasOwsV100ErrorResponse()) {
                return this.getOwsV100ErrorResponseBody(encoding);
            } else {
                throw new UnsupportedOperationException("Failed to get suitable response! ");
            }
        }
        if (this.hasWfsV100ErrorResponse()) {
            logErrorResponse(encoding);
        }

        if (version.equals(OGCConstants.WFS_VERSION_100)) {
            castorObject = newTransactionResponseV100;
        } else {
            castorObject = newTransactionResponseV110;
        }
        return marshalObject(castorObject, encoding);
    }


}

/*
 * Transaction.java
 *
 * Created on July 4, 2008, 4:13 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package nl.b3p.xml.wfs;

import nl.b3p.xml.wfs.v110.TransactionTypeChoice;
import nl.b3p.xml.wfs.v110.types.AllSomeType;

/**
 *
 * @author Jytte
 */
public interface Transaction {
    public boolean isValid();
    public void validate()throws org.exolab.castor.xml.ValidationException;
    void setService(java.lang.String service);
    void setVersion(java.lang.String version);
    void setHandle(String string);
    void setLockId(String string);
    void setReleaseAction(AllSomeType releaseAction);
    void addTransactionTypeChoice(TransactionTypeChoice ttc);
}

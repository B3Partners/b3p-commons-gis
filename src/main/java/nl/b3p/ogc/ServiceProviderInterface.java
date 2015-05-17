
package nl.b3p.ogc;

import java.util.Date;

/**
 *
 * @author Chris
 */
public interface ServiceProviderInterface {
    public Integer getId();
    public String getAbbr();
    public String getName();
    public String getTitle();
    public String getGivenName();
    public String getUrl();
    public String getType();
    public Date getUpdatedDate();
}

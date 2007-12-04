/*
 * PricingPlan.java
 *
 * Created on November 29, 2007, 4:29 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package nl.b3p.wms.capabilities;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Chris Kramer
 */
public class LayerPricing {
    
    private static int PAY_PER_REQUEST = 0;
    private Integer id;
    private int planType;
    private Date validFrom;
    private Date validUntil;
    private Date creationDate;
    private BigDecimal unitPrice;
    private Layer layer;
    
    public LayerPricing() {
        setPlanType(getPAY_PER_REQUEST());
    }
    public LayerPricing(Layer layer) {
        this();
        this.setLayer(layer);
    }
    
    public int getPlanType() {
        return planType;
    }
    
    public void setPlanType(int planType) {
        this.planType = planType;
    }
    
    public Date getValidFrom() {
        return validFrom;
    }
    
    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }
    
    public Date getValidUntil() {
        return validUntil;
    }
    
    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }
    
    public Date getCreationDate() {
        return creationDate;
    }
    
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
    
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    public Layer getLayer() {
        return layer;
    }
    
    public void setLayer(Layer layer) {
        this.layer = layer;
    }
    
    public static int getPAY_PER_REQUEST() {
        return PAY_PER_REQUEST;
    }
    
    public static void setPAY_PER_REQUEST(int aPAY_PER_REQUEST) {
        PAY_PER_REQUEST = aPAY_PER_REQUEST;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    
    
    
    
    
    
    
}

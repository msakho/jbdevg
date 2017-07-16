package com.beosbank.jbdevg.brms;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class Promotion implements java.io.Serializable
{

   static final long serialVersionUID = 1L;

   @org.kie.api.definition.type.Label("Promotion Identifier")
   private java.lang.Long promoId;
   @org.kie.api.definition.type.Label("Promotion Description")
   private java.lang.String description;
   @org.kie.api.definition.type.Label("Start date ")
   private java.util.Date beginDate;
   @org.kie.api.definition.type.Label("End Date")
   private java.util.Date endDate;
   @org.kie.api.definition.type.Label("Promotion code to use to get the discount rate")
   private java.lang.String code;
   @org.kie.api.definition.type.Label("Promotion Rate to use")
   private java.math.BigDecimal rate;

   public Promotion()
   {
   }

   public java.lang.Long getPromoId()
   {
      return this.promoId;
   }

   public void setPromoId(java.lang.Long promoId)
   {
      this.promoId = promoId;
   }

   public java.lang.String getDescription()
   {
      return this.description;
   }

   public void setDescription(java.lang.String description)
   {
      this.description = description;
   }

   public java.util.Date getBeginDate()
   {
      return this.beginDate;
   }

   public void setBeginDate(java.util.Date beginDate)
   {
      this.beginDate = beginDate;
   }

   public java.util.Date getEndDate()
   {
      return this.endDate;
   }

   public void setEndDate(java.util.Date endDate)
   {
      this.endDate = endDate;
   }

   public java.lang.String getCode()
   {
      return this.code;
   }

   public void setCode(java.lang.String code)
   {
      this.code = code;
   }

   public java.math.BigDecimal getRate()
   {
      return this.rate;
   }

   public void setRate(java.math.BigDecimal rate)
   {
      this.rate = rate;
   }

   public Promotion(java.lang.Long promoId, java.lang.String description,
         java.util.Date beginDate, java.util.Date endDate,
         java.lang.String code, java.math.BigDecimal rate)
   {
      this.promoId = promoId;
      this.description = description;
      this.beginDate = beginDate;
      this.endDate = endDate;
      this.code = code;
      this.rate = rate;
   }

}
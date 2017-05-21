/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author mlyra
 */
public class Company {
    private int companyId;
    private String companyName;
    private String industryField;
    private String country;
    
    public Company(String companyName, String industryField) {
        this.companyName = companyName;
        this.industryField = industryField;
    }

    /**
     * @return the companyId
     */
    public int getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId the companyId to set
     */
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the industryField
     */
    public String getIndustryField() {
        return industryField;
    }

    /**
     * @param industryField the industryField to set
     */
    public void setIndustryField(String industryField) {
        this.industryField = industryField;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }
    
}

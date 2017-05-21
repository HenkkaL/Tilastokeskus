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
public class Stock {
    private String ticker;
    private int id;
    private Company company;
    private String value;
    
    public Stock() {
        
    }
    
    public Stock(String ticker, Company company){
        this.ticker = ticker;
        this.company = company;
    }    

    /**
     * @return the ticker
     */
    public String getTicker() {
        return ticker;
    }

    /**
     * @param ticker the ticker to set
     */
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the companyId
     */
    public Company getCompany() {
        return this.company;
    }

    /**
     * @param company the companyId to set
     */
    public void setCompany(Company company) {
        this.company = company;
    } 
    
}

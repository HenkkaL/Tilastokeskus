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
public class PeriodicValueStock extends Stock {

    private double value;  

    /**
     *
     * @param ticker
     * @param company
     * @param value
     */
    public PeriodicValueStock(String ticker, Company company, double value) {
       super.setTicker(ticker);
       super.setCompany(company);
       this.value = value;
    }

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }
    
    
    

}

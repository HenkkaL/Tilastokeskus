/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.*;

/**
 *
 * @author mlyra
 */
public class StockValue {
    
    
    private double open;
    private double close;
    private int valueId;
    private int volume;
    private Timestamp valueDate;
    private Stock stock;
    
    public StockValue(int open, int close, Stock stock) {
        this.open = open;
        this.close = close;
        this.stock = stock;
        
    }

    /**
     * @return the open
     */
    public double getOpen() {
        return open;
    }

    /**
     * @param open the open to set
     */
    public void setOpen(double open) {
        this.open = open;
    }

    /**
     * @return the close
     */
    public double getClose() {
        return close;
    }

    /**
     * @param close the close to set
     */
    public void setClose(double close) {
        this.close = close;
    }

    /**
     * @return the valueId
     */
    public int getValueId() {
        return valueId;
    }

    /**
     * @param valueId the valueId to set
     */
    public void setValueId(int valueId) {
        this.valueId = valueId;
    }

    /**
     * @return the volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * @return the valueDate
     */
    public Timestamp getValueDate() {
        return valueDate;
    }

    /**
     * @param valueDate the valueDate to set
     */
    public void setValueDate(Timestamp valueDate) {
        this.valueDate = valueDate;
    }

    /**
     * @return the stock
     */
    public Stock getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(Stock stock) {
        this.stock = stock;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import domain.Company;
import domain.PeriodicValueStock;
import domain.Stock;
import domain.StockValue;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author mlyra
 */
public class StockDao implements DAO {
    
    private Stock stock;
    private ArrayList<Stock> stocks;
    private ArrayList<StockValue> stockValues;
    private Database database;
    
    public StockDao(Database database) {
        this.database = database;
    }
    
    @Override
    public ArrayList<Stock> listAll() throws SQLException {
        Connection connection = database.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT companies.companyName, stocks.ticker, stocks.id, companies.industryField "
                + "FROM companies INNER JOIN stocks ON companies.companyID=stocks.companyId;");
        stocks = new ArrayList();
                
        while (rs.next()) {
            String companyName = rs.getString("companyName");
            String ticker = rs.getString("ticker");
            String industryField = rs.getString("industryField");
            String id = rs.getString("id");
            stocks.add(new Stock(ticker, new Company(companyName, industryField)));
        }
        
        rs.close();
        stmt.close();
        connection.close();
        
        return stocks;
    }
    
    @Override
    public ArrayList<Stock> listByDate(String start, String end) throws SQLException {
        Connection connection = database.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs;
        stocks = new ArrayList<>();
                    
        stmt.execute("CREATE TABLE startValues AS SELECT stockId, close AS startValue FROM stockvalues WHERE DATE(valueDate)=\'" + start + "\';");
        stmt.execute("CREATE TABLE endValues AS SELECT stockId, close AS endValue FROM stockvalues WHERE DATE(valueDate)=\'" + end + "\';");
        stmt.execute("CREATE TABLE totalValues AS SELECT startValues.stockId, startValues.startValue, endValues.endValue FROM startValues"
                + " INNER JOIN endValues ON startValues.stockId=endValues.stockId;");
        rs = stmt.executeQuery("SELECT c.companyName, s.ticker, c.industryField, ((endValue - startValue) / startValue * 100) AS value FROM totalValues AS tv"
                + " INNER JOIN stocks AS s ON tv.stockId=s.id INNER JOIN companies AS c ON  s.companyId=c.companyId ORDER BY value DESC;");
        
        while (rs.next()) {
            String companyName = rs.getString("companyName");
            String ticker = rs.getString("ticker");
            String industryField = rs.getString("industryField");
            String value = rs.getString("value");
            stocks.add(new PeriodicValueStock(ticker, new Company(companyName, industryField), Double.parseDouble(value)));            
        }
        
        stmt.execute("DROP TABLE startValues;");
        stmt.execute("DROP TABLE endValues;");
        stmt.execute("DROP TABLE totalValues;");
        
        rs.close();
        stmt.close();
        connection.close();
        return stocks;
    }

}

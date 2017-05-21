/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiketesti;

import dataAccess.DAO;
import dataAccess.Database;
import dataAccess.StockDao;
import domain.Stock;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

/**
 *
 * @author mlyra
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        staticFileLocation("/public");
        Database database = new Database("jdbc:sqlite:src/stocks.db");
        
        DAO sDao = new StockDao(database);
     
      
        
        get("/list", (req, res) -> {           
            HashMap map = new HashMap<>();
            ArrayList<Stock> stocks = new  ArrayList<>();
            stocks = sDao.listAll();
            map.put("stocks", stocks);
            return new ModelAndView(map, "list");
        }, new ThymeleafTemplateEngine());
        
        post("/sortlist", (req, res) -> {           
            HashMap map = new HashMap<>();
            ArrayList<Stock> stocks = new  ArrayList<>();
            String start = req.queryParams("start");
            String end = req.queryParams("end");
            stocks = sDao.listByDate(start, end);
            map.put("stocks", stocks);
            
            return new ModelAndView(map, "sortList");
        }, new ThymeleafTemplateEngine());

    }   
    
}

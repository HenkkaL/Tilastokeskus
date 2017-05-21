/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import domain.Stock;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mlyra
 */
public interface DAO {

    ArrayList<Stock> listAll() throws SQLException;

    ArrayList<Stock> listByDate(String start, String end) throws SQLException;
    
}

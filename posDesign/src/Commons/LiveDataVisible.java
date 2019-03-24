/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commons;

import DBConnection_Controller.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author world
 */
public class LiveDataVisible {

    public String todaySales() {
        Date date = new Date();
        String todaysDate = new DateFormating().dateFormate(date);
        //String sql = "SELECT SUM(total) FROM stock_out WHERE DATE(delivery_date) = '" + todaysDate + "'";
        String sql = "SELECT SUM(`total`) FROM `stock_out` where delivery_date='2019-01-08'";
        return totalCalculation(sql);
    }

    public String monthSales() {
        String sql = "SELECT SUM(total) FROM stock_out WHERE delivery_date BETWEEN DATE_SUB(NOW(), INTERVAL 30 DAY) AND NOW()";
        return totalCalculation(sql);
    }

    public String StockInHand() {
        String sql = "SELECT SUM(stock) as stock FROM stock_hand";
        return totalCalculation(sql);
    }

    public String StockProductprice() {
        String sql = "select  (SUM(products.selling_price)*SUM(stock_hand.stock)) as result from "
                + "products,stock_hand where products.id=stock_hand.product_id and stock_hand.stock!=0";
        return totalCalculation(sql);
    }

    public String TotalNumberOfProducts() {
        String sql = "SELECT sum(stock) FROM `stock_hand` WHERE stock !=0";
        return totalCalculation(sql);
    }

    public String totalCalculation(String sqlQuery) {
        Connection con = new DbConnection().ConnDB();
        ResultSet rs = null;
        String sql = sqlQuery;
        String sum = "0";
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            rs = pst.executeQuery();
            if (rs.next()) {
                sum = rs.getString(1);
                con.close();
                rs.close();
                pst.close();
                return sum;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "LiveDataVisible in (totalCalculation)Error Message in Sales :", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                con.close();
                rs.close();
            } catch (Exception e) {
            }
        }
        return "0";
    }

    public String totalDueAmount() {
        String sql = "SELECT SUM(due) FROM `inventory_summary`";

        ResultSet rs = null;
        String sum = "0";
        try {
            Connection con = new DbConnection().ConnDB();
            PreparedStatement pst = con.prepareStatement(sql);

            rs = pst.executeQuery();
            if (rs.next()) {
                sum = rs.getString(1);
                con.close();
                rs.close();
                pst.close();
                return sum;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "LiveDataVisible in (totalCalculation)Error Message in Sales :", JOptionPane.ERROR_MESSAGE);
        } 
        return "0";
    }
}

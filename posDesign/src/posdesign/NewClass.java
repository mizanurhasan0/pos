/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posdesign;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author world
 */
public class NewClass {
    
    public static void main(String[] args) {
        /*     Connection con = new DBConnection_Controller.DbConnection().testDB();
        ArrayList<String> q = new ArrayList<>();

        String sql = "INSERT INTO `b`( `name`) VALUES ('N1name4'); ";
        String sql2 = "INSERT INTO `a`( `name`) VALUES ('N1name5');";
        q.add(0, sql);
        q.add(1, sql2);
        System.out.println(q.size());
        

        try {
            
            for (int i = 0; i < q.size(); i++) {
                PreparedStatement pst = con.prepareStatement(q.get(i));
                pst.execute();
                System.out.println("Success");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "" + e, "Error Message", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                con.close();

            } catch (Exception e) {
            }
        }
         */
        
        String date = "2019-12-12";
        String time = " 15:10:12";
        System.out.println(date.concat(time));
    }
}

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
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author world
 */
public class DaynamicDropDownValue {

    PreparedStatement pst;
    Statement st;
    ResultSet rs;

    public void productItemList(JComboBox<String> comboBox, String tableName) {
        Connection con = new DbConnection().ConnDB();
        String sql = "select name from " + tableName;
        try {
            pst = con.prepareStatement(sql);
            //pst.executeQuery();
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                comboBox.addItem(name);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "DaynamicDropDownValue of (productItemList)" + e);
        } finally {
            try {
                con.close();
                pst.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "DaynamicDropDownValue of (productItemList)" + e);
            }
        }
        comboBox.setSelectedIndex(0);
    }

    public String getComboboxGroupId(String tableName, String name) {
        Connection con = new DbConnection().ConnDB();
        String sql = "select id from " + tableName + " where name=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, name);
            rs = pst.executeQuery();
            if (rs.next()) {
                String id = rs.getString("id");
                return id;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "getGroup id by combobox(getComboboxGroupId):" + e);
        } finally {
            try {
                con.close();
                pst.close();
                rs.close();
            } catch (Exception e) {
            }
        }
        return "0";
    }

}

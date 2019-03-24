/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Commons.DateFormating;
import DBConnection_Controller.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author world
 */
public class ActivityController {

    private void tableRowReSize(JTable table) {
        table.getColumnModel().getColumn(3).setPreferredWidth(30);
        table.getColumnModel().getColumn(3).setMaxWidth(30);
        table.getColumnModel().getColumn(4).setPreferredWidth(30);
        table.getColumnModel().getColumn(4).setMaxWidth(30);
    }

    public void AllUnit(JTable table) {
        Connection con = new DbConnection().ConnDB();
        ResultSet rs;
        PreparedStatement pst;

        table.setModel(new DefaultTableModel(null, new String[]{"ID", "Unit Name", "Status", "/", "X"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();

        tableRowReSize(table);

        String sql = "select * from units";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                JButton btnEdit = new JButton(new javax.swing.ImageIcon(getClass().getResource("/IconImage/iconsedit.png")));
                JButton btnDelete = new JButton(new javax.swing.ImageIcon(getClass().getResource("/IconImage/iconsbeans.png")));

                String unitId = rs.getString("id");
                btnEdit.setName("Edit");
                btnDelete.setName(unitId);
                String unitName = rs.getString("name");
                String status = rs.getString("status");
                defaultTableModel.addRow(new Object[]{unitId, unitName, status, btnEdit, btnDelete});
            }

        } catch (SQLException e) {
            System.out.println("AllUnit:" + e);
        }
    }

    public List EditUnitData(String id) {
        Connection con = new DbConnection().ConnDB();
        ResultSet rs;
        PreparedStatement pst;

        List<String> data = new ArrayList<>();
        String sql = "SELECT * FROM units where id='" + id + "' ";

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String unit_id = id;
                data.add(0, unit_id);
                String unit_name = rs.getString("Name");
                data.add(1, unit_name);
                String unit_status = rs.getString("status");
                data.add(2, unit_status);

            }
            return data;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ForEditUnitData:" + e);
            return null;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("ForEditUnitData " + e);
            }
        }
    }

    public boolean updateUnit(String id, String unitName, String status) {
        Connection con = new DbConnection().ConnDB();
        PreparedStatement pst;

        Date date = new Date();
        String currentDate = new DateFormating().dateFormate(date);
        String sql = "UPDATE `units` SET `name`=?,`created`=?,`status`=? WHERE id='" + id + "';";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, unitName);
            pst.setString(2, currentDate);
            pst.setString(3, status);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("updateUnit" + e);
            return false;
        }
    }

    public boolean addUnit(String unitName, String status) {
        Connection con = new DbConnection().ConnDB();
        PreparedStatement pst;
        Date date = new Date();
        String currentDate = new DateFormating().dateFormate(date);
        String sql = "INSERT INTO `units` (`name`,`created`, `status`) VALUES (?, ?, ?);";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, unitName);
            pst.setString(2, currentDate);
            pst.setString(3, status);
            pst.execute();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}

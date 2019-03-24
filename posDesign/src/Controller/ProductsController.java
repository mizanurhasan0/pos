/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Commons.TableRander;
import DBConnection_Controller.DbConnection;
import Models.AddProductsModel;
import Models.BufferProduct;
import Models.ProductsEditModel;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Niklaus
 */
public class ProductsController {

    Connection con = new DbConnection().ConnDB();
    PreparedStatement pst;
    Statement st;
    ResultSet rs;

    public void productItemList(JComboBox<String> comboBox, String tableName) {

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
            JOptionPane.showMessageDialog(null, "(productItemList)" + e);
        }
        comboBox.setSelectedIndex(0);
    }

    public boolean addProduct(AddProductsModel model) {
        Connection con = new DbConnection().ConnDB();
        String sql = null;
        System.out.println("Type:" + model.getType());
        System.out.println("Images:" + model.getImages());

        if (model.getType().equals("Service")) {
            if (model.getImages() != null) {
                sql = "INSERT INTO `products`(name,type,manufacturer,vendor,"
                        + "image,selling_price,service_description) VALUES (?,?,?,?,?,?,?)";
                try {
                    InputStream is = new FileInputStream(model.getImages());

                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, model.getName());
                    pst.setString(2, model.getType());
                    pst.setString(3, model.getManufacturer());
                    pst.setString(4, model.getVendor());
                    pst.setBlob(5, is);
                    pst.setString(6, model.getSelling_price());
                    pst.setString(7, model.getService_description());
                    pst.execute();
                    return true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Insert (addProduct) Error of products table:" + e);
                    //return false;

                }
                return false;
            } else if (model.getImages() == null) {
                sql = "INSERT INTO `products`(name,type,manufacturer,vendor,"
                        + "selling_price,service_description) VALUES (?,?,?,?,?,?)";
                try {

                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, model.getName());
                    pst.setString(2, model.getType());
                    pst.setString(3, model.getManufacturer());
                    pst.setString(4, model.getVendor());
                    pst.setString(5, model.getSelling_price());
                    pst.setString(6, model.getService_description());
                    pst.execute();
                    return true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Insert (addProduct) Error of products table:" + e);
                    return false;

                }
                //  return false;
            }
            return false;
        } else if (model.getType().equals("Product")) {
            if (model.getImages() != null) {
                sql = "INSERT INTO `products`(name,type,manufacturer,vendor,unit,article_code,article_name,"
                        + "operating_voltage,diameter_bore,stroke,`measuring_sensing`,switching_output,sku,output_signal,"
                        + "image,selling_price,service_description) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                try {
                    InputStream is = new FileInputStream(model.getImages());
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, model.getName());
                    pst.setString(2, model.getType());
                    pst.setString(3, model.getManufacturer());
                    pst.setString(4, model.getVendor());
                    pst.setString(5, model.getUnit());
                    pst.setString(6, model.getArticle_code());
                    pst.setString(7, model.getArticle_name());
                    pst.setString(8, model.getOperating_voltage());
                    pst.setString(9, model.getDiameter_bore());
                    pst.setString(10, model.getStroke());
                    pst.setString(11, model.getMeansuring_sensing());
                    pst.setString(12, model.getSwitching_output());
                    pst.setString(13, model.getSku());
                    pst.setString(14, model.getOutput_signal());
                    pst.setBlob(15, is);
                    pst.setString(16, model.getSelling_price());
                    pst.setString(17, model.getService_description());
                    pst.execute();
                    return true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Insert Products(addProduct) Error of products table:" + e);
                    // return false;
                }
                return false;
            } else if (model.getImages() == null) {
                sql = "INSERT INTO `products` (name,type,manufacturer,vendor,unit,article_code,article_name,"
                        + "operating_voltage,diameter_bore,stroke,`measuring_sensing`,switching_output,sku,output_signal,"
                        + "selling_price,service_description) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                try {

                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, model.getName());
                    pst.setString(2, model.getType());
                    pst.setString(3, model.getManufacturer());
                    pst.setString(4, model.getVendor());
                    pst.setString(5, model.getUnit());
                    pst.setString(6, model.getArticle_code());
                    pst.setString(7, model.getArticle_name());
                    pst.setString(8, model.getOperating_voltage());
                    pst.setString(9, model.getDiameter_bore());
                    pst.setString(10, model.getStroke());
                    pst.setString(11, model.getMeansuring_sensing());
                    pst.setString(12, model.getSwitching_output());
                    pst.setString(13, model.getSku());
                    pst.setString(14, model.getOutput_signal());
                    pst.setString(15, model.getSelling_price());
                    pst.setString(16, model.getService_description());
                    pst.execute();
                    return true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Insert products (addProduct) Error of products table:" + e);
                    return false;
                }
            }
            return false;
        }
        return false;

    }

    public ProductsEditModel editProductsData(String id) {
        String sql = "SELECT p.id,p.name,p.type,m.name as manufacturer,v.name as vendors,u.name as unit,"
                + "p.article_code,p.article_name,p.operating_voltage,p.diameter_bore,p.stroke,p.measuring_sensing,"
                + "p.switching_output,p.sku,p.output_signal, p.image,p.selling_price,p.service_description,p.status FROM "
                + "`products` as p,manufacturers as m,vendors as v, units as u WHERE p.manufacturer=m.id and "
                + "p.vendor=v.id and p.unit=u.id and p.id='" + id + "' ";

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {

                ProductsEditModel model = new ProductsEditModel(
                        rs.getString("p.id"),
                        rs.getString("p.name"),
                        rs.getString("p.type"),
                        rs.getString("manufacturer"),
                        rs.getString("vendors"),
                        rs.getString("unit"),
                        rs.getString("p.article_code"),
                        rs.getString("p.article_name"),
                        rs.getString("p.operating_voltage"),
                        rs.getString("p.diameter_bore"),
                        rs.getString("p.stroke"),
                        rs.getString("p.measuring_sensing"),
                        rs.getString("p.switching_output"),
                        rs.getString("p.sku"),
                        rs.getString("p.output_signal"),
                        rs.getBytes("p.image"),
                        rs.getString("p.selling_price"),
                        rs.getString("p.service_description"),
                        rs.getString("p.status"));
                return model;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Edit Products(editProductsData) :" + e);
            return null;
        }

        return null;
    }

    public boolean UpdateProduct(ProductsEditModel model) {

        String sql = "UPDATE `products` SET name=?,type=?,manufacturer=?,vendor=?,unit=?,"
                + "article_code=?,article_name=?,operating_voltage=?,diameter_bore=?,stroke=?,"
                + "measuring_sensing=?,switching_output=?,sku=?,output_signal=?,image=?,"
                + "selling_price=?,service_description=?,status=? WHERE id='" + model.getId() + "'";

        try {

            pst = con.prepareStatement(sql);
            pst.setString(1, model.getName());
            pst.setString(2, model.getType());
            pst.setString(3, model.getManufacturer());
            pst.setString(4, model.getVendor());
            pst.setString(5, model.getUnit());
            pst.setString(6, model.getArticle_code());
            pst.setString(7, model.getArticle_name());
            pst.setString(8, model.getOperating_voltage());
            pst.setString(9, model.getDiameter_bore());
            pst.setString(10, model.getStroke());
            pst.setString(11, model.getMeansuring_sensing());
            pst.setString(12, model.getSwitching_output());
            pst.setString(13, model.getSku());
            pst.setString(14, model.getOutput_signal());
            pst.setBytes(15, model.getImage());
            pst.setString(16, model.getSelling_price());
            pst.setString(17, model.getService_description());
            pst.setString(18, model.getStatus());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Update Error of products table:" + e);
            return false;

        }
    }

    public String numberOfProduct() {
        String sql = "SELECT sum(stock) FROM `stock_hand` WHERE stock !=0";
        return totalCalculation(sql);

    }

    public String totalCalculation(String sqlQuery) {

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
            JOptionPane.showMessageDialog(null, e, "totalCalculation method(totalCalculation) :", JOptionPane.ERROR_MESSAGE);
        }
        return "0";
    }

    public void productDataSearch(HashMap<String, String> field, JTable tblname, String status) {
        HashMap<String, String> defaultField = new HashMap<>();
        defaultField.put("Query", "SELECT products.id, products.name, products.type, products.sku,manufacturers.name,vendors.name,units.name FROM `products`,manufacturers,vendors,units WHERE products.status ='" + status + "' and manufacturers.id=products.manufacturer and units.id=products.unit AND vendors.id=products.vendor and ");
        defaultField.put("Search", "");
        defaultField.put("Manufacturer", "");
        defaultField.put("Vendor", "");
        defaultField.put("Unit", "");

        HashMap<String, String> FinalField = new HashMap<>();

        FinalField.putAll(defaultField);
        FinalField.putAll(field);

        String query = FinalField.get("Query") + "( products.name like '%" + FinalField.get("Search") + "%' OR manufacturers.name ='" + FinalField.get("Manufacturer") + "' OR "
                + "vendors.name ='" + FinalField.get("Vendor") + "' OR units.name ='" + FinalField.get("Unit") + "') "
                + "GROUP by products.id  ORDER by id  LIMIT 10";

        ProductsController(query, tblname);
    }

    public void listedOfProducts(JTable table) {

        String sql = "SELECT products.id, products.name, products.type, products.sku,manufacturers.name,"
                + "vendors.name,units.name FROM `products`,manufacturers,vendors,units WHERE products.status='Active' and "
                + "manufacturers.id=products.manufacturer and units.id=products.unit AND vendors.id=products.vendor "
                + "ORDER by id DESC ";

        ProductsController(sql, table);
    }

    private void getRowSize(int column, int width, JTable table) {
        table.getColumnModel().getColumn(column).setPreferredWidth(width);
        table.getColumnModel().getColumn(column).setMaxWidth(width);
    }

    private void ProductsController(String SQL, JTable table) {
        String sql = SQL;
        table.setDefaultRenderer(Object.class, new TableRander());

        table.setModel(new DefaultTableModel(null, new String[]{"ID", "NAME", "TYPE", "SKU", "MANUFACTURER", "BRAND", "UNIT", "EDIT", "DELETE"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        getRowSize(7, 80, table);
        getRowSize(8, 100, table);
//        table.getColumnModel().getColumn(7).setPreferredWidth(80);
//        table.getColumnModel().getColumn(7).setMaxWidth(80);
//        table.getColumnModel().getColumn(8).setPreferredWidth(100);
//        table.getColumnModel().getColumn(8).setMaxWidth(100);

        try {
            PreparedStatement pst = con.prepareStatement(sql);

            rs = pst.executeQuery();
            while (rs.next()) {

                JButton btnEdit = new JButton("Edit", new javax.swing.ImageIcon(getClass().getResource("/IconImage/iconsedit.png")));
                JButton btnDel = new JButton("Delete", new javax.swing.ImageIcon(getClass().getResource("/IconImage/icons8-bin.png")));

                String id = rs.getString(1);
                btnEdit.setName(id);
                btnDel.setName(id);
                String name = rs.getString(2);
                String type = rs.getString(3);
                String sku = rs.getString(4);
                String manufacturer = rs.getString(5);
                String brand = rs.getString(6);
                String unit = rs.getString(7);
                defaultTableModel.addRow(new Object[]{id, name, type, sku, manufacturer, brand, unit, btnEdit, btnDel});

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Products (FinalQueryExecution) Search of Final Query Execution Method:", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void productDataSearchFilter(String text, JTable table) {
        table.setModel(new DefaultTableModel(null, new String[]{"", ""}));
        /// DefaultListModel listed = new DefaultListModel();
        String sql = "SELECT * FROM products where name like '%" + text + "%' or id like '%" + text + "%' or sku like '%" + text + "%' limit 10";
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        // defaultTableModel.removeRow(0);
        try {
            PreparedStatement pst = con.prepareStatement(sql);

            rs = pst.executeQuery();
            while (rs.next()) {
                String item_no = rs.getString(1);
                String name = rs.getString(2);

                defaultTableModel.addRow(new Object[]{item_no, name});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error Message (productDataSearchFilter)", JOptionPane.ERROR_MESSAGE);
        }

    }

    private Collection data(JTable table) {
        ArrayList<BufferProduct> arr = new ArrayList<>();
        for (int i = 0; i < table.getRowCount(); i++) {
            String id = "" + table.getValueAt(i, 0);
            String name = "" + table.getValueAt(i, 1);
            String type = "" + table.getValueAt(i, 2);
            String sku = "" + table.getValueAt(i, 3);
            String manufacturer = "" + table.getValueAt(i, 4);
            String brand = "" + table.getValueAt(i, 5);
            String unit = "" + table.getValueAt(i, 6);
            BufferProduct f = new BufferProduct(id, name,type,sku, manufacturer, brand, unit);
            arr.add(f);
        }
        return arr;
    }

    public void reportGenerator(String reportName, JTable tableName) {

        try {
            JasperReport jp = JasperCompileManager.compileReport("src/IReport/productsReport.jrxml");
            HashMap para = new HashMap();
            JRBeanCollectionDataSource jcd = new JRBeanCollectionDataSource(data(tableName));
            JasperPrint print = JasperFillManager.fillReport(jp, para, jcd);
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Frm Table report (reportGenerator) problem :" + e);
        }

    }

    public boolean deactiveProduct(String tableName, String id) {
        String sql = "UPDATE `products` SET `status`='Inactive',`activity`='Delete' WHERE id='" + id + "'";
        Connection newCon = new DbConnection().ConnDB();
        try {
            PreparedStatement pst = newCon.prepareStatement(sql);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Product Inactive, delete (deactiveProduct)function: " + e);
            return false;
        }

    }

    public int checkContact(String name) {
        //String searchName = txtUserName.getText();
        try {
            //conn = new DbConnection().ConnDB();
            st = con.createStatement();
            rs = st.executeQuery("select name from products where name='" + name + "' ;");
            while (rs.next()) {
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("(CheckContact) function exception :" + e);
        } finally {
            try {
                rs.close();
                st.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("(CheckContact) function exception :" + e);
            }
        }
        return 0;
    }

}

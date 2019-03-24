package Controller;

import Commons.DateFormating;
import Commons.TableRander;
import Commons.TableRander2;
import DBConnection_Controller.DbConnection;
import Models.PurchaseProductModel;
import Models.PurchaseReportModel;
import Models.StockInModel;
import Models.Users;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class PurchaseController {

    Connection con = new DbConnection().ConnDB();
    PreparedStatement pst;
    Statement st;
    ResultSet rs;

    private void tableRowReSize(JTable table) {
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(0).setMaxWidth(60);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);
        table.getColumnModel().getColumn(3).setMaxWidth(60);

        table.getColumnModel().getColumn(4).setPreferredWidth(90);
        table.getColumnModel().getColumn(4).setMaxWidth(90);
        table.getColumnModel().getColumn(5).setPreferredWidth(90);
        table.getColumnModel().getColumn(5).setMaxWidth(90);
        table.getColumnModel().getColumn(7).setPreferredWidth(60);
        table.getColumnModel().getColumn(7).setMaxWidth(60);
        table.getColumnModel().getColumn(8).setPreferredWidth(60);
        table.getColumnModel().getColumn(8).setMaxWidth(60);
        table.getColumnModel().getColumn(9).setPreferredWidth(30);
        table.getColumnModel().getColumn(9).setMaxWidth(30);
        table.getColumnModel().getColumn(10).setPreferredWidth(30);
        table.getColumnModel().getColumn(10).setMaxWidth(30);
    }

    public StockInModel SingleProductView(String id) {
        String sql = "SELECT products.id,products.selling_price,stock_hand.stock,products.image "
                + "FROM products LEFT JOIN stock_hand ON products.id=stock_hand.product_id WHERE "
                + "products.id in (select id from products where id='" + id + "') ";

        try {
            PreparedStatement pst = con.prepareStatement(sql);

            rs = pst.executeQuery();
            if (rs.next()) {
                StockInModel model = new StockInModel(rs.getString(1),
                        rs.getString(2), rs.getString(3), rs.getBytes(4));
                return model;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Purchase Controller (SingleProductView)Error Message", JOptionPane.ERROR_MESSAGE);

        }
//        finally {
//            try {
//                pst.close();
//                rs.close();
//            } catch (SQLException e) {
//            }
//        }
        return null;
    }

    public void FilterBysearchField(String text, JTable table) {
        // table.setModel(new DefaultTableModel(null, new String[]{"", ""}));
        Connection conn = new DbConnection().ConnDB();

        String sql = "SELECT id,name FROM `products` WHERE status='Active' and (id like '%" + text + "%' OR name like '%" + text + "%' OR sku like '%" + text + "%') limit 5;";

        table.setModel(new DefaultTableModel(null, new String[]{"", ""}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();

        getRowSize(1, 30, table);

        try {

            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                String id = rst.getString("id");
                String name = rst.getString("name");
                defaultTableModel.addRow(new Object[]{name, id,});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Purchases(FilterBysearchField) Error Message", JOptionPane.ERROR_MESSAGE);
        }
//        finally {
//            try {
//                conn.close();
//                rst.close();
//            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, e, "Purchases(FilterBysearchField) Error Message", JOptionPane.ERROR_MESSAGE);
//
//            }
//        }
    }

    public void removeQuantity(String productID, String Qty) {
        Connection con = new DbConnection().ConnDB();
        //int quantity=0;
        String sql = "UPDATE `stock_hand` SET `stock`=(`stock`-'" + Qty + "') WHERE product_id='" + productID + "'";
        try {

            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something Missing" + e, "Warning", JOptionPane.ERROR_MESSAGE);
            // return 0;
        }
    }

    public String QtyOfProducts(String productID) {
        Connection con = new DbConnection().ConnDB();
        //int quantity=0;
        String sql = "SELECT `stock` FROM `stock_hand` WHERE product_id='" + productID + "'";
        try {

            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String stock = rs.getString(1);
                return stock;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "(QtyOfProducts)" + e, "Warning", JOptionPane.ERROR_MESSAGE);
            return "0";
        }
        return "0";
    }

    public void AddQTY(String quantity, String productID) {
        Connection con = new DbConnection().ConnDB();
        //int quantity=0;
        String sql = "UPDATE `stock_hand` SET `stock`=stock+" + quantity + " WHERE product_id='" + productID + "'";
        System.out.println(sql);
        try {

            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();

            System.out.println("Success");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "(AddQTY)" + e, "Warning", JOptionPane.ERROR_MESSAGE);
            // return "0";
        } finally {
            try {
                con.close();

            } catch (Exception e) {
                System.out.println("AddQTY:" + e);
            }
        }
        // return "0";
    }

    public boolean addProduct(ArrayList<String> QuerySize) {
        Connection con = new DbConnection().ConnDB();
        try {
            for (int i = 0; i < QuerySize.size(); i++) {
                PreparedStatement pst = con.prepareStatement(QuerySize.get(i));
                pst.execute();
            }
            JOptionPane.showMessageDialog(null, "Done!", "Welcome Message", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something Missing" + e, "Warning", JOptionPane.ERROR_MESSAGE);
            return true;
        }
    }

    public void allPurchaseReport(JTable table) {
        String sql = "SELECT ins.id,u.username,u.company,ins.due,ins.paid,ins.totalPrice,ins.date,ins.payment_complate,ins.isSent_Account,ins.inventory_unique_id FROM `inventory_summary` as ins,`users` as u WHERE ins.customerId=u.id order  by ins.Date DESC";
        PurchaseController(table, sql);
    }

    public void PurchaseSearch(String sql, JTable tblname) {

        PurchaseController(tblname, sql);
    }

    private void PurchaseController(JTable table, String sql) {

        Connection con = new DbConnection().ConnDB();

        //table.setDefaultRenderer(Object.class, new TableRander());
        table.setDefaultRenderer(Object.class, new TableRander2());

        table.setModel(new DefaultTableModel(null, new String[]{"ID", "Customer", "Company", "Due", "Paid", "Total", "Date", "Status", "Acc", "/", "X"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();

        tableRowReSize(table);

        try {
            pst = con.prepareStatement(sql);

            rs = pst.executeQuery();
//SELECT ins.id,u.username,u.company,ins.due,ins.paid,ins.totalPrice,ins.date,ins.payment_complate,ins.isSent_Account,ins.inventory_unique_id FROM `inventory_summary` as ins,`users` as u WHERE ins.customerId=u.id
            while (rs.next()) {
                JButton btnEdit = new JButton(new javax.swing.ImageIcon(getClass().getResource("/IconImage/iconsedit.png")));
                JButton btnSentToAccount = new JButton(new javax.swing.ImageIcon(getClass().getResource("/IconImage/icons8-sent-20.png")));
//                JTextArea txtUser = new JTextArea();
//                 txtUser.setBorder(null);
                btnSentToAccount.setBackground(Color.white);
                btnEdit.setBackground(Color.white);
                String id = rs.getString("ins.id");

                String username = rs.getString("u.username");
                String company = rs.getString("u.company");
                String due = rs.getString("ins.due");
                String paid = rs.getString("ins.paid");
                String totalPrice = rs.getString("ins.totalPrice");
                String date = rs.getString("ins.date");
                String payment_complate = rs.getString("ins.payment_complate");
                String isSent_Account = rs.getString("ins.isSent_Account");
                String inventory_unique_id = rs.getString("ins.inventory_unique_id");
                btnSentToAccount.setName("Acc");
                btnEdit.setName(inventory_unique_id);
                // txtUser.setText(username);
                defaultTableModel.addRow(new Object[]{id, username, company, due, paid, totalPrice, date,
                    payment_complate, isSent_Account, btnEdit, btnSentToAccount});

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Purchase Controller -(allPurchaseReport):" + e);
        }
    }

    public void reportGenerator(JTable tableName) {

        try {
            JasperReport jp = JasperCompileManager.compileReport("src/IReport/purchaseReport.jrxml");
            HashMap para = new HashMap();
            JRBeanCollectionDataSource jcd = new JRBeanCollectionDataSource(data(tableName));
            JasperPrint print = JasperFillManager.fillReport(jp, para, jcd);
            JasperViewer.viewReport(print, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Frm Table report (reportGenerator) problem :" + e);
        }

    }

    private Collection data(JTable table) {
        ArrayList<PurchaseReportModel> arr = new ArrayList<>();
        // id, name, pur_price, Quantity, TotalPrice, TotalPaid, Status, Date
        for (int i = 0; i < table.getRowCount(); i++) {

            String id = "" + table.getValueAt(i, 0);
            String custom = "" + table.getValueAt(i, 1);
            String company = "" + table.getValueAt(i, 2);
            String due = "" + table.getValueAt(i, 3);
            String paid = "" + table.getValueAt(i, 4);
            String total = "" + table.getValueAt(i, 5);
            String date = "" + table.getValueAt(i, 6);
            PurchaseReportModel f = new PurchaseReportModel(id, custom, company, due, paid, total, date);
            arr.add(f);
        }
        return arr;
    }

    public void dataSearchFilter(String text, JTable table) {
        table.setModel(new DefaultTableModel(null, new String[]{"", ""}));
        /// DefaultListModel listed = new DefaultListModel();
        String sql = "SELECT * FROM products where name like '%" + text + "%'";
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
            JOptionPane.showMessageDialog(null, e, "Error Message", JOptionPane.ERROR_MESSAGE);
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

    public void listOfUserInTable(JTable tableName, Object UserRoleName) {
        String sql = "SELECT u.id,u.username,ur.name,u.email,u.employee_no,u.company,u.address,"
                + "u.user_photo,u.phone FROM `users` as u ,user_roles as ur where u.user_type=ur.id and "
                + "ur.name='" + UserRoleName + "'";

        purchaseUserTableController(tableName, sql);
    }

    private void getRowSize(int column, int width, JTable table) {
        table.getColumnModel().getColumn(column).setPreferredWidth(width);
        table.getColumnModel().getColumn(column).setMaxWidth(width);
    }

    private void purchaseUserTableController(JTable tableName, String sql) {
        Connection newCon = new DbConnection().ConnDB();
        tableName.setModel(new DefaultTableModel(null, new String[]{"ID", "Username", "Roles", "Email", "Phone", "Company Name"}));

        DefaultTableModel defaultTableModel = (DefaultTableModel) tableName.getModel();
        getRowSize(0, 60, tableName);
        try {
            PreparedStatement pst = newCon.prepareStatement(sql);

            rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString("u.id");
                String name = rs.getString("u.username");
                String userRole = rs.getString("ur.name");
                String userEmail = rs.getString("u.email");
                String userPhone = rs.getString("u.phone");
                String company = rs.getString("u.company");
                defaultTableModel.addRow(new Object[]{id, name, userRole, userEmail, userPhone, company});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "purchaseController class (listOfUser)" + e, "Error Message", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                newCon.close();
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
    }

    public void SearchByUserInfo(JTable tableName, String searchText, String UserRoleName) {
        String sql = "SELECT u.id,u.username,ur.name,u.email,u.employee_no,u.company,u.address,"
                + "u.user_photo,u.phone FROM `users` as u ,user_roles as ur where u.user_type=ur.id and "
                + "ur.name='" + UserRoleName + "'  and (u.username like '%" + searchText + "%' OR u.id ='" + searchText + "' OR u.email='" + searchText + "' "
                + "OR u.phone like '" + searchText + "%') limit 10";

        UserInfoSuggest(tableName, sql);
    }

    private void UserInfoSuggest(JTable tableName, String sql) {
        Connection newCon = new DbConnection().ConnDB();
        tableName.setModel(new DefaultTableModel(null, new String[]{"", "", "", ""}));

        DefaultTableModel defaultTableModel = (DefaultTableModel) tableName.getModel();
        getRowSize(3, -10, tableName);

        try {
            PreparedStatement pst = newCon.prepareStatement(sql);

            rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString("u.id");
                String name = rs.getString("u.username");
                String phone = rs.getString("u.phone");
                String company = rs.getString("u.company");
                defaultTableModel.addRow(new Object[]{name, phone, company, id});

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "purchaseController class (UserInfoSuggest)" + e, "Error Message", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                newCon.close();
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
    }
//
//    public Users UserInfo(String userId) {
//
//        Users user = singleUserPicker(sql);
//        return user;
//    }

    public Users singleUserPicker(String userId) {
        String sql = "SELECT `id`,`username`,`phone`,`company` FROM `users` where id='" + userId + "'";
        //String sql = "SELECT user_photo FROM `users` WHERE id='" + id + "'";
        Connection conn = new DbConnection().ConnDB();

        try {
            PreparedStatement pst1 = conn.prepareStatement(sql);

            ResultSet rs1 = pst1.executeQuery();
            if (rs1.next()) {
                Users user = new Users(
                        rs1.getString("id"),
                        rs1.getString("username"),
                        rs1.getString("phone"),
                        rs1.getString("company"));
                return user;
            }

        } catch (Exception e) {
            System.out.println("Image file exception (singleUserPicker)" + e);
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("Image file exception (singleUserPicker)" + e);
            }
        }
        return null;
    }

    public boolean PurchaseupdateHistory(List<String> values) {
        String sql = "UPDATE `inventory_summary` SET `due`='" + values.get(0) + "', `paid`='" + values.get(1) + "',"
                + "`totalPrice`='" + values.get(2) + "',"
                + " `customerId`='" + values.get(3) + "', `payment_complate`='" + values.get(4) + "' WHERE "
                + "`inventory_unique_id`='" + values.get(5) + "'";

        try {
            Connection conn = new DbConnection().ConnDB();
            PreparedStatement pst1 = conn.prepareStatement(sql);
            pst1.executeUpdate();
            JOptionPane.showMessageDialog(null, "Update Successfull ");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "(PurchaseupdateHistory) based Problem " + e);
            return false;
        }
    }

    public List<PurchaseProductModel> editPurchaseProduct(String uniquePurchaseID) {
        String sql = "SELECT i.id,i.user_id,ut.name,u.username,u.company,u.phone,u.email,i.unique_id,i.pro_id,"
                + "i.name,i.manufacturer,i.quantity,i.price,i.discount,i.sellsPrice,i.totalPrice,i.date "
                + "FROM `inventory1` as i,users as u,user_roles as ut WHERE i.user_id=u.id and "
                + "i.unique_id='" + uniquePurchaseID + "' AND u.user_type=ut.id";

//        String UserId, UserRole, CustomerName, CompanyName, Phone, Email, Unique_id, product_id,
//                ProductName, Manufacturer, Quantity, Price, Discount, sellsPrice, TotalPrice;
        Connection conn = new DbConnection().ConnDB();
        List<PurchaseProductModel> products = new ArrayList<>();

        try {
            PreparedStatement pst1 = conn.prepareStatement(sql);

            ResultSet rs1 = pst1.executeQuery();
            while (rs1.next()) {
//                String UserId, String UserRole, String CustomerName, String CompanyName, 
//                String Phone, String Email, String Unique_id, String product_id, String ProductName, 
//                        String Manufacturer, String Quantity, String Price, String Discount, 
//                                String sellsPrice, String TotalPrice
                PurchaseProductModel Pro_single = new PurchaseProductModel(rs1.getString("i.id"),
                        rs1.getString("i.user_id"), rs1.getString("ut.name"), rs1.getString("u.username"),
                        rs1.getString("u.company"), rs1.getString("u.phone"), rs1.getString("u.email"),
                        rs1.getString("i.unique_id"), rs1.getString("i.pro_id"), rs1.getString("i.name"),
                        rs1.getString("i.manufacturer"), rs1.getString("i.quantity"), rs1.getString("i.price"),
                        rs1.getString("i.discount"), rs1.getString("i.sellsPrice"), rs1.getString("i.totalPrice"),
                        rs1.getString("i.date"));

                products.add(Pro_single);

            }
            return products;
        } catch (SQLException e) {
            System.out.println("Purchase Controller (editPurchaseProduct)" + e);
            return null;
        }
    }
}

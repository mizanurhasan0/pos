/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frm_purchase_subpanel;

import Commons.ComboboxDesign;
import Commons.DaynamicDropDownValue;
import Commons.PanelController;
import Commons.TableBackgroundColor;
import Commons.TableRander;
import Commons.TextPlaceholder;
import Commons.TxtBoxSpace;
import Controller.PurchaseController;
import Frm_products.SubMenuOfPurchase;
import Frm_products_subPanel.AddProducts;
import Frm_products_subPanel.Products;
import JDialogCustom.ErrorJDialog1;
import JDialogCustom.SuccessJDialog;
import Models.PurchaseProductModel;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import Models.StockInModel;
import Models.Users;
import com.mysql.jdbc.Connection;
import com.sun.java.swing.plaf.windows.WindowsScrollBarUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.plaf.metal.MetalScrollBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import rojerusan.necesario.RSScrollBar;

/**
 *
 * @author world
 */
public class Strock_in_Custom extends javax.swing.JPanel {

    PanelController panelController = new PanelController();
    DaynamicDropDownValue dynamicDropDownValue = new DaynamicDropDownValue();

    String h = null;
    String serviceAndProduct = null;

    TextPlaceholder placeHolder = new TextPlaceholder();
    TxtBoxSpace txtBoxSpaceing = new TxtBoxSpace();
    PurchaseController controller = new PurchaseController();
    ComboboxDesign comboDesign = new ComboboxDesign();

    String txtSku1 = "Sku or Id";
    String txtQuantity1 = "0";
    String txtPrice1 = "0";
    String txtDiscout1 = "0";
    String txtTotal1 = "0";
    String txtTotalAmount1 = "0";
    String txtsellingPrice1 = "0";
    String txtPaid1 = "0";
    String txtDue1 = "0";
    String txtSearchUser1 = "Name/Mobile/ID";
    String txtPhone1 = "Phone";
    String txtCompany1 = "Company Name";

    public Strock_in_Custom() {
        initComponents();

        dynamicDropDownValue.productItemList(jComboBoxManufacture, "manufacturers");
        comboDesign.comboDesign(jComboBoxManufacture);
        dynamicDropDownValue.productItemList(jComboBoxUserRoles, "user_roles");
        comboDesign.comboDesign(jComboBoxUserRoles);
        defaultDesign();
        lbPrePaid.setVisible(false);
        textSpacingMethod();
        jPanelProductsSugest.setVisible(false);
        btnSaved2.setText("Submit");
    }

    public Strock_in_Custom(String inventoryID, String due, String paid, String fullTotalPrice) {
        initComponents();
        lb_role.setText("RoleEdit");
        EditdefaultDesign();
        textSpacingMethod();
        jPanelProductsSugest.setVisible(false);

        List<PurchaseProductModel> products = controller.editPurchaseProduct(inventoryID);
        System.out.println(products.size());
        for (int i = 0; i < products.size(); i++) {
            //    System.out.println(products.get(i).getEmail());

            DefaultTableModel defaultTableModel = (DefaultTableModel) jTableProducts.getModel();

            JButton btnEdit = new JButton(new javax.swing.ImageIcon(getClass().getResource("/IconImage/iconsedit.png")));
            JButton btnDel = new JButton(new javax.swing.ImageIcon(getClass().getResource("/IconImage/icons8-bin.png")));
            btnEdit.setName("Edit");
            //btnDel.setName(M_ID);

            defaultTableModel.addRow(new Object[]{products.get(i).getProduct_id(),
                products.get(i).getProductName(), products.get(i).getManufacturer(),
                products.get(i).getQuantity(), products.get(i).getPrice(),
                products.get(i).getDiscount(), products.get(i).getSellsPrice(),
                products.get(i).getTotalPrice(), btnEdit, btnDel});
        }
        //System.out.println(products.get(1).getCustomerName());
        lbRandom.setText(products.get(0).getUnique_id());
        txtSearchUser.setText(products.get(0).getCustomerName());

        txtPhone.setText(products.get(0).getPhone());
        txtCompany.setText(products.get(0).getCompanyName());
        jComboBoxUserRoles.setSelectedItem(products.get(0).getUserRole());
        //System.out.println(products.get(0).getUserRole());
        UserId.setText(products.get(0).getUserId());
        txtDue.setText(due);
        lbPreDue.setText(due);
        lbPrePaid.setText(paid);
        txtTotalAmount.setText(String.valueOf(fullTotalPrice));
        btnSaved2.setText("Update");

    }

    private void EditdefaultDesign() {
        dynamicDropDownValue.productItemList(jComboBoxManufacture, "manufacturers");
        dynamicDropDownValue.productItemList(jComboBoxUserRoles, "user_roles");
        comboDesign.comboDesign(jComboBoxManufacture);
        comboDesign.comboDesign(jComboBoxUserRoles);
        //jComboBoxUserRoles.setSelectedIndex(0);

        jScrollPane1.getViewport().setBackground(TableBackgroundColor.UiColors.BACKGROUND_COLOR_WHITE);

        jScrollPane1.getVerticalScrollBar().setUI(new RSScrollBar());
        jScrollPane6.getVerticalScrollBar().setUI(new RSScrollBar());
        jPanelProductsSugest.getVerticalScrollBar().setUI(new RSScrollBar());
        UserId.setVisible(false);
        UserId.setText(null);
        lbManufacturerID.setVisible(false);
        lbManufacturerID.setText(null);
        lb_id.setVisible(false);
        lb_id.setText(null);
        jScrollPane6.setVisible(false);
        lbRandom.setVisible(false);
        lb_role.setVisible(false);
        lbPreDue.setVisible(false);
        lbPrePaid.setVisible(false);
        CustomProductsTable();
    }

    private void defaultDesign() {

        lb_role.setText("role");
        jComboBoxUserRoles.setSelectedIndex(1);

        jScrollPane1.getViewport().setBackground(TableBackgroundColor.UiColors.BACKGROUND_COLOR_WHITE);
        jScrollPane1.getVerticalScrollBar().setUI(new RSScrollBar());
        jScrollPane6.getVerticalScrollBar().setUI(new RSScrollBar());
        jPanelProductsSugest.getVerticalScrollBar().setUI(new RSScrollBar());
        UserId.setVisible(false);
        UserId.setText(null);
        lbManufacturerID.setVisible(false);
        lbManufacturerID.setText(null);
        lb_id.setVisible(false);
        lb_id.setText(null);
        jScrollPane6.setVisible(false);
        lbRandom.setVisible(false);
        lb_role.setVisible(false);
        lbPreDue.setVisible(false);
        CustomProductsTable();
        btnSaved2.setText("Update");
    }

    private void CustomProductsTable() {
        jTableProducts.setDefaultRenderer(Object.class, new TableRander());

        jTableProducts.setModel(new DefaultTableModel(null, new Object[]{"ID", "Name", "Manufacturer",
            "Qty", "Price", "Dis", "Sell price", "Total price", "/", "X"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        jTableProducts.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTableProducts.getColumnModel().getColumn(0).setMaxWidth(30);
        jTableProducts.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTableProducts.getColumnModel().getColumn(2).setMaxWidth(100);
        jTableProducts.getColumnModel().getColumn(3).setPreferredWidth(60);
        jTableProducts.getColumnModel().getColumn(3).setMaxWidth(60);
        jTableProducts.getColumnModel().getColumn(4).setPreferredWidth(130);
        jTableProducts.getColumnModel().getColumn(4).setMaxWidth(130);
        jTableProducts.getColumnModel().getColumn(5).setPreferredWidth(60);
        jTableProducts.getColumnModel().getColumn(5).setMaxWidth(60);
        jTableProducts.getColumnModel().getColumn(6).setPreferredWidth(130);
        jTableProducts.getColumnModel().getColumn(6).setMaxWidth(130);
        jTableProducts.getColumnModel().getColumn(7).setPreferredWidth(130);
        jTableProducts.getColumnModel().getColumn(7).setMaxWidth(130);
        jTableProducts.getColumnModel().getColumn(8).setPreferredWidth(30);
        jTableProducts.getColumnModel().getColumn(8).setMaxWidth(30);
        jTableProducts.getColumnModel().getColumn(9).setPreferredWidth(30);
        jTableProducts.getColumnModel().getColumn(9).setMaxWidth(30);

    }

    int j = 0;
    double sum = 0;

    public void priceCalculation() {
        double a = 0;

        for (int j = 0; j < jTableProducts.getRowCount(); j++) {
            a = Double.parseDouble(jTableProducts.getValueAt(j, 7).toString());
            sum = a + sum;
        }
        txtTotalAmount.setText(String.valueOf(sum));
        txtDue.setText(String.valueOf(sum));
        sum = 0;
    }

//    private void cleanUser() {
//        txtSearchUser.setText(txtSearchUser1);
//        txtCompany.setText(txtCompany1);
//        txtPhone.setText(txtPhone1);
//        jComboBoxUserRoles.setSelectedIndex(1);
//        lbimage.setText("");
//        lbimage.setIcon(null);
//        ImageIcon imageIcon = new ImageIcon(new ImageIcon("/IconImage/default-Users.png").getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH));
//        lbimage.setIcon(imageIcon);
//    }
    private void cleanProducts() {
        txtSku.setText(txtSku1);
        lb_stock.setText("0");
        lb_id.setText(null);
        lbManufacturerID.setText(null);
        txtQuantity.setText(txtQuantity1);
        txtPrice.setText(txtPrice1);
        txtTotal.setText(txtTotal1);
        txtDiscout.setText(txtDiscout1);
        txtsellingPrice.setText(txtsellingPrice1);
        jComboBoxManufacture.setSelectedIndex(0);

    }

    private void textSpacingMethod() {
        TxtBoxSpace txtBoxSpacing = new TxtBoxSpace();
        txtBoxSpacing.txtBoxSpace(txtSku);
        txtBoxSpacing.txtBoxSpace(txtQuantity);
        txtBoxSpacing.txtBoxSpace(txtPrice);
        txtBoxSpacing.txtBoxSpace(txtDiscout);
        txtBoxSpacing.txtBoxSpace(txtTotal);
        txtBoxSpacing.txtBoxSpace(txtsellingPrice);
        txtBoxSpacing.txtBoxSpace(txtDue);
        txtBoxSpacing.txtBoxSpace(txtSearchUser);

    }

    private void calculation(JTextField quantity, JTextField buyingPrice, JTextField discount, JTextField paid) {
        String quantity1 = quantity.getText();
        if (quantity1.equals(txtQuantity1) || quantity1.isEmpty()) {
            quantity1 = "0";
        }

        String buyingPrice1 = buyingPrice.getText();
        if (buyingPrice1.equals(txtPrice1) || buyingPrice1.isEmpty()) {
            buyingPrice1 = "0";
        }
        String discount1 = discount.getText();
        if (discount1.equals(txtDiscout1) || discount1.isEmpty()) {
            discount1 = "0";
        }
//        String paid1 = paid.getText();
//        if (paid1.equals(txtPaid1) || paid1.isEmpty()) {
//            paid1 = "0";
//        }
        double productPurchasePrice = (Double.parseDouble(quantity1) * Double.parseDouble(buyingPrice1))
                - (Double.parseDouble(discount1));

        if (productPurchasePrice > 0) {
            txtTotal.setText(String.valueOf(productPurchasePrice));
        } else {

        }

        //double dueResult = productPurchasePrice - Double.parseDouble(paid1);
        //txtDue.setText(String.valueOf(dueResult));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        lb_id = new javax.swing.JLabel();
        lbManufacturerID = new javax.swing.JLabel();
        UserId = new javax.swing.JLabel();
        lbSelectRoleOfUsers = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtCompany = new javax.swing.JTextField();
        txtSearchUser = new javax.swing.JTextField();
        lbSearchBoxOfUser = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        JTabelUserSuggest = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        txtSku = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        lb_stock = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtDiscout = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtsellingPrice = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        txtTotalAmount = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        txtDue = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        txtPaid = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnSaved2 = new javax.swing.JButton();
        jComboBoxManufacture = new javax.swing.JComboBox<>();
        jPanelProductsSugest = new javax.swing.JScrollPane();
        jTableProductSuggest = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();
        lbimage = new javax.swing.JLabel();
        lbRandom = new javax.swing.JLabel();
        lb_role = new javax.swing.JLabel();
        lbPreDue = new javax.swing.JLabel();
        lbPrePaid = new javax.swing.JLabel();
        jComboBoxUserRoles = new javax.swing.JComboBox<>();

        setBackground(java.awt.Color.white);

        jPanel11.setBackground(java.awt.Color.white);
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel13.setForeground(java.awt.Color.black);
        jLabel13.setText("Products Stock entry");
        jPanel11.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 23, 190, 23));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel12.setForeground(java.awt.Color.black);
        jLabel12.setText("Stock in");
        jPanel11.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, -1));
        jPanel11.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 44, 940, 10));

        lb_id.setText("ID:");
        jPanel11.add(lb_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 30, 20));

        lbManufacturerID.setText("M_ID");
        jPanel11.add(lbManufacturerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        UserId.setText("U_ID");
        jPanel11.add(UserId, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        lbSelectRoleOfUsers.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbSelectRoleOfUsers.setForeground(java.awt.Color.black);
        lbSelectRoleOfUsers.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSelectRoleOfUsers.setText("Firstly Select User group");
        jPanel11.add(lbSelectRoleOfUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 210, 24));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel15.setForeground(java.awt.Color.black);
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Phone Number");
        jPanel11.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 188, 24));

        txtPhone.setEditable(false);
        txtPhone.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(115, 135, 156));
        txtPhone.setText("Phone");
        txtPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPhoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPhoneFocusLost(evt);
            }
        });
        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhoneKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhoneKeyReleased(evt);
            }
        });
        jPanel11.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 188, 30));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel16.setForeground(java.awt.Color.black);
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Company Name");
        jPanel11.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 188, 24));

        txtCompany.setEditable(false);
        txtCompany.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtCompany.setForeground(new java.awt.Color(115, 135, 156));
        txtCompany.setText("Company Name");
        txtCompany.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCompanyFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCompanyFocusLost(evt);
            }
        });
        txtCompany.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCompanyKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCompanyKeyReleased(evt);
            }
        });
        jPanel11.add(txtCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 188, -1));

        txtSearchUser.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtSearchUser.setForeground(new java.awt.Color(115, 135, 156));
        txtSearchUser.setText("Name/Mobile/ID");
        txtSearchUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchUserFocusLost(evt);
            }
        });
        txtSearchUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchUserActionPerformed(evt);
            }
        });
        txtSearchUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchUserKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchUserKeyReleased(evt);
            }
        });
        jPanel11.add(txtSearchUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 200, -1));

        lbSearchBoxOfUser.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbSearchBoxOfUser.setForeground(java.awt.Color.black);
        lbSearchBoxOfUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSearchBoxOfUser.setText("User Name/mobile/ID");
        jPanel11.add(lbSearchBoxOfUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 188, 20));

        jScrollPane6.setBackground(new java.awt.Color(42, 93, 240));
        jScrollPane6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(70, 166, 244), 2, true));
        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jScrollPane6MouseExited(evt);
            }
        });

        JTabelUserSuggest.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        JTabelUserSuggest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTabelUserSuggest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTabelUserSuggestMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JTabelUserSuggestMouseExited(evt);
            }
        });
        JTabelUserSuggest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTabelUserSuggestKeyPressed(evt);
            }
        });
        jScrollPane6.setViewportView(JTabelUserSuggest);

        jPanel11.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 400, 110));

        jPanel10.setBackground(java.awt.Color.white);
        jPanel10.setBorder(null);
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSku.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtSku.setForeground(new java.awt.Color(115, 135, 156));
        txtSku.setText("Sku or Id");
        txtSku.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(221, 223, 253), 1, true));
        txtSku.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSkuFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSkuFocusLost(evt);
            }
        });
        txtSku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSkuKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSkuKeyReleased(evt);
            }
        });
        jPanel10.add(txtSku, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, 30));

        jPanel3.setBackground(new java.awt.Color(221, 223, 253));
        jPanel3.setBorder(null);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(java.awt.Color.black);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Qty :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        txtQuantity.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtQuantity.setForeground(new java.awt.Color(115, 135, 156));
        txtQuantity.setText("0");
        txtQuantity.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(221, 223, 253), 1, true));
        txtQuantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtQuantityFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantityFocusLost(evt);
            }
        });
        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantityKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQuantityKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantityKeyReleased(evt);
            }
        });
        jPanel3.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 120, 30));

        lb_stock.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lb_stock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_stock.setText("0");
        jPanel3.add(lb_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 30, 30));

        jPanel10.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 200, 30));

        jPanel4.setBackground(new java.awt.Color(221, 223, 253));
        jPanel4.setBorder(null);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPrice.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtPrice.setForeground(new java.awt.Color(115, 135, 156));
        txtPrice.setText("0");
        txtPrice.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(221, 223, 253), 1, true));
        txtPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPriceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPriceFocusLost(evt);
            }
        });
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriceKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPriceKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPriceKeyReleased(evt);
            }
        });
        jPanel4.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 150, 30));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(java.awt.Color.black);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Price :");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 30));

        jPanel10.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 200, 30));

        jPanel5.setBackground(new java.awt.Color(221, 223, 253));
        jPanel5.setBorder(null);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDiscout.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtDiscout.setForeground(new java.awt.Color(115, 135, 156));
        txtDiscout.setText("0");
        txtDiscout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 223, 253)));
        txtDiscout.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDiscoutFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDiscoutFocusLost(evt);
            }
        });
        txtDiscout.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiscoutKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDiscoutKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiscoutKeyReleased(evt);
            }
        });
        jPanel5.add(txtDiscout, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 150, 30));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(java.awt.Color.black);
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Dis :");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        jPanel10.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 200, 30));

        jPanel6.setBackground(new java.awt.Color(221, 223, 253));
        jPanel6.setBorder(null);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(115, 135, 156));
        txtTotal.setText("0");
        txtTotal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(221, 223, 253), 1, true));
        txtTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTotalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTotalFocusLost(evt);
            }
        });
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        jPanel6.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 150, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setForeground(java.awt.Color.black);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Total :");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 0, -1, 30));

        jPanel10.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 200, 30));

        jPanel7.setBackground(new java.awt.Color(221, 223, 253));
        jPanel7.setBorder(null);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtsellingPrice.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtsellingPrice.setForeground(new java.awt.Color(115, 135, 156));
        txtsellingPrice.setText("0");
        txtsellingPrice.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(221, 223, 253), 1, true));
        txtsellingPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtsellingPriceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtsellingPriceFocusLost(evt);
            }
        });
        txtsellingPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsellingPriceKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsellingPriceKeyPressed(evt);
            }
        });
        jPanel7.add(txtsellingPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 150, 30));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(java.awt.Color.black);
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Sells Pri :");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        jPanel10.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, 30));

        jPanel9.setBackground(new java.awt.Color(221, 223, 253));
        jPanel9.setBorder(null);
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTotalAmount.setEditable(false);
        txtTotalAmount.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtTotalAmount.setForeground(new java.awt.Color(115, 135, 156));
        txtTotalAmount.setText("0");
        txtTotalAmount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTotalAmountFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTotalAmountFocusLost(evt);
            }
        });
        txtTotalAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalAmountKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTotalAmountKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTotalAmountKeyReleased(evt);
            }
        });
        jPanel9.add(txtTotalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 150, 30));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setForeground(java.awt.Color.black);
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Total :");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 30));

        jPanel10.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 200, 30));

        btnBack.setBackground(new java.awt.Color(0, 51, 153));
        btnBack.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(250, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/iconsback.png"))); // NOI18N
        btnBack.setText("BACK");
        btnBack.setAlignmentY(0.0F);
        btnBack.setBorderPainted(false);
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.setIconTextGap(14);
        btnBack.setOpaque(true);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel10.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 110, 30));

        jPanel8.setBackground(new java.awt.Color(221, 223, 253));
        jPanel8.setBorder(null);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDue.setEditable(false);
        txtDue.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtDue.setForeground(new java.awt.Color(115, 135, 156));
        txtDue.setText("0");
        txtDue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDueFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDueFocusLost(evt);
            }
        });
        jPanel8.add(txtDue, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 140, 30));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(java.awt.Color.black);
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Due :");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 30));

        jPanel10.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 190, 30));

        btnAdd.setBackground(new java.awt.Color(0, 51, 153));
        btnAdd.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(250, 255, 255));
        btnAdd.setText("Add");
        btnAdd.setAlignmentY(0.0F);
        btnAdd.setBorderPainted(false);
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setOpaque(true);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        btnAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAddKeyPressed(evt);
            }
        });
        jPanel10.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 60, 110, 30));

        jButton2.setBackground(new java.awt.Color(254, 254, 254));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/icon8_printer_20.png"))); // NOI18N
        jButton2.setToolTipText("Print the report");
        jButton2.setBorder(null);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 270, 30, 30));

        jButton3.setBackground(new java.awt.Color(254, 254, 254));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/clean-20.png"))); // NOI18N
        jButton3.setToolTipText("Clean Field");
        jButton3.setBorder(null);
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, 30, 30));

        jPanel12.setBackground(new java.awt.Color(221, 223, 253));
        jPanel12.setBorder(null);
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPaid.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtPaid.setForeground(new java.awt.Color(115, 135, 156));
        txtPaid.setText("0");
        txtPaid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPaidFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPaidFocusLost(evt);
            }
        });
        txtPaid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPaidKeyReleased(evt);
            }
        });
        jPanel12.add(txtPaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 150, 30));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel17.setForeground(java.awt.Color.black);
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Paid :");
        jPanel12.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 30));

        jPanel10.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 210, 30));

        btnSaved2.setBackground(new java.awt.Color(0, 51, 153));
        btnSaved2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnSaved2.setForeground(new java.awt.Color(250, 255, 255));
        btnSaved2.setText("Submit");
        btnSaved2.setAlignmentY(0.0F);
        btnSaved2.setBorderPainted(false);
        btnSaved2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaved2.setOpaque(true);
        btnSaved2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaved2ActionPerformed(evt);
            }
        });
        jPanel10.add(btnSaved2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 270, 130, 30));

        jComboBoxManufacture.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Manufacturer" }));
        jComboBoxManufacture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxManufactureActionPerformed(evt);
            }
        });
        jPanel10.add(jComboBoxManufacture, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 220, 30));

        jPanelProductsSugest.setBackground(new java.awt.Color(254, 254, 254));
        jPanelProductsSugest.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(70, 166, 244), 2, true));
        jPanelProductsSugest.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jPanelProductsSugest.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTableProductSuggest.setBackground(new java.awt.Color(254, 254, 254));
        jTableProductSuggest.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTableProductSuggest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableProductSuggest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductSuggestMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTableProductSuggestMouseExited(evt);
            }
        });
        jTableProductSuggest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableProductSuggestKeyPressed(evt);
            }
        });
        jPanelProductsSugest.setViewportView(jTableProductSuggest);

        jPanel10.add(jPanelProductsSugest, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 168, 128));

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));

        jTableProducts.setBackground(new java.awt.Color(254, 254, 254));
        jTableProducts.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jTableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Manufacturer", "Qty", "Price", "Dis", "Sell price", "Total price", "/", "X"
            }
        ));
        jTableProducts.setRowHeight(30);
        jTableProducts.setSelectionBackground(new java.awt.Color(254, 254, 254));
        jTableProducts.setSelectionForeground(new java.awt.Color(1, 1, 1));
        jTableProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProducts);

        jPanel10.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 950, 140));

        jPanel11.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, 319));

        lbimage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/default-Users.png"))); // NOI18N
        lbimage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(70, 166, 244), 2, true));
        jPanel11.add(lbimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 60, 100, 80));

        lbRandom.setText("Random");
        jPanel11.add(lbRandom, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, -1, -1));

        lb_role.setText("role");
        jPanel11.add(lb_role, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, -1, -1));

        lbPreDue.setText("Due");
        jPanel11.add(lbPreDue, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, -1, -1));

        lbPrePaid.setText("Paid");
        jPanel11.add(lbPrePaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, -1, -1));

        jPanel11.add(jComboBoxUserRoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 190, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableProductSuggestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductSuggestMouseClicked
        int i = jTableProductSuggest.getSelectedRow();
        TableModel table = jTableProductSuggest.getModel();

        String id = table.getValueAt(i, 1).toString();
        String name = table.getValueAt(i, 0).toString();
        StockInModel model = controller.SingleProductView(id);

        lb_id.setText(id);
        txtSku.setText(name);

        if (model.getStock() == null) {
            lb_stock.setText("0");
        }

        lb_stock.setText(model.getStock());
        txtsellingPrice.setText(model.getSellingPrice());

        try {
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(model.getImages()).getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH));
            lbimage.setIcon(imageIcon);
        } catch (Exception e) {
            System.out.println("image Exception :" + e);
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/IconImage/default_image.png")).getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH));
            lbimage.setIcon(imageIcon);
            // lbimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/default_image.png")));
        }

        jPanelProductsSugest.setVisible(false);
    }//GEN-LAST:event_jTableProductSuggestMouseClicked

    private void jTableProductSuggestKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableProductSuggestKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int i = jTableProductSuggest.getSelectedRow();
            TableModel table = jTableProductSuggest.getModel();

            String id = table.getValueAt(i, 1).toString();
            String name = table.getValueAt(i, 0).toString();
            StockInModel model = controller.SingleProductView(id);

            lb_id.setText(id);
            txtSku.setText(name);
            lb_stock.setText(model.getStock());
            txtsellingPrice.setText(model.getSellingPrice());
            txtDiscout.setText("0");
            txtTotal.setText("0");
            txtDue.setText("0");
            txtTotalAmount.setText("0");
            txtQuantity.requestFocus();
            jPanelProductsSugest.setVisible(false);
        }

        if ((evt.getKeyCode() == KeyEvent.VK_UP) && ((evt.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            if (txtSku.getText().isEmpty()) {
                txtSku.setText("Sku or Id");
            }
            txtSku.requestFocus();

            jPanelProductsSugest.setVisible(false);
        }
    }//GEN-LAST:event_jTableProductSuggestKeyPressed

    private void txtSkuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSkuFocusGained
        placeHolder.placeHolder(txtSku1, txtSku);
    }//GEN-LAST:event_txtSkuFocusGained

    private void txtSkuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSkuFocusLost
        placeHolder.placeHolder(txtSku1, txtSku);
    }//GEN-LAST:event_txtSkuFocusLost

    private void txtSkuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSkuKeyPressed
        if (evt.getKeyCode() == evt.VK_DOWN) {
            jPanelProductsSugest.setVisible(true);
            jTableProductSuggest.requestFocus();

        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtQuantity.requestFocus();
        }

        if ((evt.getKeyCode() == KeyEvent.VK_LEFT) && ((evt.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            txtSearchUser.requestFocus();
            jPanelProductsSugest.setVisible(false);
        }
        if ((evt.getKeyCode() == KeyEvent.VK_P) && ((evt.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            txtPaid.requestFocus();
            jPanelProductsSugest.setVisible(false);
        }
    }//GEN-LAST:event_txtSkuKeyPressed

    private void txtSkuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSkuKeyReleased
        controller.FilterBysearchField(txtSku.getText(), jTableProductSuggest);
        if (jTableProductSuggest.getRowCount() != 0) {
            jPanelProductsSugest.setVisible(true);
        } else {
            jPanelProductsSugest.setVisible(false);
        }

    }//GEN-LAST:event_txtSkuKeyReleased

    private void txtQuantityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantityFocusGained
        placeHolder.placeHolder(txtQuantity1, txtQuantity);
    }//GEN-LAST:event_txtQuantityFocusGained

    private void txtQuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantityFocusLost
        placeHolder.placeHolder(txtQuantity1, txtQuantity);
    }//GEN-LAST:event_txtQuantityFocusLost

    private void txtQuantityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtPrice.requestFocus();
        }
    }//GEN-LAST:event_txtQuantityKeyPressed

    private void txtQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyReleased

        calculation(txtQuantity, txtPrice, txtDiscout, txtTotalAmount);
        jPanelProductsSugest.setVisible(false);

    }//GEN-LAST:event_txtQuantityKeyReleased

    private void txtQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtQuantityKeyTyped

    private void txtPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceFocusGained
        placeHolder.placeHolder(txtPrice1, txtPrice);
    }//GEN-LAST:event_txtPriceFocusGained

    private void txtPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceFocusLost
        placeHolder.placeHolder(txtPrice1, txtPrice);
    }//GEN-LAST:event_txtPriceFocusLost

    private void txtPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtDiscout.requestFocus();
        }
    }//GEN-LAST:event_txtPriceKeyPressed

    private void txtPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyReleased
        calculation(txtQuantity, txtPrice, txtDiscout, txtTotalAmount);
    }//GEN-LAST:event_txtPriceKeyReleased

    private void txtPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPriceKeyTyped

    private void txtDiscoutFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiscoutFocusGained
        placeHolder.placeHolder(txtDiscout1, txtDiscout);
    }//GEN-LAST:event_txtDiscoutFocusGained

    private void txtDiscoutFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiscoutFocusLost
        placeHolder.placeHolder(txtDiscout1, txtDiscout);
    }//GEN-LAST:event_txtDiscoutFocusLost

    private void txtDiscoutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscoutKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtsellingPrice.requestFocus();
        }
    }//GEN-LAST:event_txtDiscoutKeyPressed

    private void txtDiscoutKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscoutKeyReleased
        calculation(txtQuantity, txtPrice, txtDiscout, txtTotalAmount);
    }//GEN-LAST:event_txtDiscoutKeyReleased

    private void txtDiscoutKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscoutKeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDiscoutKeyTyped

    private void txtTotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalFocusGained
        placeHolder.placeHolder(txtTotal1, txtTotal);
    }//GEN-LAST:event_txtTotalFocusGained

    private void txtTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalFocusLost
        placeHolder.placeHolder(txtTotal1, txtTotal);
    }//GEN-LAST:event_txtTotalFocusLost

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtsellingPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsellingPriceFocusGained
        placeHolder.placeHolder(txtsellingPrice1, txtsellingPrice);
    }//GEN-LAST:event_txtsellingPriceFocusGained

    private void txtsellingPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsellingPriceFocusLost
        placeHolder.placeHolder(txtsellingPrice1, txtsellingPrice);
    }//GEN-LAST:event_txtsellingPriceFocusLost

    private void txtsellingPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsellingPriceKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jComboBoxManufacture.requestFocus();
        }
    }//GEN-LAST:event_txtsellingPriceKeyPressed

    private void txtsellingPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsellingPriceKeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtsellingPriceKeyTyped

    private void txtDueFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDueFocusGained
        placeHolder.placeHolder(txtDue1, txtDue);
    }//GEN-LAST:event_txtDueFocusGained

    private void txtDueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDueFocusLost
        placeHolder.placeHolder(txtDue1, txtDue);
    }//GEN-LAST:event_txtDueFocusLost

    private void txtTotalAmountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalAmountFocusGained
        placeHolder.placeHolder(txtPaid1, txtTotalAmount);
    }//GEN-LAST:event_txtTotalAmountFocusGained

    private void txtTotalAmountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalAmountFocusLost
        placeHolder.placeHolder(txtPaid1, txtTotalAmount);
    }//GEN-LAST:event_txtTotalAmountFocusLost

    private void txtTotalAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalAmountKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jComboBoxManufacture.requestFocus();
        }
    }//GEN-LAST:event_txtTotalAmountKeyPressed

    private void txtTotalAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalAmountKeyReleased
        calculation(txtQuantity, txtPrice, txtDiscout, txtTotalAmount);
    }//GEN-LAST:event_txtTotalAmountKeyReleased

    private void txtTotalAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalAmountKeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTotalAmountKeyTyped

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        if (btnSaved2.getText().equals("Update")) {
            panelController.showPanelWindow(new PurchasesCustom());
        } else {
            panelController.showPanelWindow(new SubMenuOfPurchase());
        }

    }//GEN-LAST:event_btnBackActionPerformed

    private void txtSearchUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchUserFocusGained
        placeHolder.placeHolder(txtSearchUser1, txtSearchUser);
    }//GEN-LAST:event_txtSearchUserFocusGained

    private void txtSearchUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchUserFocusLost
        placeHolder.placeHolder(txtSearchUser1, txtSearchUser);
    }//GEN-LAST:event_txtSearchUserFocusLost

    private void txtSearchUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchUserKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            jScrollPane6.setVisible(true);
            JTabelUserSuggest.requestFocus();
            JTabelUserSuggest.setSelectionMode(1);
        }

        if (evt.getKeyCode() == Event.ENTER) {
            String searchBox = txtSearchUser.getText();
            String UserRole = jComboBoxUserRoles.getSelectedItem().toString();

            if (!UserRole.equals("Select User Roles") || !(searchBox.equals("Name/Mobile/ID") || searchBox.isEmpty())) {
                lbSelectRoleOfUsers.setForeground(Color.black);
                lbSearchBoxOfUser.setForeground(Color.black);
                controller.SearchByUserInfo(JTabelUserSuggest, txtSearchUser.getText(), jComboBoxUserRoles.getSelectedItem().toString());

            } else {
                lbSearchBoxOfUser.setForeground(Color.red);
                lbSelectRoleOfUsers.setForeground(Color.red);
            }

        }
    }//GEN-LAST:event_txtSearchUserKeyPressed

    private void txtPhoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneFocusGained
        placeHolder.placeHolder(txtPhone1, txtPhone);
    }//GEN-LAST:event_txtPhoneFocusGained

    private void txtPhoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneFocusLost
        placeHolder.placeHolder(txtPhone1, txtPhone);
    }//GEN-LAST:event_txtPhoneFocusLost

    private void txtPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneKeyPressed

    private void txtPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneKeyReleased

    private void txtCompanyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCompanyFocusGained
        placeHolder.placeHolder(txtCompany1, txtCompany);
    }//GEN-LAST:event_txtCompanyFocusGained

    private void txtCompanyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCompanyFocusLost
        placeHolder.placeHolder(txtCompany1, txtCompany);
    }//GEN-LAST:event_txtCompanyFocusLost

    private void txtCompanyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCompanyKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompanyKeyPressed

    private void txtCompanyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCompanyKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompanyKeyReleased

    private void txtSearchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchUserActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if (btnSaved2.getText().equals("Submit")) {
            AddDataToTable();
            String FullTotal = txtTotalAmount.getText();
            String txtPaidValue = txtPaid.getText();
            finalCalculation(FullTotal, txtPaidValue);
        } else if (btnSaved2.getText().equals("Update")) {
            if (checkInputField(txtSku.getText(), txtQuantity.getText(), txtPrice.getText(), txtTotal.getText(), txtsellingPrice.getText(), jComboBoxManufacture.getSelectedItem().toString(), UserId.getText()) == true) {
                String Pro_TotalPrice = txtTotal.getText();
                txtTotalAmount.setText(String.valueOf(Double.parseDouble(txtTotalAmount.getText()) + Double.parseDouble(Pro_TotalPrice)));
                controller.AddQTY(txtQuantity.getText(), lb_id.getText());
                String fullTotal = txtTotalAmount.getText();
                String paidAmount = lbPrePaid.getText();
                System.out.println("Full TOtal: " + fullTotal);
                System.out.println("Paid: " + lbPrePaid.getText());
                double dueValue = Double.parseDouble(fullTotal) - Double.parseDouble(paidAmount);
                System.out.println("DUE: " + String.valueOf(dueValue));
                txtDue.setText(String.valueOf(dueValue));
                AddDataToTable();
            }

        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void AddDataToTable() {
        String u_id = UserId.getText();
        String M_ID = lbManufacturerID.getText();
        String id = lb_id.getText();
        String sku = txtSku.getText();
        String manufacturer = jComboBoxManufacture.getSelectedItem().toString();
        String Qty = txtQuantity.getText();
        String price = txtPrice.getText();
        String Total = txtTotal.getText();
        String dis = txtDiscout.getText();
        String sellPrice = txtsellingPrice.getText();
        String totalPrice = txtTotal.getText();
        //CustomProductsTable();
        if (checkInputField(sku, Qty, price, Total, sellPrice, manufacturer, u_id) == true) {

            DefaultTableModel defaultTableModel = (DefaultTableModel) jTableProducts.getModel();
            String manufacturerName = lbManufacturerID.getText();
            if (!manufacturerName.equals("M_ID") || !manufacturerName.isEmpty()) {
                if (productExistOrNot(id) != false) {
                    JButton btnEdit = new JButton(new javax.swing.ImageIcon(getClass().getResource("/IconImage/iconsedit.png")));
                    JButton btnDel = new JButton(new javax.swing.ImageIcon(getClass().getResource("/IconImage/icons8-bin.png")));
                    btnEdit.setName("Edit");
                    btnDel.setName(M_ID);
                    defaultTableModel.addRow(new Object[]{id, sku, manufacturer,
                        Qty, price, dis, sellPrice,
                        totalPrice, btnEdit, btnDel});
                    if (btnSaved2.getText().equals("Submit")) {
                        priceCalculation();
                    }
                    cleanProducts();
                    txtSku.requestFocus();

                } else {
                    JOptionPane.showMessageDialog(null, "Already Taken");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Select Manufacturer");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fill up all Required Field");
        }
    }

    private boolean productExistOrNot(String productId) {

        for (int j = 0; j < jTableProducts.getRowCount(); j++) {
            String id = jTableProducts.getValueAt(j, 0).toString();
            if (id.equals(productId)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkInputField(String sku, String quantity,
            String price, String total, String sellingPrice, String Manufacturer, String userId) {

        int point = 0;
        if (sku.equals(txtSku1)) {
            point += 1;
        }
        if (quantity.equals(txtQuantity1)) {
            point += 1;
        }
        if (price.equals(txtPrice1)) {
            point += 1;
        }
        if (total.equals(txtTotal1)) {
            point += 1;
        }
        if (sellingPrice.equals(txtsellingPrice1)) {
            point += 1;
        }
        if (Manufacturer.equals("Select Manufacturer")) {
            point += 1;
        }
        if (userId == null) {
            point += 1;
        }
        if (point > 0) {
            return false;
        } else {
            return true;
        }
    }


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CustomProductsTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtPaidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPaidFocusGained
        placeHolder.placeHolder(txtPaid1, txtPaid);
    }//GEN-LAST:event_txtPaidFocusGained

    private void txtPaidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPaidFocusLost
        placeHolder.placeHolder(txtPaid1, txtPaid);
    }//GEN-LAST:event_txtPaidFocusLost

    private void JTabelUserSuggestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTabelUserSuggestMouseClicked
        int i = JTabelUserSuggest.getSelectedRow();
        TableModel table = JTabelUserSuggest.getModel();
        String id = table.getValueAt(i, 3).toString();
        System.out.println(id);
        Users user = controller.singleUserPicker(id);
        UserId.setText(id);
        txtSearchUser.setText(user.getName());
        txtPhone.setText(user.getUserPhone());
        txtCompany.setText(user.getCompany());
        jScrollPane6.setVisible(false);
    }//GEN-LAST:event_JTabelUserSuggestMouseClicked

    private void JTabelUserSuggestKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTabelUserSuggestKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int i = JTabelUserSuggest.getSelectedRow();
            TableModel table = JTabelUserSuggest.getModel();
            String id = table.getValueAt(i, 3).toString();
            Users user = controller.singleUserPicker(id);
            txtSearchUser.setText(user.getName());
            txtPhone.setText(user.getUserPhone());
            txtCompany.setText(user.getCompany());
            txtSku.requestFocus();
            jScrollPane6.setVisible(false);
        }

    }//GEN-LAST:event_JTabelUserSuggestKeyPressed

    private void txtSearchUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchUserKeyReleased
        jScrollPane6.setVisible(true);
        String searchBox = txtSearchUser.getText();
        String UserRole = jComboBoxUserRoles.getSelectedItem().toString();

        if (!UserRole.equals("Select User Roles") || !(searchBox.equals("Name/Mobile/ID") || searchBox.isEmpty())) {
            lbSelectRoleOfUsers.setForeground(Color.black);
            lbSearchBoxOfUser.setForeground(Color.black);
            controller.SearchByUserInfo(JTabelUserSuggest, searchBox, UserRole);
            if (JTabelUserSuggest.getRowCount() == 0) {
                jScrollPane6.setVisible(false);
            }
        } else {
            lbSearchBoxOfUser.setForeground(Color.red);
            lbSelectRoleOfUsers.setForeground(Color.red);
        }


    }//GEN-LAST:event_txtSearchUserKeyReleased

    private void btnSaved2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaved2ActionPerformed
        String uniqueID = lbRandom.getText();
        String userId = UserId.getText();
        String due = txtDue.getText();
        String paid = txtPaid.getText();
        String total = txtTotalAmount.getText();

        if (btnSaved2.getText().equals("Submit")) {
            uniqueID = String.valueOf(System.currentTimeMillis());

            String sql2 = "INSERT INTO `inventory_summary`(`inventory_unique_id`, `due`, `paid`, `totalPrice`,"
                    + "`customerId`) VALUES "
                    + "('" + uniqueID + "','" + due + "','" + paid + "','" + total + "','" + userId + "')";

            ArrayList<String> queryList = new ArrayList<>();

            for (int j = 0; j < jTableProducts.getRowCount(); j++) {
                String pro_id = jTableProducts.getValueAt(j, 0).toString();
                String pro_name = jTableProducts.getValueAt(j, 1).toString();
                String manufacturer = jTableProducts.getValueAt(j, 2).toString();
                String quantity = jTableProducts.getValueAt(j, 3).toString();
                String price = jTableProducts.getValueAt(j, 4).toString();
                String discount = jTableProducts.getValueAt(j, 5).toString();
                String sellsPrice = jTableProducts.getValueAt(j, 6).toString();
                String totalPrice = jTableProducts.getValueAt(j, 7).toString();

                String sql = "INSERT INTO `inventory1`(`unique_id`,`user_id`, `pro_id`, `name`, `manufacturer`, `quantity`, "
                        + "`price`, `discount`, `sellsPrice`, `totalPrice`,`createdBy`) VALUES "
                        + "('" + uniqueID + "','" + userId + "','" + pro_id + "','" + pro_name + "','" + manufacturer + "',"
                        + "'" + quantity + "','" + price + "','" + discount + "','" + sellsPrice + "','" + totalPrice + "','10213')";
                String sql1 = "UPDATE `stock_hand` SET `stock`=stock+" + quantity + " WHERE product_id='" + pro_id + "'";

                queryList.add(0, sql);
                queryList.add(1, sql1);

            }
            queryList.add(2, sql2);
            if (controller.addProduct(queryList) == true) {
                CustomProductsTable();
                cleanProducts();
                txtDue.setText(txtDue1);
                txtTotalAmount.setText(txtTotalAmount1);
                txtPaid.setText(txtPaid1);
            } else {
                System.out.println("Add Problem!!!");
            }

        } else if (btnSaved2.getText().equals("Update")) {
            String totalPaid = String.valueOf(Double.valueOf(lbPrePaid.getText()) + Double.valueOf(txtPaid.getText()));
            String completion = "No";
            List<String> listOfValue = new ArrayList<>();
            listOfValue.add(0, due);
            listOfValue.add(1, totalPaid);
            listOfValue.add(2, total);
            double dueValue = Double.valueOf(due);
            if (dueValue == 0) {
                completion = "Yes";
            } else if (dueValue > 0) {
                completion = "No";
            } else if (dueValue < 0) {
                completion = "Borrow";
            }

            listOfValue.add(3, userId);
            listOfValue.add(4, completion);
            listOfValue.add(5, uniqueID);

            if (controller.PurchaseupdateHistory(listOfValue) == true) {
                panelController.showPanelWindow(new PurchasesCustom());
            }

        }
    }//GEN-LAST:event_btnSaved2ActionPerformed

    private void JTabelUserSuggestMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTabelUserSuggestMouseExited

    }//GEN-LAST:event_JTabelUserSuggestMouseExited
    private void finalCalculation(String FullTotal, String txtPaidValue) {
        double cal;

        try {
            if (!FullTotal.isEmpty()) {
                if (!txtPaidValue.isEmpty()) {
                    cal = Double.parseDouble(FullTotal) - Double.parseDouble(txtPaidValue);
                    if (Double.parseDouble(txtDue.getText()) < 0) {
                        txtDue.setForeground(Color.red);
                        txtDue.setText(String.valueOf(cal));
                    } else {
                        txtDue.setForeground(new Color(115, 135, 156));
                        txtDue.setText(String.valueOf(cal));
                    }

                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Exception :" + e);
        }

    }

//    private void calculation2(String FullTotal, String txtPaidValue) {
//
//        try {
//            double cal;
//            if (!FullTotal.isEmpty()) {
//                if (!txtPaidValue.isEmpty()) {
//                    cal = Double.parseDouble(FullTotal) - Double.parseDouble(txtPaidValue);
//
//                    txtDue.setText(String.valueOf(cal));
//
//                }
//            }
//        } catch (NumberFormatException e) {
//            System.out.println("Exception :" + e);
//        }
//
//    }

    private void jTableProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductsMouseClicked
        int column = jTableProducts.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / jTableProducts.getRowHeight();

        if (row < jTableProducts.getRowCount() && row >= 0 && column < jTableProducts.getColumnCount() && column >= 0) {

            Object value = jTableProducts.getValueAt(row, column);

            if (value instanceof JButton) {
                ((JButton) value).doClick();

                JButton button = (JButton) value;

                if (button.getName().equals("Edit")) {
                    //--------PICK DATA from TABLE --------
                    DefaultTableModel model = (DefaultTableModel) jTableProducts.getModel();
                    int i = jTableProducts.getSelectedRow();
                    TableModel table = jTableProducts.getModel();
                    String Pro_id = table.getValueAt(i, 0).toString();
                    String Pro_Name = table.getValueAt(i, 1).toString();
                    String manufacturerName = table.getValueAt(i, 2).toString();
                    String Pro_Qty = table.getValueAt(i, 3).toString();
                    String Pro_Price = table.getValueAt(i, 4).toString();
                    String Pro_Dis = table.getValueAt(i, 5).toString();
                    String Pro_SellsPrice = table.getValueAt(i, 6).toString();
                    String Pro_TotalPrice = table.getValueAt(i, 7).toString();
                    String manuf_id = dynamicDropDownValue.getComboboxGroupId("manufacturers", manufacturerName);

                    //------ Entry Data -------------
                    if (btnSaved2.getText().equals("Submit")) {
                        JOptionPane.showMessageDialog(null, "Edit your products:" + button.getName());
                        lb_id.setText(Pro_id);
                        System.out.println("Submit:" + Pro_id);
                        txtSku.setText(Pro_Name);
                        txtQuantity.setText(Pro_Qty);
                        txtPrice.setText(Pro_Price);
                        txtTotal.setText(Pro_TotalPrice);
                        txtDiscout.setText(Pro_Dis);
                        lbManufacturerID.setText(manuf_id);
                        jComboBoxManufacture.setSelectedItem(manufacturerName);
                        txtsellingPrice.setText(Pro_SellsPrice);
                        model.removeRow(jTableProducts.getSelectedRow());

                    } else {
                        // JOptionPane.showMessageDialog(null, "Delete :" + button.getName());
                        lb_id.setText(Pro_id);
                        System.out.println("Update:" + Pro_id);
                        txtSku.setText(Pro_Name);
                        txtQuantity.setText(Pro_Qty);
                        txtPrice.setText(Pro_Price);
                        txtTotal.setText(Pro_TotalPrice);
                        txtDiscout.setText(Pro_Dis);
                        lbManufacturerID.setText(manuf_id);
                        jComboBoxManufacture.setSelectedItem(manufacturerName);
                        txtsellingPrice.setText(Pro_SellsPrice);

                        txtDue.setText(String.valueOf(Double.parseDouble(txtDue.getText()) - Double.parseDouble(Pro_TotalPrice)));
                        txtTotalAmount.setText(String.valueOf(Double.parseDouble(txtTotalAmount.getText()) - Double.parseDouble(Pro_TotalPrice)));
                        model.removeRow(jTableProducts.getSelectedRow());
                        lb_stock.setText(controller.QtyOfProducts(Pro_id));
                        controller.removeQuantity(Pro_id, Pro_Qty);

                        JOptionPane.showMessageDialog(null, "Update" + button.getName());
                    }

                } else if (!button.getName().equals("Edit")) {
                    //System.out.println(button.getName());
                    DefaultTableModel model = (DefaultTableModel) jTableProducts.getModel();

                    if (jTableProducts.getSelectedRow() == -1) {
                        if (jTableProducts.getRowCount() == 0) {
                            JOptionPane.showMessageDialog(null, "Empty Table Data", "Warning Message", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Select The Row", "Warning Message", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        int YesNo = JOptionPane.showConfirmDialog(null, "Are you sure", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
                        if (YesNo == 0) {
                            model.removeRow(jTableProducts.getSelectedRow());
                            JOptionPane.showMessageDialog(null, "Successfully Deleted!");
                        }

                    }
                }
            }
        }

    }//GEN-LAST:event_jTableProductsMouseClicked

    private void jTableProductSuggestMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductSuggestMouseExited
        jPanelProductsSugest.setVisible(false);
    }//GEN-LAST:event_jTableProductSuggestMouseExited

    private void jScrollPane6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane6MouseExited
        jScrollPane6.setVisible(false);
    }//GEN-LAST:event_jScrollPane6MouseExited

    private void btnAddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            AddDataToTable();
        }
    }//GEN-LAST:event_btnAddKeyPressed

    private void txtPaidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaidKeyReleased

        String FullTotal = txtTotalAmount.getText();
        String txtPaidValue = txtPaid.getText();
        String lbRole = lb_role.getText();

        String paidValue = lbPreDue.getText();
        if (lbRole.equals("paid")) {
            paidValue = "0";
        }
        if (lbRole.equals("role")) {
            finalCalculation(FullTotal, txtPaidValue);
        } else {
            finalCalculation(paidValue, txtPaidValue);
        }

    }//GEN-LAST:event_txtPaidKeyReleased

    private void jComboBoxManufactureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxManufactureActionPerformed
        String manuf_id = dynamicDropDownValue.getComboboxGroupId("manufacturers", jComboBoxManufacture.getSelectedItem().toString());
        lbManufacturerID.setText(manuf_id);
    }//GEN-LAST:event_jComboBoxManufactureActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTabelUserSuggest;
    private javax.swing.JLabel UserId;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSaved2;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBoxManufacture;
    private javax.swing.JComboBox<String> jComboBoxUserRoles;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jPanelProductsSugest;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTableProductSuggest;
    private javax.swing.JTable jTableProducts;
    private javax.swing.JLabel lbManufacturerID;
    private javax.swing.JLabel lbPreDue;
    private javax.swing.JLabel lbPrePaid;
    private javax.swing.JLabel lbRandom;
    private javax.swing.JLabel lbSearchBoxOfUser;
    private javax.swing.JLabel lbSelectRoleOfUsers;
    private javax.swing.JLabel lb_id;
    private javax.swing.JLabel lb_role;
    private javax.swing.JLabel lb_stock;
    private javax.swing.JLabel lbimage;
    private javax.swing.JTextField txtCompany;
    private javax.swing.JTextField txtDiscout;
    private javax.swing.JTextField txtDue;
    private javax.swing.JTextField txtPaid;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearchUser;
    private javax.swing.JTextField txtSku;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalAmount;
    private javax.swing.JTextField txtsellingPrice;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frm_purchase_subpanel;

import Commons.ComboboxDesign;
import Commons.DaynamicDropDownValue;
import Commons.PanelController;
import Commons.TextPlaceholder;
import Commons.TxtBoxSpace;
import Controller.PurchaseController;
import Frm_products.SubMenuOfPurchase;
import Models.StockInModel;
import Models.Users;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author world
 */
public class Strock_in_Custom2 extends javax.swing.JPanel {

    int j = 0;
    double sum = 0;

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

    /**
     * Creates new form Strock_in_Custom2
     */
    public Strock_in_Custom2() {
        initComponents();

        dynamicDropDownValue.productItemList(jComboBoxUserRoles, "user_roles");
        comboDesign.comboDesign(jComboBoxUserRoles);

        dynamicDropDownValue.productItemList(jComboBoxManufacture, "manufacturers");
        comboDesign.comboDesign(jComboBoxManufacture);

        textSpacingMethod();
    }
/*
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
*/
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
//        txtBoxSpacing.txtBoxSpace(txtDue);
        txtBoxSpacing.txtBoxSpace(txtSearchUser);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbSelectRoleOfUsers = new javax.swing.JLabel();
        lbSearchBoxOfUser = new javax.swing.JLabel();
        txtSearchUser = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtCompany = new javax.swing.JTextField();
        lbimage = new javax.swing.JLabel();
        jComboBoxManufacture = new javax.swing.JComboBox<>();
        jComboBoxUserRoles = new javax.swing.JComboBox<>();
        txtSku = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        txtsellingPrice = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtDiscout = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtPrice = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        lb_stock = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        lbPreDue = new javax.swing.JLabel();
        lbPrePaid = new javax.swing.JLabel();
        lb_role = new javax.swing.JLabel();
        lbRandom = new javax.swing.JLabel();
        lb_id = new javax.swing.JLabel();
        lbManufacturerID = new javax.swing.JLabel();
        UserId = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        btnSaved2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbSelectRoleOfUsers.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbSelectRoleOfUsers.setForeground(java.awt.Color.black);
        lbSelectRoleOfUsers.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSelectRoleOfUsers.setText("Firstly Select User group");
        jPanel1.add(lbSelectRoleOfUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 200, 24));

        lbSearchBoxOfUser.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbSearchBoxOfUser.setForeground(java.awt.Color.black);
        lbSearchBoxOfUser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSearchBoxOfUser.setText("User Name/mobile/ID");
        jPanel1.add(lbSearchBoxOfUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 188, 20));

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
        jPanel1.add(txtSearchUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 200, -1));

        txtPhone.setEditable(false);
        txtPhone.setBackground(new java.awt.Color(221, 223, 253));
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
        jPanel1.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 200, -1));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel15.setForeground(java.awt.Color.black);
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Phone Number");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 188, 24));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel16.setForeground(java.awt.Color.black);
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Company Name");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 188, 24));

        txtCompany.setEditable(false);
        txtCompany.setBackground(new java.awt.Color(221, 223, 253));
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
        jPanel1.add(txtCompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 220, -1));

        lbimage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/default-Users.png"))); // NOI18N
        lbimage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(70, 166, 244), 2, true));
        jPanel1.add(lbimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 100, 100, 90));

        jComboBoxManufacture.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Manufacturer" }));
        jPanel1.add(jComboBoxManufacture, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 220, 30));

        jPanel1.add(jComboBoxUserRoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, 30));

        txtSku.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtSku.setForeground(new java.awt.Color(115, 135, 156));
        txtSku.setHorizontalAlignment(javax.swing.JTextField.LEFT);
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
        jPanel1.add(txtSku, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 30));

        jPanel7.setBackground(new java.awt.Color(221, 223, 253));
        jPanel7.setBorder(null);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtsellingPrice.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtsellingPrice.setForeground(new java.awt.Color(115, 135, 156));
        txtsellingPrice.setHorizontalAlignment(javax.swing.JTextField.LEFT);
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

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, -1, 30));

        jPanel6.setBackground(new java.awt.Color(221, 223, 253));
        jPanel6.setBorder(null);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(115, 135, 156));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.LEFT);
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

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 200, 30));

        jPanel5.setBackground(new java.awt.Color(221, 223, 253));
        jPanel5.setBorder(null);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDiscout.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtDiscout.setForeground(new java.awt.Color(115, 135, 156));
        txtDiscout.setHorizontalAlignment(javax.swing.JTextField.LEFT);
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

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 200, 30));

        jPanel4.setBackground(new java.awt.Color(221, 223, 253));
        jPanel4.setBorder(null);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPrice.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        txtPrice.setForeground(new java.awt.Color(115, 135, 156));
        txtPrice.setHorizontalAlignment(javax.swing.JTextField.LEFT);
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

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 200, 30));

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
        txtQuantity.setHorizontalAlignment(javax.swing.JTextField.LEFT);
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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 200, 30));

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
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 210, 110, 30));

        lbPreDue.setText("Due");
        jPanel1.add(lbPreDue, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, -1, -1));

        lbPrePaid.setText("Paid");
        jPanel1.add(lbPrePaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, -1, -1));

        lb_role.setText("role");
        jPanel1.add(lb_role, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, -1, -1));

        lbRandom.setText("Random");
        jPanel1.add(lbRandom, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, -1, -1));

        lb_id.setText("ID:");
        jPanel1.add(lb_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 30, 20));

        lbManufacturerID.setText("M_ID");
        jPanel1.add(lbManufacturerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        UserId.setText("U_ID");
        jPanel1.add(UserId, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel12.setForeground(java.awt.Color.black);
        jLabel12.setText("Stock in");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, -1));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel13.setForeground(java.awt.Color.black);
        jLabel13.setText("Products Stock entry");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 23, 190, 23));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 850, 10));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 44, 940, 10));

        jPanel2.setBackground(new java.awt.Color(229, 25, 73));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel2.add(btnSaved2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 140, 130, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, 160));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            AddDataToTable();
        }
    }//GEN-LAST:event_btnAddKeyPressed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
//
//        if (btnSaved2.getText().equals("Submit")) {
//     //       AddDataToTable();
//            String FullTotal = txtTotalAmount.getText();
//            String txtPaidValue = txtPaid.getText();
//      //      finalCalculation(FullTotal, txtPaidValue);
//        } else if (btnSaved2.getText().equals("Update")) {
//            if (checkInputField(txtSku.getText(), txtQuantity.getText(), txtPrice.getText(), txtTotal.getText(), txtsellingPrice.getText(), jComboBoxManufacture.getSelectedItem().toString(), UserId.getText()) == true) {
//                String Pro_TotalPrice = txtTotal.getText();
//                txtTotalAmount.setText(String.valueOf(Double.parseDouble(txtTotalAmount.getText()) + Double.parseDouble(Pro_TotalPrice)));
//                controller.AddQTY(txtQuantity.getText(), lb_id.getText());
//                String fullTotal = txtTotalAmount.getText();
//                String paidAmount = lbPrePaid.getText();
//                System.out.println("Full TOtal: " + fullTotal);
//                System.out.println("Paid: " + lbPrePaid.getText());
//                double dueValue = Double.parseDouble(fullTotal) - Double.parseDouble(paidAmount);
//
//                System.out.println("DUE: " + String.valueOf(dueValue));
//                txtDue.setText(String.valueOf(dueValue));
//
//      //          AddDataToTable();
//            }
//
//        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyReleased

  //      calculation(txtQuantity, txtPrice, txtDiscout, txtTotalAmount);
        //   jScrollPane5.setVisible(false);
    }//GEN-LAST:event_txtQuantityKeyReleased

    private void txtQuantityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtPrice.requestFocus();
        }
    }//GEN-LAST:event_txtQuantityKeyPressed

    private void txtQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtQuantityKeyTyped

    private void txtQuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantityFocusLost
        placeHolder.placeHolder(txtQuantity1, txtQuantity);
    }//GEN-LAST:event_txtQuantityFocusLost

    private void txtQuantityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantityFocusGained
        placeHolder.placeHolder(txtQuantity1, txtQuantity);
    }//GEN-LAST:event_txtQuantityFocusGained

    private void txtPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyReleased
     //   calculation(txtQuantity, txtPrice, txtDiscout, txtTotalAmount);
    }//GEN-LAST:event_txtPriceKeyReleased

    private void txtPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtDiscout.requestFocus();
        }
    }//GEN-LAST:event_txtPriceKeyPressed

    private void txtPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPriceKeyTyped

    private void txtPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceFocusLost
        placeHolder.placeHolder(txtPrice1, txtPrice);
    }//GEN-LAST:event_txtPriceFocusLost

    private void txtPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceFocusGained
        placeHolder.placeHolder(txtPrice1, txtPrice);
    }//GEN-LAST:event_txtPriceFocusGained

    private void txtDiscoutKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscoutKeyReleased
        // calculation(txtQuantity, txtPrice, txtDiscout, txtTotalAmount);
    }//GEN-LAST:event_txtDiscoutKeyReleased

    private void txtDiscoutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscoutKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtsellingPrice.requestFocus();
        }
    }//GEN-LAST:event_txtDiscoutKeyPressed

    private void txtDiscoutKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscoutKeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDiscoutKeyTyped

    private void txtDiscoutFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiscoutFocusLost
        placeHolder.placeHolder(txtDiscout1, txtDiscout);
    }//GEN-LAST:event_txtDiscoutFocusLost

    private void txtDiscoutFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiscoutFocusGained
        placeHolder.placeHolder(txtDiscout1, txtDiscout);
    }//GEN-LAST:event_txtDiscoutFocusGained

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalFocusLost
        placeHolder.placeHolder(txtTotal1, txtTotal);
    }//GEN-LAST:event_txtTotalFocusLost

    private void txtTotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTotalFocusGained
        placeHolder.placeHolder(txtTotal1, txtTotal);
    }//GEN-LAST:event_txtTotalFocusGained

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

    private void txtsellingPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsellingPriceFocusLost
        placeHolder.placeHolder(txtsellingPrice1, txtsellingPrice);
    }//GEN-LAST:event_txtsellingPriceFocusLost

    private void txtsellingPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtsellingPriceFocusGained
        placeHolder.placeHolder(txtsellingPrice1, txtsellingPrice);
    }//GEN-LAST:event_txtsellingPriceFocusGained

    private void txtSkuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSkuKeyReleased
        //        controller.FilterBysearchField(txtSku.getText(), jTableProductSuggest);
        //        if (jTableProductSuggest.getRowCount() != 0) {
            //            jScrollPane5.setVisible(true);
            //        } else {
            //            jScrollPane5.setVisible(false);
            //        }
    }//GEN-LAST:event_txtSkuKeyReleased

    private void txtSkuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSkuKeyPressed
        if (evt.getKeyCode() == evt.VK_DOWN) {
            //            jScrollPane5.setVisible(true);
            //            jTableProductSuggest.requestFocus();

        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //  txtQuantity.requestFocus();
        }

        if ((evt.getKeyCode() == KeyEvent.VK_LEFT) && ((evt.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            txtSearchUser.requestFocus();
            //  jPanelProductsSugest.setVisible(false);
        }
        if ((evt.getKeyCode() == KeyEvent.VK_P) && ((evt.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
//            txtPaid.requestFocus();
            //            jScrollPane5.setVisible(false);
        }
    }//GEN-LAST:event_txtSkuKeyPressed

    private void txtSkuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSkuFocusLost
        placeHolder.placeHolder(txtSku1, txtSku);
    }//GEN-LAST:event_txtSkuFocusLost

    private void txtSkuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSkuFocusGained
        placeHolder.placeHolder(txtSku1, txtSku);
    }//GEN-LAST:event_txtSkuFocusGained

    private void txtCompanyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCompanyKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompanyKeyReleased

    private void txtCompanyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCompanyKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompanyKeyPressed

    private void txtCompanyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCompanyFocusLost
        placeHolder.placeHolder(txtCompany1, txtCompany);
    }//GEN-LAST:event_txtCompanyFocusLost

    private void txtCompanyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCompanyFocusGained
        placeHolder.placeHolder(txtCompany1, txtCompany);
    }//GEN-LAST:event_txtCompanyFocusGained

    private void txtPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneKeyReleased

    private void txtPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneKeyPressed

    private void txtPhoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneFocusLost
        placeHolder.placeHolder(txtPhone1, txtPhone);
    }//GEN-LAST:event_txtPhoneFocusLost

    private void txtPhoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneFocusGained
        placeHolder.placeHolder(txtPhone1, txtPhone);
    }//GEN-LAST:event_txtPhoneFocusGained

    private void txtSearchUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchUserKeyReleased
        //  jScrollPane6.setVisible(true);
        String searchBox = txtSearchUser.getText();
        String UserRole = jComboBoxUserRoles.getSelectedItem().toString();

        if (!UserRole.equals("Select User Roles") || !(searchBox.equals("Name/Mobile/ID") || searchBox.isEmpty())) {
            lbSelectRoleOfUsers.setForeground(Color.black);
            lbSearchBoxOfUser.setForeground(Color.black);
            //            controller.SearchByUserInfo(JTabelUserSuggest, searchBox, UserRole);
            //            if (JTabelUserSuggest.getRowCount() == 0) {
                //                jScrollPane6.setVisible(false);
                //            }
        } else {
            lbSearchBoxOfUser.setForeground(Color.red);
            lbSelectRoleOfUsers.setForeground(Color.red);
        }
        // controller.SearchByUserInfo(JTabelUserSuggest, searchBox, UserRole);
    }//GEN-LAST:event_txtSearchUserKeyReleased

    private void txtSearchUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchUserKeyPressed
        if (evt.getKeyCode() == evt.VK_DOWN) {
            //            jScrollPane6.setVisible(true);
            //            JTabelUserSuggest.requestFocus();
            //            JTabelUserSuggest.setSelectionMode(1);
        }

        if (evt.getKeyCode() == evt.VK_ENTER) {
            String searchBox = txtSearchUser.getText();
            String UserRole = jComboBoxUserRoles.getSelectedItem().toString();

            if (!UserRole.equals("Select User Roles") || !(searchBox.equals("Name/Mobile/ID") || searchBox.isEmpty())) {
                lbSelectRoleOfUsers.setForeground(Color.black);
                lbSearchBoxOfUser.setForeground(Color.black);
                //                controller.SearchByUserInfo(JTabelUserSuggest, txtSearchUser.getText(), jComboBoxUserRoles.getSelectedItem().toString());

            } else {
                lbSearchBoxOfUser.setForeground(Color.red);
                lbSelectRoleOfUsers.setForeground(Color.red);
            }

        }
    }//GEN-LAST:event_txtSearchUserKeyPressed

    private void txtSearchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchUserActionPerformed

    private void txtSearchUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchUserFocusLost
        placeHolder.placeHolder(txtSearchUser1, txtSearchUser);
    }//GEN-LAST:event_txtSearchUserFocusLost

    private void txtSearchUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchUserFocusGained
        placeHolder.placeHolder(txtSearchUser1, txtSearchUser);
    }//GEN-LAST:event_txtSearchUserFocusGained

    private void btnSaved2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaved2ActionPerformed
//        String uniqueID = lbRandom.getText();
//        String userId = UserId.getText();
////        String due = txtDue.getText();
////        String paid = txtPaid.getText();
////        String total = txtTotalAmount.getText();
//
//        if (btnSaved2.getText().equals("Submit")) {
//            uniqueID = String.valueOf(System.currentTimeMillis());
//
////            String sql2 = "INSERT INTO `inventory_summary`(`inventory_unique_id`, `due`, `paid`, `totalPrice`,"
////            + "`customerId`) VALUES "
////            + "('" + uniqueID + "','" + due + "','" + paid + "','" + total + "','" + userId + "')";
//
//            ArrayList<String> queryList = new ArrayList<>();
//
//            for (int j = 0; j < jTableProducts.getRowCount(); j++) {
//                String pro_id = jTableProducts.getValueAt(j, 0).toString();
//                String pro_name = jTableProducts.getValueAt(j, 1).toString();
//                String manufacturer = jTableProducts.getValueAt(j, 2).toString();
//                String quantity = jTableProducts.getValueAt(j, 3).toString();
//                String price = jTableProducts.getValueAt(j, 4).toString();
//                String discount = jTableProducts.getValueAt(j, 5).toString();
//                String sellsPrice = jTableProducts.getValueAt(j, 6).toString();
//                String totalPrice = jTableProducts.getValueAt(j, 7).toString();
//
//                String sql = "INSERT INTO `inventory1`(`unique_id`,`user_id`, `pro_id`, `name`, `manufacturer`, `quantity`, "
//                + "`price`, `discount`, `sellsPrice`, `totalPrice`,`createdBy`) VALUES "
//                + "('" + uniqueID + "','" + userId + "','" + pro_id + "','" + pro_name + "','" + manufacturer + "',"
//                + "'" + quantity + "','" + price + "','" + discount + "','" + sellsPrice + "','" + totalPrice + "','10213')";
//                String sql1 = "UPDATE `stock_hand` SET `stock`=stock+" + quantity + " WHERE product_id='" + pro_id + "'";
//
//                queryList.add(0, sql);
//                queryList.add(1, sql1);
//
//            }
////            queryList.add(2, sql2);
//            if (controller.addProduct(queryList) == true) {
////                CustomProductsTable();
////                cleanProducts();
////                txtDue.setText(txtDue1);
////                txtTotalAmount.setText(txtTotalAmount1);
////                txtPaid.setText(txtPaid1);
//            } else {
//                System.out.println("Add Problem!!!");
//            }
//
//        } else if (btnSaved2.getText().equals("Update")) {
//  //          String totalPaid = String.valueOf(Double.valueOf(lbPrePaid.getText()) + Double.valueOf(txtPaid.getText()));
////            String completion = "No";
////            List<String> listOfValue = new ArrayList<>();
////            listOfValue.add(0, due);
//// //           listOfValue.add(1, totalPaid);
////            listOfValue.add(2, total);
////            double dueValue = Double.valueOf(due);
////            if (dueValue == 0) {
////                completion = "Yes";
////            } else if (dueValue > 0) {
////                completion = "No";
////            } else if (dueValue < 0) {
////                completion = "Borrow";
////            }
//
////            listOfValue.add(3, userId);
////            listOfValue.add(4, completion);
////            listOfValue.add(5, uniqueID);
////
////            if (controller.PurchaseupdateHistory(listOfValue) == true) {
////                panelController.showPanelWindow(new PurchasesCustom());
////            }
//
//        }
    }//GEN-LAST:event_btnSaved2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UserId;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnSaved2;
    private javax.swing.JComboBox<String> jComboBoxManufacture;
    private javax.swing.JComboBox<String> jComboBoxUserRoles;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable1;
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
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearchUser;
    private javax.swing.JTextField txtSku;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtsellingPrice;
    // End of variables declaration//GEN-END:variables
}

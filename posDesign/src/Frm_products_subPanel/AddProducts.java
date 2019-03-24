/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frm_products_subPanel;

import Commons.ComboboxDesign;
import Commons.DaynamicDropDownValue;
import Commons.NumberField;
import Commons.PanelController;
import Commons.TableBackgroundColor;
import Commons.TextPlaceholder;
import Commons.TxtBoxSpace;
import JDialogCustom.ErrorJDialog1;
import JDialogCustom.SuccessJDialog;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.view.JasperViewer;
import Controller.ProductsController;
import Frm_products.SubMenuOfProducts;
import Models.AddProductsModel;

import Models.ProductsEditModel;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Niklaus
 */
public class AddProducts extends javax.swing.JPanel {

    PanelController panelController = new PanelController();
    DaynamicDropDownValue dynamicDropDownValue = new DaynamicDropDownValue();
    String imagePath = null;
    byte[] ByteImage = null;
    int chectPic;
    String h = null;
    String serviceAndProduct = null;

    TextPlaceholder placeHolder = new TextPlaceholder();
    TxtBoxSpace txtBoxSpaceing = new TxtBoxSpace();
    ProductsController controller = new ProductsController();
    ComboboxDesign comboDesign = new ComboboxDesign();

    String name = "Name";
    String articalCode = "Article Code";
    String articalName = "Article Name";
    String operatingVoltage = "Operating voltage";
    String diameter = "Diameter/Bore";
    String strock = "Strocke";
    String measuring = "Measuring /Sensing range";
    String switchingOutput = "Switching output";
    String skuPlace = "SKU";
    String outputSignal = "Output signal";
    String sellingPrice = "Sells Price";
    String imagePathfield = "No file selected";

    public AddProducts() {
        initComponents();
        textSpacingMethod();
        dynamicDropDownValue.productItemList(jComboBoxManufacture, "manufacturers");
        dynamicDropDownValue.productItemList(jComboBoxVendor, "vendors");
        dynamicDropDownValue.productItemList(jComboBoxUnit, "units");
        new TableBackgroundColor().JTableDesign();

        jRadioButtonProducts.setSelected(true);
        btnSubmit.setText("Add");

        new TxtBoxSpace().txtBoxSpace(txtUserName);

        lbl_title.setText("Add to products / Services");
        comboDesign.comboDesign(jComboBoxUnit);
        comboDesign.comboDesign(jComboBoxManufacture);
        comboDesign.comboDesign(jComboBoxVendor);
        comboDesign.comboDesign(jComboBoxVendorStatus);

        ////hidden field method
        hiddenField();

    }

    private void hiddenField() {
        this.txtUserName.requestFocus();
        btnDelete1.setVisible(false);
        btnPrint.setVisible(false);
        btnView.setVisible(false);
        jComboBoxVendorStatus.setVisible(false);
        lbSatus.setVisible(false);
        lbId.setVisible(false);
        lbManufactureId.setVisible(false);
        lbVendorId1.setVisible(false);
        lbunitId2.setVisible(false);
        jPanel16.add(jTextAreaServiceDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 430, 30));
        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/iconadd.png")));

    }

    public AddProducts(String id) {
        initComponents();

        new ProductsController().productItemList(jComboBoxManufacture, "manufacturers");
        new ProductsController().productItemList(jComboBoxVendor, "vendors");
        new ProductsController().productItemList(jComboBoxUnit, "units");
        new TableBackgroundColor().JTableDesign();
        comboDesign.comboDesign(jComboBoxUnit);
        comboDesign.comboDesign(jComboBoxManufacture);
        comboDesign.comboDesign(jComboBoxVendor);
        comboDesign.comboDesign(jComboBoxVendorStatus);

        textSpacingMethod();

        ProductsEditModel model = controller.editProductsData(id);
        txtUserName.setText(model.getName());
        lbId.setText(model.getId());

        if (model.getType() == "Service") {
            jRadioButtonService.setSelected(true);
        } else {
            jRadioButtonProducts.setSelected(true);
        }

        jComboBoxManufacture.setSelectedItem(model.getManufacturer());
        String manuf_id = dynamicDropDownValue.getComboboxGroupId("manufacturers", model.getManufacturer());
        lbManufactureId.setText(manuf_id);
        jComboBoxVendor.setSelectedItem(model.getVendor());
        String vendor_id = dynamicDropDownValue.getComboboxGroupId("vendors", model.getVendor());
        lbVendorId1.setText(vendor_id);
        jComboBoxUnit.setSelectedItem(model.getUnit());
        String unit_id = dynamicDropDownValue.getComboboxGroupId("units", model.getUnit());
        lbunitId2.setText(unit_id);
        jComboBoxVendorStatus.setSelectedItem(model.getStatus());
        txtArticalCode.setText(model.getArticle_code());
        txtAricleName.setText(model.getArticle_name());
        txtOperatingVoltage.setText(model.getOperating_voltage());
        txtDiameter.setText(model.getDiameter_bore());
        txtStocke.setText(model.getStroke());
        txtMeasuring.setText(model.getMeansuring_sensing());
        txtSwichingOutput.setText(model.getSwitching_output());
        txtSKU1.setText(model.getSku());
        txtOutputSignal.setText(model.getOutput_signal());
        jComboBoxVendorStatus.setSelectedItem(model.getStatus());
        ByteImage = model.getImage();
        imgShow.setText("");
        h = id;
        chectPic = 1;
        try {
            txtimagePath1.setText(model.getImage().toString());
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(model.getImage()).getImage().getScaledInstance(200, 60, Image.SCALE_SMOOTH));
            imgShow.setIcon(imageIcon);
        } catch (Exception e) {
            System.out.println("image Exception :" + e);
            imgShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/default_image.png")));
        }
        txtSellingPrice.setText(model.getSelling_price());
        jTextAreaServiceDescription.setText(model.getService_description());
        fieldVisible();
    }

    private void fieldVisible() {
        this.txtUserName.requestFocus();
        lbId.setVisible(false);
        lbManufactureId.setVisible(false);
        lbVendorId1.setVisible(false);
        lbunitId2.setVisible(false);
        btnBack.setVisible(true);
        btnPrint.setVisible(true);
        btnView.setVisible(true);
        btnSubmit.setText("Update");
        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/iconsedit.png")));
        lbl_title.setText("Update to products / Services");
    }

    private void textSpacingMethod() {
        txtBoxSpaceing.txtBoxSpace(txtUserName);
        txtBoxSpaceing.txtBoxSpace(txtSKU1);
        txtBoxSpaceing.txtBoxSpace(txtArticalCode);
        txtBoxSpaceing.txtBoxSpace(txtAricleName);
        txtBoxSpaceing.txtBoxSpace(txtDiameter);
        txtBoxSpaceing.txtBoxSpace(txtOutputSignal);
        txtBoxSpaceing.txtBoxSpace(txtMeasuring);
        txtBoxSpaceing.txtBoxSpace(txtSwichingOutput);
        txtBoxSpaceing.txtBoxSpace(txtStocke);
        txtBoxSpaceing.txtBoxSpace(txtSellingPrice);
        txtBoxSpaceing.txtBoxSpace(txtOperatingVoltage);
        txtBoxSpaceing.txtBoxSpace(txtimagePath1);
    }

    private void backPress(java.awt.event.KeyEvent evt) {
        if ((evt.getKeyCode() == KeyEvent.VK_B) && ((evt.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            if (lbId.getText().equals("ID")) {
                panelController.showPanelWindow(new SubMenuOfProducts());
            } else {
                panelController.showPanelWindow(new Products());
            }
            //Jpanel_list.setVisible(false);
            //btnPrint.doClick();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        txtUserName = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jRadioButtonService = new javax.swing.JRadioButton();
        jRadioButtonProducts = new javax.swing.JRadioButton();
        lb6 = new javax.swing.JLabel();
        jComboBoxManufacture = new javax.swing.JComboBox<>();
        lb3 = new javax.swing.JLabel();
        jComboBoxVendor = new javax.swing.JComboBox<>();
        jPanel13 = new javax.swing.JPanel();
        jComboBoxUnit = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        txtArticalCode = new javax.swing.JTextField();
        lb07 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtAricleName = new javax.swing.JTextField();
        lb01 = new javax.swing.JLabel();
        txtOperatingVoltage = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        txtDiameter = new javax.swing.JTextField();
        lb05 = new javax.swing.JLabel();
        txtStocke = new javax.swing.JTextField();
        lb06 = new javax.swing.JLabel();
        txtMeasuring = new javax.swing.JTextField();
        lb03 = new javax.swing.JLabel();
        txtSwichingOutput = new javax.swing.JTextField();
        lb04 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        txtOutputSignal = new javax.swing.JTextField();
        lb9 = new javax.swing.JLabel();
        txtSKU1 = new javax.swing.JTextField();
        lb09 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        txtimagePath1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txtSellingPrice = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        lb02 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        lbId = new javax.swing.JLabel();
        jTextAreaServiceDescription = new javax.swing.JTextField();
        lbSatus = new javax.swing.JLabel();
        jComboBoxVendorStatus = new javax.swing.JComboBox<>();
        btnDelete1 = new javax.swing.JButton();
        lbunitId2 = new javax.swing.JLabel();
        lbVendorId1 = new javax.swing.JLabel();
        lbManufactureId = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        imgShow = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl_title = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUserName.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(115, 135, 156));
        txtUserName.setText("Name");
        txtUserName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        txtUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserNameFocusLost(evt);
            }
        });
        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserNameKeyPressed(evt);
            }
        });
        jPanel12.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, 206, 30));

        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(78, 78, 78));
        jLabel20.setText("Name *");
        jPanel12.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 135, -1));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(78, 78, 78));
        jLabel21.setText("Type *");
        jPanel12.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 135, -1));

        buttonGroup1.add(jRadioButtonService);
        jRadioButtonService.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jRadioButtonService.setForeground(new java.awt.Color(115, 135, 156));
        jRadioButtonService.setText("Service");
        jRadioButtonService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonServiceActionPerformed(evt);
            }
        });
        jRadioButtonService.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRadioButtonServiceKeyPressed(evt);
            }
        });
        jPanel12.add(jRadioButtonService, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, 30));

        buttonGroup1.add(jRadioButtonProducts);
        jRadioButtonProducts.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioButtonProducts.setForeground(new java.awt.Color(115, 135, 156));
        jRadioButtonProducts.setText("Product");
        jRadioButtonProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonProductsActionPerformed(evt);
            }
        });
        jRadioButtonProducts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRadioButtonProductsKeyPressed(evt);
            }
        });
        jPanel12.add(jRadioButtonProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, 30));

        lb6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lb6.setForeground(new java.awt.Color(78, 78, 78));
        lb6.setText("Manufacturer *");
        jPanel12.add(lb6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 125, -1));

        jComboBoxManufacture.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jComboBoxManufacture.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Manufacturer" }));
        jComboBoxManufacture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxManufactureActionPerformed(evt);
            }
        });
        jPanel12.add(jComboBoxManufacture, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 206, 30));

        lb3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lb3.setForeground(new java.awt.Color(78, 78, 78));
        lb3.setText("Vendor *");
        jPanel12.add(lb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 135, -1));

        jComboBoxVendor.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jComboBoxVendor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Vendor" }));
        jComboBoxVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxVendorActionPerformed(evt);
            }
        });
        jPanel12.add(jComboBoxVendor, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 206, 30));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxUnit.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jComboBoxUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unit Select" }));
        jComboBoxUnit.setOpaque(false);
        jComboBoxUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUnitActionPerformed(evt);
            }
        });
        jPanel13.add(jComboBoxUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 206, 30));

        jLabel35.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(78, 78, 78));
        jLabel35.setText("Unit *");
        jPanel13.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, -1));

        txtArticalCode.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtArticalCode.setForeground(new java.awt.Color(115, 135, 156));
        txtArticalCode.setText("Article Code");
        txtArticalCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        txtArticalCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtArticalCodeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtArticalCodeFocusLost(evt);
            }
        });
        jPanel13.add(txtArticalCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 206, 30));

        lb07.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lb07.setForeground(new java.awt.Color(78, 78, 78));
        lb07.setText("Article code *");
        jPanel13.add(lb07, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 135, -1));

        jLabel36.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(78, 78, 78));
        jLabel36.setText("Article Name");
        jPanel13.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 135, -1));

        txtAricleName.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtAricleName.setForeground(new java.awt.Color(115, 135, 156));
        txtAricleName.setText("Article Name");
        txtAricleName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        txtAricleName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAricleNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAricleNameFocusLost(evt);
            }
        });
        jPanel13.add(txtAricleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 206, 30));

        lb01.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lb01.setForeground(new java.awt.Color(78, 78, 78));
        lb01.setText("Operating voltage ");
        jPanel13.add(lb01, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 135, -1));

        txtOperatingVoltage.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtOperatingVoltage.setForeground(new java.awt.Color(115, 135, 156));
        txtOperatingVoltage.setText("Operating voltage");
        txtOperatingVoltage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        txtOperatingVoltage.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtOperatingVoltageFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOperatingVoltageFocusLost(evt);
            }
        });
        jPanel13.add(txtOperatingVoltage, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 206, 30));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDiameter.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtDiameter.setForeground(new java.awt.Color(115, 135, 156));
        txtDiameter.setText("Diameter/Bore");
        txtDiameter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        txtDiameter.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDiameterFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDiameterFocusLost(evt);
            }
        });
        jPanel14.add(txtDiameter, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 206, 30));

        lb05.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lb05.setForeground(new java.awt.Color(78, 78, 78));
        lb05.setText("Diameter/Bore");
        jPanel14.add(lb05, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 162, -1));

        txtStocke.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtStocke.setForeground(new java.awt.Color(115, 135, 156));
        txtStocke.setText("Strocke");
        txtStocke.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        txtStocke.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtStockeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStockeFocusLost(evt);
            }
        });
        jPanel14.add(txtStocke, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 206, 30));

        lb06.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lb06.setForeground(new java.awt.Color(78, 78, 78));
        lb06.setText("Stroke");
        jPanel14.add(lb06, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 158, -1));

        txtMeasuring.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtMeasuring.setForeground(new java.awt.Color(115, 135, 156));
        txtMeasuring.setText("Measuring /Sensing range");
        txtMeasuring.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        txtMeasuring.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMeasuringFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMeasuringFocusLost(evt);
            }
        });
        jPanel14.add(txtMeasuring, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 206, 30));

        lb03.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lb03.setForeground(new java.awt.Color(78, 78, 78));
        lb03.setText("Measuring/ Sensing range");
        jPanel14.add(lb03, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 191, -1));

        txtSwichingOutput.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtSwichingOutput.setForeground(new java.awt.Color(115, 135, 156));
        txtSwichingOutput.setText("Switching output");
        txtSwichingOutput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        txtSwichingOutput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSwichingOutputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSwichingOutputFocusLost(evt);
            }
        });
        jPanel14.add(txtSwichingOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 206, 30));

        lb04.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lb04.setForeground(new java.awt.Color(78, 78, 78));
        lb04.setText("Switching output");
        jPanel14.add(lb04, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 165, -1));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtOutputSignal.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtOutputSignal.setForeground(new java.awt.Color(115, 135, 156));
        txtOutputSignal.setText("Output signal");
        txtOutputSignal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        txtOutputSignal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtOutputSignalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOutputSignalFocusLost(evt);
            }
        });
        jPanel15.add(txtOutputSignal, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 430, 30));

        lb9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lb9.setForeground(new java.awt.Color(78, 78, 78));
        lb9.setText("Output signal");
        jPanel15.add(lb9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 360, -1));

        txtSKU1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtSKU1.setForeground(new java.awt.Color(115, 135, 156));
        txtSKU1.setText("SKU");
        txtSKU1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        txtSKU1.setPreferredSize(new java.awt.Dimension(60, 16));
        txtSKU1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSKU1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSKU1FocusLost(evt);
            }
        });
        jPanel15.add(txtSKU1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 427, 30));

        lb09.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lb09.setForeground(new java.awt.Color(78, 78, 78));
        lb09.setText("SKU");
        jPanel15.add(lb09, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 135, -1));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(78, 78, 78));
        jLabel32.setText("Image");
        jPanel16.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 124, -1));

        txtimagePath1.setEditable(false);
        txtimagePath1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtimagePath1.setForeground(new java.awt.Color(115, 135, 156));
        txtimagePath1.setText("No file selected");
        txtimagePath1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        txtimagePath1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtimagePath1ActionPerformed(evt);
            }
        });
        jPanel16.add(txtimagePath1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 132, 30));

        jButton2.setText("Browse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 76, 30));

        txtSellingPrice.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtSellingPrice.setForeground(new java.awt.Color(115, 135, 156));
        txtSellingPrice.setText("Sells Price");
        txtSellingPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        txtSellingPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSellingPriceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSellingPriceFocusLost(evt);
            }
        });
        txtSellingPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSellingPriceKeyTyped(evt);
            }
        });
        jPanel16.add(txtSellingPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 206, 30));

        jLabel34.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(78, 78, 78));
        jLabel34.setText("Sells price *");
        jPanel16.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 135, -1));

        lb02.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lb02.setForeground(new java.awt.Color(78, 78, 78));
        lb02.setText("Service descriptions");
        jPanel16.add(lb02, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 160, -1));

        btnBack.setBackground(new java.awt.Color(0, 51, 153));
        btnBack.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(250, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/iconsback.png"))); // NOI18N
        btnBack.setText("BACK");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnBack.setIconTextGap(10);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel16.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 120, 35));

        btnPrint.setBackground(new java.awt.Color(0, 51, 153));
        btnPrint.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(250, 255, 255));
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/iconsprinter.png"))); // NOI18N
        btnPrint.setText("PDF");
        btnPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrint.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnPrint.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnPrint.setIconTextGap(10);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel16.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 120, 35));

        btnView.setBackground(new java.awt.Color(0, 51, 153));
        btnView.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnView.setForeground(new java.awt.Color(250, 255, 255));
        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/iconsview.png"))); // NOI18N
        btnView.setText("View");
        btnView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnView.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnView.setIconTextGap(10);
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        jPanel16.add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 120, 35));

        btnSubmit.setBackground(new java.awt.Color(0, 51, 153));
        btnSubmit.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(250, 255, 255));
        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/iconadd.png"))); // NOI18N
        btnSubmit.setText(" Add");
        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmit.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnSubmit.setIconTextGap(10);
        btnSubmit.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        jPanel16.add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, 120, 35));

        lbId.setText("ID");
        jPanel16.add(lbId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 30, 20));

        jTextAreaServiceDescription.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel16.add(jTextAreaServiceDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 206, 30));

        lbSatus.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lbSatus.setForeground(new java.awt.Color(78, 78, 78));
        lbSatus.setText("Satus");
        jPanel16.add(lbSatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 135, -1));

        jComboBoxVendorStatus.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jComboBoxVendorStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));
        jPanel16.add(jComboBoxVendorStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 206, 30));

        btnDelete1.setBackground(new java.awt.Color(0, 51, 153));
        btnDelete1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnDelete1.setForeground(new java.awt.Color(250, 255, 255));
        btnDelete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/iconsbeans.png"))); // NOI18N
        btnDelete1.setText("Delete");
        btnDelete1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnDelete1.setIconTextGap(10);
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });
        jPanel16.add(btnDelete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 120, 35));

        lbunitId2.setText("u");
        jPanel16.add(lbunitId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 32, 16));

        lbVendorId1.setText("v");
        jPanel16.add(lbVendorId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 40, 16));

        lbManufactureId.setText("m");
        jPanel16.add(lbManufactureId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 26, 16));

        jPanel4.setBackground(java.awt.Color.white);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/default_image.png"))); // NOI18N
        imgShow.setMaximumSize(new java.awt.Dimension(200, 60));
        imgShow.setMinimumSize(new java.awt.Dimension(200, 60));
        imgShow.setPreferredSize(new java.awt.Dimension(200, 60));
        jPanel4.add(imgShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 190, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_title.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lbl_title.setText("Add To Products / Services");
        jPanel3.add(lbl_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 340, 23));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setText("Basic Information");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 190, 23));

        jSeparator1.setForeground(new java.awt.Color(0, 51, 153));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 300, -1));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNameFocusGained
        placeHolder.placeHolder(name, txtUserName);
    }//GEN-LAST:event_txtUserNameFocusGained

    private void txtUserNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNameFocusLost

        placeHolder.placeHolder(name, txtUserName);
    }//GEN-LAST:event_txtUserNameFocusLost

    private void jRadioButtonServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonServiceActionPerformed
        jPanel13.setVisible(false);
        jPanel14.setVisible(false);
        jPanel15.setVisible(false);


    }//GEN-LAST:event_jRadioButtonServiceActionPerformed

    private void jRadioButtonProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonProductsActionPerformed
        jPanel13.setVisible(true);
        jPanel14.setVisible(true);
        jPanel15.setVisible(true);

    }//GEN-LAST:event_jRadioButtonProductsActionPerformed

    private void txtArticalCodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtArticalCodeFocusGained
        placeHolder.placeHolder(articalCode, txtArticalCode);
    }//GEN-LAST:event_txtArticalCodeFocusGained

    private void txtArticalCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtArticalCodeFocusLost
        placeHolder.placeHolder(articalCode, txtArticalCode);
    }//GEN-LAST:event_txtArticalCodeFocusLost

    private void txtAricleNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAricleNameFocusGained
        placeHolder.placeHolder(articalName, txtAricleName);
    }//GEN-LAST:event_txtAricleNameFocusGained

    private void txtAricleNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAricleNameFocusLost
        placeHolder.placeHolder(articalName, txtAricleName);
    }//GEN-LAST:event_txtAricleNameFocusLost

    private void txtOperatingVoltageFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOperatingVoltageFocusGained
        placeHolder.placeHolder(operatingVoltage, txtOperatingVoltage);
    }//GEN-LAST:event_txtOperatingVoltageFocusGained

    private void txtOperatingVoltageFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOperatingVoltageFocusLost
        placeHolder.placeHolder(operatingVoltage, txtOperatingVoltage);
    }//GEN-LAST:event_txtOperatingVoltageFocusLost

    private void txtDiameterFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiameterFocusGained
        placeHolder.placeHolder(diameter, txtDiameter);
    }//GEN-LAST:event_txtDiameterFocusGained

    private void txtDiameterFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiameterFocusLost

        placeHolder.placeHolder(diameter, txtDiameter);
    }//GEN-LAST:event_txtDiameterFocusLost

    private void txtStockeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStockeFocusGained
        placeHolder.placeHolder(strock, txtStocke);
    }//GEN-LAST:event_txtStockeFocusGained

    private void txtStockeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStockeFocusLost
        placeHolder.placeHolder(strock, txtStocke);
    }//GEN-LAST:event_txtStockeFocusLost

    private void txtMeasuringFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMeasuringFocusGained
        placeHolder.placeHolder(measuring, txtMeasuring);
    }//GEN-LAST:event_txtMeasuringFocusGained

    private void txtMeasuringFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMeasuringFocusLost
        placeHolder.placeHolder(measuring, txtMeasuring);
    }//GEN-LAST:event_txtMeasuringFocusLost

    private void txtSwichingOutputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSwichingOutputFocusGained
        placeHolder.placeHolder(switchingOutput, txtSwichingOutput);
    }//GEN-LAST:event_txtSwichingOutputFocusGained

    private void txtSwichingOutputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSwichingOutputFocusLost
        placeHolder.placeHolder(switchingOutput, txtSwichingOutput);
    }//GEN-LAST:event_txtSwichingOutputFocusLost

    private void txtOutputSignalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOutputSignalFocusGained
        placeHolder.placeHolder(outputSignal, txtOutputSignal);
    }//GEN-LAST:event_txtOutputSignalFocusGained

    private void txtOutputSignalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOutputSignalFocusLost
        placeHolder.placeHolder(outputSignal, txtOutputSignal);
    }//GEN-LAST:event_txtOutputSignalFocusLost

    private void txtSKU1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSKU1FocusGained
        placeHolder.placeHolder(skuPlace, txtSKU1);
    }//GEN-LAST:event_txtSKU1FocusGained

    private void txtSKU1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSKU1FocusLost
        placeHolder.placeHolder(skuPlace, txtSKU1);
    }//GEN-LAST:event_txtSKU1FocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        attachPhoto();
    }//GEN-LAST:event_jButton2ActionPerformed
    public void attachPhoto() {
        JFileChooser file = new JFileChooser();

        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            imagePath = path;
            txtimagePath1.setText(imagePath);
            imgShow.setIcon(ResizeImage(path, null));
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No File Selected");
        }
    }

    public ImageIcon ResizeImage(String ImagePath, byte[] pic) {
        ImageIcon MyImage = null;
        if (ImagePath != null) {
            MyImage = new ImageIcon(ImagePath);
        } else {
            MyImage = new ImageIcon(pic);
        }
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(imgShow.getWidth(),
                imgShow.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    private void cleanField() {

        txtUserName.setText("Name");
        jRadioButtonService.setSelected(false);
        jRadioButtonProducts.setSelected(true);
        jComboBoxManufacture.setSelectedIndex(0);
        jComboBoxVendor.setSelectedIndex(0);
        jComboBoxUnit.setSelectedIndex(0);
        txtArticalCode.setText(articalCode);
        txtAricleName.setText(articalName);
        txtOperatingVoltage.setText(operatingVoltage);
        txtDiameter.setText(diameter);
        txtStocke.setText(strock);
        txtMeasuring.setText(measuring);
        txtSwichingOutput.setText(switchingOutput);
        txtSKU1.setText(skuPlace);
        txtOutputSignal.setText(outputSignal);
        txtimagePath1.setText(imagePathfield);
        txtSellingPrice.setText(sellingPrice);
        jTextAreaServiceDescription.setText("");
        imgShow.setText("");
        imgShow.setIcon(null);
    }
    private void txtSellingPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSellingPriceFocusGained
        placeHolder.placeHolder(sellingPrice, txtSellingPrice);
    }//GEN-LAST:event_txtSellingPriceFocusGained

    private void txtSellingPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSellingPriceFocusLost
        placeHolder.placeHolder(sellingPrice, txtSellingPrice);
    }//GEN-LAST:event_txtSellingPriceFocusLost

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        if (lbId.getText().equals("ID")) {
            panelController.showPanelWindow(new SubMenuOfProducts());
        } else {
            panelController.showPanelWindow(new Products());
        }


    }//GEN-LAST:event_btnBackActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed

        try {
            Random rand = new Random();
            int selected = rand.nextInt(100);
            String userHomeDirectory = System.getProperty("user.home");
            String outputFile = userHomeDirectory + File.separatorChar + selected + "'.pdf";
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("name", txtUserName.getText());
            String type = "";
            if (jRadioButtonService.isSelected() == true) {
                type = "Service";
            } else {
                type = "Product";
            }
            parameters.put("type", type);
            parameters.put("sku", txtSKU1.getText());

            parameters.put("unit", jComboBoxUnit.getSelectedItem());
            parameters.put("vendor", jComboBoxVendor.getSelectedItem());
            parameters.put("manufacturer", jComboBoxManufacture.getSelectedItem());

            parameters.put("stroke", txtStocke.getText());
            parameters.put("price", txtSellingPrice.getText());
            parameters.put("status", "Active");

            JasperPrint jasperPrint = JasperFillManager.fillReport("src/IReport/singleProductsReport.jasper", parameters, new JREmptyDataSource());

            /* outputStream to create PDF */
            OutputStream outputStream = new FileOutputStream(new File(outputFile));
            /* Write content to PDF file */
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            System.out.println("File Generated: " + outputFile);
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setVisible(true);

        } catch (JRException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        try {
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("name", txtUserName.getText());
            String type = "";
            if (jRadioButtonService.isSelected() == true) {
                type = "Service";
            } else {
                type = "Product";
            }
            parameters.put("type", type);
            parameters.put("sku", txtSKU1.getText());

            parameters.put("unit", jComboBoxUnit.getSelectedItem());
            parameters.put("vendor", jComboBoxVendor.getSelectedItem());
            parameters.put("manufacturer", jComboBoxManufacture.getSelectedItem());

            parameters.put("strocke", txtStocke.getText());
            parameters.put("price", txtSellingPrice.getText());
            parameters.put("status", "Active");

            JasperPrint jasperPrint = JasperFillManager.fillReport("src/IReport/singleProductsReport.jasper", parameters, new JREmptyDataSource());

            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);

            jasperViewer.setVisible(true);

        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        int i = 0;
        String name = txtUserName.getText();
        if (name.equals("Name")) {
            name = "";
            i += 1;
        }
        String serviceAndProduct = "";
        if (jRadioButtonService.isSelected()) {
            serviceAndProduct = "Service";
            i += 1;

        }
        if (jRadioButtonProducts.isSelected()) {
            serviceAndProduct = "Product";
            i += 1;

        }
        String type = serviceAndProduct;
        int manufacturer = jComboBoxManufacture.getSelectedIndex();
        if (manufacturer == 0) {
            manufacturer = 0;
            i += 1;
        }
        int vendor = jComboBoxVendor.getSelectedIndex();
        if (vendor == 0) {
            vendor = 0;
            i += 1;
        }
        int unit = jComboBoxUnit.getSelectedIndex();
        if (unit == 0) {
            unit = 0;

        }
        String article_code = txtArticalCode.getText();
        if (article_code.equals(article_code)) {
            article_code = null;
        }

        String article_name = txtAricleName.getText();
        if (article_name.equals(articalName)) {
            article_name = null;
        }
        String operating_voltage = txtOperatingVoltage.getText();
        if (operating_voltage.equals(operatingVoltage)) {
            operating_voltage = null;
        }

        String diameter_bore = txtDiameter.getText();
        if (diameter_bore.equals(diameter)) {
            diameter_bore = null;
        }

        String stroke = txtStocke.getText();
        if (stroke.equals(strock)) {
            stroke = null;
        }
        String measuring_sensing = txtMeasuring.getText();
        if (measuring_sensing.equals(measuring)) {
            measuring_sensing = null;
        }
        String switching_output = txtSwichingOutput.getText();
        if (switching_output.equals(switchingOutput)) {
            switching_output = null;
        }
        String sku = txtSKU1.getText();
        if (sku.equals(skuPlace)) {
            sku = null;
        }
        String output_signal = txtUserName.getText();
        if (output_signal.equals(outputSignal)) {
            output_signal = null;
        }
        String selling_price = txtSellingPrice.getText();
        if (selling_price.equals("Sells Price")) {
            selling_price = "";
            i += 1;
        }

        String service_description = jTextAreaServiceDescription.getText();
        AddProductsModel addModel;

        if (jRadioButtonService.isSelected()) {

            if (txtimagePath1.equals(imagePathfield)) {

                addModel = new AddProductsModel(name, type, String.valueOf(manufacturer),
                        String.valueOf(vendor),
                        selling_price, service_description,
                        jComboBoxVendorStatus.getSelectedItem().toString());

            } else {

                addModel = new AddProductsModel(name, type, String.valueOf(manufacturer),
                        String.valueOf(vendor), imagePath,
                        selling_price, service_description,
                        jComboBoxVendorStatus.getSelectedItem().toString());
            }

        } else {
            if (txtimagePath1.equals(imagePathfield)) {

                addModel = new AddProductsModel(name, type, String.valueOf(manufacturer),
                        String.valueOf(vendor), String.valueOf(unit), article_code,
                        article_name, operating_voltage, diameter_bore, stroke,
                        measuring_sensing, switching_output, sku, output_signal,
                        selling_price, service_description,
                        jComboBoxVendorStatus.getSelectedItem().toString());
            } else {
                addModel = new AddProductsModel(name, type, String.valueOf(manufacturer),
                        String.valueOf(vendor), String.valueOf(unit), article_code,
                        article_name, operating_voltage, diameter_bore, stroke,
                        measuring_sensing, switching_output, sku, output_signal,
                        selling_price, imagePath, service_description,
                        jComboBoxVendorStatus.getSelectedItem().toString());
            }
        }
        if (i > 4) {
            ErrorJDialog1 er = new ErrorJDialog1(null, true);
            er.setVisible(true);
        } else {
            if (btnSubmit.getText().equals("Add")) {

                if (controller.addProduct(addModel) == true) {

                    SuccessJDialog er = new SuccessJDialog(null, true);
                    er.setVisible(true);
                    cleanField();
                } else {
                    System.out.println("this are submit method error:");
                    ErrorJDialog1 er = new ErrorJDialog1(null, true);
                    er.setVisible(true);
                }

            } else if (btnSubmit.getText().equals("Update")) {
                if (updateContact() == true) {
                    SuccessJDialog er = new SuccessJDialog(null, true);
                    er.setVisible(true);
                   // cleanField();
                } else {
                    System.out.println("this are submit method error:");
                    ErrorJDialog1 er = new ErrorJDialog1(null, true);
                    er.setVisible(true);
                }
            }

        }
        imagePath = null;
    }//GEN-LAST:event_btnSubmitActionPerformed
    public boolean updateContact() {

        String name = txtUserName.getText();
        if (name.equals("Name")) {
            name = "";
        }
        String serviceAndProduct = "";
        if (jRadioButtonService.isSelected()) {
            serviceAndProduct = "Service";
        }
        if (jRadioButtonProducts.isSelected()) {
            serviceAndProduct = "Product";
        }
        String type = serviceAndProduct;

        String article_code = txtArticalCode.getText();
        String article_name = txtAricleName.getText();
        String operating_voltage = txtOperatingVoltage.getText();
        String diameter_bore = txtDiameter.getText();
        String stroke = txtStocke.getText();
        String measuring_sensing = txtMeasuring.getText();
        String switching_output = txtSwichingOutput.getText();
        String sku = txtSKU1.getText();
        String output_signal = txtUserName.getText();

        String selling_price = txtSellingPrice.getText();
        byte[] pp = null;
        if (chectPic == 0) {
            getDefaultPic();
            pp = ByteImage;
        } else {
            pp = ByteImage;
        }
        String service_description = jTextAreaServiceDescription.getText();
        String activeInactive = jComboBoxVendorStatus.getSelectedItem().toString();
        try {
            ProductsEditModel model2 = new ProductsEditModel(lbId.getText(),
                    name,
                    type,
                    lbManufactureId.getText(),
                    lbVendorId1.getText(),
                    lbunitId2.getText(),
                    article_code, article_name, operating_voltage, diameter_bore, stroke,
                    measuring_sensing, switching_output, sku, output_signal, pp, selling_price,
                    service_description, activeInactive);
            controller.UpdateProduct(model2);

            return true;
        } catch (Exception e) {
            System.out.println("Execute Update:" + e);
            return false;
        }

    }

    public void getDefaultPic() {
        try {
            File f;
            f = new File("iconsmaximum.png");
            BufferedImage bf = ImageIO.read(f);
            ImageIcon ii = new ImageIcon(bf);
            ii.getImage().flush();
            imgShow.setText("");
            imgShow.setIcon(ii);
            personPic(bf);
        } catch (IOException ex) {
            Logger.getLogger(AddProducts.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void personPic(BufferedImage originalImage) {
        try {
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                ImageIO.write(originalImage, "png", baos);
                baos.flush();
                ByteImage = baos.toByteArray();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }
    private void jComboBoxUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUnitActionPerformed

        String unit_id = dynamicDropDownValue.getComboboxGroupId("units", jComboBoxUnit.getSelectedItem().toString());
        lbunitId2.setText(unit_id);
    }//GEN-LAST:event_jComboBoxUnitActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed

        if (controller.deactiveProduct("products", lbId.getText()) == true) {
            SuccessJDialog er = new SuccessJDialog(null, true);
            er.setVisible(true);
            panelController.showPanelWindow(new Products());
        } else {
            ErrorJDialog1 er = new ErrorJDialog1(null, true);
            er.setVisible(true);
        }
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void jComboBoxManufactureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxManufactureActionPerformed

        String manuf_id = dynamicDropDownValue.getComboboxGroupId("manufacturers", jComboBoxManufacture.getSelectedItem().toString());
        lbManufactureId.setText(manuf_id);
    }//GEN-LAST:event_jComboBoxManufactureActionPerformed

    private void jComboBoxVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxVendorActionPerformed
        String vendor_id = dynamicDropDownValue.getComboboxGroupId("vendors", jComboBoxVendor.getSelectedItem().toString());
        lbVendorId1.setText(vendor_id);
    }//GEN-LAST:event_jComboBoxVendorActionPerformed

    private void txtUserNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyPressed
        backPress(evt);
    }//GEN-LAST:event_txtUserNameKeyPressed

    private void jRadioButtonProductsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButtonProductsKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonProductsKeyPressed

    private void jRadioButtonServiceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButtonServiceKeyPressed

    }//GEN-LAST:event_jRadioButtonServiceKeyPressed

    private void txtimagePath1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtimagePath1ActionPerformed
        attachPhoto();
    }//GEN-LAST:event_txtimagePath1ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        backPress(evt);
    }//GEN-LAST:event_formKeyPressed

    private void txtSellingPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSellingPriceKeyTyped
        new NumberField().typeNumber(evt);
    }//GEN-LAST:event_txtSellingPriceKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnView;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel imgShow;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxManufacture;
    private javax.swing.JComboBox<String> jComboBoxUnit;
    private javax.swing.JComboBox<String> jComboBoxVendor;
    private javax.swing.JComboBox<String> jComboBoxVendorStatus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButtonProducts;
    private javax.swing.JRadioButton jRadioButtonService;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextAreaServiceDescription;
    private javax.swing.JLabel lb01;
    private javax.swing.JLabel lb02;
    private javax.swing.JLabel lb03;
    private javax.swing.JLabel lb04;
    private javax.swing.JLabel lb05;
    private javax.swing.JLabel lb06;
    private javax.swing.JLabel lb07;
    private javax.swing.JLabel lb09;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb9;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbManufactureId;
    private javax.swing.JLabel lbSatus;
    private javax.swing.JLabel lbVendorId1;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JLabel lbunitId2;
    private javax.swing.JTextField txtAricleName;
    private javax.swing.JTextField txtArticalCode;
    private javax.swing.JTextField txtDiameter;
    private javax.swing.JTextField txtMeasuring;
    private javax.swing.JTextField txtOperatingVoltage;
    private javax.swing.JTextField txtOutputSignal;
    private javax.swing.JTextField txtSKU1;
    private javax.swing.JTextField txtSellingPrice;
    private javax.swing.JTextField txtStocke;
    private javax.swing.JTextField txtSwichingOutput;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTextField txtimagePath1;
    // End of variables declaration//GEN-END:variables
}

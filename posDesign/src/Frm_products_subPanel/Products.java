/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frm_products_subPanel;

import Commons.ComboboxDesign;
import Commons.DaynamicDropDownValue;
import Commons.PanelController;
import Commons.TableBackgroundColor;
import Commons.TextPlaceholder;
import Commons.TxtBoxSpace;
import Controller.ProductsController;
import JDialogCustom.ErrorJDialog1;
import JDialogCustom.SuccessJDialog;
import com.sun.java.swing.plaf.windows.WindowsScrollBarUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

/**
 *
 * @author Niklaus
 */
public class Products extends javax.swing.JPanel {

    PanelController panelController = new PanelController();
    TextPlaceholder placeHolder = new TextPlaceholder();
    TxtBoxSpace txtBoxSpaceing = new TxtBoxSpace();
    ProductsController controller = new ProductsController();
    ComboboxDesign comboDesign = new ComboboxDesign();
    DaynamicDropDownValue dropDownValues = new DaynamicDropDownValue();

    public Products() {
        initComponents();
        txtSearch1.requestFocus();

        controller.listedOfProducts(jTable_list);

        dropDownValues.productItemList(jComboBoxManufacture, "manufacturers");
        dropDownValues.productItemList(jComboBoxChooseVendor, "vendors");
        dropDownValues.productItemList(jComboBoxUnite, "units");
        defaultDesign();
    }

    private void defaultDesign() {
        jTable_list.getTableHeader().setBackground(Color.WHITE);
        JTableHeader th = jTable_list.getTableHeader();
        th.setPreferredSize(new Dimension(150, 30));
        jTable_list.setBackground(Color.WHITE);
        jScrollPaneProductTable.getVerticalScrollBar().setUI(new WindowsScrollBarUI());
        Jpanel_list.setVisible(false);
        comboDesign.comboDesign(jComboBoxUnite);
        comboDesign.comboDesign(jComboBoxManufacture);
        comboDesign.comboDesign(jComboBoxChooseVendor);
        comboDesign.comboDesign(jComboBoxItemStatus);

    }

    private void defaultListOfTable() {
        if (jComboBoxManufacture.getSelectedItem().equals("Select Manufacturer")
                && jComboBoxChooseVendor.getSelectedItem().equals("Select Vendor")
                && jComboBoxUnite.getSelectedItem().equals("Select Units")
                && jComboBoxItemStatus.getSelectedItem().equals("Select Status")
                && (txtSearch1.getText().equals("Search") || txtSearch1.getText().isEmpty())) {
            controller.listedOfProducts(jTable_list);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Jpanel_list = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSuggest = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtSearch1 = new javax.swing.JTextField();
        lb9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lb07 = new javax.swing.JLabel();
        jComboBoxManufacture = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        lb05 = new javax.swing.JLabel();
        jComboBoxChooseVendor = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        lb6 = new javax.swing.JLabel();
        jComboBoxUnite = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        lb7 = new javax.swing.JLabel();
        jComboBoxItemStatus = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        btnReports = new javax.swing.JButton();
        jScrollPaneProductTable = new javax.swing.JScrollPane();
        jTable_list = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(0, 51, 153));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/iconsplus.png"))); // NOI18N
        jLabel1.setText("Add");
        jLabel1.setAlignmentY(0.0F);
        jLabel1.setBorder(null);
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jLabel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel1KeyPressed(evt);
            }
        });
        jPanel9.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 70, 30));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(78, 78, 78));
        jLabel17.setText("Products records");
        jLabel17.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 190, 20));

        jSeparator2.setForeground(new java.awt.Color(0, 51, 153));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 980, 10));

        jTableSuggest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableSuggest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSuggestMouseClicked(evt);
            }
        });
        jTableSuggest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableSuggestKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTableSuggest);

        javax.swing.GroupLayout Jpanel_listLayout = new javax.swing.GroupLayout(Jpanel_list);
        Jpanel_list.setLayout(Jpanel_listLayout);
        Jpanel_listLayout.setHorizontalGroup(
            Jpanel_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        );
        Jpanel_listLayout.setVerticalGroup(
            Jpanel_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );

        jPanel1.add(Jpanel_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 206, 160));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        txtSearch1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtSearch1.setForeground(new java.awt.Color(115, 135, 156));
        txtSearch1.setText("Search");
        txtSearch1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 220, 220)));
        txtSearch1.setPreferredSize(new java.awt.Dimension(60, 16));
        txtSearch1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearch1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearch1FocusLost(evt);
            }
        });
        txtSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch1ActionPerformed(evt);
            }
        });
        txtSearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearch1KeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearch1KeyPressed(evt);
            }
        });

        lb9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lb9.setForeground(new java.awt.Color(78, 78, 78));
        lb9.setText("Search");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb9, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        lb07.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lb07.setForeground(new java.awt.Color(78, 78, 78));
        lb07.setText("Choose manufacturer");

        jComboBoxManufacture.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jComboBoxManufacture.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Manufacturer" }));
        jComboBoxManufacture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxManufactureActionPerformed(evt);
            }
        });
        jComboBoxManufacture.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxManufactureKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBoxManufacture, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb07, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb07)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxManufacture, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        lb05.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lb05.setForeground(new java.awt.Color(78, 78, 78));
        lb05.setText("Choose vendor");

        jComboBoxChooseVendor.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jComboBoxChooseVendor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Vendor" }));
        jComboBoxChooseVendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxChooseVendorActionPerformed(evt);
            }
        });
        jComboBoxChooseVendor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxChooseVendorKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lb05, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addComponent(jComboBoxChooseVendor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb05)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBoxChooseVendor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        lb6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lb6.setForeground(new java.awt.Color(78, 78, 78));
        lb6.setText("Units");

        jComboBoxUnite.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jComboBoxUnite.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Units" }));
        jComboBoxUnite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUniteActionPerformed(evt);
            }
        });
        jComboBoxUnite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxUniteKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxUnite, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb6)
                .addGap(6, 6, 6)
                .addComponent(jComboBoxUnite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        lb7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lb7.setForeground(new java.awt.Color(78, 78, 78));
        lb7.setText("Status");

        jComboBoxItemStatus.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jComboBoxItemStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Status", "Active", "Inactive" }));
        jComboBoxItemStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxItemStatusActionPerformed(evt);
            }
        });
        jComboBoxItemStatus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxItemStatusKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxItemStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBoxItemStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnSearch.setBackground(new java.awt.Color(0, 51, 153));
        btnSearch.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnSearch.setIconTextGap(1);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnReports.setBackground(new java.awt.Color(255, 255, 255));
        btnReports.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnReports.setForeground(java.awt.Color.black);
        btnReports.setText("Report");
        btnReports.setAlignmentY(0.0F);
        btnReports.setBorder(null);
        btnReports.setBorderPainted(false);
        btnReports.setContentAreaFilled(false);
        btnReports.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReports.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReports.setOpaque(true);
        btnReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(btnReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 990, -1));

        jScrollPaneProductTable.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPaneProductTable.setBorder(null);
        jScrollPaneProductTable.setForeground(new java.awt.Color(0, 153, 255));
        jScrollPaneProductTable.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneProductTable.setAlignmentX(0.0F);
        jScrollPaneProductTable.setAlignmentY(0.0F);
        jScrollPaneProductTable.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jScrollPaneProductTable.setName("Products Reports"); // NOI18N

        jTable_list.setBorder(null);
        jTable_list.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTable_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "TYPE", "SKU", "MANUFACTURER", "BRAND", "UNIT", "Edit", "Delete"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_list.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable_list.setGridColor(java.awt.Color.white);
        jTable_list.setRowHeight(28);
        jTable_list.setSelectionBackground(java.awt.Color.white);
        jTable_list.setSelectionForeground(java.awt.Color.black);
        jTable_list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_list.setShowVerticalLines(false);
        jTable_list.getTableHeader().setReorderingAllowed(false);
        jTable_list.setUpdateSelectionOnSort(false);
        jTable_list.setVerifyInputWhenFocusTarget(false);
        jTable_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_listMouseClicked(evt);
            }
        });
        jScrollPaneProductTable.setViewportView(jTable_list);
        if (jTable_list.getColumnModel().getColumnCount() > 0) {
            jTable_list.getColumnModel().getColumn(0).setResizable(false);
            jTable_list.getColumnModel().getColumn(1).setResizable(false);
            jTable_list.getColumnModel().getColumn(2).setResizable(false);
            jTable_list.getColumnModel().getColumn(3).setResizable(false);
            jTable_list.getColumnModel().getColumn(5).setResizable(false);
            jTable_list.getColumnModel().getColumn(6).setResizable(false);
            jTable_list.getColumnModel().getColumn(7).setResizable(false);
            jTable_list.getColumnModel().getColumn(7).setPreferredWidth(60);
            jTable_list.getColumnModel().getColumn(8).setResizable(false);
            jTable_list.getColumnModel().getColumn(8).setPreferredWidth(60);
        }

        jPanel1.add(jScrollPaneProductTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 990, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableSuggestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSuggestMouseClicked

    }//GEN-LAST:event_jTableSuggestMouseClicked

    private void jTableSuggestKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableSuggestKeyPressed
        if (evt.getKeyCode() == 10) {
            int i = jTableSuggest.getSelectedRow();
            TableModel table = jTableSuggest.getModel();
            txtSearch1.setText(table.getValueAt(i, 1).toString());
            //            JOptionPane.showMessageDialog(null, table.getValueAt(i, 1));
            Jpanel_list.setVisible(false);
            btnSearch.requestFocus();
        }
    }//GEN-LAST:event_jTableSuggestKeyPressed

    private void txtSearch1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch1FocusGained
        placeHolder.placeHolder("Search", txtSearch1);
        //defaultListOfTable();
        if (txtSearch1.getText().equals(null) || txtSearch1.getText().equals("Search")) {
            Jpanel_list.setVisible(false);

        }
    }//GEN-LAST:event_txtSearch1FocusGained

    private void txtSearch1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearch1FocusLost
        placeHolder.placeHolder("Search", txtSearch1);
    }//GEN-LAST:event_txtSearch1FocusLost

    private void txtSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch1ActionPerformed

    }//GEN-LAST:event_txtSearch1ActionPerformed

    private void txtSearch1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch1KeyPressed
        if (!txtSearch1.getText().isEmpty() || !txtSearch1.getText().equals("Search")) {
            Jpanel_list.setVisible(true);
            if (evt.getKeyCode() == 40) {
                jTableSuggest.requestFocus();
            }
        } else {
            defaultListOfTable();
        }
        new ProductsController().productDataSearchFilter(txtSearch1.getText(), jTableSuggest);

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            FilterDataSearch();
        }
    }//GEN-LAST:event_txtSearch1KeyPressed

    private void txtSearch1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch1KeyTyped
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            jTableSuggest.requestFocus();
        }
    }//GEN-LAST:event_txtSearch1KeyTyped

    private void jComboBoxManufactureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxManufactureActionPerformed
        String name = jComboBoxManufacture.getSelectedItem().toString();
        Jpanel_list.setVisible(false);
        if (name.equals("Select Manufacturer")) {

        } else {
//            String id = controller.getComboboxGroupId("manufacturers", name);
//            lbManufactureID.setText(id);
        }
    }//GEN-LAST:event_jComboBoxManufactureActionPerformed

    private void jComboBoxChooseVendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxChooseVendorActionPerformed
        String name = jComboBoxChooseVendor.getSelectedItem().toString();
        Jpanel_list.setVisible(false);
        if (name.equals("Select Vendor")) {

        } else {
//            String id = controller.getComboboxGroupId("vendors", name);
//            lbvendorId.setText(id);
        }
    }//GEN-LAST:event_jComboBoxChooseVendorActionPerformed

    private void jComboBoxUniteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUniteActionPerformed
        String name = jComboBoxUnite.getSelectedItem().toString();
        Jpanel_list.setVisible(false);
        if (name.equals("Select Units")) {

        } else {
//            String id = controller.getComboboxGroupId("units", name);
//            lbUnitId.setText(id);
        }
    }//GEN-LAST:event_jComboBoxUniteActionPerformed

    private void jComboBoxItemStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxItemStatusActionPerformed
        String name = jComboBoxItemStatus.getSelectedItem().toString();
        Jpanel_list.setVisible(false);
        if (name.equals("Select Status")) {

        } else {
            // JOptionPane.showMessageDialog(null, name);
        }
    }//GEN-LAST:event_jComboBoxItemStatusActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        FilterDataSearch();
    }//GEN-LAST:event_btnSearchActionPerformed
    private void FilterDataSearch() {
        Jpanel_list.setVisible(false);
        String txtSearch = txtSearch1.getText();
        String manufacturer = jComboBoxManufacture.getSelectedItem().toString();
        String vendor = jComboBoxChooseVendor.getSelectedItem().toString();
        String unit = jComboBoxUnite.getSelectedItem().toString();
        String status = jComboBoxItemStatus.getSelectedItem().toString();

        if (txtSearch.equals("Search") || txtSearch.equals("")) {
            txtSearch = "";
        }
        if (manufacturer.equals("Select Manufacturer")) {
            manufacturer = "";
        }
        if (vendor.equals("Select Vendor")) {
            vendor = "";
        }
        if (unit.equals("Select Units")) {
            unit = "";
        }
        if (status.equals("Select Status")) {
            status = "Active";
        }
        HashMap<String, String> fields = new HashMap<>();

        fields.put("Search", txtSearch);
        fields.put("Manufacturer", manufacturer);
        fields.put("Vendor", vendor);
        fields.put("Unit", unit);

        controller.productDataSearch(fields, jTable_list, status);
    }
    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportsActionPerformed
        controller.reportGenerator("productsReport.jrxml", jTable_list);

    }//GEN-LAST:event_btnReportsActionPerformed

    private void jTable_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_listMouseClicked
        Jpanel_list.setVisible(false);
//        int i = jTable_list.getSelectedRow();
//        TableModel table = jTable_list.getModel();
//        String id = table.getValueAt(i, 1).toString();

        int column = jTable_list.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / jTable_list.getRowHeight();

        if (row < jTable_list.getRowCount() && row >= 0 && column < jTable_list.getColumnCount() && column >= 0) {

            Object value = jTable_list.getValueAt(row, column);

            if (value instanceof JButton) {
                ((JButton) value).doClick();

                JButton button = (JButton) value;

                if (button.getText().equals("Edit")) {
                    AddProducts pro = new AddProducts(button.getName());
                    //System.out.println(id);
                    panelController.showPanelWindow(pro);
                } else if (button.getText().equals("Delete")) {
                    if (controller.deactiveProduct("products", button.getName()) == true) {

                        SuccessJDialog er = new SuccessJDialog(null, true);
                        er.setVisible(true);
                        controller.listedOfProducts(jTable_list);
                    } else {
                        ErrorJDialog1 er = new ErrorJDialog1(null, true);
                        er.setVisible(true);
                    }
                }
            }
        }

    }//GEN-LAST:event_jTable_listMouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        Jpanel_list.setVisible(false);
        // defaultListOfTable();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        Jpanel_list.setVisible(false);
    }//GEN-LAST:event_formMouseClicked

    private void jLabel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1KeyPressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        panelController.showPanelWindow(new AddProducts());
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jComboBoxManufactureKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxManufactureKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            jComboBoxChooseVendor.requestFocus();
        }
    }//GEN-LAST:event_jComboBoxManufactureKeyPressed

    private void jComboBoxChooseVendorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxChooseVendorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            jComboBoxUnite.requestFocus();
        }
    }//GEN-LAST:event_jComboBoxChooseVendorKeyPressed

    private void jComboBoxUniteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxUniteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            jComboBoxItemStatus.requestFocus();
        }
    }//GEN-LAST:event_jComboBoxUniteKeyPressed

    private void jComboBoxItemStatusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxItemStatusKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_TAB) {
            btnSearch.requestFocus();
        }
    }//GEN-LAST:event_jComboBoxItemStatusKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpanel_list;
    private javax.swing.JButton btnReports;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> jComboBoxChooseVendor;
    private javax.swing.JComboBox<String> jComboBoxItemStatus;
    private javax.swing.JComboBox<String> jComboBoxManufacture;
    private javax.swing.JComboBox<String> jComboBoxUnite;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneProductTable;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableSuggest;
    private javax.swing.JTable jTable_list;
    private javax.swing.JLabel lb05;
    private javax.swing.JLabel lb07;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    private javax.swing.JLabel lb9;
    public static javax.swing.JTextField txtSearch1;
    // End of variables declaration//GEN-END:variables
}

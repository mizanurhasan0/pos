/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frm_products;

import Commons.HoverAnimation;
import Commons.LiveDataVisible;
import Commons.PanelController;
import Controller.ProductsController;
import Frm_purchase_subpanel.Purchases;
import Frm_purchase_subpanel.PurchasesCustom;
import Frm_purchase_subpanel.Strock_in;
import Frm_purchase_subpanel.Strock_in_Custom;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Niklaus
 */
public class SubMenuOfPurchase extends javax.swing.JPanel {

    PanelController panelController = new PanelController();
    HoverAnimation hover = new HoverAnimation();
    ProductsController controller = new ProductsController();

    /**
     * Creates new form SubMenuOfPurchase
     */
    public SubMenuOfPurchase() {
        initComponents();
        autoMethodExecute();
    }

    private void autoMethodExecute() {

        //milliseconds
        ActionListener taskPerformer = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                lbtext.setText(new LiveDataVisible().totalDueAmount());
            }
        };
        int delay = 6000;
        new Timer(delay, taskPerformer).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panelOverview = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lbtextnew1 = new javax.swing.JLabel();
        lbtext = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbtext1 = new javax.swing.JLabel();
        panelNew = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lbtextnew = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        panelProducts = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbtextproducts = new javax.swing.JLabel();
        btnproducts = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        lbl_title = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        panelOverview.setBackground(new java.awt.Color(255, 255, 255));
        panelOverview.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 38, 91)));
        panelOverview.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelOverview.setPreferredSize(new java.awt.Dimension(200, 200));
        panelOverview.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelOverviewMouseMoved(evt);
            }
        });
        panelOverview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelOverviewMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelOverviewMouseExited(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(0, 51, 153));

        lbtextnew1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbtextnew1.setForeground(new java.awt.Color(255, 255, 255));
        lbtextnew1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtextnew1.setText("Due");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbtextnew1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbtextnew1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        lbtext.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lbtext.setForeground(new java.awt.Color(0, 51, 153));
        lbtext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtext.setText("00000");

        lbtext1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        lbtext1.setForeground(new java.awt.Color(55, 38, 91));
        lbtext1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtext1.setText("Total");

        javax.swing.GroupLayout panelOverviewLayout = new javax.swing.GroupLayout(panelOverview);
        panelOverview.setLayout(panelOverviewLayout);
        panelOverviewLayout.setHorizontalGroup(
            panelOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelOverviewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelOverviewLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(panelOverviewLayout.createSequentialGroup()
                        .addGroup(panelOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbtext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbtext1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        panelOverviewLayout.setVerticalGroup(
            panelOverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOverviewLayout.createSequentialGroup()
                .addComponent(lbtext1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbtext, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelNew.setBackground(new java.awt.Color(255, 255, 255));
        panelNew.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 153)));
        panelNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelNew.setPreferredSize(new java.awt.Dimension(200, 200));
        panelNew.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelNewMouseMoved(evt);
            }
        });
        panelNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelNewMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelNewMouseExited(evt);
            }
        });
        panelNew.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panelNewKeyPressed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 51, 153));

        lbtextnew.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbtextnew.setForeground(new java.awt.Color(255, 255, 255));
        lbtextnew.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtextnew.setText("Stock in");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbtextnew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbtextnew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        btnAdd.setBackground(java.awt.Color.white);
        btnAdd.setForeground(java.awt.Color.white);
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/icons8-purchase_stockin_100.png"))); // NOI18N
        btnAdd.setBorder(null);
        btnAdd.setBorderPainted(false);
        btnAdd.setContentAreaFilled(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnAdd.setIconTextGap(10);
        btnAdd.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnAddMouseMoved(evt);
            }
        });
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddMouseExited(evt);
            }
        });
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

        javax.swing.GroupLayout panelNewLayout = new javax.swing.GroupLayout(panelNew);
        panelNew.setLayout(panelNewLayout);
        panelNewLayout.setHorizontalGroup(
            panelNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
        );
        panelNewLayout.setVerticalGroup(
            panelNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNewLayout.createSequentialGroup()
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelProducts.setBackground(new java.awt.Color(255, 255, 255));
        panelProducts.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 38, 91)));
        panelProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelProducts.setPreferredSize(new java.awt.Dimension(200, 200));
        panelProducts.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelProductsMouseMoved(evt);
            }
        });
        panelProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelProductsMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelProductsMouseExited(evt);
            }
        });
        panelProducts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panelProductsKeyPressed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(0, 51, 153));

        lbtextproducts.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lbtextproducts.setForeground(new java.awt.Color(255, 255, 255));
        lbtextproducts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtextproducts.setText("Purchase Report");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbtextproducts, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbtextproducts, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        btnproducts.setBackground(java.awt.Color.white);
        btnproducts.setForeground(java.awt.Color.white);
        btnproducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconImage/icons8-purchase_report-100.png"))); // NOI18N
        btnproducts.setAlignmentY(0.0F);
        btnproducts.setBorder(null);
        btnproducts.setBorderPainted(false);
        btnproducts.setContentAreaFilled(false);
        btnproducts.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnproducts.setIconTextGap(10);
        btnproducts.setName("Products"); // NOI18N
        btnproducts.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnproductsMouseMoved(evt);
            }
        });
        btnproducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnproductsMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnproductsMouseExited(evt);
            }
        });
        btnproducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproductsActionPerformed(evt);
            }
        });
        btnproducts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnproductsKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelProductsLayout = new javax.swing.GroupLayout(panelProducts);
        panelProducts.setLayout(panelProductsLayout);
        panelProductsLayout.setHorizontalGroup(
            panelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnproducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelProductsLayout.setVerticalGroup(
            panelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProductsLayout.createSequentialGroup()
                .addComponent(btnproducts, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jSeparator2.setForeground(new java.awt.Color(0, 51, 153));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setText("Sub-menu of purchase");

        lbl_title.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lbl_title.setText("Purchase Dashboard");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(panelNew, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(panelProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(panelOverview, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 173, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl_title)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelOverview, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelNew, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                        .addComponent(panelProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(252, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void panelOverviewMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOverviewMouseMoved
        //  hover.setHover(panelOverview, lbtext, 26);
    }//GEN-LAST:event_panelOverviewMouseMoved

    private void panelOverviewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOverviewMouseClicked

        //new PanelController().showPanelWindow(new ProductsOverview());
    }//GEN-LAST:event_panelOverviewMouseClicked

    private void panelOverviewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOverviewMouseExited
        // hover.releaseHover(panelOverview, lbtext, 14);
    }//GEN-LAST:event_panelOverviewMouseExited

    private void btnAddMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseMoved
        hover.setHover(panelNew, lbtextnew, 18);
    }//GEN-LAST:event_btnAddMouseMoved

    private void btnAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseExited
        hover.releaseHover(panelNew, lbtextnew, 14);
    }//GEN-LAST:event_btnAddMouseExited

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        panelController.showPanelWindow(new Strock_in_Custom());
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAddKeyPressed
        if (evt.getKeyCode() == evt.VK_RIGHT) {
            btnproducts.requestFocus();
            hover.setHover(panelProducts, lbtextproducts, 18);
            hover.releaseHover(panelNew, lbtextnew, 14);
        }
        if (evt.getKeyCode() == 10) {
            // panelController.showPanelWindow(new AddProducts());
        }
    }//GEN-LAST:event_btnAddKeyPressed

    private void panelNewMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelNewMouseMoved
        hover.setHover(panelNew, lbtextnew, 18);
    }//GEN-LAST:event_panelNewMouseMoved

    private void panelNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelNewMouseClicked
        panelController.showPanelWindow(new Strock_in());
    }//GEN-LAST:event_panelNewMouseClicked

    private void panelNewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelNewMouseExited
        hover.releaseHover(panelNew, lbtextnew, 14);
    }//GEN-LAST:event_panelNewMouseExited

    private void panelNewKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelNewKeyPressed
        if (evt.getKeyCode() == evt.VK_RIGHT) {
            panelProducts.requestFocus();
            hover.setHover(panelProducts, lbtextnew, 18);
            hover.releaseHover(panelNew, lbtextnew, 14);
        }
    }//GEN-LAST:event_panelNewKeyPressed

    private void btnproductsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnproductsMouseMoved
        hover.setHover(panelProducts, lbtextproducts, 18);
    }//GEN-LAST:event_btnproductsMouseMoved

    private void btnproductsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnproductsMouseExited
        hover.releaseHover(panelProducts, lbtextproducts, 14);
    }//GEN-LAST:event_btnproductsMouseExited

    private void btnproductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproductsActionPerformed
        // panelController.showPanelWindow(new Products());
    }//GEN-LAST:event_btnproductsActionPerformed

    private void btnproductsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnproductsKeyPressed

        if (evt.getKeyCode() == 39) {
            btnAdd.requestFocus();
            hover.releaseHover(panelProducts, lbtextproducts, 14);
            hover.setHover(panelNew, lbtextnew, 18);
        }
        if (evt.getKeyCode() == 10) {
            // panelController.showPanelWindow(new Products());

        }
    }//GEN-LAST:event_btnproductsKeyPressed

    private void panelProductsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelProductsMouseMoved
        hover.setHover(panelProducts, lbtextproducts, 18);
    }//GEN-LAST:event_panelProductsMouseMoved

    private void panelProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelProductsMouseClicked
        //panelController.showPanelWindow(new Products());
    }//GEN-LAST:event_panelProductsMouseClicked

    private void panelProductsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelProductsMouseExited
        hover.releaseHover(panelProducts, lbtextproducts, 14);
    }//GEN-LAST:event_panelProductsMouseExited

    private void panelProductsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelProductsKeyPressed

    }//GEN-LAST:event_panelProductsKeyPressed

    private void btnproductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnproductsMouseClicked
        panelController.showPanelWindow(new PurchasesCustom());
    }//GEN-LAST:event_btnproductsMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnproducts;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JLabel lbtext;
    private javax.swing.JLabel lbtext1;
    private javax.swing.JLabel lbtextnew;
    private javax.swing.JLabel lbtextnew1;
    private javax.swing.JLabel lbtextproducts;
    private javax.swing.JPanel panelNew;
    private javax.swing.JPanel panelOverview;
    private javax.swing.JPanel panelProducts;
    // End of variables declaration//GEN-END:variables
}

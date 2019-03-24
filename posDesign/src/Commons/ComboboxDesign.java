/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commons;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 *
 * @author Niklaus
 */
public class ComboboxDesign {

    public void comboDesign(JComboBox jCombo) {
        jCombo.setBackground(Color.white);
        jCombo.setUI(new BasicComboBoxUI() {
            protected JButton createArrowButton() {
                BasicArrowButton arrowButton = new BasicArrowButton(BasicArrowButton.SOUTH, null, null, new Color(0, 51, 153), null);
                return arrowButton;
            }
        });
    }
}

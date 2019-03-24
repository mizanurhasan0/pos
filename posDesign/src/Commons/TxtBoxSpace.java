/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commons;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 *
 * @author Niklaus
 */
public class TxtBoxSpace {

    public void txtBoxSpace(JTextField txtField) {
        txtField.setBorder(BorderFactory.createCompoundBorder(
                txtField.getBorder(),
                BorderFactory.createEmptyBorder(0, 5, 0, 5)));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commons;

import javax.swing.JTextField;

/**
 *
 * @author Niklaus
 */
public class TextPlaceholder {

    public void placeHolder(String text, JTextField fieldName) {
        if (fieldName.getText().trim().equals(text)) {
            fieldName.setText("");
        } else if (fieldName.getText().trim().equals("")) {
            fieldName.setText(text);
        }

    }

}

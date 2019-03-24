/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commons;

import java.awt.Color;
import javax.swing.UIManager;

/**
 *
 * @author Niklaus
 */
public class TableBackgroundColor {

    public static class UiColors {

        public static Color BACKGROUND_COLOR_WHITE = new Color(255, 255, 255);
    }

    public void JTableDesign() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

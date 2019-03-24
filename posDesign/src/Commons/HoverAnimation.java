package Commons;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class HoverAnimation {

    public void setHover(JPanel panelOverview, JLabel lbtext, int textSize) {
        panelOverview.setBackground(new Color(153, 153, 255));
        lbtext.setFont(new Font("Century Gothic", Font.PLAIN, textSize));
        // lbtext.setForeground(new Color(255, 255, 255));
        Border selectBorder = BorderFactory.createLineBorder(new Color(255, 255, 255));
        panelOverview.setBorder(selectBorder);
    }
  

    public void releaseHover(JPanel panelOverview, JLabel lbtext, int textSize) {
        panelOverview.setBackground(new Color(255, 255, 255));
        lbtext.setFont(new Font("Century Gothic", Font.BOLD, textSize));
        Border selectBorder = BorderFactory.createLineBorder(new Color(55, 38, 91));
        panelOverview.setBorder(selectBorder);
    }
  
}

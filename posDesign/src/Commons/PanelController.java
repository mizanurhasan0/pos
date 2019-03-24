package Commons;

import Frm_products.SubMenuOfPurchase;
import Frm_products_subPanel.Products;
import java.awt.Panel;
import javax.swing.JPanel;
import static posdesign.Main2Frame.panelDisplay;
//import static mainTest.Main2Frame2.panelDisplay;

/**
 *
 * @author Niklaus
 */
public class PanelController {

    public void showPanelWindow(JPanel windowFrame) {
        panelDisplay.removeAll();
        panelDisplay.repaint();
        panelDisplay.revalidate();

        panelDisplay.add(windowFrame);
        panelDisplay.repaint();
        panelDisplay.revalidate();
    }



   
}

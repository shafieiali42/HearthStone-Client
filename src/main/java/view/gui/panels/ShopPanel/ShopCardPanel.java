package view.gui.panels.ShopPanel;

import javax.swing.*;
import java.awt.*;

public class ShopCardPanel extends JPanel {


    private static final int NUM_OF_CARD_IN_EVERY_ROW = 4;

    private JScrollPane jScrollPane;



    public ShopCardPanel(){
        setBackground(Color.darkGray);
        setLayout(null);
    }




    public void setJScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
    }
    public JScrollPane getJScrollPane() {
        return jScrollPane;
    }
    public int getNumOfCardInEveryRow(){return NUM_OF_CARD_IN_EVERY_ROW;}

}

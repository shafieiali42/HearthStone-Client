package view.gui.panels.ShopPanel;

import controller.Administer;
import utility.guiUtilities.LengthOfMessage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PanelToShowCardInBuySellPanel extends JPanel {



    private String cardToShowName;


    public PanelToShowCardInBuySellPanel() {

        setLayout(null);
//        setBackground(Color.orange);
        setSize(300, 500);

    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;

        if (cardToShowName==null) {
            int lengthOfMessage = LengthOfMessage.lengthOfMessage("Click on your Intended Card!", graphics2D);
            graphics2D.drawString("Click on your Intended Card!", (300 - lengthOfMessage) / 2, 250);
        } else {
            try {
                Administer.showShopStateCardInBuySellPanel(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public String getCardToShowName() {
        return cardToShowName;
    }

    public void setCardToShowName(String cardToShowName) {
        this.cardToShowName = cardToShowName;
    }
}

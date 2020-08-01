package view.gui.panels.ShopPanel;


import utility.constant.Constant;

import javax.swing.*;
import java.awt.*;


public class ShopPage extends JPanel {


    public ShopPage() {
        setSize(Constant.widthOfMainFrame, Constant.heightOfMainFrame);
        setLayout(null);
        this.addPanel(Constant.getPanels().get("ButtonPanel"), 0, 0, Constant.WIDTH_OF_BUTTON_PANEL_IN_SHOP,
                Constant.HEIGHT_OF_BUTTON_PANEL_IN_SHOP);

        ShopCardPanel shopCardPanel = (ShopCardPanel) Constant.getPanels().get("ShopCardPanel");
        shopCardPanel.setPreferredSize(new Dimension(1000, 1800));
        shopCardPanel.setFocusable(true);
        shopCardPanel.requestFocus();
        shopCardPanel.setJScrollPane(new JScrollPane(shopCardPanel));
        shopCardPanel.getJScrollPane().setBounds(0, Constant.HEIGHT_OF_BUTTON_PANEL_IN_SHOP, 1000, 720);
        shopCardPanel.getJScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        shopCardPanel.getJScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        shopCardPanel.getJScrollPane().setBorder(null);
        shopCardPanel.getJScrollPane().setFocusable(false);
        this.add(shopCardPanel.getJScrollPane());
        BuySellPanel buySellPanel =(BuySellPanel)Constant.getPanels().get("BuySellPanel");
        this.addPanel(buySellPanel, 1000, Constant.getPanels().get("ButtonPanel").getHeight(),
                Constant.WIDTH_OF_BUY_SELL_PANEL, Constant.HEIGHT_OF_BUY_SELL_PANEL);

    }


    public void addPanel(JPanel panel, int x, int y, int width, int height) {
        panel.setBounds(x, y, width, height);
        add(panel);
    }

}

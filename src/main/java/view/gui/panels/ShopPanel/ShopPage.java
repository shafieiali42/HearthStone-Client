package view.gui.panels.ShopPanel;

import Utility.Config2.ConfigLoader;
import View.Gui.Panels.MyMainFrame.MyMainFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Properties;

public class ShopPage extends JPanel {

    private Properties properties;

    {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/ShopPanel/ShopPage.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int WIDTH_OF_BUTTON_PANEL_IN_SHOP=Integer.parseInt(properties.getProperty("WIDTH_OF_BUTTON_PANEL_IN_SHOP"));
    int HEIGHT_OF_BUTTON_PANEL_IN_SHOP=Integer.parseInt(properties.getProperty("HEIGHT_OF_BUTTON_PANEL_IN_SHOP"));
    int WIDTH_OF_BUY_SELL_PANEL=Integer.parseInt(properties.getProperty("WIDTH_OF_BUY_SELL_PANEL"));
    int HEIGHT_OF_BUY_SELL_PANEL=Integer.parseInt(properties.getProperty("HEIGHT_OF_BUY_SELL_PANEL"));

    private static ShopPage shopPage=new ShopPage();
    public static ShopPage getInstance(){return shopPage;}



    private ShopPage(){
        setSize(MyMainFrame.getInstance().getMyFrameWidth(),MyMainFrame.getInstance().getMyFrameHeight());
        setLayout(null);
        this.addPanel(ButtonPanel.getInstance(),0,0, WIDTH_OF_BUTTON_PANEL_IN_SHOP,
                HEIGHT_OF_BUTTON_PANEL_IN_SHOP);

        ShopCardPanel.getInstance().setPreferredSize(new Dimension(1000,1800));
        ShopCardPanel.getInstance().setFocusable(true);
        ShopCardPanel.getInstance().requestFocus();
        ShopCardPanel.getInstance().setJScrollPane(new JScrollPane(ShopCardPanel.getInstance()));
        ShopCardPanel.getInstance().getJScrollPane().setBounds(0,HEIGHT_OF_BUTTON_PANEL_IN_SHOP,1000,720);
        ShopCardPanel.getInstance().getJScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        ShopCardPanel.getInstance().getJScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        ShopCardPanel.getInstance().getJScrollPane().setBorder(null);
        ShopCardPanel.getInstance().getJScrollPane().setFocusable(false);
        this.add(ShopCardPanel.getInstance().getJScrollPane());

        this.addPanel(BuySellPanel.getInstance(),1000,ButtonPanel.getInstance().getHeight(),
                WIDTH_OF_BUY_SELL_PANEL,HEIGHT_OF_BUY_SELL_PANEL);

    }


    public void addPanel(JPanel panel,int x, int y, int width,int height){
        panel.setBounds(x,y,width,height);
        add(panel);
    }

}

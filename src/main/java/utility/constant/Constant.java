package utility.constant;


import utility.config.ConfigLoader;
import view.gui.panels.CollectionPages.*;
import view.gui.panels.SettingPanel.SettingPage;
import view.gui.panels.ShopPanel.ButtonPanel;
import view.gui.panels.ShopPanel.BuySellPanel;
import view.gui.panels.ShopPanel.PanelToShowCardInBuySellPanel;
import view.gui.panels.ShopPanel.ShopCardPanel;
import view.gui.panels.StatusPanel.RankedPanel;
import view.gui.panels.StatusPanel.ShowDeckInfoPanel;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class Constant {


    private static HashMap<String, JPanel> panels = new HashMap<>();

    public static void setPanelsMap() {
        panels.put("cardPanelOfCollectionPage", new CardPanel());
        panels.put("cardPanelOfDeckPage", new CardPanel());
        panels.put("DeckPanel", new DeckPanel());
        panels.put("CollectionPage", new CollectionPage());
        panels.put("CategoryPanel", new CategoryPanel());
        panels.put("CategoryPanelOfChangeDeck", new CategoryPanelOfChangeDeck());
        panels.put("DeckPage", new DeckPage());
        panels.put("DeckViewer", new DeckViewer());
        panels.put("manaPanelForCollectionPage", new ManaPanel());
        panels.put("manaPanelForDeckPage", new ManaPanel());
        panels.put("ShowDeckInfoPanel",new ShowDeckInfoPanel());
        panels.put("RankedPanel",new RankedPanel());
        panels.put("SettingPage",new SettingPage());
        panels.put("ButtonPanel",new ButtonPanel());
        panels.put("ShopCardPanel",new ShopCardPanel());
        panels.put("PanelToShowCardInBuySellPanel",new PanelToShowCardInBuySellPanel());
        panels.put("BuySellPanel",new BuySellPanel());

    }

    public static HashMap<String, JPanel> getPanels() {
        return panels;
    }

    public static void setPanels(HashMap<String, JPanel> panels) {
        Constant.panels = panels;
    }

    private static Properties properties;

    {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/configFiles/graphicConfigFiles/Panels/SettingPanel/SettingPage.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int X_COORDINATE_OF_BUTTONS_IN_SETTING = Integer.parseInt(properties.getProperty("X_COORDINATE_OF_BUTTONS_IN_SETTING"));
    public static int Y_COORDINATE_OF_CHANGE_BACK_OF_CARDS_BTN = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_CHANGE_BACK_OF_CARDS_BTN"));
    public static int WIDTH_OF_BTN_IN_SETTING = Integer.parseInt(properties.getProperty("WIDTH_OF_BTN_IN_SETTING"));
    public static int HEIGHT_OF_BTN_IN_SETTING = Integer.parseInt(properties.getProperty("HEIGHT_OF_BTN_IN_SETTING"));
    public static int Y_COORDINATE_OF_BACK_BTN = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_BACK_BTN"));
    public static int Y_COORDINATE_OF_MUTE_BTN = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_MUTE_BTN"));
    public static int Y_COORDINATE_OF_INCREASE_BTN = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_INCREASE_BTN"));
    public static int Y_COORDINATE_OF_DECREASE_BTN = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_DECREASE_BTN"));


    {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/configFiles/graphicConfigFiles/Panels/ShopPanel/ShopPage.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int WIDTH_OF_BUTTON_PANEL_IN_SHOP = Integer.parseInt(properties.getProperty("WIDTH_OF_BUTTON_PANEL_IN_SHOP"));
    public static int HEIGHT_OF_BUTTON_PANEL_IN_SHOP = Integer.parseInt(properties.getProperty("HEIGHT_OF_BUTTON_PANEL_IN_SHOP"));
    public static int WIDTH_OF_BUY_SELL_PANEL = Integer.parseInt(properties.getProperty("WIDTH_OF_BUY_SELL_PANEL"));
    public static int HEIGHT_OF_BUY_SELL_PANEL = Integer.parseInt(properties.getProperty("HEIGHT_OF_BUY_SELL_PANEL"));


    {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/StatusPanel/RankedPanel.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int WIDE_OF_RANKED_PANEL = Integer.parseInt(properties.getProperty("WIDE_OF_RANKED_PANEL"));
    public static int HEIGHT_OF_RANKED_PANEL = Integer.parseInt(properties.getProperty("HEIGHT_OF_RANKED_PANEL"));


    {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/CollectionPages/CollectionPage.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int WIDTH_OF_CATEGORY_PANEL = Integer.parseInt(properties.getProperty("WIDTH_OF_CATEGORY_PANEL"));
    public static int HEIGHT_OF_CATEGORY_PANEL = Integer.parseInt(properties.getProperty("HEIGHT_OF_CATEGORY_PANEL"));
    public static int HEIGHT_OF_CATEGORY_PANEL_DECK_PAGE = Integer.parseInt(properties.getProperty("HEIGHT_OF_CATEGORY_PANEL_DECK_PAGE"));
    //    int HEIGHT_OF_CATEGORY_PANEL=Integer.parseInt(properties.getProperty("HEIGHT_OF_CATEGORY_PANEL"));
    public static int WIDTH_OF_MANA_PANEL = Integer.parseInt(properties.getProperty("WIDTH_OF_MANA_PANEL"));
    public static int HEIGHT_OF_MANA_PANEL = Integer.parseInt(properties.getProperty("HEIGHT_OF_CATEGORY_PANEL"));







    {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/CollectionPages/DeckPage.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int WIDTH_OF_CATEGORY_PANEL_DECK_PAGE = Integer.parseInt(properties.getProperty("WIDTH_OF_CATEGORY_PANEL_DECK_PAGE"));


    {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/CollectionPages/DeckPanel.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int WIDTH_OF_DECK_PANEL = Integer.parseInt(properties.getProperty("WIDTH_OF_DECK_PANEL"));
    public static int HEIGHT_OF_DECK_PANEL = Integer.parseInt(properties.getProperty("HEIGHT_OF_DECK_PANEL"));


    {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/CollectionPages/DeckViewer.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int WIDTH_OF_DECK_VIEWER = Integer.parseInt(properties.getProperty("WIDTH_OF_DECK_VIEWER"));
    public static int HEIGHT_OF_DECK_VIEWER = Integer.parseInt(properties.getProperty("HEIGHT_OF_DECK_VIEWER"));
    public static int HEIGHT_OF_LITTLE_CARD = Integer.parseInt(properties.getProperty("HEIGHT_OF_LITTLE_CARD"));


    {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/CollectionPages/LittleCardPanel.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int height = Integer.parseInt(properties.getProperty("HEIGHT_OF_LITTLE_CARD"));

    public static int width = Integer.parseInt(properties.getProperty("WIDTH_OF_LITTLE_CARD"));


    {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/CollectionPages/ManaPanel.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int HEIGHT_OF_MANA_BTN = Integer.parseInt(properties.getProperty("HEIGHT_OF_MANA_BTN"));
    public static int WIDTH_OF_MANA_BTN = Integer.parseInt(properties.getProperty("WIDTH_OF_MANA_BTN"));
    public static int WIDTH_OF_BACK_BTN_IN_MANA_PANEL = Integer.parseInt(properties.getProperty("WIDTH_OF_BACK_BTN_IN_MANA_PANEL"));
    public static int HEIGHT_OF_BACK_BTN_IN_MANA_PANEL = Integer.parseInt(properties.getProperty("HEIGHT_OF_BACK_BTN_IN_MANA_PANEL"));


    public static int widthOfMainFrame = 0;
    public static int heightOfMainFrame = 0;
    public static int defaultCloseOperation;
    public static boolean resizable;

    static {
        try {
            Properties properties = ConfigLoader.getInstance().readProperties("src/main/resources/configFiles/graphicConfigFiles/Panels/MyMainFrame/MainFrameConfigFiles.properties");
            widthOfMainFrame = Integer.parseInt(properties.getProperty("width"));
            heightOfMainFrame = Integer.parseInt(properties.getProperty("height"));
            defaultCloseOperation = Integer.parseInt(properties.getProperty("CloseOperation"));
            resizable = Boolean.parseBoolean(properties.getProperty("Resizable"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

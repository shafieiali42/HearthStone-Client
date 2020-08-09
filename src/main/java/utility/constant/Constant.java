package utility.constant;


import utility.config.ConfigLoader;
import view.gui.panels.CollectionPages.*;
import view.gui.panels.GamePage.InfoPassivePage;
import view.gui.panels.SettingPanel.SettingPage;
import view.gui.panels.ShopPanel.ButtonPanel;
import view.gui.panels.ShopPanel.BuySellPanel;
import view.gui.panels.ShopPanel.PanelToShowCardInBuySellPanel;
import view.gui.panels.ShopPanel.ShopCardPanel;
import view.gui.panels.StatusPanel.RankedPanel;
import view.gui.panels.StatusPanel.ShowDeckInfoPanel;
import view.gui.panels.StatusPanel.StatusPage;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class Constant {

    public static void main(String[] args) {
        System.out.println("LoadClass Constant");
    }

    private static HashMap<String, JPanel> panels = new HashMap<>();



    public static void setPanelsMap() {
        panels.put("cardPanelOfCollectionPage", new CardPanel());
        panels.put("cardPanelOfDeckPage", new CardPanel());
        panels.put("manaPanelForCollectionPage", new ManaPanel());
        panels.put("manaPanelForDeckPage", new ManaPanel());
        panels.put("DeckPanel", new DeckPanel());
        panels.put("CategoryPanel", new CategoryPanel());
        panels.put("CollectionPage", new CollectionPage());
        panels.put("CategoryPanelOfChangeDeck", new CategoryPanelOfChangeDeck());
        panels.put("DeckViewer", new DeckViewer());
        panels.put("DeckPage", new DeckPage());
        panels.put("ShowDeckInfoPanel", new ShowDeckInfoPanel());
        panels.put("RankedPanel", new RankedPanel());
        panels.put("StatusPage", new StatusPage());
        panels.put("SettingPage", new SettingPage());
        panels.put("ButtonPanel", new ButtonPanel());
        panels.put("ShopCardPanel", new ShopCardPanel());
        panels.put("PanelToShowCardInBuySellPanel", new PanelToShowCardInBuySellPanel());
        panels.put("BuySellPanel", new BuySellPanel());
    }

    public static HashMap<String, JPanel> getPanels() {
        return panels;
    }

    public static void setPanels(HashMap<String, JPanel> panels) {
        Constant.panels = panels;
    }

    private static Properties properties;

    public static int X_COORDINATE_OF_BUTTONS_IN_SETTING = 0;
    public static int Y_COORDINATE_OF_CHANGE_BACK_OF_CARDS_BTN = 0;
    public static int WIDTH_OF_BTN_IN_SETTING = 0;
    public static int HEIGHT_OF_BTN_IN_SETTING = 0;
    public static int Y_COORDINATE_OF_BACK_BTN = 0;
    public static int Y_COORDINATE_OF_MUTE_BTN = 0;
    public static int Y_COORDINATE_OF_INCREASE_BTN = 0;
    public static int Y_COORDINATE_OF_DECREASE_BTN = 0;

    static {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/configFiles/graphicConfigFiles/Panels/SettingPanel/SettingPage.properties");
            X_COORDINATE_OF_BUTTONS_IN_SETTING = Integer.parseInt(properties.getProperty("X_COORDINATE_OF_BUTTONS_IN_SETTING"));
            Y_COORDINATE_OF_CHANGE_BACK_OF_CARDS_BTN = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_CHANGE_BACK_OF_CARDS_BTN"));
            WIDTH_OF_BTN_IN_SETTING = Integer.parseInt(properties.getProperty("WIDTH_OF_BTN_IN_SETTING"));
            HEIGHT_OF_BTN_IN_SETTING = Integer.parseInt(properties.getProperty("HEIGHT_OF_BTN_IN_SETTING"));
            Y_COORDINATE_OF_BACK_BTN = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_BACK_BTN"));
            Y_COORDINATE_OF_MUTE_BTN = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_MUTE_BTN"));
            Y_COORDINATE_OF_INCREASE_BTN = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_INCREASE_BTN"));
            Y_COORDINATE_OF_DECREASE_BTN = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_DECREASE_BTN"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int WIDTH_OF_BUTTON_PANEL_IN_SHOP = 0;
    public static int HEIGHT_OF_BUTTON_PANEL_IN_SHOP = 0;
    public static int WIDTH_OF_BUY_SELL_PANEL = 0;
    public static int HEIGHT_OF_BUY_SELL_PANEL = 0;

    static {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/configFiles/graphicConfigFiles/Panels/ShopPanel/ShopPage.properties");
            WIDTH_OF_BUTTON_PANEL_IN_SHOP = Integer.parseInt(properties.getProperty("WIDTH_OF_BUTTON_PANEL_IN_SHOP"));
            HEIGHT_OF_BUTTON_PANEL_IN_SHOP = Integer.parseInt(properties.getProperty("HEIGHT_OF_BUTTON_PANEL_IN_SHOP"));
            WIDTH_OF_BUY_SELL_PANEL = Integer.parseInt(properties.getProperty("WIDTH_OF_BUY_SELL_PANEL"));
            HEIGHT_OF_BUY_SELL_PANEL = Integer.parseInt(properties.getProperty("HEIGHT_OF_BUY_SELL_PANEL"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int WIDE_OF_RANKED_PANEL = 0;
    public static int HEIGHT_OF_RANKED_PANEL = 0;

    static {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/configFiles/graphicConfigFiles/Panels/StatusPanel/RankedPanel.properties");
            WIDE_OF_RANKED_PANEL = Integer.parseInt(properties.getProperty("WIDE_OF_RANKED_PANEL"));
            HEIGHT_OF_RANKED_PANEL = Integer.parseInt(properties.getProperty("HEIGHT_OF_RANKED_PANEL"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static {
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


    static {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/CollectionPages/DeckPage.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int WIDTH_OF_CATEGORY_PANEL_DECK_PAGE = Integer.parseInt(properties.getProperty("WIDTH_OF_CATEGORY_PANEL_DECK_PAGE"));


    static {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/CollectionPages/DeckPanel.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int WIDTH_OF_DECK_PANEL = Integer.parseInt(properties.getProperty("WIDTH_OF_DECK_PANEL"));
    public static int HEIGHT_OF_DECK_PANEL = Integer.parseInt(properties.getProperty("HEIGHT_OF_DECK_PANEL"));


    static {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/CollectionPages/DeckViewer.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int WIDTH_OF_DECK_VIEWER = Integer.parseInt(properties.getProperty("WIDTH_OF_DECK_VIEWER"));
    public static int HEIGHT_OF_DECK_VIEWER = Integer.parseInt(properties.getProperty("HEIGHT_OF_DECK_VIEWER"));
    public static int HEIGHT_OF_LITTLE_CARD = Integer.parseInt(properties.getProperty("HEIGHT_OF_LITTLE_CARD"));


    static {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/CollectionPages/LittleCardPanel.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int height = Integer.parseInt(properties.getProperty("HEIGHT_OF_LITTLE_CARD"));

    public static int width = Integer.parseInt(properties.getProperty("WIDTH_OF_LITTLE_CARD"));


    static {
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
            System.out.println("Constant");
            Properties properties2 = ConfigLoader.getInstance().readProperties("src/main/resources/configFiles/graphicConfigFiles/Panels/MyMainFrame/MainFrameConfigFiles.properties");
            widthOfMainFrame = Integer.parseInt(properties2.getProperty("width"));
            heightOfMainFrame = Integer.parseInt(properties2.getProperty("height"));
            defaultCloseOperation = Integer.parseInt(properties2.getProperty("CloseOperation"));
            resizable = Boolean.parseBoolean(properties2.getProperty("Resizable"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/GamePage/Play.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int HEIGHT_OF_HANDS_PANEL = Integer.parseInt(properties.getProperty("HEIGHT_OF_HANDS_PANEL"));
    public static int WIDTH_OF_GAME_PANEL = Integer.parseInt(properties.getProperty("WIDTH_OF_GAME_PANEL"));
    public static int HEIGHT_OF_GAME_PANEL = Integer.parseInt(properties.getProperty("HEIGHT_OF_GAME_PANEL"));
    public static int NUMBER_OF_CARDS_PER_ROW_HANDS_CARDS = Integer.parseInt(properties.getProperty("NUMBER_OF_CARDS_PER_ROW_HANDS_CARDS"));
    public static int NUMBER_OF_CARDS_PER_ROW_GAME_PANEL = Integer.parseInt(properties.getProperty("NUMBER_OF_CARDS_PER_ROW_GAME_PANEL"));
    public static int X_COORDINATE_OF_HERO_IMAGE = Integer.parseInt(properties.getProperty("X_COORDINATE_OF_HERO_IMAGE"));
    public static int Y_COORDINATE_OF_HERO_IMAGE = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_HERO_IMAGE"));
    public static int WIDTH_OF_HERO_IMAGE = Integer.parseInt(properties.getProperty("WIDTH_OF_HERO_IMAGE"));
    public static int HEIGHT_OF_HERO_IMAGE = Integer.parseInt(properties.getProperty("HEIGHT_OF_HERO_IMAGE"));
    public static int X_COORDINATE_OF_HERO_POWER_IMAGE = Integer.parseInt(properties.getProperty("X_COORDINATE_OF_HERO_POWER_IMAGE"));
    public static int Y_COORDINATE_OF_HERO_POWER_IMAGE = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_HERO_POWER_IMAGE"));
    public static int WIDTH_OF_HERO_POWER_IMAGE = Integer.parseInt(properties.getProperty("WIDTH_OF_HERO_POWER_IMAGE"));
    public static int HEIGHT_OF_HERO_POWER_IMAGE = Integer.parseInt(properties.getProperty("HEIGHT_OF_HERO_POWER_IMAGE"));
    public static int WIDTH_OF_WEAPON_IMAGE = Integer.parseInt(properties.getProperty("WIDTH_OF_WEAPON_IMAGE"));
    public static int HEIGHT_OF_WEAPON_IMAGE = Integer.parseInt(properties.getProperty("HEIGHT_OF_WEAPON_IMAGE"));
    public static int X_COORDINATE_OF_WEAPON = Integer.parseInt(properties.getProperty("X_COORDINATE_OF_WEAPON"));
    public static int Y_COORDINATE_OF_WEAPON = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_WEAPON"));
    public static int X_COORDINATE_OF_HEAL_FIELD = Integer.parseInt(properties.getProperty("X_COORDINATE_OF_HEAL_FIELD"));
    public static int Y_COORDINATE_OF_HEAL_FIELD = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_HEAL_FIELD"));
    public static int MIN_X_FOR_PUT_CARDS = Integer.parseInt(properties.getProperty("MIN_X_FOR_PUT_CARDS"));
    public static int MAX_X_FOR_PUT_CARDS = Integer.parseInt(properties.getProperty("MAX_X_FOR_PUT_CARDS"));
    public static int MIN_Y_FOR_PUT_CARDS = Integer.parseInt(properties.getProperty("MIN_Y_FOR_PUT_CARDS"));
    public static int MAX_Y_FOR_PUT_CARDS = Integer.parseInt(properties.getProperty("MAX_Y_FOR_PUT_CARDS"));
    public static int WIDTH_OF_EACH_CARD_GAME_PANEL = Integer.parseInt(properties.getProperty("WIDTH_OF_EACH_CARD_GAME_PANEL"));
    public static int HEIGHT_OF_EACH_CARD_GAME_PANEL = Integer.parseInt(properties.getProperty("HEIGHT_OF_EACH_CARD_GAME_PANEL"));
    public static int WIDTH_OF_EACH_CARD_HANDS_CARDS = Integer.parseInt(properties.getProperty("WIDTH_OF_EACH_CARD_HANDS_CARDS"));
    public static int HEIGHT_OF_EACH_CARD_HANDS_CARDS = Integer.parseInt(properties.getProperty("HEIGHT_OF_EACH_CARD_HANDS_CARDS"));
    public static int WIDTH_OF_HANDS_PANEL = Integer.parseInt(properties.getProperty("WIDTH_OF_HANDS_PANEL"));
    public static int X_COORDINATE_OF_ENEMY_HERO_IMAGE = Integer.parseInt(properties.getProperty("X_COORDINATE_OF_ENEMY_HERO_IMAGE"));
    public static int Y_COORDINATE_OF_ENEMY_HERO_IMAGE = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_ENEMY_HERO_IMAGE"));
    public static int X_COORDINATE_OF_ENEMY_HERO_POWER_IMAGE = Integer.parseInt(properties.getProperty("X_COORDINATE_OF_ENEMY_HERO_POWER_IMAGE"));
    public static int Y_COORDINATE_OF_ENEMY_HERO_POWER_IMAGE = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_ENEMY_HERO_POWER_IMAGE"));
    public static int X_COORDINATE_OF__ENEMY_WEAPON = Integer.parseInt(properties.getProperty("X_COORDINATE_OF__ENEMY_WEAPON"));
    public static int Y_COORDINATE_OF_ENEMY_WEAPON = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_ENEMY_WEAPON"));


    static {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/GamePage/Log.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int WIDTH_OF_LOG_PANEL = Integer.parseInt(properties.getProperty("WIDTH_OF_LOG_PANEL"));
    public static int HEIGHT_OF_LOG_PANEL = Integer.parseInt(properties.getProperty("HEIGHT_OF_LOG_PANEL"));


    static {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/GamePage/InfoPassive.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int X_COORDINATE_OF_FIRST_BTN = Integer.parseInt(properties.getProperty("X_COORDINATE_OF_FIRST_BTN"));
    public static int Y_COORDINATE_OF_FIRST_BTN = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_FIRST_BTN"));


    static {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/GamePage/GamePage.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int WIDTH_OF_END_TURN_PANEL = Integer.parseInt(properties.getProperty("WIDTH_OF_END_TURN_PANEL"));
    public static int HEIGHT_OF_END_TURN_PANEL = Integer.parseInt(properties.getProperty("HEIGHT_OF_END_TURN_PANEL"));


    static {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/GamePage/FirstThreeCardsPage.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int WIDTH_OF_OK_BTN = Integer.parseInt(properties.getProperty("WIDTH_OF_OK_BTN"));
    public static int HEIGHT_OF_OK_BTN = Integer.parseInt(properties.getProperty("HEIGHT_OF_OK_BTN"));


    static {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/GamePage/DeckAndEndTurnPanel.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int WIDTH_OF_QIT_BTN = Integer.parseInt(properties.getProperty("WIDTH_OF_QIT_BTN"));
    public static int HEIGHT_OF_QUIT_BTN = Integer.parseInt(properties.getProperty("HEIGHT_OF_QUIT_BTN"));

    static {
        setPanelsMap();
    }


}


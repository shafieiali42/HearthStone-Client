package controller.controllers;

import controller.Alliance;
import utility.constant.Constant;
import utility.guiUtilities.MethodsOfShowCardsOnPanel;
import view.CardView.CardImagePanel;
import view.gui.panels.GamePage.DiscoverCardsPage;
import view.gui.panels.GamePage.LogPanel;
import view.gui.panels.GamePage.PlayPanel;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GamePartController {

    private static ArrayList<String> allCardsOfPlayerNames = new ArrayList<>();

    public static boolean isThisCardLock(String cardName) {
        return !allCardsOfPlayerNames.contains(cardName);
    }

    public static ArrayList<String> getAllCardsOfPlayerNames() {
        return allCardsOfPlayerNames;
    }

    public static void setAllCardsOfPlayerNames(ArrayList<String> allCardsOfPlayerNames) {
        GamePartController.allCardsOfPlayerNames = allCardsOfPlayerNames;
    }

    public static ArrayList<String> getListOfWeapons() {
        ArrayList<String> weaponsNames = new ArrayList<>();
        DiscoverCardsPage discoverCardsPage = (DiscoverCardsPage) Constant.getPanels().get("DiscoverCardsPage");
        weaponsNames.add(discoverCardsPage.getFirstCard());
        weaponsNames.add(discoverCardsPage.getSecondCard());
        weaponsNames.add(discoverCardsPage.getThirdCard());
        return weaponsNames;
    }

    public static void reStartDiscoverPageSetting() {
        DiscoverCardsPage discoverCardsPage = (DiscoverCardsPage) Constant.getPanels().get("DiscoverCardsPage");
        discoverCardsPage.reStartSetting();
    }


    private static String friendlyHeroHp;
    private static String friendlyHeroAttackPower;
    private static String enemyHeroHp;
    private static String enemyHeroAttackPower;

    private static String friendlyWeaponDurability;
    private static String enemyWeaponDurability;

    private static String friendlyWeaponAttackPower;
    private static String enemyWeaponAttackPower;
    private static HashMap<String, String> enemyHpHashMap = new HashMap<>();
    private static HashMap<String, String> enemyAttackPowerHashMap = new HashMap<>();

    public static HashMap<String, String> getEnemyHpHashMap() {
        return enemyHpHashMap;
    }

    public static void setEnemyHpHashMap(HashMap<String, String> enemyHpHashMap) {
        GamePartController.enemyHpHashMap = enemyHpHashMap;
    }

    public static HashMap<String, String> getEnemyAttackPowerHashMap() {
        return enemyAttackPowerHashMap;
    }

    public static void setEnemyAttackPowerHashMap(HashMap<String, String> enemyAttackPowerHashMap) {
        GamePartController.enemyAttackPowerHashMap = enemyAttackPowerHashMap;
    }

    public static String getFriendlyWeaponAttackPower() {
        return friendlyWeaponAttackPower;
    }

    public static void setFriendlyWeaponAttackPower(String friendlyWeaponAttackPower) {
        GamePartController.friendlyWeaponAttackPower = friendlyWeaponAttackPower;
    }

    public static String getEnemyWeaponAttackPower() {
        return enemyWeaponAttackPower;
    }

    public static void setEnemyWeaponAttackPower(String enemyWeaponAttackPower) {
        GamePartController.enemyWeaponAttackPower = enemyWeaponAttackPower;
    }


    public static String getFriendlyHeroHp() {
        return friendlyHeroHp;
    }

    public static void setFriendlyHeroHp(String friendlyHeroHp) {
        GamePartController.friendlyHeroHp = friendlyHeroHp;
    }

    public static String getFriendlyHeroAttackPower() {
        return friendlyHeroAttackPower;
    }

    public static void setFriendlyHeroAttackPower(String friendlyHeroAttackPower) {
        GamePartController.friendlyHeroAttackPower = friendlyHeroAttackPower;
    }

    public static String getEnemyHeroHp() {
        return enemyHeroHp;
    }

    public static void setEnemyHeroHp(String enemyHeroHp) {
        GamePartController.enemyHeroHp = enemyHeroHp;
    }

    public static String getEnemyHeroAttackPower() {
        return enemyHeroAttackPower;
    }

    public static void setEnemyHeroAttackPower(String enemyHeroAttackPower) {
        GamePartController.enemyHeroAttackPower = enemyHeroAttackPower;
    }

    public static String giveMinionHpWithName(int numberOfCardInBattleGround, Alliance alliance) {
        if (alliance.equals(Alliance.WHITE)) {
            return friendlyHpHashMap.get((numberOfCardInBattleGround ) + "") + "";

        } else if (alliance.equals(Alliance.BLACK)) {
            return enemyHpHashMap.get((numberOfCardInBattleGround ) + "") + "";
        }
        return "-55555555";
    }


    public static String giveMinionAttackWithName(int numberOfCardInBattleGround, Alliance alliance) {

        if (alliance.equals(Alliance.WHITE)) {
            return friendlyAttackPowerHashMap.get((numberOfCardInBattleGround ) + "") + "";

        } else if (alliance.equals(Alliance.BLACK)) {

            return enemyAttackPowerHashMap.get((numberOfCardInBattleGround ) + "") + "";
        }
        return "-66666666";
    }


    private static HashMap<String, String> friendlyHpHashMap = new HashMap<>();
    private static HashMap<String, String> friendlyAttackPowerHashMap = new HashMap<>();

    public static HashMap<String, String> getFriendlyHpHashMap() {
        return friendlyHpHashMap;
    }

    public static void setFriendlyHpHashMap(HashMap<String, String> friendlyHpHashMap) {
        GamePartController.friendlyHpHashMap = friendlyHpHashMap;
    }

    public static HashMap<String, String> getFriendlyAttackPowerHashMap() {
        return friendlyAttackPowerHashMap;
    }

    public static void setFriendlyAttackPowerHashMap
            (HashMap<String, String> friendlyAttackPowerHashMap) {
        GamePartController.friendlyAttackPowerHashMap = friendlyAttackPowerHashMap;
    }

    public static String getFriendlyWeaponDurability() {
        return friendlyWeaponDurability;
    }

    public static void setFriendlyWeaponDurability(String friendlyWeaponDurability) {
        GamePartController.friendlyWeaponDurability = friendlyWeaponDurability;
    }

    public static String getEnemyWeaponDurability() {
        return enemyWeaponDurability;
    }

    public static void setEnemyWeaponDurability(String enemyWeaponDurability) {
        GamePartController.enemyWeaponDurability = enemyWeaponDurability;
    }


    public static String giveWeaponDurability(Alliance alliance) {

        if (alliance.equals(Alliance.WHITE)) {
            return friendlyWeaponDurability;

        } else if (alliance.equals(Alliance.BLACK)) {
            return enemyWeaponDurability;
        }
        return "-555555";
    }

    public static String giveWeaponAttackPower(Alliance alliance) {

        if (alliance.equals(Alliance.WHITE)) {
            return friendlyWeaponAttackPower;

        } else if (alliance.equals(Alliance.BLACK)) {
            return enemyWeaponAttackPower;
        }
        return "-555555";
    }


    public static String giveHeroHp(Alliance alliance) {
        if (alliance.equals(Alliance.WHITE)) {
            return friendlyHeroHp;
        } else if (alliance.equals(Alliance.BLACK)) {
            return enemyHeroHp;
        }
        return "-888888";
    }

    public static String giveHeroAttackPower(Alliance alliance) {
        if (alliance.equals(Alliance.WHITE)) {
            return friendlyHeroAttackPower;
        } else if (alliance.equals(Alliance.BLACK)) {
            return enemyHeroAttackPower;
        }
        return "-888888";
    }



    public static boolean canDragCard(int y) {
        if (gameMode.equalsIgnoreCase("OfflineGame")){
            return true;
        }
        return y >= 670;
    }




    public static void writeOnLogPanel(String log) {
        LogPanel logPanel=(LogPanel)Constant.getPanels().get("LogPanel");
        StringBuilder addToLog = new StringBuilder(logPanel.getLog());
        for (int i = 0; i < log.length(); i++) {
            char c = log.charAt(i);
            if (Character.isUpperCase(c)) {
                addToLog.append("\n");
                addToLog.append(c);
            } else {
                addToLog.append(c);
            }
        }
        logPanel.setLog(addToLog.toString() + "\n\n");
        logPanel.repaint();
        logPanel.revalidate();

    }

        //*****************************************************************************

    private static ArrayList<String> whiteHandCards = new ArrayList<>();
    private static ArrayList<String> blackHandCards = new ArrayList<>();

    private static ArrayList<String> whiteBattleGround = new ArrayList<>();
    private static ArrayList<String> blackBattleGround = new ArrayList<>();

    private static String gameMode;

    private static String mana;
    private static String numberOfCardsInDeck;
    private static String questCardName;
    private static String getManaSpendForQuest;
    private static String getManaNeededForQuest;


    public static String getFriendlyImprovementOfQuest() {
        if (questCardName != null) {
            return getManaNeededForQuest +
                    "/" + getManaNeededForQuest;
        } else {
            return "NoActiveQuest";
        }
    }


    public static void setNeedTimer(boolean show) {
        PlayPanel playPanel = (PlayPanel) Constant.getPanels().get("PlayPanel");
        playPanel.setNeedTimer(show);
    }


    public static void showHeroPower(JPanel panel, int widthOfHeroPowerImage, int heightOfHeroPowerImage,
                                     int xCoordinateOfHeroPower, int yCoordinateOfHeroPower,
                                     String heroName, Alliance alliance) {


        CardImagePanel cardImagePanel = null;
        try {
            cardImagePanel = new CardImagePanel(heroName + "HeroPower",
                    widthOfHeroPowerImage, heightOfHeroPowerImage, "heroPower", alliance);
        } catch (IOException e) {
            e.printStackTrace();
        }

        MethodsOfShowCardsOnPanel.addPanel(cardImagePanel, panel,
                xCoordinateOfHeroPower, yCoordinateOfHeroPower, widthOfHeroPowerImage, heightOfHeroPowerImage);
    }


    public static void showWeaponOfGameState(JPanel panel, int widthOfWeaponImage, int heightOfWeaponImage,
                                             int xCoordinateOfWeapon, int yCoordinateOfWeapon,
                                             String weaponName, Alliance alliance) {
        if (weaponName != null && !weaponName.equalsIgnoreCase("")) {
            try {
                CardImagePanel cardImagePanel = new CardImagePanel(weaponName,
                        widthOfWeaponImage, heightOfWeaponImage, "weapon", alliance);

                MethodsOfShowCardsOnPanel.addPanel(cardImagePanel, panel,
                        xCoordinateOfWeapon, yCoordinateOfWeapon, widthOfWeaponImage, heightOfWeaponImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void showEnemyHandsCardInPlay(JPanel panel, int numberOfCardsPerRowHandsCards,
                                                int typeOfBackOfCards, String gameMode, ArrayList<String> handsCards) {
        if (!gameMode.equalsIgnoreCase("OfflineGame")) {
            MethodsOfShowCardsOnPanel.showBackOfEnemyHandsCards(handsCards,
                    panel, numberOfCardsPerRowHandsCards, typeOfBackOfCards);
        } else {
            MethodsOfShowCardsOnPanel.showHandsCards(handsCards,
                    panel, numberOfCardsPerRowHandsCards, Alliance.BLACK);
        }
    }

    public static void showFriendlyHandsCardInPlay(JPanel panel, int numberOfCardsPerRowHandsCards,
                                                   ArrayList<String> handsCards, Alliance alliance) {

        MethodsOfShowCardsOnPanel.showHandsCards(handsCards, panel, numberOfCardsPerRowHandsCards, alliance);
    }

    public static void showBattleGroundCardsInPlay(JPanel panel, int numberOfCardsPerRowGamePanel,
                                                   ArrayList<String> battleGround, Alliance alliance) {

        MethodsOfShowCardsOnPanel.showBattleGroundCards(battleGround, panel, numberOfCardsPerRowGamePanel, alliance);
    }


    //getter and setters
    //********************

    public static ArrayList<String> getWhiteHandCards() {
        return whiteHandCards;
    }

    public static void setWhiteHandCards(ArrayList<String> whiteHandCards) {
        GamePartController.whiteHandCards = whiteHandCards;
    }

    public static ArrayList<String> getBlackHandCards() {
        return blackHandCards;
    }

    public static void setBlackHandCards(ArrayList<String> blackHandCards) {
        GamePartController.blackHandCards = blackHandCards;
    }

    public static ArrayList<String> getWhiteBattleGround() {
        return whiteBattleGround;
    }

    public static void setWhiteBattleGround(ArrayList<String> whiteBattleGround) {
        GamePartController.whiteBattleGround = whiteBattleGround;
    }

    public static ArrayList<String> getBlackBattleGround() {
        return blackBattleGround;
    }

    public static void setBlackBattleGround(ArrayList<String> blackBattleGround) {
        GamePartController.blackBattleGround = blackBattleGround;
    }

    public static String getGameMode() {
        return gameMode;
    }

    public static void setGameMode(String gameMode) {
        GamePartController.gameMode = gameMode;
    }

    public static String getMana() {
        return mana;
    }

    public static void setMana(String mana) {
        GamePartController.mana = mana;
    }

    public static String getNumberOfCardsInDeck() {
        return numberOfCardsInDeck;
    }

    public static void setNumberOfCardsInDeck(String numberOfCardsInDeck) {
        GamePartController.numberOfCardsInDeck = numberOfCardsInDeck;
    }

    public static String getQuestCardName() {
        return questCardName;
    }

    public static void setQuestCardName(String questCardName) {
        GamePartController.questCardName = questCardName;
    }

    public static String getGetManaSpendForQuest() {
        return getManaSpendForQuest;
    }

    public static void setGetManaSpendForQuest(String getManaSpendForQuest) {
        GamePartController.getManaSpendForQuest = getManaSpendForQuest;
    }

    public static String getGetManaNeededForQuest() {
        return getManaNeededForQuest;
    }

    public static void setGetManaNeededForQuest(String getManaNeededForQuest) {
        GamePartController.getManaNeededForQuest = getManaNeededForQuest;
    }

}

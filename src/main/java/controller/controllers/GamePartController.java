package controller.controllers;

import controller.Alliance;
import utility.constant.Constant;
import utility.guiUtilities.MethodsOfShowCardsOnPanel;
import view.CardView.CardImagePanel;
import view.gui.panels.GamePage.PlayPanel;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class GamePartController {


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
        PlayPanel playPanel=(PlayPanel) Constant.getPanels().get("PlayPanel");
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
        if (weaponName != null) {
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

package controller.controllers;

import controller.Alliance;
import utility.constant.Constant;
import utility.guiUtilities.MethodsOfShowCardsOnPanel;
import view.CardView.CardImagePanel;
import view.gui.panels.GamePage.PlayPanel;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GamePartController {


//    private static int attacker;
//    private static int target;
//
//    private static Alliance attackerAlliance;
//    private static Alliance targetAlliance;
//
//    private static int targetOfSpell;
//    private static Alliance allianceOfSpellsTarget;
//
//    private static int targetOfHeroPower;
//    private static Alliance targetAllianceOfHeroPower;


    private static String friendlyHeroHp;
    private static String friendlyHeroAttackPower;
    private static String enemyHeroHp;
    private static String enemyHeroAttackPower;

    private static String friendlyWeaponDurability;
    private static String enemyWeaponDurability;

    private static String friendlyWeaponAttackPower;
    private static String enemyWeaponAttackPower;
    private static HashMap<Integer, Integer> enemyHpHashMap = new HashMap<>();
    private static HashMap<Integer, Integer> enemyAttackPowerHashMap = new HashMap<>();

    public static HashMap<Integer, Integer> getEnemyHpHashMap() {
        return enemyHpHashMap;
    }

    public static void setEnemyHpHashMap(HashMap<Integer, Integer> enemyHpHashMap) {
        GamePartController.enemyHpHashMap = enemyHpHashMap;
    }

    public static HashMap<Integer, Integer> getEnemyAttackPowerHashMap() {
        return enemyAttackPowerHashMap;
    }

    public static void setEnemyAttackPowerHashMap(HashMap<Integer, Integer> enemyAttackPowerHashMap) {
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

    public static int giveMinionHpWithName(int numberOfCardInBattleGround, Alliance alliance) {
        if (alliance.equals(Alliance.WHITE)) {
            return friendlyHpHashMap.get(numberOfCardInBattleGround - 1);

        } else if (alliance.equals(Alliance.BLACK)) {
            return enemyHpHashMap.get(numberOfCardInBattleGround - 1);
        }
        return -55555555;
    }


    public static int giveMinionAttackWithName(int numberOfCardInBattleGround, Alliance alliance) {

        if (alliance.equals(Alliance.WHITE)) {
            return friendlyAttackPowerHashMap.get(numberOfCardInBattleGround - 1);

        } else if (alliance.equals(Alliance.BLACK)) {

            return enemyAttackPowerHashMap.get(numberOfCardInBattleGround - 1);
        }
        return -66666666;
    }


    private static HashMap<Integer, Integer> friendlyHpHashMap = new HashMap<>();
    private static HashMap<Integer, Integer> friendlyAttackPowerHashMap = new HashMap<>();

    public static HashMap<Integer, Integer> getFriendlyHpHashMap() {
        return friendlyHpHashMap;
    }

    public static void setFriendlyHpHashMap(HashMap<Integer, Integer> friendlyHpHashMap) {
        GamePartController.friendlyHpHashMap = friendlyHpHashMap;
    }

    public static HashMap<Integer, Integer> getFriendlyAttackPowerHashMap() {
        return friendlyAttackPowerHashMap;
    }

    public static void setFriendlyAttackPowerHashMap(HashMap<Integer, Integer> friendlyAttackPowerHashMap) {
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


    public static int giveWeaponDurability(Alliance alliance) {

        if (alliance.equals(Alliance.WHITE)) {
            return Integer.parseInt(friendlyWeaponDurability);

        } else if (alliance.equals(Alliance.BLACK)) {
            return Integer.parseInt(enemyWeaponDurability);
        }
        return -555555;
    }

    public static int giveWeaponAttackPower(Alliance alliance) {

        if (alliance.equals(Alliance.WHITE)) {
            return Integer.parseInt(friendlyWeaponAttackPower);

        } else if (alliance.equals(Alliance.BLACK)) {
            return Integer.parseInt(enemyWeaponAttackPower);
        }
        return -555555;
    }


    public static int giveHeroHp(Alliance alliance) {
        if (alliance.equals(Alliance.WHITE)) {
            return Integer.parseInt(friendlyHeroHp);
        } else if (alliance.equals(Alliance.BLACK)) {
            return Integer.parseInt(enemyHeroHp);
        }
        return -888888;
    }

    public static int giveHeroAttackPower(Alliance alliance) {
        if (alliance.equals(Alliance.WHITE)) {
            return Integer.parseInt(friendlyHeroAttackPower);
        } else if (alliance.equals(Alliance.BLACK)) {
            return Integer.parseInt(enemyHeroAttackPower);
        }
        return -888888;
    }


    public static boolean canDragCard(int y) {
        return y >= 670;
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


//    public static int getAttacker() {
//        return attacker;
//    }
//
//    public static void setAttacker(int attacker) {
//        GamePartController.attacker = attacker;
//    }
//
//    public static int getTarget() {
//        return target;
//    }
//
//    public static void setTarget(int target) {
//        GamePartController.target = target;
//    }
//
//    public static Alliance getAttackerAlliance() {
//        return attackerAlliance;
//    }
//
//    public static void setAttackerAlliance(Alliance attackerAlliance) {
//        GamePartController.attackerAlliance = attackerAlliance;
//    }
//
//    public static Alliance getTargetAlliance() {
//        return targetAlliance;
//    }
//
//    public static void setTargetAlliance(Alliance targetAlliance) {
//        GamePartController.targetAlliance = targetAlliance;
//    }
//
//    public static int getTargetOfSpell() {
//        return targetOfSpell;
//    }
//
//    public static void setTargetOfSpell(int targetOfSpell) {
//        GamePartController.targetOfSpell = targetOfSpell;
//    }
//
//    public static Alliance getAllianceOfSpellsTarget() {
//        return allianceOfSpellsTarget;
//    }
//
//    public static void setAllianceOfSpellsTarget(Alliance allianceOfSpellsTarget) {
//        GamePartController.allianceOfSpellsTarget = allianceOfSpellsTarget;
//    }
//
//    public static int getTargetOfHeroPower() {
//        return targetOfHeroPower;
//    }
//
//    public static void setTargetOfHeroPower(int targetOfHeroPower) {
//        GamePartController.targetOfHeroPower = targetOfHeroPower;
//    }
//
//    public static Alliance getTargetAllianceOfHeroPower() {
//        return targetAllianceOfHeroPower;
//    }
//
//    public static void setTargetAllianceOfHeroPower(Alliance targetAllianceOfHeroPower) {
//        GamePartController.targetAllianceOfHeroPower = targetAllianceOfHeroPower;
//    }
}

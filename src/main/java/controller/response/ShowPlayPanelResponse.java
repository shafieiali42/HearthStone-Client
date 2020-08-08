package controller.response;

import controller.controllers.GamePartController;
import utility.constant.Constant;
import utility.guiUtilities.Sounds;
import view.gui.panels.GamePage.PlayPanel;

import java.util.ArrayList;

public class ShowPlayPanelResponse extends Response {


    private String userName;
    private ArrayList<String> nameOfWhiteHandsCards;
    private ArrayList<String> nameOfBlackHandsCards;
    private ArrayList<String> nameOfWhiteBattleGroundCards;
    private ArrayList<String> nameOfBlackBattleGroundCards;
    private String whitePlayerHeroName;
    private String blackPlayerHeroName;
    private String whitePlayerWeaponName;
    private String blackPlayerWeaponName;
    private String state;

    public ShowPlayPanelResponse(String userName, ArrayList<String> nameOfWhiteHandsCards,
                                 ArrayList<String> nameOfBlackHandsCards,
                                 ArrayList<String> nameOfWhiteBattleGroundCards,
                                 ArrayList<String> nameOfBlackBattleGroundCards,
                                 String whitePlayerHeroName, String blackPlayerHeroName,
                                 String whitePlayerWeaponName, String blackPlayerWeaponName, String state) {


        this.userName = userName;
        this.nameOfWhiteHandsCards = nameOfWhiteHandsCards;
        this.nameOfBlackHandsCards = nameOfBlackHandsCards;
        this.nameOfWhiteBattleGroundCards = nameOfWhiteBattleGroundCards;
        this.nameOfBlackBattleGroundCards = nameOfBlackBattleGroundCards;
        this.whitePlayerHeroName = whitePlayerHeroName;
        this.blackPlayerHeroName = blackPlayerHeroName;
        this.whitePlayerWeaponName = whitePlayerWeaponName;
        this.blackPlayerWeaponName = blackPlayerWeaponName;
        this.state=state;
    }



    @Override
    public void execute() {
        if (state.equalsIgnoreCase("EndTurn")){
            GamePartController.setNeedTimer(false);
            Sounds.playActionSounds("src/main/resources/Sounds/ActionVoices/EndTurn.wav");
        }
        PlayPanel playPanel=(PlayPanel) Constant.getPanels().get("PlayPanel");
        playPanel.setNameOfFriendlyHero(whitePlayerHeroName);
        playPanel.setNameOfEnemyHero(blackPlayerHeroName);
        playPanel.setNameOfFriendlyWeapon(whitePlayerWeaponName);
        playPanel.setNameOfEnemyWeapon(blackPlayerWeaponName);
        GamePartController.setWhiteHandCards(nameOfWhiteHandsCards);
        GamePartController.setBlackHandCards(nameOfBlackHandsCards);
        GamePartController.setWhiteBattleGround(nameOfWhiteBattleGroundCards);
        GamePartController.setBlackBattleGround(nameOfBlackBattleGroundCards);
        playPanel.setNeedsToRepaint(true);
        playPanel.repaint();
        playPanel.revalidate();
    }



    //getter and setters
    //********************

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<String> getNameOfWhiteHandsCards() {
        return nameOfWhiteHandsCards;
    }

    public void setNameOfWhiteHandsCards(ArrayList<String> nameOfWhiteHandsCards) {
        this.nameOfWhiteHandsCards = nameOfWhiteHandsCards;
    }

    public ArrayList<String> getNameOfBlackHandsCards() {
        return nameOfBlackHandsCards;
    }

    public void setNameOfBlackHandsCards(ArrayList<String> nameOfBlackHandsCards) {
        this.nameOfBlackHandsCards = nameOfBlackHandsCards;
    }

    public ArrayList<String> getNameOfWhiteBattleGroundCards() {
        return nameOfWhiteBattleGroundCards;
    }

    public void setNameOfWhiteBattleGroundCards(ArrayList<String> nameOfWhiteBattleGroundCards) {
        this.nameOfWhiteBattleGroundCards = nameOfWhiteBattleGroundCards;
    }

    public ArrayList<String> getNameOfBlackBattleGroundCards() {
        return nameOfBlackBattleGroundCards;
    }

    public void setNameOfBlackBattleGroundCards(ArrayList<String> nameOfBlackBattleGroundCards) {
        this.nameOfBlackBattleGroundCards = nameOfBlackBattleGroundCards;
    }

    public String getWhitePlayerHeroName() {
        return whitePlayerHeroName;
    }

    public void setWhitePlayerHeroName(String whitePlayerHeroName) {
        this.whitePlayerHeroName = whitePlayerHeroName;
    }

    public String getBlackPlayerHeroName() {
        return blackPlayerHeroName;
    }

    public void setBlackPlayerHeroName(String blackPlayerHeroName) {
        this.blackPlayerHeroName = blackPlayerHeroName;
    }

    public String getWhitePlayerWeaponName() {
        return whitePlayerWeaponName;
    }

    public void setWhitePlayerWeaponName(String whitePlayerWeaponName) {
        this.whitePlayerWeaponName = whitePlayerWeaponName;
    }

    public String getBlackPlayerWeaponName() {
        return blackPlayerWeaponName;
    }

    public void setBlackPlayerWeaponName(String blackPlayerWeaponName) {
        this.blackPlayerWeaponName = blackPlayerWeaponName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

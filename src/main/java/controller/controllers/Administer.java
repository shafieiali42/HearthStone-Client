package controller.controllers;

import utility.constant.Constant;
import utility.guiUtilities.MethodsOfShowCardsOnPanel;
import utility.guiUtilities.Sounds;
import view.CardView.CardImagePanel;
import view.gui.panels.GamePage.PlayPanel;
import view.gui.panels.ShopPanel.PanelToShowCardInBuySellPanel;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Administer {




    public static void showGroupOfCards(ArrayList<String> listOfCardsNames,JPanel panel, int numberOfCardsPerRow) {
        MethodsOfShowCardsOnPanel.showCards(listOfCardsNames,panel, numberOfCardsPerRow);
    }


    public static void showShopStateCardInBuySellPanel(JPanel panel) throws IOException {//todo check.....
        PanelToShowCardInBuySellPanel panelToShowCardInBuySellPanel=(PanelToShowCardInBuySellPanel)
                Constant.getPanels().get("PanelToShowCardInBuySellPanel");
        CardImagePanel cardImagePanel = new CardImagePanel(panelToShowCardInBuySellPanel.getCardToShowName());
        MethodsOfShowCardsOnPanel.addPanel(cardImagePanel, panel, 0, 0, panel.getWidth(), panel.getHeight());
    }


    public static void changeBackOfCards(int typeOfBackOfCards) {
        PlayPanel playPanel=(PlayPanel)Constant.getPanels().get("PlayPanel");
        playPanel.setTypeOfBackOfCards(typeOfBackOfCards);
    }

    public static void changeStatusOfSound(int numberOfPushMuteBtn) {
        Sounds.changeStatus(numberOfPushMuteBtn);
    }

    public static void playActionSounds(String action) {
        Sounds.playActionSounds("src/main/resources/Sounds/ActionVoices/" + action + ".wav");
    }


    public static void increaseSound() {
        Sounds.increaseSound();
    }

    public static void decreaseSound() {
        Sounds.decreaseSound();
    }

    public static void goBack() {
//        ControllerOfMainComponents.setStatus(Status.MAIN_MENU_PAGE);
        Controller.getCurrentClient().sendGoToPage(Controller.getCurrentPlayerUserName(),"MainMenuPage");

    }

    public static void playMainSound(String path) {
        Sounds.playMainSound(path);
    }



}

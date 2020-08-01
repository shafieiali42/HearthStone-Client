package controller;

import utility.guiUtilities.MethodsOfShowCardsOnPanel;
import utility.guiUtilities.Sounds;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Administer {




    public static void showGroupOfCards(ArrayList<String> listOfCardsNames,JPanel panel, int numberOfCardsPerRow) {
        try {
            MethodsOfShowCardsOnPanel.showCards(listOfCardsNames,panel, numberOfCardsPerRow);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void changeBackOfCards(int typeOfBackOfCards) {
        PlayPanel.getInstance().setTypeOfBackOfCards(typeOfBackOfCards);
    }

    public static void changeStatusOfSound(int numberOfPushMuteBtn) {
        Sounds.changeStatus(numberOfPushMuteBtn);
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

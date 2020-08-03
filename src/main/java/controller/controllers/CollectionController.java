package controller.controllers;

import utility.guiUtilities.MethodsOfShowCardsOnPanel;
import view.gui.panels.CollectionPages.LittleCardPanel;

import javax.swing.*;
import java.util.ArrayList;

public class CollectionController {


    public static void showLittleCardPanelOnDeckViewer(LittleCardPanel littleCardPanel, JPanel panel,
                                                       int xCoordinate, int yCoordinate) {
        MethodsOfShowCardsOnPanel.addPanel(littleCardPanel, panel,
                xCoordinate, yCoordinate, littleCardPanel.getWidth(), littleCardPanel.getHeight());
    }


    private static ArrayList<String> listOfCardOfDeckToChange=new ArrayList<>();

    public static ArrayList<String> getListOfCardOfDeckToChange() {
        return listOfCardOfDeckToChange;
    }

    public static void setListOfCardOfDeckToChange(ArrayList<String> listOfCardOfDeckToChange) {
        CollectionController.listOfCardOfDeckToChange = listOfCardOfDeckToChange;
    }
}

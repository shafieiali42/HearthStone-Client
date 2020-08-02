package controller.response;

import Main.ClientMain;
import utility.constant.Constant;
import view.gui.panels.CollectionPages.CollectionPage;
import view.gui.panels.CollectionPages.DeckPanel;

import javax.swing.*;

public class MakeChangeToDeckToChangeResponse extends Response {


    private String typeOfRequest;
    private String newField;


    public MakeChangeToDeckToChangeResponse(String typeOfRequest, String newField) {
        this.typeOfRequest = typeOfRequest;
        this.newField = newField;
    }


    @Override
    public void execute() {

        switch (typeOfRequest) {
            case "SelectMainDeck":
                JOptionPane.showMessageDialog(null, "Your Deck is:" +newField);
                break;
            case "ChangeName":

                break;

            case "ChangeHero":

                break;
            case "RemoveDeck":
                ((DeckPanel) Constant.getPanels().get("DeckPanel")).showDeckButtons();
                CollectionPage collectionPage = (CollectionPage) Constant.getPanels().get("CollectionPage");
                collectionPage.repaint();
                collectionPage.revalidate();
                ClientMain.getMyMainFrame().setContentPane(Constant.getPanels().get("CollectionPage"));
                break;


        }
    }


    public String getTypeOfRequest() {
        return typeOfRequest;
    }

    public void setTypeOfRequest(String typeOfRequest) {
        this.typeOfRequest = typeOfRequest;
    }


    public String getNewField() {
        return newField;
    }

    public void setNewField(String newField) {
        this.newField = newField;
    }
}

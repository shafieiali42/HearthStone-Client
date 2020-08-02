package controller.response;

import utility.constant.Constant;
import view.gui.panels.CollectionPages.DeckPanel;

import java.util.ArrayList;

public class ShowDeckButtonsResponse extends Response {

    private ArrayList<String> deckNamesList;

    public ShowDeckButtonsResponse(ArrayList<String> deckNamesList) {
        this.deckNamesList = deckNamesList;
    }


    @Override
    public void execute() {
        DeckPanel deckPanel = (DeckPanel) Constant.getPanels().get("DeckPanel");
        deckPanel.removeAll();
        deckPanel.repaint();
        deckPanel.revalidate();
        deckPanel.add(deckPanel.getNewDeckBtn());
        if (deckNamesList.size() != 0) {
            for (String deckName : deckNamesList) {
                deckPanel.initButtonForDeck(deckName);
            }
        }
    }

    public ArrayList<String> getDeckNamesList() {
        return deckNamesList;
    }


    public void setDeckNamesList(ArrayList<String> deckNamesList) {
        this.deckNamesList = deckNamesList;
    }
}

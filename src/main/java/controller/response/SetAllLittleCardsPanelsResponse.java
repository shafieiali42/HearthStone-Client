package controller.response;

import view.gui.panels.CollectionPages.LittleCardPanel;

import java.util.ArrayList;
import java.util.HashMap;

public class SetAllLittleCardsPanelsResponse extends Response {


    private HashMap<String,Integer> allCardsNameMana;

    public SetAllLittleCardsPanelsResponse(HashMap<String, Integer> allCardsNameMana) {
        this.allCardsNameMana = allCardsNameMana;
    }

    @Override
    public void execute() {
        for (String cardName : allCardsNameMana.keySet()) {
            LittleCardPanel.getAllLittleCardPanels().add(new LittleCardPanel(allCardsNameMana.get(cardName), cardName, 0));
        }
    }


    public HashMap<String, Integer> getAllCardsNameMana() {
        return allCardsNameMana;
    }

    public void setAllCardsNameMana(HashMap<String, Integer> allCardsNameMana) {
        this.allCardsNameMana = allCardsNameMana;
    }
}

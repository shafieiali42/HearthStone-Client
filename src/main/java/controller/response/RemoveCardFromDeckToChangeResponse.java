package controller.response;

import controller.CollectionController;
import utility.constant.Constant;
import view.gui.panels.CollectionPages.DeckPage;
import view.gui.panels.CollectionPages.DeckViewer;

import java.util.HashMap;

public class RemoveCardFromDeckToChangeResponse extends Response {


    private String userName;
    private HashMap<String, Integer> usesMap;


    public RemoveCardFromDeckToChangeResponse(String userName, HashMap<String, Integer> usesMap) {
        this.userName = userName;
        this.usesMap = usesMap;
    }

    @Override
    public void execute() {
        DeckViewer deckViewer = (DeckViewer) Constant.getPanels().get("DeckViewer");
        DeckPage deckPage = (DeckPage) Constant.getPanels().get("DeckPage");
        deckPage.setListOfLittleCardsPanelOfDeckToChange(deckViewer.setLittleCardsListFromHashMap(usesMap));
        CollectionController.setListOfCardOfDeckToChange(null);
        for (String cardName:usesMap.keySet()){
            if (usesMap.get(cardName)>0){
                CollectionController.getListOfCardOfDeckToChange().add(cardName);
            }
        }
        deckViewer.showCardsInDecK();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public HashMap<String, Integer> getUsesMap() {
        return usesMap;
    }

    public void setUsesMap(HashMap<String, Integer> usesMap) {
        this.usesMap = usesMap;
    }
}

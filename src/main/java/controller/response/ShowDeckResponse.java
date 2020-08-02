package controller.response;


import Main.ClientMain;
import utility.constant.Constant;
import view.gui.panels.CollectionPages.DeckPage;
import view.gui.panels.CollectionPages.DeckViewer;
import java.util.HashMap;

public class ShowDeckResponse extends Response {


    private HashMap<String, Integer> usesHashMap;


    public ShowDeckResponse(HashMap<String, Integer> usesHashMap) {
        this.usesHashMap = usesHashMap;
    }


    @Override
    public void execute() {
        DeckPage deckPage = (DeckPage) Constant.getPanels().get("DeckPage");
        DeckViewer deckViewer = (DeckViewer) Constant.getPanels().get("DeckViewer");
        deckPage.setListOfLittleCardsPanelOfDeckToChange(
                deckViewer.setLittleCardsListFromHashMap(usesHashMap));
        ClientMain.getMyMainFrame().setContentPane(Constant.getPanels().get("DeckPage"));
        deckViewer.removeAll();
        deckViewer.repaint();
        deckViewer.revalidate();
    }


    public HashMap<String, Integer> getUsesHashMap() {
        return usesHashMap;
    }

    public void setUsesHashMap(HashMap<String, Integer> usesHashMap) {
        this.usesHashMap = usesHashMap;
    }
}

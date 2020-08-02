package controller.response;

import Main.ClientMain;
import utility.constant.Constant;
import view.gui.panels.CollectionPages.DeckPage;
import view.gui.panels.CollectionPages.DeckPanel;
import view.gui.panels.CollectionPages.DeckViewer;
import view.gui.panels.CollectionPages.LittleCardPanel;

public class DoneCreatDeckResponse extends Response {


    private String state;


    public DoneCreatDeckResponse(String state) {
        this.state = state;
    }


    @Override
    public void execute() {
        DeckViewer deckViewer = (DeckViewer) Constant.getPanels().get("DeckViewer");
        deckViewer.removeAll();
        deckViewer.repaint();
        deckViewer.revalidate();
        DeckPage deckPage = (DeckPage) Constant.getPanels().get("DeckPage");
        if (state.equalsIgnoreCase("CHANGE_DECK")) {
            deckPage.setListOfLittleCardsPanelOfDeckToChange(LittleCardPanel.getAllLittleCardPanels());
            ClientMain.getMyMainFrame().setContentPane(Constant.getPanels().get("CollectionPage"));
            ((DeckPanel) Constant.getPanels().get("DeckPanel")).showDeckButtons();
        }else if (state.equalsIgnoreCase("MAKE_DECK")){
            deckPage.setListOfLittleCardsPanelOfDeckToChange(LittleCardPanel.getAllLittleCardPanels());
            ClientMain.getMyMainFrame().setContentPane(Constant.getPanels().get("CollectionPage"));
            ((DeckPanel) Constant.getPanels().get("DeckPanel")).showDeckButtons();
        }
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

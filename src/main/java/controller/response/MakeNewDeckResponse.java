package controller.response;

import Main.ClientMain;
import controller.controllers.Controller;
import utility.constant.Constant;
import view.gui.panels.CollectionPages.DeckPage;
import view.gui.panels.CollectionPages.LittleCardPanel;

public class MakeNewDeckResponse extends Response {


    private String deckName;
    private String heroName;


    public MakeNewDeckResponse(String deckName, String heroName) {
        this.deckName = deckName;
        this.heroName = heroName;
    }

    @Override
    public void execute() {

        ((DeckPage) Constant.getPanels().get("DeckPage")).setNameOfDeckToChange(deckName);

        ((DeckPage) Constant.getPanels().get("DeckPage")).
                setListOfLittleCardsPanelOfDeckToChange(LittleCardPanel.getAllLittleCardPanels());

        ClientMain.getMyMainFrame().setContentPane(Constant.getPanels().get("DeckPage"));
        Controller.getCurrentClient().sendGoToPageRequest(Controller.getCurrentPlayerUserName(), "DeckPage");
    }


    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }
}

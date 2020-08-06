package controller.response;

import utility.constant.Constant;
import view.gui.panels.GamePage.DiscoverCardsPage;

public class DiscoverPageResponse extends Response {


    private String cardName;


    public DiscoverPageResponse(String cardName) {
        this.cardName = cardName;
    }

    @Override
    public void execute() {
        DiscoverCardsPage discoverPage=(DiscoverCardsPage) Constant.getPanels().get("DiscoverCardsPage");
        discoverPage.setSelectedWeapon(this.cardName);
        discoverPage.setWaiting(false);
    }


    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }


}

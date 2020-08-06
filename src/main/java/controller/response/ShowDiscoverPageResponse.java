package controller.response;

import Main.ClientMain;
import utility.constant.Constant;
import view.gui.panels.GamePage.DiscoverCardsPage;

public class ShowDiscoverPageResponse extends Response {

    private String firstCard;
    private String secondCard;
    private String thirdCard;

    public ShowDiscoverPageResponse(String firstCard, String secondCard, String thirdCard) {
        this.firstCard = firstCard;
        this.secondCard = secondCard;
        this.thirdCard = thirdCard;
    }

    @Override
    public void execute() {
        DiscoverCardsPage discoverCardsPage = (DiscoverCardsPage) Constant.getPanels().get("DiscoverCardsPage");
        discoverCardsPage.setFirstCard(firstCard);
        discoverCardsPage.setSecondCard(secondCard);
        discoverCardsPage.setThirdCard(thirdCard);
        ClientMain.getMyMainFrame().setContentPane(discoverCardsPage);
    }


    public String getFirstCard() {
        return firstCard;
    }

    public void setFirstCard(String firstCard) {
        this.firstCard = firstCard;
    }

    public String getSecondCard() {
        return secondCard;
    }

    public void setSecondCard(String secondCard) {
        this.secondCard = secondCard;
    }

    public String getThirdCard() {
        return thirdCard;
    }

    public void setThirdCard(String thirdCard) {
        this.thirdCard = thirdCard;
    }
}

package controller.response;

import Main.ClientMain;
import controller.Client;
import utility.constant.Constant;
import view.gui.panels.GamePage.FirstThreeCardsPage;

import java.util.ArrayList;

public class GoToFirstThreeCardPageResponse extends Response {


    private ArrayList<String> firstThreeCardsName;

    public GoToFirstThreeCardPageResponse(ArrayList<String> firstThreeCardsName) {
        this.firstThreeCardsName = firstThreeCardsName;
    }

    @Override
    public void execute() {
        FirstThreeCardsPage firstThreeCardsPage=(FirstThreeCardsPage) Constant.getPanels().get("FirstThreeCardsPage");
        firstThreeCardsPage.setFirstThreeCardsName(firstThreeCardsName);
        firstThreeCardsPage.setFirstCard(firstThreeCardsName.get(0));
        firstThreeCardsPage.setSecondCard(firstThreeCardsName.get(1));
        firstThreeCardsPage.setThirdCard(firstThreeCardsName.get(2));
        ClientMain.getMyMainFrame().setContentPane(firstThreeCardsPage);
    }

    public ArrayList<String> getFirstThreeCardsName() {
        return firstThreeCardsName;
    }

    public void setFirstThreeCardsName(ArrayList<String> firstThreeCardsName) {
        this.firstThreeCardsName = firstThreeCardsName;
    }
}

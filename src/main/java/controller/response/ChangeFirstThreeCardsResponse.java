package controller.response;

import Main.ClientMain;
import controller.Client;
import utility.constant.Constant;
import view.gui.panels.GamePage.FirstThreeCardsPage;

import javax.swing.*;
import java.util.ArrayList;

public class ChangeFirstThreeCardsResponse extends Response {

    private int changedCardIndex;
    private ArrayList<String> firstThreeCardsName;

    public ChangeFirstThreeCardsResponse(int changedCardIndex, ArrayList<String> firstThreeCardsName) {
        this.changedCardIndex = changedCardIndex;
        this.firstThreeCardsName = firstThreeCardsName;
    }

    @Override
    public void execute() {
        FirstThreeCardsPage firstThreeCardsPage = (FirstThreeCardsPage) Constant.getPanels().get("FirstThreeCardsPage");
        firstThreeCardsPage.setFirstThreeCardsName(firstThreeCardsName);
        switch (changedCardIndex) {
            case 1:
                firstThreeCardsPage.setCanChangeFirstCard(false);
                firstThreeCardsPage.setFirstCard(firstThreeCardsName.get(0));
            case 2:
                firstThreeCardsPage.setCanChangeSecondCard(false);
                firstThreeCardsPage.setFirstCard(firstThreeCardsName.get(1));
            case 3:
                firstThreeCardsPage.setCanChangeThirdCard(false);
                firstThreeCardsPage.setFirstCard(firstThreeCardsName.get(2));
            case -1:
                JOptionPane.showMessageDialog(ClientMain.getMyMainFrame(), "You cant change this card",
                        "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
        firstThreeCardsPage.repaint();
        firstThreeCardsPage.revalidate();
    }


    public int getChangedCardIndex() {
        return changedCardIndex;
    }

    public void setChangedCardIndex(int changedCardIndex) {
        this.changedCardIndex = changedCardIndex;
    }

    public ArrayList<String> getFirstThreeCardsName() {
        return firstThreeCardsName;
    }

    public void setFirstThreeCardsName(ArrayList<String> firstThreeCardsName) {
        this.firstThreeCardsName = firstThreeCardsName;
    }
}

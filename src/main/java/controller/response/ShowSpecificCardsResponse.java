package controller.response;

import controller.Administer;
import utility.constant.Constant;
import utility.guiUtilities.MethodsOfShowCardsOnPanel;
import view.gui.panels.CollectionPages.CardPanel;
import view.gui.panels.ShopPanel.ShopCardPanel;

import java.util.ArrayList;

public class ShowSpecificCardsResponse extends Response {


    private ArrayList<String> names;
    private String group;
    private String panelName;


    public ShowSpecificCardsResponse(ArrayList<String> names,String group,String panelName) {
        this.names = names;
        this.group=group;
        this.panelName=panelName;
    }

    @Override
    public void execute() {
        switch (group) {
            case "Buyable":
            case "Salable":
                ShopCardPanel shopCardPanel=(ShopCardPanel) Constant.getPanels().get("ShopCardPanel");
                Administer.showGroupOfCards(names, shopCardPanel,shopCardPanel.getNumOfCardInEveryRow());
                break;
            case "LockCards":
            case "UnLockCards":
            case "AllCards":
            case "NeutralCards":
            case "PriestCards":
            case "HunterCards":
            case "WarlockCards":
            case "RogueCards":
            case "MageCards":
                CardPanel cardPanel=(CardPanel)Constant.getPanels().get(panelName);
                MethodsOfShowCardsOnPanel.showCards(names,cardPanel,CardPanel.getNumOfCardInEveryRow());
                break;
        }

    }


    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public ArrayList<String> getNames() {
        return names;
    }


    public void setNames(ArrayList<String> names) {
        this.names = names;
    }


    public String getPanelName() {
        return panelName;
    }

    public void setPanelName(String panelName) {
        this.panelName = panelName;
    }
}

package controller.response;

import controller.Administer;
import utility.constant.Constant;
import view.gui.panels.ShopPanel.ShopCardPanel;

import java.util.ArrayList;

public class ShowSpecificCardsResponse extends Response {


    private ArrayList<String> names;
    private String group;


    public ShowSpecificCardsResponse(ArrayList<String> names, String group) {
        this.names = names;
        this.group = group;
    }

    @Override
    public void execute() {
        switch (group) {
            case "Buyable":
            case "Salable":
                ShopCardPanel shopCardPanel=(ShopCardPanel) Constant.getPanels().get("ShopCardPanel");
                Administer.showGroupOfCards(names, shopCardPanel,shopCardPanel.getNumOfCardInEveryRow());
                break;
            case "":

                break;
            case "":

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
}

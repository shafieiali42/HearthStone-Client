package controller.response;

import controller.controllers.Administer;
import utility.constant.Constant;
import view.gui.panels.GamePage.PlayPanel;

import javax.swing.*;

public class ChangeBackOfCardsResponse extends Response {


    private String mode;

    public ChangeBackOfCardsResponse(String mode) {

        this.mode = mode;
    }

    @Override
    public void execute() {

        Administer.changeBackOfCards(Integer.parseInt(mode));
        PlayPanel playPanel=(PlayPanel) Constant.getPanels().get("PlayPanel");
        JOptionPane.showMessageDialog(null,
                "Type of Back of cards changed to " + playPanel.getTypeOfBackOfCards(), "Info", JOptionPane.INFORMATION_MESSAGE);

    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}

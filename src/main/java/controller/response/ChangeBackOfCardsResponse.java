package controller.response;

import controller.controllers.Administer;

import javax.swing.*;

public class ChangeBackOfCardsResponse extends Response {


    private String mode;

    public ChangeBackOfCardsResponse(String mode) {

        this.mode = mode;
    }

    @Override
    public void execute() {

        Administer.changeBackOfCards(Integer.parseInt(mode));
        JOptionPane.showMessageDialog(null,
                "Type of Back of cards changed to " + PlayPanel.getInstance().getTypeOfBackOfCards(), "Info", JOptionPane.INFORMATION_MESSAGE);

    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}

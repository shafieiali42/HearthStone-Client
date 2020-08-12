package controller.response;

import controller.controllers.Controller;
import controller.controllers.GamePartController;

import javax.swing.*;

public class ShowGameModesResponse extends Response {



    private String userName;
    private Object[] possibilities;

    public ShowGameModesResponse(String userName, Object[] possibilities) {
        this.userName = userName;
        this.possibilities = possibilities;
    }

    @Override
    public void execute() {
        Icon questionError = UIManager.getIcon("OptionPane.questionIcon");
        String gameMode = (String) JOptionPane.showInputDialog(
                null,
                "Select Your favorite Game Mode:",
                "Select GameMode",
                JOptionPane.PLAIN_MESSAGE,
                questionError,
                possibilities,
                "OnlineGame");

        GamePartController.setGameMode(gameMode);
        Controller.getCurrentClient().sendPlayGameRequest(gameMode);
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Object[] getPossibilities() {
        return possibilities;
    }

    public void setPossibilities(Object[] possibilities) {
        this.possibilities = possibilities;
    }
}

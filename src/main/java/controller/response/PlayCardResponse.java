package controller.response;

import Main.ClientMain;
import controller.controllers.Controller;
import controller.controllers.GamePartController;
import utility.constant.Constant;
import utility.guiUtilities.Sounds;
import view.gui.panels.GamePage.PlayPanel;

import javax.swing.*;

public class PlayCardResponse extends Response {


    private String message;
    private String playingCardName;


    public PlayCardResponse(String message, String playingCardName) {
        setResponseType("PlayCardResponse");
        this.message = message;
        this.playingCardName = playingCardName;
    }


    @Override
    public void execute() {
        PlayPanel playPanel = (PlayPanel) Constant.getPanels().get("PlayPanel");
        if (message.contains("mana")) {
            JOptionPane.showMessageDialog(ClientMain.getMyMainFrame(),
                    "You don't have enough mana", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (message.equalsIgnoreCase("NonSpell")) {
            playPanel.setPlayingCardName(playingCardName);
            playPanel.setNeedAnimation(true);
            Controller.getCurrentClient().sendShowPlayPanelRequest();
        } else {
            playPanel.repaint();
            playPanel.revalidate();
            Sounds.playActionSounds("src/main/resources/Sounds/ActionVoices/PlayCards.wav");
            Controller.getCurrentClient().sendShowPlayPanelRequest();
        }
        GamePartController.writeOnLogPanel("Play "+playingCardName);
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPlayingCardName() {
        return playingCardName;
    }

    public void setPlayingCardName(String playingCardName) {
        this.playingCardName = playingCardName;
    }
}

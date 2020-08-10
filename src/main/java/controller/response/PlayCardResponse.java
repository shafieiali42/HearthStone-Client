package controller.response;

import utility.constant.Constant;
import utility.guiUtilities.Sounds;
import view.gui.panels.GamePage.PlayPanel;

public class PlayCardResponse extends Response {


    private String message;

    public PlayCardResponse(String message) {
        this.message = message;
    }


    @Override
    public void execute() {
        PlayPanel playPanel = (PlayPanel) Constant.getPanels().get("PlayPanel");
        if (message.equalsIgnoreCase("NonSpell")) {
            playPanel.setNeedAnimation(true);
        } else {
            playPanel.repaint();
            playPanel.revalidate();
            Sounds.playActionSounds("src/main/resources/Sounds/ActionVoices/PlayCards.wav");
        }
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

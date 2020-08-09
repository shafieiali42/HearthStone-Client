package controller.response;

import utility.constant.Constant;
import view.gui.panels.GamePage.DeckAndEndTurnBtnPanel;

public class ShowChatResponse extends Response {


    private String text;

    public ShowChatResponse(String text) {
        this.text = text;
    }


    @Override
    public void execute() {
        DeckAndEndTurnBtnPanel deckAndEndTurnBtnPanel=(DeckAndEndTurnBtnPanel)
                Constant.getPanels().get("DeckAndEndTurnBtnPanel");
        deckAndEndTurnBtnPanel.setChatText(text);
        deckAndEndTurnBtnPanel.repaint();
        deckAndEndTurnBtnPanel.revalidate();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

package controller.response;

import controller.controllers.Controller;
import view.CardView.CardImagePanel;

public class MouseClickResponse extends Response {

    private boolean clicked;


    public MouseClickResponse(boolean clicked) {
        setResponseType("MouseClickResponse");
        this.clicked = clicked;
    }


    @Override
    public void execute() {
        CardImagePanel.setClicked(clicked);
        Controller.getCurrentClient().sendShowPlayPanelRequest();
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
}

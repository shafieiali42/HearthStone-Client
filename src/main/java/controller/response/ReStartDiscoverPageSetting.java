package controller.response;

import Main.ClientMain;
import controller.Client;
import controller.controllers.GamePartController;
import utility.constant.Constant;
import view.gui.panels.GamePage.GamePage;

public class ReStartDiscoverPageSetting extends Response {




    @Override
    public void execute() {
        GamePage gamePage=(GamePage) Constant.getPanels().get("GamePage");
        ClientMain.getMyMainFrame().setContentPane(gamePage);
        GamePartController.reStartDiscoverPageSetting();
    }
}

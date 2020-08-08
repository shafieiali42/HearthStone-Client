package controller.response;

import Main.ClientMain;
import utility.constant.Constant;
import view.gui.panels.GamePage.LogPanel;
import view.gui.panels.GamePage.PlayPanel;
import view.gui.panels.MenuPanel.MainMenuPage;

public class QuitGameResponse extends Response {



    @Override
    public void execute() {
        PlayPanel playPanel = (PlayPanel) Constant.getPanels().get("PlayPanel");
        LogPanel logPanel = (LogPanel) Constant.getPanels().get("LogPanel");
        playPanel.removeAll();
        playPanel.setNeedsToRepaint(true);
        playPanel.repaint();
        playPanel.revalidate();
        logPanel.removeAll();
        logPanel.setLog("");
        logPanel.repaint();
        logPanel.revalidate();
        ClientMain.getMyMainFrame().setContentPane(new MainMenuPage());
    }


}

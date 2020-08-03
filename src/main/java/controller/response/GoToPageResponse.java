package controller.response;

import Main.ClientMain;
import utility.constant.Constant;
import view.gui.panels.CollectionPages.CollectionPage;
import view.gui.panels.GamePage.FirstThreeCardsPage;
import view.gui.panels.GamePage.GamePage;
import view.gui.panels.GamePage.InfoPassivePage;
import view.gui.panels.MenuPanel.MainMenuPage;
import view.gui.panels.SettingPanel.SettingPage;
import view.gui.panels.ShopPanel.ShopPage;
import view.gui.panels.StatusPanel.ShowDeckInfoPanel;
import view.gui.panels.StatusPanel.StatusPage;

public class GoToPageResponse extends Response {


    private String pageName;

    public GoToPageResponse(String pageName) {
        this.pageName = pageName;
    }

    @Override
    public void execute() {
        switch (pageName) {
            case "StatusPage":
                ClientMain.getMyMainFrame().setContentPane(new StatusPage());
                break;
            case "SettingPage":
                ClientMain.getMyMainFrame().setContentPane(new SettingPage());
                break;
            case "ShopPage":
                ClientMain.getMyMainFrame().setContentPane(new ShopPage());
                break;
            case "CollectionPage":
                ClientMain.getMyMainFrame().setContentPane(Constant.getPanels().get("CollectionPage"));
                break;
            case "DeckPage":
                ClientMain.getMyMainFrame().setContentPane(Constant.getPanels().get("DeckPage"));
            case "MainMenuPage":
                ShowDeckInfoPanel showDeckInfoPanel = (ShowDeckInfoPanel) Constant.getPanels().get("ShowDeckInfoPanel");
                showDeckInfoPanel.setReadyToShow(false);
                showDeckInfoPanel.removeAll();
                showDeckInfoPanel.repaint();
                showDeckInfoPanel.revalidate();
                ClientMain.getMyMainFrame().setContentPane(new MainMenuPage());
                break;
            case "MainMenuPageNormal":
                ClientMain.getMyMainFrame().setContentPane(new MainMenuPage());
                break;
            case "GamePage":
                ClientMain.getMyMainFrame().setContentPane(GamePage.getInstance());
                break;
            case "FirstThreeCardsPage":
                ClientMain.getMyMainFrame().setContentPane(FirstThreeCardsPage.getInstance());
                break;
            case "InfoPassivePage":
                ClientMain.getMyMainFrame().setContentPane(InfoPassivePage.getInstance());
                break;


        }
    }


    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
}

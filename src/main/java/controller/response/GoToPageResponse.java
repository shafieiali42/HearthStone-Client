package controller.response;

import Main.ClientMain;
import view.gui.panels.CollectionPages.CollectionPage;
import view.gui.panels.SettingPanel.SettingPage;
import view.gui.panels.ShopPanel.ShopPage;
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
                ClientMain.getMyMainFrame().setContentPane(new CollectionPage());
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

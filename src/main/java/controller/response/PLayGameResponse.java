package controller.response;

import Main.ClientMain;
import utility.constant.Constant;
import view.gui.panels.GamePage.FirstThreeCardsPage;
import view.gui.panels.GamePage.InfoPassivePage;
import view.gui.panels.GamePage.PlayPanel;

import java.util.ArrayList;

public class PLayGameResponse extends Response {




    private boolean successful;
    private String userName;
    private String friendlyHeroName;
    private String enemyHeroName;
    private ArrayList<String> passiveNames;


    public PLayGameResponse(boolean successful,
                            String userName, String friendlyHeroName, String enemyHeroName,
                            ArrayList<String> passiveNames) {
        this.successful = successful;
        this.userName = userName;
        this.friendlyHeroName = friendlyHeroName;
        this.enemyHeroName = enemyHeroName;
        this.passiveNames=passiveNames;
    }





    @Override
    public void execute() {
        Constant.getPanels().put("InfoPassivePage",new InfoPassivePage());
        InfoPassivePage infoPassivePage=(InfoPassivePage) Constant.getPanels().get("InfoPassivePage");
        infoPassivePage.setNameOfPassives(passiveNames);
        infoPassivePage.repaint();
        infoPassivePage.revalidate();
        Constant.getPanels().put("FirstThreeCardsPage",new FirstThreeCardsPage());
        FirstThreeCardsPage firstThreeCardsPage=(FirstThreeCardsPage)Constant.getPanels().get("FirstThreeCardsPage");
        firstThreeCardsPage.reStartSetting();
        ClientMain.getMyMainFrame().setContentPane(infoPassivePage);
        PlayPanel playPanel=(PlayPanel)Constant.getPanels().get("PlayPanel");
        playPanel.setNameOfFriendlyHero(friendlyHeroName);
        playPanel.setNameOfEnemyHero(enemyHeroName);

    }



    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFriendlyHeroName() {
        return friendlyHeroName;
    }

    public void setFriendlyHeroName(String friendlyHeroName) {
        this.friendlyHeroName = friendlyHeroName;
    }

    public String getEnemyHeroName() {
        return enemyHeroName;
    }

    public void setEnemyHeroName(String enemyHeroName) {
        this.enemyHeroName = enemyHeroName;
    }

    public ArrayList<String> getPassiveNames() {
        return passiveNames;
    }

    public void setPassiveNames(ArrayList<String> passiveNames) {
        this.passiveNames = passiveNames;
    }





}

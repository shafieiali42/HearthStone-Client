package controller.response;

import utility.constant.Constant;
import view.gui.panels.StatusPanel.ShowDeckInfoPanel;

public class ShowDeckNumberResponse extends Response {


        private String deckName;
        private String heroName;
        private String wins;
        private String use;
        private String mostUsedCardName;
        private String manaAvg;
        private String winsPerPlay;


    public ShowDeckNumberResponse(String deckName, String heroName, String wins, String use,
                                  String mostUsedCardName, String manaAvg, String winsPerPlay) {

        this.deckName = deckName;
        this.heroName = heroName;
        this.wins = wins;
        this.use = use;
        this.mostUsedCardName = mostUsedCardName;
        this.manaAvg = manaAvg;
        this.winsPerPlay = winsPerPlay;
    }



    @Override
    public void execute() {
        ShowDeckInfoPanel showDeckInfoPanel=(ShowDeckInfoPanel)Constant.getPanels().get("ShowDeckInfoPanel");
        showDeckInfoPanel.setDeckNameField(deckName);
        showDeckInfoPanel.setHeroNameField(heroName);
        showDeckInfoPanel.setWinsField(wins);
        showDeckInfoPanel.setUseField(use);
        showDeckInfoPanel.setMostUsedCardField(mostUsedCardName);
        showDeckInfoPanel.setManaAvgFiled(manaAvg);
        showDeckInfoPanel.setWinsPerPlayField(winsPerPlay);
        showDeckInfoPanel.setReadyToShow(true);
        showDeckInfoPanel.repaint();
        showDeckInfoPanel.revalidate();
    }



    //getter and setters
    //********************

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getMostUsedCardName() {
        return mostUsedCardName;
    }

    public void setMostUsedCardName(String mostUsedCardName) {
        this.mostUsedCardName = mostUsedCardName;
    }

    public String getManaAvg() {
        return manaAvg;
    }

    public void setManaAvg(String manaAvg) {
        this.manaAvg = manaAvg;
    }

    public String getWinsPerPlay() {
        return winsPerPlay;
    }

    public void setWinsPerPlay(String winsPerPlay) {
        this.winsPerPlay = winsPerPlay;
    }


}

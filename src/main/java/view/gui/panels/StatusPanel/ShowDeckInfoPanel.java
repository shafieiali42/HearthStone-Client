package view.gui.panels.StatusPanel;


import utility.guiUtilities.LengthOfMessage;
import javax.swing.*;
import java.awt.*;

public class ShowDeckInfoPanel extends JPanel {

    private static final int WIDE_OF_SHOW_INFO_PANEL =700;
    private static final int HEIGHT_OF_SHOW_INFO_PANEL=800;


    private boolean readyToShow=false;
    private String nameOfDeckToShow;


    private String deckNameField;
    private String heroNameField;
    private String winsField;
    private String useField;
    private String mostUsedCardField;
    private String manaAvgFiled;
    private String winsPerPlayField;



    public String getNameOfDeckToShow() {
        return nameOfDeckToShow;
    }

    public void setNameOfDeckToShow(String nameOfDeckToShow) {
        this.nameOfDeckToShow = nameOfDeckToShow;
    }


    public boolean isReadyToShow() {
        return readyToShow;
    }

    public void setReadyToShow(boolean readyToShow) {
        this.readyToShow = readyToShow;
    }

    public ShowDeckInfoPanel(){
        setLayout(null);
        setSize(WIDE_OF_SHOW_INFO_PANEL,HEIGHT_OF_SHOW_INFO_PANEL);
        setBounds(0,0,WIDE_OF_SHOW_INFO_PANEL,HEIGHT_OF_SHOW_INFO_PANEL);
        setBackground(Color.orange);

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D=(Graphics2D)g;
        graphics2D.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        if(readyToShow){
            showDeckOfStatusState(this,graphics2D);
        }
    }






    public  void showDeckOfStatusState(JPanel panel, Graphics2D graphics2D) {
        String name = "Name: " +this.deckNameField;
        int lengthOfName = LengthOfMessage.lengthOfMessage(name, graphics2D);
        String heroName = "Hero: " +this.heroNameField ;
        int lengthOfHeroName = LengthOfMessage.lengthOfMessage(heroName, graphics2D);
        String wins = "Wins:" + this.winsField;
        int lengthOfWins = LengthOfMessage.lengthOfMessage(wins, graphics2D);
        String use = "Uses: " + this.useField;
        int lengthOfUse = LengthOfMessage.lengthOfMessage(use, graphics2D);
        String mostUsedCard = "Most Used Card: " +this.mostUsedCardField ;
        int lengthOfCard = LengthOfMessage.lengthOfMessage(mostUsedCard, graphics2D);
        String manaAvg = "Average of Mana: " + this.mostUsedCardField;
        int lengthOfMana = LengthOfMessage.lengthOfMessage(manaAvg, graphics2D);
        String winsPerPlay = "Wins per Play: " +this.winsPerPlayField;
        int lengthOfWinsPerPlay = LengthOfMessage.lengthOfMessage(winsPerPlay, graphics2D);
        graphics2D.drawString(name, (panel.getWidth() - lengthOfName) / 2, 50);
        graphics2D.drawString(heroName, (panel.getWidth() - lengthOfHeroName) / 2, 100);
        graphics2D.drawString(wins, (panel.getWidth() - lengthOfWins) / 2, 150);
        graphics2D.drawString(use, (panel.getWidth() - lengthOfUse) / 2, 200);
        graphics2D.drawString(mostUsedCard, (panel.getWidth() - lengthOfCard) / 2, 250);
        graphics2D.drawString(manaAvg, (panel.getWidth() - lengthOfMana) / 2, 300);
        graphics2D.drawString(winsPerPlay, (panel.getWidth() - lengthOfWinsPerPlay) / 2, 350);
    }








    public String getDeckNameField() {
        return deckNameField;
    }

    public void setDeckNameField(String deckNameField) {
        this.deckNameField = deckNameField;
    }

    public String getHeroNameField() {
        return heroNameField;
    }

    public void setHeroNameField(String heroNameField) {
        this.heroNameField = heroNameField;
    }

    public String getWinsField() {
        return winsField;
    }

    public void setWinsField(String winsField) {
        this.winsField = winsField;
    }

    public String getUseField() {
        return useField;
    }

    public void setUseField(String useField) {
        this.useField = useField;
    }

    public String getMostUsedCardField() {
        return mostUsedCardField;
    }

    public void setMostUsedCardField(String mostUsedCardField) {
        this.mostUsedCardField = mostUsedCardField;
    }

    public String getManaAvgFiled() {
        return manaAvgFiled;
    }

    public void setManaAvgFiled(String manaAvgFiled) {
        this.manaAvgFiled = manaAvgFiled;
    }

    public String getWinsPerPlayField() {
        return winsPerPlayField;
    }

    public void setWinsPerPlayField(String winsPerPlayField) {
        this.winsPerPlayField = winsPerPlayField;
    }
}


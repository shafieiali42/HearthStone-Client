package view.gui.panels.StatusPanel;


import Controller.Administer;

import javax.swing.*;
import java.awt.*;

public class ShowDeckInfoPanel extends JPanel {

    private static final int WIDE_OF_SHOW_INFO_PANEL =700;
    private static final int HEIGHT_OF_SHOW_INFO_PANEL=800;


    private boolean readyToShow=false;
    private String nameOfDeckToShow;

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
//            deckToShow.defineMostUsedCard();
            Administer.defineMostUsedCardInDeck(nameOfDeckToShow);
            Administer.showDeckOfStatusState(this,graphics2D);
        }
    }

}


package view.gui.panels.CollectionPages;


import utility.constant.Constant;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class DeckPage extends JPanel {




    private ArrayList<LittleCardPanel> listOfLittleCardsPanelOfDeckToChange = new ArrayList<LittleCardPanel>();

    public ArrayList<LittleCardPanel> getListOfLittleCardsPanelOfDeckToChange() {
        return listOfLittleCardsPanelOfDeckToChange;
    }

    public void setListOfLittleCardsPanelOfDeckToChange(ArrayList<LittleCardPanel> listOfLittleCardsPanelOfDeckToChange) {
        this.listOfLittleCardsPanelOfDeckToChange = listOfLittleCardsPanelOfDeckToChange;
    }

    private String nameOfDeckToChange;

    public String getNameOfDeckToChange() {
        return nameOfDeckToChange;
    }

    public void setNameOfDeckToChange(String nameOfDeckToChange) {
        this.nameOfDeckToChange = nameOfDeckToChange;
    }


    public DeckPage() {

        nameOfDeckToChange = "";

        setSize(Constant.widthOfMainFrame, Constant.heightOfMainFrame);
        setLayout(null);
        this.addPanel(Constant.getPanels().get("CategoryPanelOfChangeDeck"), 0, 0, Constant.WIDTH_OF_CATEGORY_PANEL_DECK_PAGE,
                Constant.HEIGHT_OF_CATEGORY_PANEL_DECK_PAGE);

        this.addPanel(Constant.getPanels().get("DeckViewer"), Constant.WIDTH_OF_CATEGORY_PANEL_DECK_PAGE, 0,
                Constant.getPanels().get("DeckViewer").getWidth(), Constant.getPanels().get("DeckViewer").getHeight());

        CardPanel cardPanelOfDeckPage = (CardPanel)Constant.getPanels().get("cardPanelOfDeckPage");
        cardPanelOfDeckPage.setPreferredSize(new Dimension(1155, 1600));
        cardPanelOfDeckPage.setFocusable(true);
        cardPanelOfDeckPage.requestFocus();

        cardPanelOfDeckPage.getJScrollPane().setBounds(0, Constant.HEIGHT_OF_CATEGORY_PANEL, 1155, 620);
        cardPanelOfDeckPage.getJScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        cardPanelOfDeckPage.getJScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        cardPanelOfDeckPage.getJScrollPane().setBorder(null);
        cardPanelOfDeckPage.getJScrollPane().setFocusable(false);
        this.add(cardPanelOfDeckPage.getJScrollPane());


        this.addPanel(Constant.getPanels().get("manaPanelForDeckPage"), 0,
                (Constant.HEIGHT_OF_CATEGORY_PANEL + 620),
                Constant.WIDTH_OF_MANA_PANEL, Constant.HEIGHT_OF_MANA_PANEL);


    }

    public void addPanel(JPanel panel, int x, int y, int width, int height) {
        panel.setBounds(x, y, width, height);
        add(panel);
    }

    public void addPanel(JScrollPane jScrollPane, int x, int y, int width, int height) {
        jScrollPane.setBounds(x, y, width, height);
        add(jScrollPane);
    }

}

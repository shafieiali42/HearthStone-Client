package view.gui.panels.CollectionPages;


import utility.constant.Constant;

import javax.swing.*;
import java.awt.*;



public class CollectionPage extends JPanel {


    public CollectionPage() {
        setSize(Constant.widthOfMainFrame, Constant.heightOfMainFrame);
        setLayout(null);
        this.addPanel(Constant.getPanels().get("CategoryPanel"), 0, 0, Constant.WIDTH_OF_CATEGORY_PANEL, Constant.HEIGHT_OF_CATEGORY_PANEL);


        DeckPanel deckPanel=(DeckPanel)Constant.getPanels().get("DeckPanel");
        deckPanel.setPreferredSize(new Dimension(250, 1600));
        deckPanel.setFocusable(true);
        deckPanel.requestFocus();
        deckPanel.setJScrollPane(new JScrollPane(deckPanel));
        deckPanel.getJScrollPane().setBounds(Constant.WIDTH_OF_CATEGORY_PANEL,
                0, 250, 800);
        deckPanel.getJScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        deckPanel.getJScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        deckPanel.getJScrollPane().setBorder(null);
        deckPanel.getJScrollPane().setFocusable(false);
        this.add(deckPanel.getJScrollPane());


        CardPanel cardPanelOfCollectionPage = (CardPanel)Constant.getPanels().get("cardPanelOfCollectionPage");
        cardPanelOfCollectionPage.setPreferredSize(new Dimension(1155, 1600));
        cardPanelOfCollectionPage.setFocusable(true);
        cardPanelOfCollectionPage.requestFocus();

        cardPanelOfCollectionPage.getJScrollPane().setBounds(0, Constant.HEIGHT_OF_CATEGORY_PANEL_DECK_PAGE,
                1155, 620);
        cardPanelOfCollectionPage.getJScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        cardPanelOfCollectionPage.getJScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        cardPanelOfCollectionPage.getJScrollPane().setBorder(null);
        cardPanelOfCollectionPage.getJScrollPane().setFocusable(false);
        this.add(cardPanelOfCollectionPage.getJScrollPane());

        this.addPanel(Constant.getPanels().get("manaPanelForCollectionPage"), 0,
                (Constant.HEIGHT_OF_CATEGORY_PANEL_DECK_PAGE + 620/*CardPanel.getInstance().getJScrollPane().getHeight()*/),
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

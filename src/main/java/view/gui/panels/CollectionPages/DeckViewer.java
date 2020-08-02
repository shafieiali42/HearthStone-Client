package view.gui.panels.CollectionPages;


import controller.CollectionController;
import controller.Controller;
import utility.constant.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;


public class DeckViewer extends JPanel {


    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);
    public static final int WIDTH_OF_BTN = 90;
    public static final int HEIGHT_OF_BTN = 90;

    private JButton doneBtn;


    public DeckViewer() {
        setLayout(null);
        setBackground(Color.gray);
        setSize(Constant.WIDTH_OF_DECK_VIEWER, Constant.HEIGHT_OF_DECK_VIEWER);
        initDoneBtn();
    }


    public void designBtn(JButton btn) {
        btn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        btn.setForeground(colorOfTextOfBtn);
        btn.setBackground(colorOfBtn);
    }

    private void initDoneBtn() {
        doneBtn = new JButton("Done");
        designBtn(doneBtn);
        doneBtn.setBounds((Constant.WIDTH_OF_DECK_VIEWER - doneBtn.getWidth()) / 2,
                30 * Constant.HEIGHT_OF_LITTLE_CARD + 100, doneBtn.getWidth(), doneBtn.getHeight());
        doneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                done();
            }
        });
        add(doneBtn);
    }

    private void done() {
        Controller.getCurrentClient().sendDoneCreatDeckRequest();
    }

    public void showCardsInDecK() {
        DeckViewer deckViewer = (DeckViewer) Constant.getPanels().get("DeckViewer");
        deckViewer.removeAll();
        deckViewer.repaint();
        deckViewer.revalidate();
        int yCoordinate = 0;
        for (LittleCardPanel littleCardPanel : this.getLittleCardPanelOfDeckToChangeFromDeckPage()) {
            for (String cardName : CollectionController.getListOfCardOfDeckToChange()) {
                if (littleCardPanel.getNameLabel().getText().equalsIgnoreCase(cardName)) {

                    CollectionController.showLittleCardPanelOnDeckViewer(littleCardPanel, this,
                            (Constant.WIDTH_OF_DECK_VIEWER - littleCardPanel.getWidth()) / 2, yCoordinate);

                    yCoordinate += littleCardPanel.getHeight() + 5;
                    break;
                }
            }
        }
        add(doneBtn);
    }


    public ArrayList<LittleCardPanel> setLittleCardsListFromHashMap(HashMap<String, Integer> hashMap) {
        ArrayList<LittleCardPanel> littleCardPanelsOfThisHashMap = LittleCardPanel.getAllLittleCardPanels();
        for (String cardName : hashMap.keySet()) {
            int useOfCard = hashMap.get(cardName);
            for (LittleCardPanel littleCardPanel : littleCardPanelsOfThisHashMap) {
                if (littleCardPanel.getNameLabel().getText().equalsIgnoreCase(cardName)) {
                    littleCardPanel.getUsedLabel().setText(useOfCard + "");
                }
            }
        }
        return littleCardPanelsOfThisHashMap;
    }

    public ArrayList<LittleCardPanel> getLittleCardPanelOfDeckToChangeFromDeckPage() {
//        return CollectionState.getInstance().getDeckToChange().getLittleCardPanelsOfThisDeck();
        DeckPage deckPage=(DeckPage)Constant.getPanels().get("DeckPage");
        return deckPage.getListOfLittleCardsPanelOfDeckToChange();
    }

}

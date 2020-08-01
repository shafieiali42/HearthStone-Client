package view.gui.panels.CollectionPages;


import Main.ClientMain;
import utility.constant.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
                30* Constant.HEIGHT_OF_LITTLE_CARD + 100, doneBtn.getWidth(), doneBtn.getHeight());
        doneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                done();
            }
        });
        add(doneBtn);
    }

    private void done() {
        if (CollectionController.getListOfCardsOfCollectionStatesDeck().size() < 15) {

            JOptionPane.showMessageDialog(null,
                    "You must select at least 15 cards.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            DeckViewer deckViewer =(DeckViewer)Constant.getPanels().get("DeckViewer");
            deckViewer.removeAll();
            deckViewer.repaint();
            deckViewer.revalidate();
            DeckPage deckPage =(DeckPage)Constant.getPanels().get("DeckPage");
            if (ControllerOfMainComponents.getStatus().equals(Status.CHANGE_DECK)) {
                ControllerOfMainComponents.currentPlayer.getLoggerOfMyPlayer().info("Changed deck " +
                       deckPage.getNameOfDeckToChange());
                CollectionController.defineUsesHashMap();
                CollectionController.makeCollectionStatesDeckToNull();
                deckPage.setListOfLittleCardsPanelOfDeckToChange(LittleCardPanel.getAllLittleCardPanels());

                ControllerOfMainComponents.setStatus(Status.COLLECTIONS_PAGE);
                ClientMain.getMyMainFrame().setContentPane(Constant.getPanels().get("CollectionPage"));
                ((DeckPanel)Constant.getPanels().get("DeckPanel")).showDeckButtons();
            } else if (ControllerOfMainComponents.getStatus().equals(Status.MAKE_DECK)) {
                CollectionController.defineUsesHashMap();
                CollectionController.addCollectionStatesDeckToPlayersDecksList();
                CollectionController.makeCollectionStatesDeckToNull();
               deckPage.setListOfLittleCardsPanelOfDeckToChange(LittleCardPanel.getAllLittleCardPanels());

                ControllerOfMainComponents.setStatus(Status.COLLECTIONS_PAGE);
               ClientMain.getMyMainFrame().setContentPane(Constant.getPanels().get("CollectionPage"));
                ((DeckPanel)Constant.getPanels().get("DeckPanel")).showDeckButtons();
                Administer.writeLog("Make new Deck");
            }
        }
    }

    public void showCardsInDecK() {
        DeckViewer deckViewer=(DeckViewer)Constant.getPanels().get("DeckViewer");
        deckViewer.removeAll();
        deckViewer.repaint();
        deckViewer.revalidate();
        int yCoordinate = 0;
        for ( LittleCardPanel littleCardPanel : CollectionController.getLittleCardPanelOfDeckToChangeFromDeckPage()) {
            for (Cards card : CollectionController.getListOfCardsOfCollectionStatesDeck()) {
                if (littleCardPanel.getNameLabel().getText().equalsIgnoreCase(card.getName())) {

                    CollectionController.showLittleCardPanelOnDeckViewer(littleCardPanel, this,
                            (Constant.WIDTH_OF_DECK_VIEWER - littleCardPanel.getWidth()) / 2, yCoordinate);

                    yCoordinate += littleCardPanel.getHeight() + 5;
                    break;
                }
            }
        }
        add(doneBtn);
    }


}

package view.gui.panels.CollectionPages;


import Main.ClientMain;
import controller.Controller;
import utility.constant.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeckPanel extends JPanel {


    private static final int WIDTH_OF_BTN = 180;
    private static final int HEIGHT_OF_BTN = 40;
    private Color colorOfTextOfNewDeckBtn = new Color(255, 0, 0);
    private Color colorOfNewDeckBtn = new Color(48, 48, 45);
    private Color colorOfDeckBtn = new Color(48, 48, 45);
//    private static DeckPanel deckPanel = new DeckPanel();
//
//    public static DeckPanel getInstance() {
//        return deckPanel;
//    }


    private JButton newDeckBtn;
    private JScrollPane jScrollPane;

    public JScrollPane getJScrollPane() {
        return jScrollPane;
    }

    public void setJScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
    }

    public DeckPanel() {
        setBackground(Color.blue);
        setLayout(new FlowLayout(1, 20, 20));
        setJScrollPane(new JScrollPane(this));
        setBounds(0, 0, Constant.WIDTH_OF_DECK_PANEL, Constant.HEIGHT_OF_DECK_PANEL);
        initNewDeckBtn();
    }

    public void designDeckBtn(JButton btn) {
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
//        btn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        btn.setPreferredSize(new Dimension(WIDTH_OF_BTN, HEIGHT_OF_BTN));
        btn.setMaximumSize(new Dimension(WIDTH_OF_BTN, HEIGHT_OF_BTN));
        btn.setMinimumSize(new Dimension(WIDTH_OF_BTN, HEIGHT_OF_BTN));
        btn.setForeground(colorOfTextOfNewDeckBtn);
        btn.setBackground(colorOfNewDeckBtn);
    }

    public void initButtonForDeck(String deckName) {
        JButton button = new JButton(deckName);
        designDeckBtn(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerOfMainComponents.setStatus(Status.CHANGE_DECK);
                LittleCardPanel.setAllLittleCardPanels();
                CollectionController.setCollectionDeck(deckName);
                showDeck();
            }
        });
        this.add(button);
    }

    private void initNewDeckBtn() {
        newDeckBtn = new JButton("New Deck");
        newDeckBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        newDeckBtn.setForeground(colorOfTextOfNewDeckBtn);
        newDeckBtn.setBackground(colorOfNewDeckBtn);
        newDeckBtn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        newDeckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                ControllerOfMainComponents.setStatus(Status.MAKE_DECK);
                makeNewDeck();
            }
        });
        this.add(newDeckBtn);
    }

    private void makeNewDeck() {
        DeckViewer deckViewer = (DeckViewer) Constant.getPanels().get("DeckViewer");
        deckViewer.removeAll();
        deckViewer.repaint();
        deckViewer.revalidate();
        LittleCardPanel.setAllLittleCardPanels();
//        CollectionController.makeCollectionStatesDeckToNull();
        ((DeckPage) Constant.getPanels().get("DeckPage")).setNameOfDeckToChange("");
        String name = JOptionPane.showInputDialog("Enter your favorite name!");
        Object[] possibilities = {"Mage", "Rogue", "Warlock", "Hunter", "Priest"};
        Icon questionError = UIManager.getIcon("OptionPane.questionIcon");
        String heroName = (String) JOptionPane.showInputDialog(
                null,
                "Select Your favorite Hero:",
                "Select Hero",
                JOptionPane.PLAIN_MESSAGE,
                questionError,
                possibilities,
                "Mage");
        Controller.getCurrentClient().sendMakeNewDeckRequest(name, heroName);
//        CollectionController.makeNewDeck(name, heroName);
//        ((DeckPage) Constant.getPanels().get("DeckPage")).setNameOfDeckToChange(name);
//        Controller.getCurrentClient().sendGoToPage(Controller.getCurrentPlayerUserName(), "DeckPage");
//        ClientMain.getMyMainFrame().setContentPane(DeckPage.getInstance());
    }

    public void showDeckButtons() {
        DeckPanel deckPanel = (DeckPanel) Constant.getPanels().get("DeckPanel");
        deckPanel.removeAll();
        deckPanel.repaint();
        deckPanel.revalidate();
        this.add(newDeckBtn);
        if (CollectionController.getListOfPlayersDeckNames().size() != 0) {
            for (String deckName : CollectionController.getListOfPlayersDeckNames()) {
                initButtonForDeck(deckName);
            }
        }
    }


    private void showDeck() {
        ClientMain.getMyMainFrame().setContentPane(Constant.getPanels().get("DeckPage"));
        DeckViewer deckViewer = (DeckViewer) Constant.getPanels().get("DeckViewer");
        deckViewer.removeAll();
        deckViewer.repaint();
        deckViewer.revalidate();


    }


}






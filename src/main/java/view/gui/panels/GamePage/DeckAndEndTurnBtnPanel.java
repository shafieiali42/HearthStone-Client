package view.gui.panels.GamePage;

import controller.controllers.Controller;
import controller.controllers.GamePartController;
import utility.constant.Constant;
import utility.guiUtilities.DrawRotate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DeckAndEndTurnBtnPanel extends JPanel {


    private static final int WIDTH_OF_BTN = 150;
    private static final int HEIGHT_OF_BTN = 80;
    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);
    private JTextField chatField;
    private JButton sendBtn;
    private JButton endTurnBtn;
    private JButton quitGameBtn;
    private String chatText;
    private static DeckAndEndTurnBtnPanel deckAndEndTurnBtnPanel = new DeckAndEndTurnBtnPanel();

    public static DeckAndEndTurnBtnPanel getInstance() {
        return deckAndEndTurnBtnPanel;
    }


    private DeckAndEndTurnBtnPanel() {
        setBackground(Color.gray);
        setLayout(null);
        setSize(Constant.WIDTH_OF_END_TURN_PANEL, Constant.HEIGHT_OF_END_TURN_PANEL);
        initEndTurnBtn();
        initFirstDeck();
        initSecondDeck();
        initQuitGameBtn();
        initSearchTools();
    }

    private void initQuitGameBtn() {
        quitGameBtn = new JButton("Quit");
        quitGameBtn.setSize(Constant.WIDTH_OF_QIT_BTN, Constant.HEIGHT_OF_QUIT_BTN);
        quitGameBtn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        quitGameBtn.setBounds((Constant.WIDTH_OF_END_TURN_PANEL - Constant.WIDTH_OF_QIT_BTN) / 2,
                720, Constant.WIDTH_OF_QIT_BTN, Constant.HEIGHT_OF_QUIT_BTN);
        quitGameBtn.setForeground(colorOfTextOfBtn);
        quitGameBtn.setBackground(colorOfBtn);
        quitGameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog((Component) null, "Are you sure to leave game?\n" + "This will make you lose",
                        "Warning", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {

                    Controller.getCurrentClient().sendQuitGameRequest();
//                        GamePartController.initializeGameState();
//                        PlayPanel.getInstance().removeAll();
//                        PlayPanel.getInstance().setNeedsToRepaint(true);
//                        PlayPanel.getInstance().repaint();
//                        PlayPanel.getInstance().revalidate();
//                        LogPanel.getInstance().removeAll();
//                        LogPanel.getInstance().setLog("");
//                        LogPanel.getInstance().repaint();
//                        LogPanel.getInstance().revalidate();
////                    Administer.playMainSound("src/main/resources/Sounds/FirstAudio.wav");
//                        MyMainFrame.getInstance().setContentPane(MainMenuPage.getInstance());


                }
            }
        });
        add(quitGameBtn);
    }


    private void initSecondDeck() {
        DeckViewerInPlay.getInstanceOfSecondDeck().setBounds(60, 100, DeckViewerInPlay.getWidthOfDeck(), DeckViewerInPlay.getHeightOfDeck());

        DeckViewerInPlay.getInstanceOfSecondDeck().setToolTipText("There are 0 cards in this Models.Deck");//TODO needs to change in next phase:))
        add(DeckViewerInPlay.getInstanceOfSecondDeck());
    }

    private void initFirstDeck() {
        DeckViewerInPlay.getInstanceOfFirstDeck().setBounds(60, 550, DeckViewerInPlay.getWidthOfDeck(), DeckViewerInPlay.getHeightOfDeck());

        DeckViewerInPlay.getInstanceOfFirstDeck().setToolTipText("You have " +
                GamePartController.getNumberOfCardsInDeck() + "cards in your deck");
        add(DeckViewerInPlay.getInstanceOfFirstDeck());
    }

    private void initEndTurnBtn() {
        endTurnBtn = new JButton("End Turn");
        endTurnBtn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        endTurnBtn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        endTurnBtn.setBounds((Constant.WIDTH_OF_END_TURN_PANEL - WIDTH_OF_BTN) / 2,
                (Constant.HEIGHT_OF_END_TURN_PANEL - HEIGHT_OF_BTN) / 2 - 20
                , WIDTH_OF_BTN, HEIGHT_OF_BTN);//todo init yCoordinate:))
        endTurnBtn.setForeground(colorOfTextOfBtn);
        endTurnBtn.setBackground(colorOfBtn);
        endTurnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendEndTurnRequest();
//                Mapper.getInstance().addRequest(Mapper.RequestTypes.END_TURN);
//                Mapper.getInstance().executeRequests();
//                DeckViewerInPlay.getInstanceOfFirstDeck().setToolTipText("You have " +
//                        GamePartController.getNumberOfFriendlyCardsOfDeckInGameState() + "cards in your deck");

            }
        });
        add(endTurnBtn);
    }



    private void initSearchTools() {
        chatField = new JTextField(20);
        chatField.setBounds(5,290,190,20);
        sendBtn = new JButton("Send");
        sendBtn.setSize(40, 20);
        sendBtn.setBounds(20,310,150,30);
        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendTextRequest(chatField.getText());
                //                    Administer.writeLog("Search for card: " + searchField.getText());
//                    CLI.currentPlayer.getLoggerOfMyPlayer().info("Search for card: "+searchField.getText());
//                searchInCards(searchField.getText());
            }
        });
        add(chatField);
        add(sendBtn);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        g.drawString(GamePartController.getMana() + "/" + "10", 60, 700);
        g.setFont(new Font("TimesRoman", Font.ITALIC, 15));
//        g.drawString(Administer.getEnemyImprovementOfQuest(), 50, 295);
        g.drawString(GamePartController.getFriendlyImprovementOfQuest(), 50, 495);
        g.drawString(chatText,5,250);
        DeckViewerInPlay.getInstanceOfFirstDeck().setToolTipText("You have " +
                GamePartController.getNumberOfCardsInDeck() + "cards in your deck");



//        DeckViewerInPlay.getInstanceOfSecondDeck().setToolTipText("You have " +
//                GamePartController.getNumberOfEnemyCardsOfDeckInGameState() + "cards in your deck");

    }


    public String getChatText() {
        return chatText;
    }

    public void setChatText(String chatText) {
        this.chatText = chatText;
    }
}


class DeckViewerInPlay extends JPanel {

    public static int getWidthOfDeck() {
        return WIDTH_OF_DECK;
    }

    public static int getHeightOfDeck() {
        return HEIGHT_OF_DECK;
    }

    private static final int WIDTH_OF_DECK = 80;
    private static final int HEIGHT_OF_DECK = 120;
    private int witchPanel;
    private static DeckViewerInPlay firstDeck = new DeckViewerInPlay(1);

    public static DeckViewerInPlay getInstanceOfFirstDeck() {
        return firstDeck;
    }

    private static DeckViewerInPlay secondDeck = new DeckViewerInPlay(2);

    public static DeckViewerInPlay getInstanceOfSecondDeck() {
        return secondDeck;
    }

    private DeckViewerInPlay(int witchPanel) {
        setLayout(null);
        setBackground(Color.orange);
        setSize(WIDTH_OF_DECK, HEIGHT_OF_DECK);
        this.witchPanel = witchPanel;
    }




    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        if (witchPanel == 1) {
            DrawRotate.drawRotate(graphics2D, WIDTH_OF_DECK / 2 - 10, 10, 90, "Friendly");
        } else if (witchPanel == 2) {
            DrawRotate.drawRotate(graphics2D, WIDTH_OF_DECK / 2 - 10, 20, 90, "Enemy");
        }
    }


}









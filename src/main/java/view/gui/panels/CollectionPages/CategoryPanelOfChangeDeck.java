package view.gui.panels.CollectionPages;


import controller.controllers.Controller;
import utility.constant.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryPanelOfChangeDeck extends JPanel {


    public static final int NUMBER_OF_BTN = 9;
    public static final int WIDTH_OF_BTN = 90;
    public static final int HEIGHT_OF_BTN = 90;

    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);


    private JButton HeroCardsBtn;
    private JButton neutralBtn;
    private JButton changeNameBtn;
    private JButton changeHeroBtn;
    private JButton removeDeckBtn;
    private JButton selectDeckBtn;


    public CategoryPanelOfChangeDeck() {
        setBackground(Color.cyan);
        setLayout(new FlowLayout(NUMBER_OF_BTN, 20, 20));
        initButtons();
    }

    private void initButtons() {
        initHeroCardsBtn();
        initNeutralBtn();
        initChangeNameBtn();
        initChangeHeroBtn();
        initSelectDeckBtn();
        initRemoveDeckBtn();
    }


    private void initSelectDeckBtn() {
        selectDeckBtn = new JButton("Select Deck");
        designBtn(selectDeckBtn);
        selectDeckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectDeck();
            }
        });
        add(selectDeckBtn);
    }

    private void selectDeck() {
//        CLI.currentPlayer.setCurrentDeck(DeckPage.getInstance().getDeckTOChange());
        System.out.println("select deck");
        Controller.getCurrentClient().sendSelectMainDeckRequest("SelectMainDeck");//todo
//        CollectionController.selectMainDeck();
        JOptionPane.showMessageDialog(null, "Your Deck is:" +
                ((DeckPage) Constant.getPanels().get("DeckPage")).getNameOfDeckToChange());
//        CLI.currentPlayer.getLoggerOfMyPlayer().info("select " + DeckPage.getInstance().getDeckTOChange().getName() + " for main deck");
    }

    private void initChangeNameBtn() {
        changeNameBtn = new JButton("Change Name");
        designBtn(changeNameBtn);
        changeNameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeName();
            }
        });
        add(changeNameBtn);
    }

    private void changeName() {
        String name = JOptionPane.showInputDialog("Enter your favorite name!");
        Controller.getCurrentClient().sendChangeNameOfDeckRequest("ChangeName",name); //todo
//        CollectionController.changeNameOfDeck(name);
//        DeckPage.getInstance().getDeckTOChange().setName(JOptionPane.showInputDialog("Enter your favorite name!"));
//        CLI.currentPlayer.getLoggerOfMyPlayer().info("Change name of deck ");
    }


    public void designBtn(JButton btn) {
        btn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        btn.setForeground(colorOfTextOfBtn);
        btn.setBackground(colorOfBtn);
    }

    private void initChangeHeroBtn() {
        changeHeroBtn = new JButton("Change Hero");
        designBtn(changeHeroBtn);
        changeHeroBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeHero();
            }
        });
        add(changeHeroBtn);
    }

    private void changeHero() {
        Object[] possibilities = {"Mage", "Rogue", "Warlock", "Hunter", "Priest"};
        Icon questionError = UIManager.getIcon("OptionPane.questionIcon");
        String s = (String) JOptionPane.showInputDialog(
                null,
                "Select Your favorite Hero:",
                "Select Hero",
                JOptionPane.PLAIN_MESSAGE,
                questionError,
                possibilities,
                "Mage");

        Controller.getCurrentClient().sendChangeHeroOfDeckRequest("ChangeHero",s);//todo
//        CollectionController.changeHeroOfDeck(s);

    }

    private void initRemoveDeckBtn() {
        removeDeckBtn = new JButton("Remove Deck");
        designBtn(removeDeckBtn);
        removeDeckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Controller.getCurrentClient().sendRemoveDeckRequest("RemoveDeck"); //todo
                removeDeck();
            }
        });
        add(removeDeckBtn);
    }

    private void removeDeck() {
//        CLI.currentPlayer.getAllDecksOfPlayer().remove(DeckPage.getInstance().getDeckTOChange());
//        CollectionController.removeDeck();
//        ((DeckPanel) Constant.getPanels().get("DeckPanel")).showDeckButtons();
//        CollectionPage.getInstance().repaint();
//        CollectionPage.getInstance().revalidate();
//        ClientMain.getMyMainFrame().setContentPane(Constant.getPanels().get("CollectionPage"));
//        CLI.currentPlayer.getLoggerOfMyPlayer().info("Removed "+DeckPage.getInstance().getDeckTOChange().getName());
    }

    private void initNeutralBtn() {
        neutralBtn = new JButton("Neutral");
        designBtn(neutralBtn);
        neutralBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendShowSpecificCardsRequest("NeutralCards", "cardPanelOfDeckPage");
//                    CollectionController.showCardsOnCardPanelWithSpecifiedClass("Neutral",
//                            Constant.getPanels().get("cardPanelOfDeckPage"), CardPanel.getNumOfCardInEveryRow());
            }
        });
        add(neutralBtn);
    }

    private void initHeroCardsBtn() {
        HeroCardsBtn = new JButton("Hero Cards");
        designBtn(HeroCardsBtn);
        HeroCardsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendShowSpecialCardsOfHeroRequest();
//                    Controller.getCurrentClient().sendShowSpecificCardsRequest(
//                            CollectionController.getHeroNameOfDeckToChange()+"Cards", "cardPanelOfDeckPage");

//                    CollectionController.showCardsOnCardPanelWithSpecifiedClass(CollectionController.getHeroNameOfDeckToChange(),
//                            Constant.getPanels().get("cardPanelOfDeckPage"), CardPanel.getNumOfCardInEveryRow());
            }
        });
        add(HeroCardsBtn);
    }


}

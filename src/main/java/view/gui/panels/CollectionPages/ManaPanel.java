package view.gui.panels.CollectionPages;


import Main.ClientMain;
import controller.Controller;
import utility.constant.Constant;
import view.gui.panels.MenuPanel.MainMenuPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;


public class ManaPanel extends JPanel {


    private static final int NUM_OF_COMPONENT = 13;

    private Color colorOfManaBtn = new Color(255, 0, 0);
    private Color colorOfTextOfBtn = new Color(48, 48, 45);
    private Color colorOfBackBtn = new Color(255, 0, 0);

    private JTextField searchField;
    private JButton searchBtn;
    private JButton backBtn;
    private JButton oneManaBtn;
    private JButton twoManaBtn;
    private JButton threeManaBtn;
    private JButton fourManaBtn;
    private JButton fiveManaBtn;
    private JButton sixManaBtn;
    private JButton sevenManaBtn;
    private JButton eightManaBtn;
    private JButton nineManaBtn;
    private JButton tenManaBtn;



    public ManaPanel() {
        setBackground(Color.pink);
        setLayout(new FlowLayout(NUM_OF_COMPONENT, 20, 20));
        initButtons();
        initSearchTools();
    }

    private void initButtons() {
        initBackBtn();
        initOneManaBtn();
        initTwoManaBtn();
        initThreeManaBtn();
        initFourManaBtn();
        initFiveManaBtn();
        initSixManaBtn();
        initSevenManaBtn();
        initEightManaBtn();
        initNineManaBtn();
        initTenManaBtn();
    }

    private void initSearchTools() {
        searchField = new JTextField(20);
        searchBtn = new JButton("Search");
        searchBtn.setSize(40, 20);
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //                    Administer.writeLog("Search for card: " + searchField.getText());
//                    CLI.currentPlayer.getLoggerOfMyPlayer().info("Search for card: "+searchField.getText());
                searchInCards(searchField.getText());
            }
        });
        add(searchField);
        add(searchBtn);
    }


    public void designBtn(JButton btn) {
        btn.setSize(Constant.WIDTH_OF_MANA_BTN, Constant.HEIGHT_OF_MANA_BTN);
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        btn.setForeground(colorOfTextOfBtn);
        btn.setBackground(colorOfManaBtn);
    }


    private void initTenManaBtn() {
        tenManaBtn = new JButton("10");
        designBtn(tenManaBtn);
        tenManaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterByMana(10);
            }
        });
        this.add(tenManaBtn);
    }

    private void initNineManaBtn() {
        nineManaBtn = new JButton("9");
        designBtn(nineManaBtn);
        nineManaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterByMana(9);
            }
        });
        this.add(nineManaBtn);
    }

    private void initEightManaBtn() {
        eightManaBtn = new JButton("8");
        designBtn(eightManaBtn);
        eightManaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterByMana(8);
            }
        });
        this.add(eightManaBtn);
    }

    private void initSevenManaBtn() {
        sevenManaBtn = new JButton("7");
        designBtn(sevenManaBtn);
        sevenManaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterByMana(7);
            }
        });
        this.add(sevenManaBtn);
    }

    private void initSixManaBtn() {
        sixManaBtn = new JButton("6");
        designBtn(sixManaBtn);
        sixManaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterByMana(6);
            }
        });
        this.add(sixManaBtn);
    }

    private void initFiveManaBtn() {
        fiveManaBtn = new JButton("5");
        designBtn(fiveManaBtn);
        fiveManaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterByMana(5);
            }
        });
        this.add(fiveManaBtn);
    }

    private void initFourManaBtn() {
        fourManaBtn = new JButton("4");
        designBtn(fourManaBtn);
        fourManaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterByMana(4);
            }
        });
        this.add(fourManaBtn);
    }

    private void initThreeManaBtn() {
        threeManaBtn = new JButton("3");
        designBtn(threeManaBtn);
        threeManaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterByMana(3);
            }
        });
        this.add(threeManaBtn);
    }

    private void initTwoManaBtn() {
        twoManaBtn = new JButton("2");
        designBtn(twoManaBtn);
        twoManaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterByMana(2);
            }
        });
        this.add(twoManaBtn);
    }

    private void initOneManaBtn() {
        oneManaBtn = new JButton("1");
        designBtn(oneManaBtn);
        oneManaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterByMana(1);
            }
        });
        this.add(oneManaBtn);
    }


    private void initBackBtn() {
        backBtn = new JButton("Back");
        backBtn.setFont(new Font("TimesRoman", Font.ITALIC, 30));
        backBtn.setForeground(colorOfTextOfBtn);
        backBtn.setBackground(colorOfBackBtn);
        backBtn.setSize(Constant.WIDTH_OF_BACK_BTN_IN_MANA_PANEL, Constant.HEIGHT_OF_BACK_BTN_IN_MANA_PANEL);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardPanel cardPanel = (CardPanel) Constant.getPanels().get("cardPanelOfCollectionPage");
                cardPanel.removeAll();
                cardPanel.repaint();
                cardPanel.revalidate();
//                Administer.writeLog("Go back from collection page");
                goBack();
            }
        });
        this.add(backBtn);
    }

    private void goBack() {
        Controller.getCurrentClient().sendGoBackFromCollectionPages();
    }


    private void searchInCards(String searchFieldText) {
        Controller.getCurrentClient().sendShowSearchCardsRequest(searchFieldText);
//        CollectionController.showSearchedCards(searchFieldText,  Constant.getPanels().get("cardPanelOfCollectionPage"),
//              Constant.getPanels().get("cardPanelOfDeckPage"), CardPanel.getNumOfCardInEveryRow());
    }

    public void filterByMana(int mana) {
        Controller.getCurrentClient().sendShowCardsFilteredByManaRequest(mana);
//        CollectionController.showCardsWithSpecifiedManaCost(mana, Constant.getPanels().get("cardPanelOfCollectionPage"),
//                Constant.getPanels().get("cardPanelOfDeckPage"), CardPanel.getNumOfCardInEveryRow());
    }

}

package view.gui.panels.CollectionPages;


import controller.controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CategoryPanel extends JPanel {

    public static final int NUMBER_OF_BTN = 9;
    public static final int WIDTH_OF_BTN = 90;
    public static final int HEIGHT_OF_BTN = 90;


    private JButton mageBtn;
    private JButton rogueBtn;
    private JButton warlockBtn;
    private JButton hunterBtn;
    private JButton priestBtn;
    private JButton neutralBtn;
    private JButton allCardBtn;
    private JButton unLockBtn;
    private JButton lockBtn;

    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);


    public CategoryPanel() {
        setBackground(Color.cyan);
        setLayout(new FlowLayout(NUMBER_OF_BTN, 20, 20));
        initButtons();
    }

    private void initButtons() {
        initMageBtn();
        initRogueBtn();
        initWarlockBtn();
        initHunterBtn();
        initPriestBtn();
        initNeutralBtn();
        initAllCardsBtn();
        initUnlockBtn();
        initLockBtn();
    }

    public void designBtn(JButton btn) {
        btn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        btn.setForeground(colorOfTextOfBtn);
        btn.setBackground(colorOfBtn);
    }

    private void initLockBtn() {
        lockBtn = new JButton("Lock");
        designBtn(lockBtn);
        lockBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendShowSpecificCardsRequest("LockCards","cardPanelOfCollectionPage");
            }
        });
        add(lockBtn);

    }

    private void initUnlockBtn() {
        unLockBtn = new JButton("UnLock");
        designBtn(unLockBtn);
        unLockBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendShowSpecificCardsRequest("UnLockCards","cardPanelOfCollectionPage");
            }
        });
        add(unLockBtn);
    }

    private void initAllCardsBtn() {
        allCardBtn = new JButton("All");
        designBtn(allCardBtn);
        allCardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendShowSpecificCardsRequest("AllCards","cardPanelOfCollectionPage");
            }
        });
        add(allCardBtn);
    }

    private void initNeutralBtn() {
        neutralBtn = new JButton("Neutral");
        designBtn(neutralBtn);
        neutralBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendShowSpecificCardsRequest("NeutralCards","cardPanelOfCollectionPage");
            }
        });
        add(neutralBtn);
    }

    private void initPriestBtn() {
        priestBtn = new JButton("Priest");
        designBtn(priestBtn);
        priestBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendShowSpecificCardsRequest("PriestCards","cardPanelOfCollectionPage");
            }
        });
        add(priestBtn);
    }

    private void initHunterBtn() {
        hunterBtn = new JButton("Hunter");
        designBtn(hunterBtn);
        hunterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendShowSpecificCardsRequest("HunterCards","cardPanelOfCollectionPage");
                //                    CollectionController.showCardsOnCardPanelWithSpecifiedClass("Hunter",
//                            Constant.getPanels().get("cardPanelOfCollectionPage"), CardPanel.getNumOfCardInEveryRow());
            }
        });
        add(hunterBtn);
    }

    private void initWarlockBtn() {
        warlockBtn = new JButton("Warlock");
        designBtn(warlockBtn);
        warlockBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendShowSpecificCardsRequest("WarlockCards","cardPanelOfCollectionPage");
                //                    CollectionController.showCardsOnCardPanelWithSpecifiedClass("Warlock",
//                            Constant.getPanels().get("cardPanelOfCollectionPage"), CardPanel.getNumOfCardInEveryRow());
            }
        });
        add(warlockBtn);
    }

    private void initRogueBtn() {
        rogueBtn = new JButton("Rogue");
        designBtn(rogueBtn);
        rogueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendShowSpecificCardsRequest("RogueCards","cardPanelOfCollectionPage");
                //                    CollectionController.showCardsOnCardPanelWithSpecifiedClass("Rogue",
//                            Constant.getPanels().get("cardPanelOfCollectionPage"), CardPanel.getNumOfCardInEveryRow());
            }
        });
        add(rogueBtn);
    }

    private void initMageBtn() {
        mageBtn = new JButton("Mage");
        designBtn(mageBtn);
        mageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendShowSpecificCardsRequest("MageCards","cardPanelOfCollectionPage");
                //                    CollectionController.showCardsOnCardPanelWithSpecifiedClass("Mage",
//                            Constant.getPanels().get("cardPanelOfCollectionPage"), CardPanel.getNumOfCardInEveryRow());
//                    filterByClassOfCard("Mage");
            }
        });
        add(mageBtn);
    }

}

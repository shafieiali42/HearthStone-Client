package view.gui.panels.ShopPanel;


import controller.controllers.Administer;
import controller.controllers.Controller;
import utility.constant.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {

    private static final int NUMBER_OF_BTN = 3;
    public static final int WIDTH_OF_BTN = 90;
    public static final int HEIGHT_OF_BTN = 90;


    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);


    private JButton walletBtn;
    private JButton buyableCardsBtn;
    private JButton salableCardsBtn;
    private JButton backBtn;


    public ButtonPanel() {
        setBackground(Color.gray);
        setLayout(new FlowLayout(NUMBER_OF_BTN, 20, 20));
        initButtons();

    }

    private void initButtons() {
        initBackBtn();
        initWalletBtn();
        initBuyableCardsBtn();
        initSalableCardsBtn();

    }

    public void designBtn(JButton btn) {
        btn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        btn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        btn.setForeground(colorOfTextOfBtn);
        btn.setBackground(colorOfBtn);
    }

    private void initBackBtn() {
        backBtn = new JButton("Back");
        designBtn(backBtn);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Administer.writeLog("Back from shop page");
//                CLI.currentPlayer.getLoggerOfMyPlayer().info("Back from shop page");
                ShopCardPanel shopCardPanel = (ShopCardPanel) Constant.getPanels().get("ShopCardPanel");
                shopCardPanel.removeAll();
                shopCardPanel.repaint();
                shopCardPanel.revalidate();
                Administer.goBack();
            }
        });
        add(backBtn);
    }



    private void initSalableCardsBtn() {
        salableCardsBtn = new JButton("SalableCards");
        designBtn(salableCardsBtn);
        salableCardsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //                    Administer.writeLog("Show salable cards");
//                    CLI.currentPlayer.getLoggerOfMyPlayer().info("Show salable cards");
                Controller.getCurrentClient().sendShowSpecificCardsRequest("Salable","ShopCardPanel");

            }
        });
        add(salableCardsBtn);
    }

    private void initBuyableCardsBtn() {
        buyableCardsBtn = new JButton("BuyableCards");
        designBtn(buyableCardsBtn);
        buyableCardsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendShowSpecificCardsRequest("Buyable","ShopCardPanel");
            }
        });
        add(buyableCardsBtn);
    }

    private void initWalletBtn() {
        walletBtn = new JButton("Wallet");
        designBtn(walletBtn);
        walletBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.getCurrentClient().sendShowWalletRequest(Controller.getCurrentPlayerUserName());
            }
        });
        add(walletBtn);
    }

}

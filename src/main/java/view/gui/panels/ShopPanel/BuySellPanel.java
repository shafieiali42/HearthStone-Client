package view.gui.panels.ShopPanel;


import controller.controllers.Controller;
import utility.constant.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuySellPanel extends JPanel {


    private Color colorOfTextOfBtn = new Color(255, 0, 0);
    private Color colorOfBtn = new Color(48, 48, 45);
    public static final int WIDTH_OF_BTN = 140;
    public static final int HEIGHT_OF_BTN = 60;

    private JLabel priceLabel;
    private JButton transactionBtn;


    private boolean isFirstTime = true;
    private String cardName;


    private void initPriceLabel() {
        priceLabel = new JLabel();
        priceLabel.setBounds(100, 75, 150, 30);
        add(priceLabel);
    }

    public BuySellPanel() {
//        setBackground(Color.cyan);
        setLayout(null);
        initPriceLabel();
        initTransactionBtn();

        PanelToShowCardInBuySellPanel panelToShowCardInBuySellPanel =
                (PanelToShowCardInBuySellPanel) Constant.getPanels().get("PanelToShowCardInBuySellPanel");

        panelToShowCardInBuySellPanel.setBounds(
                (Constant.WIDTH_OF_BUY_SELL_PANEL - panelToShowCardInBuySellPanel.getWidth()) / 2, 100,
                panelToShowCardInBuySellPanel.getWidth(),
                panelToShowCardInBuySellPanel.getHeight());

        add(panelToShowCardInBuySellPanel);
    }


    private void initTransactionBtn() {
        transactionBtn = new JButton("Transaction");
        transactionBtn.setSize(WIDTH_OF_BTN, HEIGHT_OF_BTN);
        transactionBtn.setFont(new Font("TimesRoman", Font.ITALIC, 20));
        transactionBtn.setForeground(colorOfTextOfBtn);
        transactionBtn.setBackground(colorOfBtn);
        transactionBtn.setBounds((400 - transactionBtn.getWidth()) / 2, 620, transactionBtn.getWidth(), transactionBtn.getHeight());
        transactionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelToShowCardInBuySellPanel panelToShowCardInBuySellPanel = (PanelToShowCardInBuySellPanel)
                        Constant.getPanels().get("PanelToShowCardInBuySellPanel");

                Controller.getCurrentClient().sendTransactionRequest(panelToShowCardInBuySellPanel.getCardToShowName());
            }
        });
        add(transactionBtn);
    }


    public boolean getIsFirstTime() {
        return isFirstTime;
    }

    public void setFirstTime(boolean firstTime) {
        isFirstTime = firstTime;
    }

    public JLabel getPriceLabel() {
        return priceLabel;
    }

    public void setPriceLabel(JLabel priceLabel) {
        this.priceLabel = priceLabel;
    }


}





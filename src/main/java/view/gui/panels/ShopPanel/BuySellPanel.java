package view.gui.panels.ShopPanel;

import Controller.Administer;
import Controller.ControllerOfMainComponents;
import Logic.Status;
import Utility.Config2.ConfigLoader;
import utility.constant.Constant;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;

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

                if (Administer.isShopStateCardNull()) {
                    JOptionPane.showMessageDialog(null,
                            "Please select a card!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);

                } else {
                    if (ControllerOfMainComponents.getStatus().equals(Status.BUY_PAGE)) {

                        int reply = JOptionPane.showConfirmDialog(null, "Are you sure that you want buy this card?\n" +
                                        "this card cost" + Administer.getMoneyOfShopStatesCard() + "$",
                                "Buy", JOptionPane.YES_NO_OPTION);

                        if (reply == JOptionPane.YES_OPTION) {
                            try {
                                Administer.buyShopStateCard();
                                Administer.playActionSounds("BuyCard");
                                Administer.makeShopStateCardNull();
                                PanelToShowCardInBuySellPanel panelToShowCardInBuySellPanel =
                                        (PanelToShowCardInBuySellPanel) Constant.getPanels().get("PanelToShowCardInBuySellPanel");
                                panelToShowCardInBuySellPanel.removeAll();
                                panelToShowCardInBuySellPanel.repaint();
                                panelToShowCardInBuySellPanel.revalidate();
                                BuySellPanel buySellPanel =(BuySellPanel)Constant.getPanels().get("BuySellPanel");
                                buySellPanel.getPriceLabel().setText("");
                                ButtonPanel.showBuyableCards();

                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }

                        }
                    } else if (ControllerOfMainComponents.getStatus().equals(Status.SELL_PAGE)) {
                        try {
                            if (Administer.isShopStateCardNull()) {
                                JOptionPane.showConfirmDialog(null, "Please select a card!",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                int reply = JOptionPane.showConfirmDialog(null,
                                        "Are you sure that you want sell this card?\n" +
                                                "this card cost" + Administer.getMoneyOfShopStatesCard() + "$",
                                        "Sell", JOptionPane.YES_NO_OPTION);

                                if (reply == JOptionPane.YES_OPTION) {

                                    if (!Administer.isShopStateCardInMyDecks()) {
                                        Administer.sellShopStateCard();
                                        Administer.playActionSounds("SellCard");
                                        ButtonPanel.showSalableCards();
                                        Administer.makeShopStateCardNull();
                                        PanelToShowCardInBuySellPanel panelToShowCardInBuySellPanel =
                                                (PanelToShowCardInBuySellPanel) Constant.getPanels().get("PanelToShowCardInBuySellPanel");
                                        panelToShowCardInBuySellPanel.removeAll();
                                        panelToShowCardInBuySellPanel.repaint();
                                        panelToShowCardInBuySellPanel.revalidate();
                                        BuySellPanel buySellPanel =(BuySellPanel)Constant.getPanels().get("BuySellPanel");
                                        buySellPanel.getPriceLabel().setText("");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "This card is in your deck",
                                                "Error", JOptionPane.ERROR_MESSAGE);
                                        Administer.makeShopStateCardNull();
                                        PanelToShowCardInBuySellPanel panelToShowCardInBuySellPanel =
                                                (PanelToShowCardInBuySellPanel) Constant.getPanels().get("PanelToShowCardInBuySellPanel");

                                        panelToShowCardInBuySellPanel.removeAll();
                                        panelToShowCardInBuySellPanel.repaint();
                                        panelToShowCardInBuySellPanel.revalidate();
                                        BuySellPanel buySellPanel =(BuySellPanel)Constant.getPanels().get("BuySellPanel");
                                        buySellPanel.getPriceLabel().setText("");
                                    }
                                }
                            }
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
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





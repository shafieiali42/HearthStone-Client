package controller.response;

import controller.Administer;
import controller.Controller;
import utility.constant.Constant;
import view.gui.panels.ShopPanel.ButtonPanel;
import view.gui.panels.ShopPanel.BuySellPanel;
import view.gui.panels.ShopPanel.PanelToShowCardInBuySellPanel;

import javax.swing.*;

public class TransactionResponse extends Response {


    private boolean successful;
    private String transactionType;


    public TransactionResponse(boolean successful, String transactionType) {
        this.successful = successful;
        this.transactionType = transactionType;
    }


    @Override
    public void execute() {
        if (successful) {
            PanelToShowCardInBuySellPanel panelToShowCardInBuySellPanel =
                    (PanelToShowCardInBuySellPanel) Constant.getPanels().get("PanelToShowCardInBuySellPanel");
            if (transactionType.equalsIgnoreCase("Buy")) {
                Administer.playActionSounds("BuyCard");
                panelToShowCardInBuySellPanel.setCardToShowName(null);

                panelToShowCardInBuySellPanel.removeAll();
                panelToShowCardInBuySellPanel.repaint();
                panelToShowCardInBuySellPanel.revalidate();
                BuySellPanel buySellPanel = (BuySellPanel) Constant.getPanels().get("BuySellPanel");
                buySellPanel.getPriceLabel().setText("");
                Controller.getCurrentClient().sendShowSpecificCardsRequest("Buyable","BuySellPanel");//todo
            } else if (transactionType.equalsIgnoreCase("sell")) {
                Administer.playActionSounds("SellCard");
                Controller.getCurrentClient().sendShowSpecificCardsRequest("Salable","BuySellPanel");//todo

//                PanelToShowCardInBuySellPanel panelToShowCardInBuySellPanel =
//                        (PanelToShowCardInBuySellPanel) Constant.getPanels().get("PanelToShowCardInBuySellPanel");
                panelToShowCardInBuySellPanel.setCardToShowName(null);
                panelToShowCardInBuySellPanel.removeAll();
                panelToShowCardInBuySellPanel.repaint();
                panelToShowCardInBuySellPanel.revalidate();
                BuySellPanel buySellPanel = (BuySellPanel) Constant.getPanels().get("BuySellPanel");
                buySellPanel.getPriceLabel().setText("");
            }
        } else {
            if (transactionType.equalsIgnoreCase("Sell")) {
                JOptionPane.showMessageDialog(null, "This card is in your deck",
                        "Error", JOptionPane.ERROR_MESSAGE);

                PanelToShowCardInBuySellPanel panelToShowCardInBuySellPanel =
                        (PanelToShowCardInBuySellPanel) Constant.getPanels().get("PanelToShowCardInBuySellPanel");
                panelToShowCardInBuySellPanel.setCardToShowName(null);
                panelToShowCardInBuySellPanel.removeAll();
                panelToShowCardInBuySellPanel.repaint();
                panelToShowCardInBuySellPanel.revalidate();
                BuySellPanel buySellPanel = (BuySellPanel) Constant.getPanels().get("BuySellPanel");
                buySellPanel.getPriceLabel().setText("");
            }
        }


    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}

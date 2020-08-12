package controller.response;

import controller.controllers.Administer;
import controller.controllers.Controller;
import controller.controllers.GamePartController;
import utility.constant.Constant;
import view.gui.panels.ShopPanel.BuySellPanel;
import view.gui.panels.ShopPanel.PanelToShowCardInBuySellPanel;

import javax.swing.*;
import java.util.ArrayList;

public class TransactionResponse extends Response {


    private boolean successful;
    private String transactionType;
    private ArrayList<String> allCardsNames;


    public TransactionResponse(boolean successful, String transactionType,ArrayList<String> allCardsNames) {
        this.successful = successful;
        this.transactionType = transactionType;
        this.allCardsNames=allCardsNames;
    }


    @Override
    public void execute() {
        if (successful) {
            PanelToShowCardInBuySellPanel panelToShowCardInBuySellPanel =
                    (PanelToShowCardInBuySellPanel) Constant.getPanels().get("PanelToShowCardInBuySellPanel");
            GamePartController.setAllCardsOfPlayerNames(allCardsNames);
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

    public ArrayList<String> getAllCardsNames() {
        return allCardsNames;
    }

    public void setAllCardsNames(ArrayList<String> allCardsNames) {
        this.allCardsNames = allCardsNames;
    }
}

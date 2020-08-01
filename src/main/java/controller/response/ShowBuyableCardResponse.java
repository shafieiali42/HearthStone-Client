package controller.response;

import utility.constant.Constant;
import view.gui.panels.ShopPanel.BuySellPanel;
import view.gui.panels.ShopPanel.PanelToShowCardInBuySellPanel;

public class ShowBuyableCardResponse extends Response {


    private String cardName;

    public ShowBuyableCardResponse(String cardName) {
        this.cardName = cardName;
    }

    @Override
    public void execute() {

        PanelToShowCardInBuySellPanel panelToShowCardInBuySellPanel =
                (PanelToShowCardInBuySellPanel) Constant.getPanels().get("PanelToShowCardInBuySellPanel");

        panelToShowCardInBuySellPanel.removeAll();
        panelToShowCardInBuySellPanel.repaint();
        panelToShowCardInBuySellPanel.revalidate();
        BuySellPanel buySellPanel=(BuySellPanel)Constant.getPanels().get("BuySellPanel");
        buySellPanel.getPriceLabel().setText("");
        panelToShowCardInBuySellPanel.setCardToShowName(cardName);
//        BuySellPanel.getInstance().getPriceLabel().setText("Price " + Administer.getMoneyOfShopStatesCard() + " $");
        panelToShowCardInBuySellPanel.repaint();
        panelToShowCardInBuySellPanel.revalidate();
    }


    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}

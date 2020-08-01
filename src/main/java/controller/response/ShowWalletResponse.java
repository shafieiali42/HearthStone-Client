package controller.response;

import javax.swing.*;

public class ShowWalletResponse extends Response {


    private int money;

    public ShowWalletResponse(int money) {
        this.money = money;
    }

    @Override
    public void execute() {

        JOptionPane.showConfirmDialog(null, "You have " + money + " Money!",
                "Wallet", JOptionPane.DEFAULT_OPTION);


    }


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

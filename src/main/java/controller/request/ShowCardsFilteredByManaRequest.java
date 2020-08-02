package controller.request;

import controller.response.Response;
import controller.response.ShowSpecificCardsResponse;

import java.util.ArrayList;

public class ShowCardsFilteredByManaRequest extends Request {


    private String userName;
    private int mana;

    public ShowCardsFilteredByManaRequest(String userName, int mana) {
        this.userName = userName;
        this.mana = mana;
    }



    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

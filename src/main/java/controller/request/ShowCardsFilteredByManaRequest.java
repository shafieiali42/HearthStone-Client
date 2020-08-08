package controller.request;

import controller.response.Response;
import controller.response.ShowSpecificCardsResponse;

import java.util.ArrayList;

public class ShowCardsFilteredByManaRequest extends Request {


    private int mana;

    public ShowCardsFilteredByManaRequest(String userName, int mana) {
        setUserName(userName);
        setRequestType("ShowCardsFilteredByManaRequest");
        this.mana = mana;
    }



    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

}

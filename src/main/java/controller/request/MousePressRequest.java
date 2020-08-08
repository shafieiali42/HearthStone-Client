package controller.request;

import controller.response.ChangeFirstThreeCardsResponse;
import controller.response.Response;

public class MousePressRequest extends Request {


    private String cardName;
    private String firstCardNameOfThreeCards;
    private String secondCardNameOfThreeCards;
    private String thirdCardNameOfThreeCards;
    private boolean firstCardCanChangeInThreeCards;
    private boolean secondCardCanChangeInThreeCards;
    private boolean thirdCardCanChangeInThreeCards;


    public MousePressRequest(String userName, String cardName, String firstCardNameOfThreeCards, String secondCardNameOfThreeCards, String thirdCardNameOfThreeCards,
                             boolean firstCardCanChangeInThreeCards, boolean secondCardCanChangeInThreeCards,
                             boolean thirdCardCanChangeInThreeCards) {

        setUserName(userName);
        setRequestType("MousePressRequest");
        this.cardName = cardName;
        this.firstCardNameOfThreeCards = firstCardNameOfThreeCards;
        this.secondCardNameOfThreeCards = secondCardNameOfThreeCards;
        this.thirdCardNameOfThreeCards = thirdCardNameOfThreeCards;
        this.firstCardCanChangeInThreeCards = firstCardCanChangeInThreeCards;
        this.secondCardCanChangeInThreeCards = secondCardCanChangeInThreeCards;
        this.thirdCardCanChangeInThreeCards = thirdCardCanChangeInThreeCards;
    }


    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getFirstCardNameOfThreeCards() {
        return firstCardNameOfThreeCards;
    }

    public void setFirstCardNameOfThreeCards(String firstCardNameOfThreeCards) {
        this.firstCardNameOfThreeCards = firstCardNameOfThreeCards;
    }

    public String getSecondCardNameOfThreeCards() {
        return secondCardNameOfThreeCards;
    }

    public void setSecondCardNameOfThreeCards(String secondCardNameOfThreeCards) {
        this.secondCardNameOfThreeCards = secondCardNameOfThreeCards;
    }

    public String getThirdCardNameOfThreeCards() {
        return thirdCardNameOfThreeCards;
    }

    public void setThirdCardNameOfThreeCards(String thirdCardNameOfThreeCards) {
        this.thirdCardNameOfThreeCards = thirdCardNameOfThreeCards;
    }

    public boolean isFirstCardCanChangeInThreeCards() {
        return firstCardCanChangeInThreeCards;
    }

    public void setFirstCardCanChangeInThreeCards(boolean firstCardCanChangeInThreeCards) {
        this.firstCardCanChangeInThreeCards = firstCardCanChangeInThreeCards;
    }

    public boolean isSecondCardCanChangeInThreeCards() {
        return secondCardCanChangeInThreeCards;
    }

    public void setSecondCardCanChangeInThreeCards(boolean secondCardCanChangeInThreeCards) {
        this.secondCardCanChangeInThreeCards = secondCardCanChangeInThreeCards;
    }

    public boolean isThirdCardCanChangeInThreeCards() {
        return thirdCardCanChangeInThreeCards;
    }

    public void setThirdCardCanChangeInThreeCards(boolean thirdCardCanChangeInThreeCards) {
        this.thirdCardCanChangeInThreeCards = thirdCardCanChangeInThreeCards;
    }
}

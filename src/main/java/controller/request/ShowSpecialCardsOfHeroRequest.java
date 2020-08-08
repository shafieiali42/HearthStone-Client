package controller.request;

public class ShowSpecialCardsOfHeroRequest extends Request {


    public ShowSpecialCardsOfHeroRequest(String userName) {
        setUserName(userName);
        setRequestType("ShowSpecialCardsOfHeroRequest");
    }

}

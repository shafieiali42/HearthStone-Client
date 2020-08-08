package controller.request;


public class ShowSearchCardsRequest extends Request {

    private String searchTextField;


    public ShowSearchCardsRequest(String userName, String searchTextField) {
        setUserName(userName);
        setRequestType("ShowSearchCardsRequest");
        this.searchTextField = searchTextField;
    }



    public String getSearchTextField() {
        return searchTextField;
    }

    public void setSearchTextField(String searchTextField) {
        this.searchTextField = searchTextField;
    }


}

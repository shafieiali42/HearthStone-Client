package controller.request;


public class ShowSearchCardsRequest extends Request {


    private String userName;
    private String searchTextField;


    public ShowSearchCardsRequest(String userName, String searchTextField) {
        this.userName = userName;
        this.searchTextField = searchTextField;
    }



    public String getSearchTextField() {
        return searchTextField;
    }

    public void setSearchTextField(String searchTextField) {
        this.searchTextField = searchTextField;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}

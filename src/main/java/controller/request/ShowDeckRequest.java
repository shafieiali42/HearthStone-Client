package controller.request;

public class ShowDeckRequest extends Request {


    private String nameOfDeckToShow;


    public ShowDeckRequest(String userName, String nameOfDeckToShow) {
        setUserName(userName);
        setRequestType("ShowDeckRequest");
        this.nameOfDeckToShow = nameOfDeckToShow;
    }


    public String getNameOfDeckToShow() {
        return nameOfDeckToShow;
    }

    public void setNameOfDeckToShow(String nameOfDeckToShow) {
        this.nameOfDeckToShow = nameOfDeckToShow;
    }
}

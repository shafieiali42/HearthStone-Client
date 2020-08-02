package controller.request;

public class ShowDeckRequest extends Request {


    private String userName;
    private String nameOfDeckToShow;


    public ShowDeckRequest(String userName, String nameOfDeckToShow) {
        this.userName = userName;
        this.nameOfDeckToShow = nameOfDeckToShow;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNameOfDeckToShow() {
        return nameOfDeckToShow;
    }

    public void setNameOfDeckToShow(String nameOfDeckToShow) {
        this.nameOfDeckToShow = nameOfDeckToShow;
    }
}

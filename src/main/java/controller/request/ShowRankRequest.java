package controller.request;

public class ShowRankRequest extends Request {


    private String typeOfRank;

    public ShowRankRequest(String userName,String typeOfRank) {
        setRequestType("ShowRankRequest");
        setUserName(userName);
        this.typeOfRank = typeOfRank;
    }


    public String getTypeOfRank() {
        return typeOfRank;
    }

    public void setTypeOfRank(String typeOfRank) {
        this.typeOfRank = typeOfRank;
    }
}

package controller.request;

public class MouseReleasedRequest extends Request {


    private String userName;
    private String cardName;
    private String xCoordinateOfReleased;
    private String yCoordinateOfReleased;

    public MouseReleasedRequest(String userName, String cardName, String xCoordinateOfReleased, String yCoordinateOfReleased) {
        this.userName = userName;
        this.cardName = cardName;
        this.xCoordinateOfReleased = xCoordinateOfReleased;
        this.yCoordinateOfReleased = yCoordinateOfReleased;
    }


    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getxCoordinateOfReleased() {
        return xCoordinateOfReleased;
    }

    public void setxCoordinateOfReleased(String xCoordinateOfReleased) {
        this.xCoordinateOfReleased = xCoordinateOfReleased;
    }

    public String getyCoordinateOfReleased() {
        return yCoordinateOfReleased;
    }

    public void setyCoordinateOfReleased(String yCoordinateOfReleased) {
        this.yCoordinateOfReleased = yCoordinateOfReleased;
    }
}

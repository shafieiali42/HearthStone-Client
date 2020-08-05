package controller.request;

import controller.Alliance;

public class MouseClickRequest extends Request {



    private String userName;
    private String cardName;
    private String typeOfCard;
    private boolean clicked;
    private int xCoordinateOfCard;
    private int yCoordinateOfCard;
    private Alliance alliance;
    private String typeOfClick;


    public MouseClickRequest(String userName, String cardName, String typeOfCard, boolean clicked,
                             int xCoordinateOfCard, int yCoordinateOfCard, Alliance alliance,String typeOfClick) {

        this.userName = userName;
        this.cardName = cardName;
        this.typeOfCard = typeOfCard;
        this.clicked = clicked;
        this.xCoordinateOfCard = xCoordinateOfCard;
        this.yCoordinateOfCard = yCoordinateOfCard;
        this.alliance = alliance;
        this.typeOfClick=typeOfClick;
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

    public String getTypeOfCard() {
        return typeOfCard;
    }

    public void setTypeOfCard(String typeOfCard) {
        this.typeOfCard = typeOfCard;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public int getxCoordinateOfCard() {
        return xCoordinateOfCard;
    }

    public void setxCoordinateOfCard(int xCoordinateOfCard) {
        this.xCoordinateOfCard = xCoordinateOfCard;
    }

    public int getyCoordinateOfCard() {
        return yCoordinateOfCard;
    }

    public void setyCoordinateOfCard(int yCoordinateOfCard) {
        this.yCoordinateOfCard = yCoordinateOfCard;
    }

    public Alliance getAlliance() {
        return alliance;
    }

    public void setAlliance(Alliance alliance) {
        this.alliance = alliance;
    }

    public String getTypeOfClick() {
        return typeOfClick;
    }

    public void setTypeOfClick(String typeOfClick) {
        this.typeOfClick = typeOfClick;
    }
}

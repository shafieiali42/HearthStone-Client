package controller.request;

public class MakeNewDeckRequest extends Request {


    private String deckName;
    private String heroName;
    private String userName;


    public MakeNewDeckRequest(String userName,String deckName, String heroName) {
        this.userName=userName;
        this.deckName = deckName;
        this.heroName = heroName;
    }


    public String getDeckName() {
        return deckName;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

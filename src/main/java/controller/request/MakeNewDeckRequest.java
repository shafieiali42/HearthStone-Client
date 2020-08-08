package controller.request;

public class MakeNewDeckRequest extends Request {


    private String deckName;
    private String heroName;


    public MakeNewDeckRequest(String userName,String deckName, String heroName) {
        setUserName(userName);
        setRequestType("MakeNewDeckRequest");
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

}

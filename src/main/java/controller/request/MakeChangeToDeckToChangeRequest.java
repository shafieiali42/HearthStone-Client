package controller.request;

public class MakeChangeToDeckToChangeRequest extends Request {


    private String userName;
    private String typeOfRequest;
    private String newFiled;


    public MakeChangeToDeckToChangeRequest(String userName, String typeOfRequest, String newFiled) {
        this.userName = userName;
        this.typeOfRequest = typeOfRequest;
        this.newFiled = newFiled;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTypeOfRequest() {
        return typeOfRequest;
    }

    public void setTypeOfRequest(String typeOfRequest) {
        this.typeOfRequest = typeOfRequest;
    }

    public String getNewFiled() {
        return newFiled;
    }

    public void setNewFiled(String newFiled) {
        this.newFiled = newFiled;
    }
}

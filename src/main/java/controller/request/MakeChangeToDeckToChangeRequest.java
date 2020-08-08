package controller.request;

public class MakeChangeToDeckToChangeRequest extends Request {


    private String typeOfRequest;
    private String newFiled;


    public MakeChangeToDeckToChangeRequest(String userName, String typeOfRequest, String newFiled) {
        setUserName(userName);
        setRequestType("MakeChangeToDeckToChangeRequest");
        this.typeOfRequest = typeOfRequest;
        this.newFiled = newFiled;
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

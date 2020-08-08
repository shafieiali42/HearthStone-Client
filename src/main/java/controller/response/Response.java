package controller.response;

public  class Response {


    private String responseReceiversToken;
    private String responseType;
    public  void execute(){}



    //getter and setters
    //********************

    public String getResponseReceiversToken() {
        return responseReceiversToken;
    }
    public void setResponseReceiversToken(String responseReceiversToken) {
        this.responseReceiversToken = responseReceiversToken;
    }
    public String getResponseType() {
        return responseType;
    }
    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }
}

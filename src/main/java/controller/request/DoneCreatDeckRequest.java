package controller.request;

public class DoneCreatDeckRequest extends Request{




    public DoneCreatDeckRequest(String sendersToken,String userName) {
        setUserName(userName);
        setRequestType("DoneCreatDeckRequest");
        setRequestSendersToken(sendersToken);
    }

}

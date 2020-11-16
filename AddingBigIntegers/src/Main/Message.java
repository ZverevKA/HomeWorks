package Main;

public class Message {
    private Carry msg;
    private boolean readiness;

    public Message(){
        readiness = false;
    }
    public void setMsg(Carry msg){
        this.msg = msg;
    }
    public Carry getMsg(){
        return msg;
    }
    public void setReady(){
        this.readiness = true;
    }
    public boolean isReady(){
        return readiness;
    }
}

package Parallel;

public class Message {
    private Compositionable msg;
    private boolean readiness;

    public Message(){
        readiness = false;
    }
    public void setMsg(Compositionable msg){
        this.msg = msg;
    }
    public Compositionable getMsg(){
        return msg;
    }
    public void setReady(){
        this.readiness = true;
    }
    public boolean isReady(){
        return readiness;
    }
}

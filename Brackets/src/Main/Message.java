package Main;

public class Message {
    private int msg;
    private boolean readiness;

    public Message() {
        readiness = false;
    }
    public void setMsg(int msg) {
        this.msg = msg;
    }
    public int getMsg() {
        return msg;
    }
    public void setReady() {
        this.readiness = true;
    }
    public boolean isReady() {
        return readiness;
    }
}

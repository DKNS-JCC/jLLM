package Model;

public class csvResponse {
    private String msg;
    private String type;
    private int size;

    public csvResponse(String msg, String type, int size) {
        this.msg = msg;
        this.type = type;
        this.size = size;
    }

    public String getMsg() {
        return msg;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(int size) {
        this.size = size;
    }

    
}

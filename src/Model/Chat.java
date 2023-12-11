package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Chat implements Serializable {
    private String llname;
    private ArrayList<Message> messages;
    
    public Chat() {
    }

    public Chat(String llname, ArrayList<Message> messages) {
        this.llname = llname;
        this.messages = messages;
    }

    public String getLlname() {
        return llname;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setLlname(String llname) {
        this.llname = llname;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
    
}


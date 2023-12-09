
package Model;
import java.util.List;

public class Chat {
    private String llname;
    private List<Message> messages;
    

    public Chat(String llname, List<Message> messages) {
        this.llname = llname;
        this.messages = messages;
    }

    public String getLlname() {
        return llname;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setLlname(String llname) {
        this.llname = llname;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    
}


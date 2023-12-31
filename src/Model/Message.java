
package Model;

import java.io.Serializable;

public class Message implements Serializable {
    private String sender;
    private String date;
    private String content;


    // Constructor
    public Message(String sender, String date, String content) {
        this.sender = sender;
        this.date = date;
        this.content = content;
    }
    public Message() {
    }

    // Getters y Setters
    public String getSender() {
        return sender;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setDate(String date) {
        this.date= date;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}

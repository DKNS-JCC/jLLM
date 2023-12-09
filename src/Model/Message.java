
package Model;

import java.time.Instant;

public class Message {
    private String sender;
    private Instant date;
    private String content;

    // Constructor
    public Message(String sender, Instant date, String content) {
        this.sender = sender;
        this.date = date;
        this.content = content;
    }

    // Getters y Setters
    public String getSender() {
        return sender;
    }

    public Instant getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setDate(Instant date) {
        this.date= date;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}

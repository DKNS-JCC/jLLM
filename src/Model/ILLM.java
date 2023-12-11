package Model;

import java.util.ArrayList;

public interface ILLM 
{
    public String speak (String text);
    public String getIdentifier();
    public Message createMessage(String text);
    public void saveConversation(Message message);
    public ArrayList<Message> listConversations();

}

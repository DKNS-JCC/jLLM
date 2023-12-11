package Model;
import java.util.ArrayList;

public class csvModel implements ILLM
{
    public csvModel()
    {
    }
    public String speak (String text)
    {
        return "Hello World";
    }
    public Message createMessage(String text)
    {
        return null;
    }
    public void saveConversation(Message message)
    {
    }
    public ArrayList<Message> listConversations()
    {
        return null;
    }
    public String getIdentifier()
    {
        return "csvModel";
    }
    public ArrayList<Chat> importChat()
    {
        return null;
    }
    public boolean exportChat(ArrayList<Chat> chats)
    {
        return false;
    }

}

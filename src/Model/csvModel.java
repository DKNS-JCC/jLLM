package Model;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class csvModel implements ILLM
{
    private File file = Paths.get(System.getProperty("user.home"), "Desktop", "jLLM", "input.csv").toFile();
    public csvModel()
    {
    }
    public String speak (String text)
    {
        if (file.exists())
        {
            
        }
        else
        {
            return null;
        }
        
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

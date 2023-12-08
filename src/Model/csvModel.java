package Model;
import java.util.ArrayList;

public class csvModel implements ILLM, IRepository
{
    public csvModel()
    {
    }
    public String speak (String text)
    {
        return "Hello World";
    }
    public String getIdentifier()
    {
        return "csvModel";
    }
    public ArrayList<Chat> importarChat()
    {
        return null;
    }
    public boolean exportarChat(ArrayList<Chat> chats)
    {
        return false;
    }

}

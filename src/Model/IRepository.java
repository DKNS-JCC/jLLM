package Model;
import java.util.ArrayList;

public interface IRepository 
{
    public ArrayList<Chat> importChat();
    public boolean exportChat(ArrayList<Chat> chats);

}

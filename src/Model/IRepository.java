package Model;
import java.util.ArrayList;

public interface IRepository 
{
    public ArrayList<Chat> importarChat();
    public boolean exportarChat(ArrayList<Chat> chats);
}

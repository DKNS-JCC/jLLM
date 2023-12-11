package Model;
import java.util.ArrayList;

public interface IRepository 
{
    public ArrayList<Chat> importChat();
    public boolean exportChat(ArrayList<Chat> chats);
    public void saveMessage(Message message);
    public ArrayList<Message> listChat();
    public void saveChat();
    public ArrayList<Chat> listChats();
}

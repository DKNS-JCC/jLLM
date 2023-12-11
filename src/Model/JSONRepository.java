package Model;

import java.util.ArrayList;

public class JSONRepository implements IRepository {

    

    public JSONRepository() {
    }

    public boolean exportChat(ArrayList<Chat> chats) {
        
        return true;
    }

    public ArrayList<Chat> importChat() {
        return new ArrayList<Chat>();
    }

    public ArrayList<Chat> listConversations() {
        return new ArrayList<Chat>();
    }

    public ArrayList<Message> listChat() {
        return new ArrayList<Message>();
    }

    public void saveConversation() {
    }

    public void saveMessage(Message message) {
    }


}

package Model;

import java.util.ArrayList;

public class JSONRepository implements IRepository {

    public JSONRepository() {
    }

    public boolean exportarChat(ArrayList<Chat> chats) {
        return true;
    }

    public ArrayList<Chat> importarChat() {
        return new ArrayList<Chat>();
    }
}

package Model;

import java.util.ArrayList;

public class fakeModel implements ILLM, IRepository {
    public fakeModel() {
    }

    public String speak(String text) {
        return "Hello World";
    }

    public String getIdentifier() {
        return "fakeModel";
    }

    public ArrayList<Chat> importarChat() {
        return null;
    }

    public boolean exportarChat(ArrayList<Chat> chats) {
        return false;
    }
}

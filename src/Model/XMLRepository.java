package Model;

import java.util.ArrayList;

public class XMLRepository implements IRepository {

    private ArrayList<Chat> chats = new ArrayList<Chat>();
    private ArrayList<Message> mensajes = new ArrayList<Message>();
    private String ID;

    public XMLRepository() {
    }

    public boolean exportChat(ArrayList<Chat> chats) {
        return true;
    }

    public ArrayList<Chat> importChat() {
        return new ArrayList<Chat>();
    }

    public ArrayList<Chat> listChats() {
        return chats; // Devuelve la lista de conversaciones
    }

    public ArrayList<Message> listChat() {
        return mensajes; // Devuelve la lista de mensajes
    }

    public void saveChat() {
        // Añade la conversación actual a la lista de conversaciones
        if (!mensajes.isEmpty()) {
            Chat chat_nuevo = new Chat( , new ArrayList<>(mensajes));
            chats.add(chat_nuevo);
            mensajes.clear(); // Borra la conversación actual
        }
    }

    public void setIdentifier(String ID) {
        this.ID = ID;
    }

    public void saveMessage(Message message) {
        mensajes.add(message);
    }

}

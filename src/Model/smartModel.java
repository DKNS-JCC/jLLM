package Model;

import java.io.Serializable;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import io.github.amithkoujalgi.ollama4j.core.OllamaAPI;


public class smartModel implements ILLM, Serializable {
    
    private ArrayList<Chat> chats = new ArrayList<Chat>();
    private ArrayList<Message> mensajes = new ArrayList<Message>();

    // Constructor
    public smartModel() {
        
    }

    // Generar respuesta
    @Override
    public String speak(String text) {
        String host = "http://localhost:11434";
        OllamaAPI ollamaAPI = new OllamaAPI(host);
        try {
            String response = ollamaAPI.ask("mistral",text);
            return response;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    // Generar mensaje de respuesta
    @Override
    public Message createMessage(String text) {
        String formattedTimestamp = Instant
                .now()
                .atZone(java.time.ZoneOffset.UTC)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Message message = new Message(getIdentifier(), formattedTimestamp, text);
        return message;
    }

    // Mostrat tipo de modelo
    @Override
    public String getIdentifier() {
        return "smartModel";
    }

    @Override
    public ArrayList<Chat> listChats() {
        return chats; // Devuelve la lista de conversaciones
    }

    @Override
    public ArrayList<Message> listChat() {
        return mensajes; // Devuelve la lista de mensajes
    }

    @Override
    public void saveChat() {
        // Añade la conversación actual a la lista de conversaciones
        if (!mensajes.isEmpty()) {
            Chat chat_nuevo = new Chat(getIdentifier(), new ArrayList<>(mensajes));
            chats.add(chat_nuevo);
            mensajes.clear(); // Borra la conversación actual
        }
    }

    @Override
    public void setChats(ArrayList<Chat> chats_n) {
        if (chats.size() == 0) {
            this.chats = chats_n;
        } else {
            for (Chat chat : chats_n) {
                chats.add(chat);
            }
        }
    }

    @Override
    public void saveMessage(Message message) {
        mensajes.add(message);
    }

    public static csvResponse getInstanceFromDelimitedString(
            String delimitedString,
            String delimiter) {
        String[] chunks = delimitedString.split(delimiter);
        if (chunks.length != 3) {
            return null;
        }
        try {
            String tipo = chunks[0];
            int size = Integer.parseInt(chunks[1]);
            String content = chunks[2];
            csvResponse response = new csvResponse(content, tipo, size);
            return response;
        } catch (Exception e) {
            // Tomamos linea como inválida
            return null;
        }
    }
}

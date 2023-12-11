package Model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class csvModel implements ILLM, Serializable {

    private ArrayList<Chat> chats = new ArrayList<Chat>();
    private ArrayList<Message> mensajes = new ArrayList<Message>();

    // Constructor
    public csvModel() {
    }

    // Generar respuesta
    @Override
    public String speak(String text) {
        File file = Paths.get(System.getProperty("user.home"), "Desktop", "jLLM", "input.csv").toFile();
        String delimiter = ",";
    
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            Collections.shuffle(lines); // Randomize lines
            for (String line : lines) {
                csvResponse response = getInstanceFromDelimitedString(line, delimiter);
                if (response == null) {
                    continue;
                }
                if (text.contains("?") && response.getType().equals("pregunta")) {
                    return response.getMsg();
                }
                else if ((text.contains("hola") || text.contains("saludos") || text.contains("buenas")) && response.getType().equals("saludo")) {
                    return response.getMsg();
                }
                else if ((text.contains("adios") || text.contains("hasta luego")) && response.getType().equals("despedida")) {
                    return response.getMsg();
                }
                else if ((text.contains("quien") || text.contains("como") || text.contains("que") || text.contains("donde") || text.contains("cuando") || text.contains("por que")) && response.getType().equals("pregunta")) {
                    return response.getMsg();
                }
                else if ((text.contains("no") || text.contains("nada") || text.contains("ninguna") || text.contains("ninguno")) && response.getType().equals("negacion")) {
                    return response.getMsg();
                }
                else if ((text.contains("si") || text.contains("claro") || text.contains("por supuesto") || text.contains("efectivamente")) && response.getType().equals("afirmacion")) {
                    return response.getMsg();
                }
                else if ((text.contains("bien") || text.contains("genial") || text.contains("perfecto") || text.contains("estupendo")) && response.getType().equals("estado")) {
                    return response.getMsg();
                }
                else if ((text.contains("wow") || text.contains("guau") || text.contains("increible") || text.contains("flipante")) && response.getType().equals("sorpresa")) {
                    return response.getMsg();
                }
                else {
                    if (response.getType().equals("refran")) {
                        return response.getMsg();
                    }
                    else {
                        continue;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    
        return null; // Default return if no conditions are met
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
        return "csvModel";
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

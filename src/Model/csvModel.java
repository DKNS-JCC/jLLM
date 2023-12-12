package Model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class csvModel implements ILLM, Serializable {

    private ArrayList<Chat> chats = new ArrayList<Chat>();
    private ArrayList<Message> mensajes = new ArrayList<Message>();

    ArrayList<String> refranes = new ArrayList<String>();
    ArrayList<String> sorpresas = new ArrayList<String>();
    ArrayList<String> saludos = new ArrayList<String>();
    ArrayList<String> despedidas = new ArrayList<String>();
    ArrayList<String> afirmaciones = new ArrayList<String>();
    ArrayList<String> negaciones = new ArrayList<String>();
    ArrayList<String> preguntas = new ArrayList<String>();

    // Constructor
    public csvModel() {
    }

    // Generar respuesta
    @Override
    public String speak(String text) {
        leerCSV();
        if (text.contains("hola") || (text.contains("buenas")) || (text.contains("saludos")) || (text.contains("buenos dias")) || (text.contains("buenas tardes")) || (text.contains("buenas noches")) || (text.contains("que tal")) || (text.contains("hey")) || (text.contains("hi")) || (text.contains("hello")) || (text.contains("holi")) || (text.contains("holis")) || (text.contains("holas")) || (text.contains("holaa")) || (text.contains("holaaa")) || (text.contains("holaaaa")) || (text.contains("holaaaaa")) || (text.contains("holaaaaaa")) || (text.contains("holaaaaaaa")) || (text.contains("holaaaaaaaa")) || (text.contains("holaaaaaaaaa")) || (text.contains("holaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")) || (text.contains("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"))){
            //elegir un elemento aleatorio de la lista de saludos
            Collections.shuffle (saludos);
            return saludos.get(0);
        }
        else if (text.contains("adios") || (text.contains("hasta luego")) || (text.contains("hasta pronto")) || (text.contains("hasta la vista")) || (text.contains("nos vemos")) || (text.contains("hasta mañana")) || (text.contains("hasta la proxima")) ){
            //elegir un elemento aleatorio de la lista de despedidas
            Collections.shuffle (despedidas);
            return despedidas.get(0);
        }
        else if (text.contains("si") || (text.contains("claro")) || (text.contains("afirmativo")) || (text.contains("positivo"))){
            //elegir un elemento aleatorio de la lista de afirmaciones
            Collections.shuffle (afirmaciones);
            return afirmaciones.get(0);
        }
        else if (text.contains("no") || (text.contains("nada")) || (text.contains("negativo")) || (text.contains("negativo"))){
            //elegir un elemento aleatorio de la lista de negaciones
            Collections.shuffle (negaciones);
            return negaciones.get(0);
        }
        else if (text.contains("?") || (text.contains("pregunta")) || (text.contains("que")) || (text.contains("como")) || (text.contains("cuando")) || (text.contains("donde")) || (text.contains("quien")) || (text.contains("por que"))){
            //elegir un elemento aleatorio de la lista de preguntas
            Collections.shuffle (preguntas);
            return preguntas.get(0);
        }
        else if (text.contains("refran") || (text.contains("dicho")) || (text.contains("frase"))){
            //elegir un elemento aleatorio de la lista de refranes
            Collections.shuffle (refranes);
            return refranes.get(0);
        }
        else if (text.contains("sorpresa") || (text.contains("wow")) || (text.contains("sorprendeme"))){
            //elegir un elemento aleatorio de la lista de sorpresas
            Collections.shuffle (sorpresas);
            return sorpresas.get(0);
        }
        else {
            Collections.shuffle (preguntas);
            return preguntas.get(0);
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

    private void leerCSV (){
        File file = Paths.get(System.getProperty("user.home"), "Desktop", "jLLM", "input.csv").toFile();
        String delimiter = ",";
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            for (String line : lines) {
                csvResponse response = getInstanceFromDelimitedString(line, delimiter);
                if (response == null) {
                    continue;
                }
                else
                if (response.getType().equals("refran")){
                    this.refranes.add(response.getMsg());
                }
                else if (response.getType().equals("sorpresa")){
                    this.sorpresas.add(response.getMsg());
                }
                else if (response.getType().equals("saludo")){
                    this.saludos.add(response.getMsg());
                }
                else if (response.getType().equals("despedida")){
                    this.despedidas.add(response.getMsg());
                }
                else if (response.getType().equals("afirmacion")){
                    this.afirmaciones.add(response.getMsg());
                }
                else if (response.getType().equals("negacion")){
                    this.negaciones.add(response.getMsg());
                }
                else if (response.getType().equals("pregunta")){
                    this.preguntas.add(response.getMsg());
                }
                else {continue;}
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

package Model;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class fakeModel implements ILLM, Serializable {

    private ArrayList<Chat> chats = new ArrayList<Chat>();
    private ArrayList<Message> mensajes = new ArrayList<Message>();

    // Constructor
    public fakeModel() {
    }

    // Generar respuesta
    @Override
    public String speak(String text) {
        text = text.toLowerCase();
        if (text.contains("hola")) {
            return "Hola, ¿qué tal?";
        } else if (text.contains("tal")) {
            return "Bien, ¿y tú?";
        } else if (text.contains("bien")) {
            return "Me alegro";
        } else if (text.contains("adiós")) {
            return "Hasta luego";
        } else if (text.contains("llamas")) {
            return "Me llamo LamentableLM a su servicio señor";
        } else if (text.contains("eres")) {
            return "Soy Reptiliano";
        } else if (text.contains("hacer")) {
            return "Nada, soy un chatbot lamentable";
        } else if (text.contains("hora")) {
            return "Son las " + java.time.LocalTime.now();
        } else if (text.contains("dia")) {
            return "Hoy es " + java.time.LocalDate.now();
        } else if (text.contains("tiempo")) {
            return "Hace sol";
        } else if (text.contains("vida")) {
            return "La vida es CR7";
        } else if (text.contains("amor")) {
            return "Al igual que un informatico, yo tampoco se que es el amor";
        } else if (text.contains("muerte")) {
            return "La muerte es el final de la vida";
        } else if (text.contains("felicidad")) {
            return "La felicidad es un estado de ánimo";
        } else if (text.contains("tristeza")) {
            return "La tristeza es un estado de ánimo";
        } else if (text.contains("amistad")) {
            return "La amistad es un sentimiento";
        } else if (text.contains("familia")) {
            return "La familia es un grupo de personas *Musica Toreto*";
        } else if (text.contains("soledad")) {
            return "Hablar con un chatbot";
        } else if (text.contains("alegria")) {
            return "La alegría es un estado de ánimo";
        } else if (text.contains("paz")) {
            return "No se dime tu";
        } else if (text.contains("guerra")) {
            return "La guerra es un conflicto armado entre dos o más grupos humanos";
        } else if (text.contains("salud")) {
            return "La salud es un estado de bienestar";
        } else if (text.contains("+") || text.contains("-") || text.contains("/") || text.contains("*")) {
            return "No soy una calculadora mister";
        } else if (text.contains("como")) {
            return "Comiendo lomo";
        } else if (text.contains("chiste")) {
            return "¿Qué le dice un jaguar a otro jaguar? Jaguar you?";
        } else if (text.contains("aleatorio")) {
            return "El numero aleatorio es: " + (int) (Math.random() * 100000000); // 0-100000000
        } else {
            return "No te entiendo";
        }
    }

    // Generar mensaje de respuesta
    @Override
    public Message createMessage(String text, String user) {
        String formattedTimestamp = Instant
                .now()
                .atZone(ZoneOffset.UTC)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        if (user == null) {
            return new Message(getIdentifier(), formattedTimestamp, text);
        } else {
            return new Message(user, formattedTimestamp, text);
        }
    }

    // Mostrat tipo de modelo
    @Override
    public String getIdentifier() {
        return "fakeModel";
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

}

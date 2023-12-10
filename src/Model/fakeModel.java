package Model;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class fakeModel implements ILLM, IRepository {
    
    private List<Message> messages = new ArrayList<Message>();
    
    public fakeModel() {
    }


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
        } else if (text.contains("+") || text.contains("-") || text.contains("/") || text.contains("*") ) {
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

    @Override
    public Message createMessage(String text) {
        String formattedTimestamp = Instant.now().atZone(java.time.ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Message message = new Message(getIdentifier(), formattedTimestamp, text);
        return message;
    }

    public void saveConversation(Message message) {
        messages.add(message);
    }

    public ArrayList<Message> listConversations() {
        return new ArrayList<>(messages);
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

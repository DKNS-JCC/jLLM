
package View;

import Controller.Controller;
import Model.Message;

import java.io.IOException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.coti.tools.Esdia;

import io.github.jonelo.jAdapterForNativeTTS.engines.SpeechEngine;
import io.github.jonelo.jAdapterForNativeTTS.engines.SpeechEngineNative;
import io.github.jonelo.jAdapterForNativeTTS.engines.Voice;
import io.github.jonelo.jAdapterForNativeTTS.engines.VoicePreferences;
import io.github.jonelo.jAdapterForNativeTTS.engines.exceptions.SpeechEngineCreationException;

public class TTSView extends View {

    private Controller c;

    public TTSView() {
        super();
    }

    @Override
    public void showAppStart(String message) {
        hablar(message);
    }

    @Override
    public void showAppEnd(String message) {
        hablar(message);
    }

    @Override
    public void showMainMenu() {
        int option = 0;
        do{
        clearScreen();
        hablar("A continuación le muestro las opciones disponibles");
        hablar("Pulse 1 para iniciar una conversación");
        System.out.println("1. Iniciar conversacion");
        hablar("Pulse 2 para ver el historial de conversaciones");
        System.out.println("2. Listar conversaciones");
        hablar("Pulse 3 para importar o exportar el historial de conversaciones");
        System.out.println("3. Importar/exportar conversaciones");
        hablar("Pulse 4 para salir");
        System.out.println("4. Salir");

        option = Esdia.readInt("Introduzca una opción: ", 1, 4);

        switch (option) {
            case 1:
                clearScreen();
                hablar("Ha seleccionado iniciar una conversación");
                startConversation();
                break;
            case 2:
                clearScreen();
                hablar("Ha seleccionado ver el historial de conversaciones");
                break;
            case 3:
                clearScreen();
                hablar("Ha seleccionado importar o exportar el historial de conversaciones");
                hablar("Pulse 1 para importar el historial de conversaciones");
                System.out.println("1. Importar historial de conversaciones");
                hablar("Pulse 2 para exportar el historial de conversaciones");
                System.out.println("2. Exportar historial de conversaciones");
                hablar("Pulse 3 para volver");
                System.out.println("3. Volver");
                option = Esdia.readInt("Introduzca una opción: ", 1, 3);
                switch (option) {
                    case 1:
                        clearScreen();
                        hablar("Ha seleccionado importar el historial de conversaciones");
                        break;
                    case 2:
                        clearScreen();
                        hablar("Ha seleccionado exportar el historial de conversaciones");
                        break;
                    case 3:
                        clearScreen();
                        hablar("Ha seleccionado volver");
                        break;
                }
                break;
            case 4:
                clearScreen();
                hablar("Ha seleccionado salir");
                System.out.println("                    _");
                System.out.println("               _  / |");
                System.out.println("              / \\ | | /\\");
                System.out.println("               \\ \\| |/ /");
                System.out.println("                \\ Y | /___");
                System.out.println("              .-.) '. `__/");
                System.out.println("             (.-.   / /");
                System.out.println("                 | ' |");
                System.out.println("                 |___|");
                System.out.println("                [_____]");
                System.out.println("                |     |");
                System.out.println("           HASTA LA PROXIMA!");

                break;
        }
    }while(option!=4);
    }

    private void hablar(String msg) {
        try {
            SpeechEngine speechEngine = SpeechEngineNative.getInstance();
            List<Voice> voices = speechEngine.getAvailableVoices();

            VoicePreferences voicePreferences = new VoicePreferences();
            voicePreferences.setLanguage("es");
            voicePreferences.setCountry("ES");
            voicePreferences.setGender(VoicePreferences.Gender.FEMALE);
            Voice voice = speechEngine.findVoiceByPreferences(voicePreferences);

            if (voice == null) {
                voice = voices.get(0); // default voice
            }

            speechEngine.setVoice(voice.getName());
            speechEngine.say(msg);
            try {
                Thread.sleep(msg.length() * 80); // Velocidad de habla entre mensajes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (SpeechEngineCreationException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void startConversation() {
        clearScreen();
        while (true) {
            String formattedTimestamp = Instant.now().atZone(java.time.ZoneOffset.UTC)
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            Message message = new Message(System.getProperty("user.name"), formattedTimestamp,
                    Esdia.readString_ne("Prompt: "));
            if (message.getContent().equals("/salir")) {
                break;
            }
            clearScreen();
            c.almacenaConversacion(message);
            Message response = c.sendMessage(message);
            hablar(response.getContent());
            c.almacenaConversacion(response);
            for (Message messagep : c.listConversations()) {
                System.out.println(String.format("%-15s | %-10s | %-20s", messagep.getDate(), messagep.getSender(),
                        messagep.getContent()));
            }
        }
    }

    // FUNCION CLEARSCREEN THX TO:
    // https://stackoverflow.com/questions/2979383/java-clear-the-console
    public final static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void setController(Controller controller) {
        this.c = controller;
    }
}

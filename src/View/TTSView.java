package View;

import Controller.Controller;
import Model.Chat;
import Model.Message;
import com.coti.tools.Esdia;
import io.github.jonelo.jAdapterForNativeTTS.engines.SpeechEngine;
import io.github.jonelo.jAdapterForNativeTTS.engines.SpeechEngineNative;
import io.github.jonelo.jAdapterForNativeTTS.engines.Voice;
import io.github.jonelo.jAdapterForNativeTTS.engines.VoicePreferences;
import io.github.jonelo.jAdapterForNativeTTS.engines.exceptions.SpeechEngineCreationException;
import java.io.IOException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TTSView extends View {

  private Controller c;

  public TTSView() {
    super();
  }

  @Override
  public void showAppStart(String message) {
    hablar(message);
    System.out.println("                   _");
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
    System.out.println("                 HOLA!");
  }

  @Override
  public void showAppEnd(String message) {
    System.out.println("                   _");
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
    hablar(message);
  }

  @Override
  public void showMainMenu() {
    int option = 0;
    do {
      clearScreen();
      hablar("Opciones disponibles");
      System.out.println("1. Iniciar conversacion");
      hablar("Pulse 1 para iniciar una conversación");
      System.out.println("2. Listar conversaciones");
      hablar("Pulse 2 para ver el historial de conversaciones");
      System.out.println("3. Importar/exportar conversaciones");
      hablar("Pulse 3 para importar o exportar el historial de conversaciones");
      System.out.println("4. Salir");
      hablar("Pulse 4 para salir");

      option = Esdia.readInt("Introduzca una opción: ", 1, 4);

      switch (option) {
        case 1:
          clearScreen();
          hablar("En que quieres que te ayude?");
          startConversation();
          break;
        case 2:
          clearScreen();
          hablar("Ha seleccionado ver el historial");
          listarChats();
          break;
        case 3:
          clearScreen();
          hablar("Ha seleccionado importar o exportar conversaciones");
          hablar("Pulse 1 para importar");
          System.out.println("1. Importar historial de conversaciones");
          hablar("Pulse 2 para exportar");
          System.out.println("2. Exportar historial de conversaciones");
          hablar("Pulse 3 para volver");
          System.out.println("3. Volver");
          option = Esdia.readInt("Introduzca una opción: ", 1, 3);
          switch (option) {
            case 1:
              clearScreen();
              hablar("Ha seleccionado importar el historial de conversaciones");
              if (c.importChat()) {
                hablar("importación correcta!\n");
              } else {
                hablar("Error al importar las conversaciones\n");
              }
              break;
            case 2:
              clearScreen();
              hablar("Ha seleccionado exportar el historial de conversaciones");
              if (c.exportChat()) {
                hablar("exportacion correcta!\n");
              } else {
                hablar("Error al exportar las conversaciones\n");
              }
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

          break;
      }
    } while (option != 4);
  }

  //Funcion para hablar
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
        Thread.sleep(msg.length() * 75); // Velocidad de habla entre mensajes
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
      Message message = c.crearMessage(
        Esdia.readString("Introduce un mensaje: ")
      );
      if (message.getContent().equals("/salir")) {
        break;
      }
      clearScreen();
      c.saveMessage(message);
      Message response = c.sendMessage(message);
      c.saveMessage(response);
      for (Message messagep : c.listChat()) {
        System.out.println(
          String.format(
            "%-15s | %-10s | %-20s",
            messagep.getDate(),
            messagep.getSender(),
            messagep.getContent()
          )
        );
      }
      hablar(response.getContent());
    }
    c.saveChat(); // Guarda la conversación actual
  }

  private void listarChats() {
    if (c.listChats().isEmpty()) {
      hablar("No hay conversaciones disponibles");
      System.out.println("-");
      hablar("Pulse cualquier tecla para volver.");
      Esdia.readString("...");
    } else {
      int option = 0;
      do {
        clearScreen();
        hablar("Estas son las conversaciones disponibles");
        int i = 1;
        for (Chat chat : c.listChats()) {
          System.out.println(
            String.format(
              "%d. | %-10s | %d mensajes | %-20s",
              i,
              chat.getMessages().get(0).getDate(),
              chat.getMessages().size(),
              chat.getMessages().get(0).getContent()
            )
          );
          i++;
        }
        System.out.println("");
        hablar("Pulse 1 para ver una conversación");
        System.out.println("1. Ver conversacion");
        hablar("Pulse 2 para borrar una conversación");
        System.out.println("2. Borrar conversacion");
        hablar("Pulse 3 para volver");
        System.out.println("3. Volver");
        option = Esdia.readInt("Introduce una opcion: ", 1, 3);
        switch (option) {
          case 1:
            hablar("Que conversación quieres ver?");
            option = Esdia.readInt("Introduce una opcion para ver: ");
            clearScreen();
            for (Message messagep : c
              .listChats()
              .get(option - 1)
              .getMessages()) {
              System.out.println(
                String.format(
                  "%-15s | %-10s | %-20s",
                  messagep.getDate(),
                  messagep.getSender(),
                  messagep.getContent()
                )
              );
            }
            hablar("Pulsa cualquier tecla para volver...");
            Esdia.readString("...");
            break;
          case 2:
            hablar("Que conversación quieres borrar?");
            option = Esdia.readInt("Introduce una opcion para borrar: ");
            for (Message messagep : c
              .listChats()
              .get(option - 1)
              .getMessages()) {
              System.out.println(
                String.format(
                  "%-15s | %-10s | %-20s",
                  messagep.getDate(),
                  messagep.getSender(),
                  messagep.getContent()
                )
              );
            }
            hablar("Confima que quieres borrar esta conversación");
            String confirm = Esdia.readString_ne(
              "¿Estas seguro de que quieres borrar esta conversacion? (s/N): "
            );
            if (confirm.equals("s") || confirm.equals("S")) {
              c.listChats().remove(option - 1);
              hablar("Conversacion borrada");
              hablar("Pulsa cualquier tecla para volver...");
              Esdia.readString("...");
            } else {
              hablar("Conversacion no borrada");
              hablar("Pulsa cualquier tecla para volver...");
              Esdia.readString("...");
            }
            clearScreen();
            break;
          case 3:
            break;
          default:
            hablar("SELECCIONA UNA OPCIÓN VÁLIDA");
        }
      } while (option != 3 && !c.listChats().isEmpty());
    }
  }

  // FUNCION CLEARSCREEN THX TO:
  // https://stackoverflow.com/questions/2979383/java-clear-the-console
  public static final void clearScreen() {
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

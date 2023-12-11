/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Controller;
import Model.Message;
import Model.Chat;

import com.coti.tools.Esdia;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author jorge
 */
public class ConsoleView extends View {

    private Controller c;

    public ConsoleView() {
        super();
    }

    @Override
    public void setController(Controller controller) {
        this.c = controller;
    }

    @Override
    public void showAppStart(String message) {
        System.out.println(message);
    }

    @Override
    public void showAppEnd(String message) {
        System.out.println(message);
    }

    @Override
    public void showMainMenu() {
        int option = 0;

        do {
            System.out.println("1. Iniciar conversacion");
            System.out.println("2. Listar conversaciones");
            System.out.println("3. Importar/exportar conversaciones");
            System.out.println("4. Salir");

            option = Esdia.readInt("Introduce una opcion: ");

            switch (option) {
                case 1:
                    clearScreen();
                    startConversation();
                    // c.saveChat();
                    break;
                case 2:
                    clearScreen();
                    listarChats();
                    break;

                case 3:
                    clearScreen();
                    do {
                        System.out.println("1. Importar conversaciones");
                        System.out.println("2. Exportar conversaciones");
                        System.out.println("3. Volver");

                        option = Esdia.readInt("Introduce una opcion: ");

                        switch (option) {
                            case 1:
                                clearScreen();
                                // c.importChat();
                                break;
                            case 2:
                                clearScreen();
                                // c.exportChat();
                                break;
                            case 3:
                                clearScreen();
                                break;
                            default:
                                System.out.println("Opcion incorrecta");
                        }
                    } while (option != 3);

                    break;

                case 4:
                    clearScreen();
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (option != 4);

    }

    public void startConversation() {
        clearScreen();
        while (true) {
            Message message = c.crearMessage(Esdia.readString("Introduce un mensaje: "));
            if (message.getContent().equals("/salir")) {
                break;
            }
            clearScreen();
            c.saveMessage(message);
            Message response = c.sendMessage(message);
            c.saveMessage(response);
            for (Message messagep : c.listChat()) {
                System.out.println(String.format("%-15s | %-10s | %-20s", messagep.getDate(), messagep.getSender(),
                        messagep.getContent()));
            }
        }
        c.saveChat(); // Guarda la conversación actual
    }

    private void listarChats() {
        if (c.listChats().isEmpty()) {
            System.out.println("No hay conversaciones disponibles");
            Esdia.readString("Pulsa cualquier tecla para volver...");
        } else {

            System.out.println("Conversaciones disponibles:");
            int i = 0;
            for (Chat chat : c.listChats()) {
                System.out.println(String.format("%d. | %-15s | %-20s", i, chat.getLlname(), chat.getMessages().get(0).getContent()));
                i++;
            }
            System.out.println("");
            System.out.println("1. Ver conversacion");
            System.out.println("2. Borrar conversacion");
            System.out.println("3. Volver");
            int option = Esdia.readInt("Introduce una opcion: ", 1, 3);
            switch (option) {
                case 1:
                    option = Esdia.readInt("Introduce una opcion para ver: ");
                    break;
                case 2:
                    option = Esdia.readInt("Introduce una opcion para borrar: ");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcion incorrecta");
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
}

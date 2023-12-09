/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Controller;
import Model.Message;

import com.coti.tools.Esdia;
import com.coti.tools.Esdia.*;
import java.time.Instant;

/**
 *
 * @author jorge
 */
public class ConsoleView extends View {

    Controller c;

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
            System.out.println("3. Salir");

            option = Esdia.readInt("Introduce una opcion: ");

            switch (option) {
                case 1:
                    clearScreen();    
                    startConversation();
                    // saveChat();
                    break;
                case 2:
                    clearScreen();
                    // c.listChat();
                    break;
                case 3:
                    clearScreen();
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (option != 3);
    }

    public void startConversation() {
        clearScreen();
        while (true) {
            Message message = new Message(System.getProperty("user.name"), Instant.now(), Esdia.readString_ne("Prompt: "));
            if (message.getContent().equals("/salir")) {
                break;
            }
            clearScreen();
            c.almacenaConversacion(message);
            Message response = c.sendMessage(message);
            c.almacenaConversacion(response);
            for (Message messagep : c.listConversations()) {
                System.out.println(String.format("%-35s | %20s | %-20s", messagep.getDate(), messagep.getSender(), messagep.getContent()));
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

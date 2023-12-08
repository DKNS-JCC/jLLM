/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Controller;
import Model.Message;

import com.coti.tools.Esdia;
import com.coti.tools.Esdia.*;

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
                    c.startConversation();
                    break;
                case 2:
                    c.listConversations();
                    break;
                case 3:
                    System.out.println("Hasta la proxima!");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (option != 3);
    }

    public void showStartConversation() {
        System.out.println("Bienvenido, soy LamentableLM, en que puedo ayudarte?");
    }
}


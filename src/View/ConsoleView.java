/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author jorge
 */
public class ConsoleView extends View {
    
    public ConsoleView(){
        super();
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
        System.out.println("1. Iniciar conversacion");
        System.out.println("2. Salir");
    }
}

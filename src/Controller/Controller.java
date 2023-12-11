/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.ConsoleView;
import View.TTSView;
import View.View;
import Model.fakeModel;
import Model.csvModel;
import Model.Message;

import java.util.ArrayList;

import Model.ILLM;
import Model.IRepository;

/**
 *
 * @author jorge
 */
public class Controller {
    View view;
    IRepository repository;
    ILLM model;

    public Controller(View viewType, IRepository repositoryType, ILLM modelType) {
        this.view = viewType;
        this.repository = repositoryType;
        this.model = modelType;
        view.setController(this);
    }

    public void initApplication() {
        view.showAppStart("Hola, bienvenido a LamentableLM estoy a su servicio");
        view.showMainMenu();
        view.showAppEnd("Hasta la próxima! Gracias por usar LamentableLM");
    }

    //We need to implement this method
    public Message sendMessage(Message messagerecieved) {
        String response = model.speak(messagerecieved.getContent());
        Message response2 = model.createMessage(response);
        return response2;
    }

    public void almacenaConversacion(Message message) {
        model.saveConversation(message);
    }

    public ArrayList<Message> listConversations (){
        ArrayList <Message> messages = model.listConversations();
        return messages;
    }

    public void exportarChat(){
        
    }


}

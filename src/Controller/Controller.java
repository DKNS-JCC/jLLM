/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.View;
import Model.Message;
import Model.Chat;

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

    //Constructor
    public Controller(View viewType, IRepository repositoryType, ILLM modelType) {
        this.view = viewType;
        this.repository = repositoryType;
        this.model = modelType;
        view.setController(this);
    }

    //Inicio de la aplicación
    public void initApplication() {
        view.showAppStart("Hola, bienvenido a LamentableLM estoy a su servicio");
        view.showMainMenu();
        view.showAppEnd("Hasta la próxima! Gracias por usar LamentableLM");
    }

    //Envio y respuesta de mensajes
    public Message sendMessage(Message messagerecieved) {
        String response = model.speak(messagerecieved.getContent());
        Message response2 = model.createMessage(response);
        return response2;
    }

    public Message crearMessage(String content) {
        Message message = model.createMessage(content);
        return message;
    }

    //Guardado de mensaje
    public void saveMessage(Message message) {
        repository.saveMessage(message);
    }

    //Listado de mensajes
    public ArrayList<Message> listChat (){
        return repository.listChat();
    }

    public void getIdentifier(){
        repository.setIdentifier(model.getIdentifier())
    }

    //Guardado de conversación
    public void saveChat(){
        repository.saveChat();
    }

    //Listado de conversaciones
    public ArrayList<Chat> listChats(){
        return repository.listChats();
    }

}

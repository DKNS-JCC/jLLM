/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Chat;
import Model.ILLM;
import Model.IRepository;
import Model.Message;
import View.View;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

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
    //Ruta del archivo binario
    File file = Paths
      .get(System.getProperty("user.home"), "Desktop", "jLLM", "output.bin")
      .toFile();
    view.showAppStart("Hola, bienvenido a javaLLM estoy a su servicio");
    if (file.exists() && file.length() > 0) {
      model = cargarModelo(file);
    }
    view.showMainMenu();
    guardarModelo(model, file);
    view.showAppEnd("Hasta la próxima! Gracias por usar javaLLM");
  }

  //Guardado del modelo serializado
  public static void guardarModelo(ILLM modelo, File file) {

    try (
      ObjectOutputStream salida = new ObjectOutputStream(
        new FileOutputStream(file)
      )
    ) {
      salida.writeObject(modelo);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //Carga del modelo serializado
  public static ILLM cargarModelo(File file) {
    ILLM modelo = null;

    try (
      ObjectInputStream entrada = new ObjectInputStream(
        new FileInputStream(file)
      )
    ) {
      modelo = (ILLM) entrada.readObject();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }

    return modelo;
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
    model.saveMessage(message);
  }

  //Listado de mensajes
  public ArrayList<Message> listChat() {
    return model.listChat();
  }

  //Guardado de conversación
  public void saveChat() {
    model.saveChat();
  }

  //Listado de conversaciones
  public ArrayList<Chat> listChats() {
    return model.listChats();
  }

  //Exportar conversación
  public boolean exportChat() {
    ArrayList<Chat> chats = model.listChats();
    return repository.exportChat(chats);
  }

  //Importar conversación
  public boolean importChat() {
    ArrayList<Chat> chats = repository.importChat();
    model.setChats(chats);
    return true;
  }
}

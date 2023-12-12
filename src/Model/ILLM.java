package Model;

import java.util.ArrayList;

public interface ILLM 
{
    //devuelve el mensaje que se va a enviar
    public String speak (String text);
    //devuelve el identificador del modelo
    public String getIdentifier();
    //crea un mensaje (remitente, fecha, contenido)
    public Message createMessage(String text, String user);
    //guarda un mensaje
    public void saveMessage(Message message);
    //lista los mensajes
    public ArrayList<Message> listChat();
    //lista las conversaciones
    public ArrayList<Chat> listChats();
    //guarda la conversación
    public void saveChat();
    //establece las conversaciones para importar
    public void setChats(ArrayList<Chat> chats_n);

}

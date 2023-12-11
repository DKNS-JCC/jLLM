package Model;

public interface ILLM 
{
    //devuelve el mensaje que se va a enviar
    public String speak (String text);
    //devuelve el identificador del modelo
    public String getIdentifier();
    //crea un mensaje (remitente, fecha, contenido)
    public Message createMessage(String text);
}

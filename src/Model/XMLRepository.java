package Model;


import java.util.ArrayList;

public class XMLRepository implements IRepository  
{
    public XMLRepository() {
    }

    public boolean exportarChat(ArrayList<Chat> chats){
        return true;
    }

    public ArrayList<Chat> importarChat(){
        return new ArrayList<Chat>();
    }
}

package Model;


import java.util.ArrayList;

public class XMLRepository implements IRepository  
{
    public XMLRepository() {
    }

    public boolean exportChat(ArrayList<Chat> chats){
        
        return true;
    }

    public ArrayList<Chat> importChat(){
        return new ArrayList<Chat>();
    }

}

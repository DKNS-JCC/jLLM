package Model;
import java.util.ArrayList;

/**
 *
 * @author jorge
 */
public interface PersistenceRepository {
    public ArrayList<Chat> importarChat();
    public boolean exportarChat(ArrayList<Chat> chats);
}

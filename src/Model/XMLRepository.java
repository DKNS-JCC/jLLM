package Model;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class XMLRepository implements IRepository {

  public XMLRepository() {}

  public boolean exportChat(ArrayList<Chat> chats) {
    XmlMapper mapper = new XmlMapper();
    Path ruta = Paths.get(
      System.getProperty("user.home"),
      "Desktop",
      "jLLM",
      "output.xml"
    );
    File file = ruta.toFile();
    try {
      mapper.writeValue(file, chats);
    } catch (Exception e) {
      System.out.println("Error al exportar el chat");
      return false;
    }
    return true;
  }

  public ArrayList<Chat> importChat() {
    Path ruta = Paths.get(
      System.getProperty("user.home"),
      "Desktop",
      "jLLM",
      "output.xml"
    );
    File file = ruta.toFile();
    return new ArrayList<Chat>();
  }
}

package Model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JSONRepository implements IRepository {

  public JSONRepository() {}

  @Override
  public boolean exportChat(ArrayList<Chat> chats) {
    Gson gson = new Gson();
    String json = gson.toJson(chats);

    Path ruta = Paths.get(
      System.getProperty("user.home"),
      "Desktop",
      "jLLM",
      "output.json"
    );

    File file = ruta.toFile();

    try (PrintWriter pw = new PrintWriter(file)) {
      pw.println(json);
      return true;
    } catch (Exception e) {
      System.out.println("Error al exportar el chat");
      return false;
    }
  }

  @Override
  public ArrayList<Chat> importChat() {
    Path ruta = Paths.get(
      System.getProperty("user.home"),
      "Desktop",
      "jLLM",
      "output.json"
    );

    File file = ruta.toFile();

    if (file.exists()) {
      Gson gson = new Gson();
      try {
        String json = new String(Files.readAllBytes(ruta));
        return gson.fromJson(
          json,
          new TypeToken<ArrayList<Chat>>() {}.getType()
        );
        
      } catch (Exception e) {
        System.out.println("Error al importar el chat" + e.getMessage());
      }
    } else {
      System.out.println("El archivo no existe en la ruta" + ruta);
    }
    return null;
  }
}

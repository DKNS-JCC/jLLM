package View;
import com.coti.tools.Esdia;

//Clase encargada de seleccionar los modos de uso iniciales
public class TempView {
    public TempView(){

    }

    public String showPreMainMenu() {
        String retorno = "";
        System.out.println("Uso: java -jar jllm.jar <Repository Type> <Model Type> <View Type>");
        System.out.println("\nINICIANDO INTERFAZ DE CONFIGURACION BASICA...");
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clearScreen();
        System.out.println("SELECTOR DE REPOSITORIO:");
        System.out.println("1. XML");
        System.out.println("2. JSON");
        System.out.println("3. CSV");

        int option = Esdia.readInt("Introduce una opcion: ", 1,3);

        switch (option){
            case 1: 
                retorno += "xml";
                break;
            case 2:
                retorno += "json";
                break;
            case 3:
                retorno += "csv";
                break;
        }
        clearScreen();
        System.out.println("SELECTOR DE MODELO:");
        System.out.println("1. Fake");
        System.out.println("2. csvModel");
        System.out.println("3. Smart");

        option = Esdia.readInt("Introduce una opcion: ", 1,3);

        switch (option){
            case 1: 
                retorno += " fake";
                break;
            case 2:
                retorno += " csv";
                break;
            case 3:
                retorno += " smart";
                break;
        }
        clearScreen();

        System.out.println("SELECTOR DE VISTA:");
        System.out.println("1. Consola");
        System.out.println("2. Voz");

        option = Esdia.readInt("Introduce una opcion: ", 1,2);

        switch (option){
            case 1: 
                retorno += " consola";
                break;
            case 2:
                retorno += " voz";
                break;
        }

        return retorno;
    }

    public static final void clearScreen() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

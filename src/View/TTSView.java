
package View;


public class TTSView extends View {
    
    public TTSView(){
        super();
    }

    @Override
    public void showAppStart(String message) {
        System.out.println(message);
    }

    @Override
    public void showAppEnd(String message) {
        System.out.println(message);
    }

    @Override
    public void showMainMenu() {
        System.out.println("1. Iniciar conversacion");
        System.out.println("2. Salir");
    }
}

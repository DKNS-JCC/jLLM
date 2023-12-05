
package jllm;
import View.View;
import Model.Model;
import Controller.Controller;
import Model.PersistenceRepository;


/**
 *
 * @author jorge
 */
public class JLLM {


    public static void main(String[] args) {
        View view;
        Model model;
        PersistenceRepository repository;

        
        if(args.length == 3){
            view = getViewForoption(args[2]);
            repository = getRepositoryForOption(args[0]);
            model = getModelForOption(args[1]);
            System.out.println("Iniciando app en modo "+ args[0]+","+ args[1]+","+ args[2]);
            
        }else{
            // Opciones por defecto:
            System.out.println("Se esperaba llamada con 3 argumentos, creando en default");
            view = new ConsoleView();
            repository = new MemoryRepository();
            model = new fakeModel();
            
        }
        
        Controller c = new Controller(model, view, repository);
        
        c.initApplication();  
    }

    private static View getViewForoption(String arg) {
        switch (arg) {
            case "consola":
                return new ConsoleView();
            case "voz":
                return new TTSView();
            default:
                return new ConsoleView();
        }
    }
    private static PersistenceRepository getRepositoryForOption(String arg){
        switch (arg){
            case "xml":
                return new XMLRepository();
            case "json":
                return new JSONRepository();
            default:
                return new XMLRepository();
        }
    }
    private static Model getModelForOption(String arg){
        switch (arg){
            case "fake":
                return new fakeModel();
            case "csv":
                return new CSVModel();
            case "smart":
                return new smartModel();
            default:
                return new fakeModel();
        }
    }
    
}

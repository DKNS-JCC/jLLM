
package jllm;

import View.View;
import View.ConsoleView;
import View.TTSView;
import Model.fakeModel;
import Model.csvModel;
import Model.XMLRepository;
import Model.JSONRepository;
import Controller.Controller;
import Model.ILLM;
import Model.IRepository;

/**
 *
 * @author jorge
 */
public class Main {

    public static void main(String[] args) {
        View view;
        IRepository repository;
        ILLM modelType;

        if (args.length == 3) {
            view = getViewForOption(args[2]);
            repository = getRepositoryForOption(args[0]);
            modelType = getModelForOption(args[1]);

        } else {
            // Opciones por defecto
            view = new ConsoleView();
            repository = new XMLRepository();
            modelType = new fakeModel();
        }

        Controller c = new Controller(view, repository, modelType);

        c.initApplication();
    }

    private static View getViewForOption(String arg) {
        switch (arg) {
            case "consola":
                return new ConsoleView();
            case "voz":
                return new TTSView();
            default:
                return new ConsoleView();
        }
    }

    private static IRepository getRepositoryForOption(String arg) {
        switch (arg) {
            case "xml":
                return new XMLRepository();
            case "json":
                return new JSONRepository();
            default:
                return new XMLRepository();
        }
    }

    private static ILLM getModelForOption(String arg) {
        switch (arg) {
            case "fake":
                return new fakeModel();
            case "csv":
                return new csvModel();
            case "smart":
                // return new smartModel();
            default:
                return new fakeModel();
        }
    }

}

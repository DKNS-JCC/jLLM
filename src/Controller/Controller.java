/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.ConsoleView;
import View.TTSView;
import View.View;
import Model.fakeModel;
import Model.csvModel;
import Model.ILLM;
import Model.IRepository;

/**
 *
 * @author jorge
 */
public class Controller {
    View view;
    IRepository repository;
    ILLM modelType;

    public Controller(View viewType, IRepository repositoryType, ILLM modelType) {
        this.view = viewType;
        this.repository = repositoryType;
        this.modelType = modelType;
        view.setController(this);
    }

    public void initApplication() {
        view.showAppStart("Bienvenido a LamentableLM");
        view.showMainMenu();
        view.showAppEnd("Hasta la proxima!");
    }

    public void startConversation (){
        
        
    }


}

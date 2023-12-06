/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Model;
import View.View;
import Model.IRepository;



/**
 *
 * @author jorge
 */
public class Controller extends View {
    View view;
    Model model;
    IRepository repository;
    public Controller (Model model, View view, IRepository repository)
    {
        super(model, view, repository);
    }

    public void initApplication() {
        view.showAppStart("Bienvenido a LamentableLM");
        view.showMainMenu();
        view.showAppEnd("Hasta la proxima!");
    }
}

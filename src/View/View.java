
package View;


import Controller.Controller;


public abstract class View {
    
    protected Controller c;
    
    public abstract void showAppStart(String msg);
    public abstract void showMainMenu();
    public abstract void showAppEnd(String msg);
    
}

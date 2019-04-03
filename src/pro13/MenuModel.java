package pro13;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MenuModel {
    private PropertyChangeSupport support;

    public MenuModel() {
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }
}


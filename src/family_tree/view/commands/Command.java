package family_tree.view.commands;

import java.io.Serializable;

import family_tree.view.View;

public abstract class Command implements Serializable{
    private String description;
    private View view;
    
    public Command(String description, View view)
    {
        this.description = description;
        this.view = view;
    }

    public String getDescription()
    {
        return description;
    }

    View getView()
    {
        return view;
    }
    public abstract void execute();
}

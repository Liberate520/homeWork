package homeWork.src.view.commands2;

import homeWork.src.view.View2;

public abstract class Command2 {
    private String description2;
    private View2 view2;
    public Command2(String description2, View2 view2){
        this.description2 = description2;
        this.view2 = view2;
    }

    public String getDescription2(){
        return description2;
    }

    View2 getView2(){
        return view2;
    }

    public abstract void execute();

}

package FamTree;

import java.io.Serializable;

public class Human implements Serializable {
    public String humanName;
    public int humanAge;

    public Human(String humanName, int humanAge){
        this.humanName = humanName;
        this.humanAge = humanAge;
    }

    public String getHumanName(){
        return humanName;
    }

}

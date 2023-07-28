package FamTree;

public class Human {
    public String humanName;
    public int humanAge;

    public Human(String humanName, int humanAge){
        this.humanName = humanName;
        this.humanAge = humanAge;
    }

    public String getHumanName(){
        return humanName;
    }

    public void setHumanName(String humanName){
        this.humanName = humanName;
    }

    public int getHumanAge(){
        return humanAge;
    }
    public void setHumanAge(int humanAge){
        this.humanAge = humanAge;
    }
}

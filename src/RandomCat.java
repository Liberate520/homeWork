import java.util.Random;

public class RandomCat {
    
    private String name;

    public RandomCat(){
        int i = new Random().nextInt(1,5);
        if (i == 1) name = "Василий";
        else if (i == 2) name = "Борис";
        else if (i == 3) name = "Тихон";
        else if (i == 4) name = "Бaрсик"; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

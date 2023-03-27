package model;
import java.util.List;

public class Individual {
    private String name;
    private Gender gender;
    private Integer yearofbirth;
    private Individual father;
    private Individual mother;
    private List<Individual> children;

    
    public Individual() {
    }


    public String getName() {
        return name;
    }

    public Integer getYearofbirth() {
        return yearofbirth;
    }

    
      
    // private String getChildrenInfo(){
    //     StringBuilder res = new StringBuilder();
    //     res.append("children: ");
    //     if (children.size() != 0){
    //         res.append(children.get(0).getName());
    //         for(int i = 1; i < children.size(); i++){
    //             res.append(", ");
    //             res.append(children.get(i).getName());
    //         }
    //     } else {
    //         res.append("no");
    //     }
    //     return res.toString();
    // }

    public Individual getFather() {
        return father;
    }

    public Individual getMother() {
        return mother;
    }

    public String getInfo() {
        return String.format("Имя: %s; Пол: %s; Год рождения: %d; Отец: %s; Мать: %s.", name, gender, yearofbirth, getFather(), getMother());
    }   

    public boolean addChild(Individual child){
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }
    

}

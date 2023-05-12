package Семинар1.homeWork;

import java.util.List;

public class Presenter {
    public Human CreateHuman(List<String> data){
        if (data.get(0).equals("")){
            System.out.println("Введено слишком мало данных");
        return null;  }

         
          
        
        else{
        Human new_person = new Human(data.get(0), 
                                         data.get(1), 
                                         data.get(2), 
                                         data.get(3), 
                                         data.get(4), 
                                         data.get(5), 
                                         data.get(6), 
                                         data.get(7));
            return new_person;
        
    }
    
}
}

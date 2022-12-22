package Семинар1.homeWork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.SourceDataLine;

public class Tree  implements Saveandreadable{
    
    ArrayList<Human> family;
    
    public Tree(ArrayList<Human> list){
        this.family = list;
    }
    public Tree(){
        this(null);
    }

// На случай, если нужен результат
public Human find_father(List<Human> family, Human person){
    Human res = null;
    String father_id = person.getFather_id();
    if(father_id == null){
        System.out.println("Отца нет");
        
    }
    else{
        for(Human relative : family){
            if(father_id.equals(relative.getPerson_id())){
                res = relative;
            }
        }
        
    }
    return res;

}

public Human find_mother(List<Human> family, Human person){
    Human res = null;
    String mother_id = person.getMother_id();
    if(mother_id == null){
        System.out.println("Матери нет");
        
    }
    else{
        for(Human relative : family){
            if(mother_id.equals(relative.getPerson_id())){
                res = relative;
            }
        }
        
    }
    return res;

}

public ArrayList<Human> find_sister_and_brother(List<Human> family, Human person){
    ArrayList<Human> res = new ArrayList<>();
    String mother_id = person.getMother_id();
    String father_id = person.getFather_id();
    if(mother_id == null && father_id == null){
        System.out.println("Установить не возможно");
    }
    else{
        for(Human relative : family){
            if((mother_id.equals(relative.getMother_id()) || father_id.equals(relative.getFather_id())) && !person.getPerson_id().equals(relative.getPerson_id())){
                res.add(relative);
            }
        }
    }
    try{
        res.get(0);
        return res;
    }
    catch (IndexOutOfBoundsException e) {
        System.out.println("Братьев и сестер обнаружить не получилось");
        return res;
    }

}
// На случай, если нужен только вывод
public void print_father(List<Human> family, Human person){
    Human res = null;
    String father_id = person.getFather_id();
    if(father_id == null){
        System.out.println("Отца нет");
        
    }
    else{
        for(Human relative : family){
            if(father_id.equals(relative.getPerson_id())){
                res = relative;
            }
        }
        System.out.println(res);
        
    }
    
}

public void print_mother(List<Human> family, Human person){
    Human res = null;
    String mother_id = person.getMother_id();
    if(mother_id == null){
        System.out.println("Матери нет");
        
    }
    else{
        for(Human relative : family){
            if(mother_id.equals(relative.getPerson_id())){
                res = relative;
            }
        }
        System.out.println(res);
    }
    

}


public static void print_sister_and_brother(List<Human> family, Human person){
    ArrayList<Human> res = new ArrayList<>();
    String mother_id = person.getMother_id();
    String father_id = person.getFather_id();
    if(mother_id == null && father_id == null){
        System.out.println("Установить не возможно");
    }
    else{
        for(Human relative : family){
            if((mother_id.equals(relative.getMother_id()) || father_id.equals(relative.getFather_id())) && !person.getPerson_id().equals(relative.getPerson_id())){
                res.add(relative);
            }
        }
    }
    try{
        res.get(0);
        System.out.println(res);
        
    }
    catch (IndexOutOfBoundsException e) {
        System.out.println("Братьев и сестер обнаружить не получилось");
        
    }
    
}

@Override
public void print_info(ArrayList<Human> family) throws IOException{
    FileWriter file = new FileWriter("family.txt", true);
    for(Human relative : family){
        file.write("\n" +  relative);
    }
    file.close();
 

}
private static String[] txt_parse(String txtstring){
    String [] str = txtstring.split(": ");
    return str;
}

public static void age(Human person){
    java.util.Date dateNow = new java.util.Date();
    DateFormat formater = new SimpleDateFormat("y");
    Integer year = Integer.parseInt(formater.format(dateNow));
    Integer b_year = Integer.parseInt(person.getBirthDate().substring(6,10));
    Integer res_age = year - b_year;
    System.out.println(res_age);

}

@Override
public void read_info(ArrayList<Human> family, String file_name) throws IOException{
    File file = new File(file_name);
        FileReader fr = new FileReader(file);
        BufferedReader breader = new BufferedReader(fr);
        String line = breader.readLine();
        List<String> data = new ArrayList<>();
        while(line != null){
            while(!line.equals("Следующий человек")){
                switch(txt_parse(line)[0]){
                    case "Имя":
                        String firstname = txt_parse(line)[1];
                        data.add(firstname);
                        break;
                    case "Фамилия":
                        String lastname = txt_parse(line)[1];
                        data.add(lastname);
                        break;
                    case "Дата рождения":
                        String birth_date = txt_parse(line)[1];
                        data.add(birth_date);
                        break;
                    case "Дата смерти":
                        String deth_date = txt_parse(line)[1];
                        data.add(deth_date);
                        break;
                    case "Пол":
                        String gender = txt_parse(line)[1];
                        data.add(gender);
                        break;
                    case "Идентификационный номер":
                        String person_id = txt_parse(line)[1];
                        data.add(person_id);
                        break;
                    case "Отец":
                        String father_id = txt_parse(line)[1];
                        data.add(father_id);
                        break;    
                    case "Мать":
                        String mother_id = txt_parse(line)[1];
                        data.add(mother_id );
                        break;
                }
            
            line = breader.readLine();
        
    }
        Human new_person = new Human(data.get(0), 
                                     data.get(1), 
                                     data.get(2), 
                                     data.get(3), 
                                     data.get(4), 
                                     data.get(5), 
                                     data.get(6), 
                                     data.get(7));
        family.add(new_person);

    line = breader.readLine();
   
    }
    
}
@Override
public String toString() {
    // TODO Auto-generated method stub
    return super.toString();
}



}
    

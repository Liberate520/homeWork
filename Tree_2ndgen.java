package Семинар1.homeWork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

// Сделать наследованием от первого класса
public class Tree_2ndgen extends Tree_1rstgen {
    
    private String father_id;
    
    private String mother_id;
    List<Tree_2ndgen> family;

    
    
    public Tree_2ndgen(String inp_firstname, String inp_lastname, String inp_birth_date, String inp_deth_date, String inp_gender, String inp_person_id, String inp_father_id, String inp_mother_id, String inp_child_id){
        super(inp_firstname, inp_lastname, inp_birth_date, inp_deth_date, inp_gender, inp_person_id, inp_child_id);
        this.father_id = inp_father_id;
        this.mother_id = inp_mother_id;

    }
    public Tree_2ndgen(String inp_firstname, String inp_lastname, String inp_birth_date, String inp_gender, String inp_person_id){
        this(inp_firstname, inp_lastname, inp_birth_date, null, inp_gender, inp_person_id, null, null, null);

    }
    // Нужно прописать способ, чтобы null проставлялся как  - и изучить формат даты, в том числе, как их в f-строку записывать
    @Override
    public String toString() {
        return super.toString();
    }

    public String getFather_id() {
        return father_id;
    }
    public void setFather_id(String father_id) {
        this.father_id = father_id;
    }

    public String getMother_id() {
        return mother_id;
    }
    public void setMother_id(String mother_id) {
        this.mother_id = mother_id;
    }
    
    
    // На случай, если нужен результат
    public Tree_2ndgen find_father(List<Tree_2ndgen> family, Tree_2ndgen person){
        Tree_2ndgen res = null;
        father_id = person.getFather_id();
        if(mother_id == null){
            System.out.println("Отца нет");
            
        }
        else{
            for(Tree_2ndgen relative : family){
                if(father_id.equals(relative.getPerson_id())){
                    res = relative;
                }
            }
            
        }
        return res;

    }

    public Tree_2ndgen find_mother(List<Tree_2ndgen> family, Tree_2ndgen person){
        Tree_2ndgen res = null;
        mother_id = person.getMother_id();
        if(mother_id == null){
            System.out.println("Матери нет");
            
        }
        else{
            for(Tree_2ndgen relative : family){
                if(mother_id.equals(relative.getPerson_id())){
                    res = relative;
                }
            }
            
        }
        return res;

    }
    
    public ArrayList<Tree_2ndgen> find_sister_and_brother(List<Tree_2ndgen> family, Tree_2ndgen person){
        ArrayList<Tree_2ndgen> res = new ArrayList<>();
        mother_id = person.getMother_id();
        father_id = person.getFather_id();
        if(mother_id == null && father_id == null){
            System.out.println("Установить не возможно");
        }
        else{
            for(Tree_2ndgen relative : family){
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
    public void print_father(List<Tree_2ndgen> family, Tree_2ndgen person){
        Tree_2ndgen res = null;
        father_id = person.getFather_id();
        if(mother_id == null){
            System.out.println("Отца нет");
            
        }
        else{
            for(Tree_2ndgen relative : family){
                if(father_id.equals(relative.getPerson_id())){
                    res = relative;
                }
            }
            System.out.println(res);
            
        }
        
    }

    public void print_mother(List<Tree_2ndgen> family, Tree_2ndgen person){
        Tree_2ndgen res = null;
        mother_id = person.getMother_id();
        if(mother_id == null){
            System.out.println("Матери нет");
            
        }
        else{
            for(Tree_2ndgen relative : family){
                if(mother_id.equals(relative.getPerson_id())){
                    res = relative;
                }
            }
            System.out.println(res);
        }
        

    }


    public void print_sister_and_brother(List<Tree_2ndgen> family, Tree_2ndgen person){
        ArrayList<Tree_2ndgen> res = new ArrayList<>();
        mother_id = person.getMother_id();
        father_id = person.getFather_id();
        if(mother_id == null && father_id == null){
            System.out.println("Установить не возможно");
        }
        else{
            for(Tree_2ndgen relative : family){
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


    public void print_family(List<Tree_2ndgen> family) throws IOException{
        FileWriter file = new FileWriter("family.txt", true);
        for(Tree_2ndgen relative : family){
            file.write("\n" +  relative);
        }
        file.close();
     

    }
    private static String[] txt_parse(String txtstring){
        String [] str = txtstring.split(": ");
        return str;
    }


   
    public  void read_info(List<Tree_2ndgen> family, String file_name) throws IOException{
       
        File file = new File(file_name);
        FileReader fr = new FileReader(file);
        BufferedReader breader = new BufferedReader(fr);
        String line = breader.readLine();
        
        while(line != null){
            while(!line.equals("Следующий человек")){
                switch(txt_parse(line)[0]){
                    case "Имя":
                        super.firstname = txt_parse(line)[1];
                        break;
                    case "Фамилия":
                        super.lastname = txt_parse(line)[1];
                        break;
                    case "Дата рождения":
                        super.birth_date = txt_parse(line)[1];
                        break;
                    case "Дата смерти":
                        super.deth_date = txt_parse(line)[1];
                        break;
                    case "Пол":
                        gender = txt_parse(line)[1];
                        break;
                    case "Идентификационный номер":
                        super.person_id = txt_parse(line)[1];
                        break;
                    case "Отец":
                        this.father_id = txt_parse(line)[1];
                        break;    
                    case "Мать":
                        this.mother_id = txt_parse(line)[1];
                        break;
                    case "Ребенок":
                        super.child_id = txt_parse(line)[1];
                        break;
                }
            line = breader.readLine();
        
    }
        Tree_2ndgen new_person = new Tree_2ndgen(firstname, lastname, birth_date, deth_date, gender, person_id, father_id, mother_id, child_id);
        family.add(new_person);

    line = breader.readLine();
   
    }
    // return family;


     
}
}
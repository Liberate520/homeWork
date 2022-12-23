package Семинар1.homeWork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fileredactor implements Saveandreadable{

    private String filename;
    public Fileredactor(String fname){
        this.filename = fname;
    }
    public Fileredactor(){
        this(null);
    }

    @Override
    public void read_info(Tree family) throws IOException{
        File file = new File(filename);
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
            family.addHuman(new_person);
    
        line = breader.readLine();
       
        }
        
    }

    private static String[] txt_parse(String txtstring){
        String [] str = txtstring.split(": ");
        return str;
    }

    @Override
    public void print_info(Tree family) throws IOException{
    FileWriter file = new FileWriter("family.txt", true);
    for(Human relative : family){
        file.write("\n" +  relative);
    }
    file.close();
 

}

}

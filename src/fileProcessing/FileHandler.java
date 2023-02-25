package fileProcessing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import project.Human;
import project.User;
import project.FamilyTree;
 
public class FileHandler<T extends User> {
    private Writeable format_write;
    private Readable format_read;

    public void write(Writeable format_write, String file_name, HashMap<Integer, String> humans_index_by_generation, ArrayList<T> humans_list) throws IOException {
        this.format_write = format_write;
        String [] file = new String [humans_list.size()];
        String separator = "FileHandler";
        for (int i = 0; i < humans_list.size(); i++) {
            T human = humans_list.get(i);
            Integer gen = -1;
            for (int j = 1; j <= humans_index_by_generation.size(); j++) {
                if (humans_index_by_generation.get(j).contains(Integer.toString(i))) {
                    gen = j;
                    break;
                }
            }
            file[i] = Integer.toString(gen) + separator + human.getName() + separator + human.getSex() + separator 
                    + Integer.toString(human.getYearOfBirth()) + separator + human.getFatherName(human.getFather()) + separator 
                    + human.getMotherName(human.getMother()) + separator + human.getChildrenName(human.getChildren());
        }
        format_write.write(file_name, file, separator);
    }

    public FamilyTree<T> read(Readable format_read, String file_name) throws IOException {
        this.format_read = format_read;
        ArrayList<String[]> file = format_read.read(file_name);

        Integer gen = 1;
        HashMap<Integer, String> humans_index_by_generation = new HashMap<>();
        ArrayList<T> humans_list = new ArrayList<>();

        for (int i
         = 0; i < file.size(); i++) {
            String [] human = file.get(i);
            T hum_mother = null;
            T hum_father = null;
            for (int j = 0; j < humans_list.size(); j++) {
                if (humans_list.get(j).getName().equalsIgnoreCase(human[4])) hum_father = humans_list.get(j);
                else if (humans_list.get(j).getName().equalsIgnoreCase(human[5])) hum_mother = humans_list.get(j);
            }
            T uswer = new T(human[1], human[2], Integer.parseInt(human[3]), hum_father, hum_mother);
            humans_list.add(uswer);
            if (hum_father != null) hum_father.addChild(humans_list.get(humans_list.size() - 1));
            if (hum_mother != null) hum_mother.addChild(humans_list.get(humans_list.size() - 1));
            gen = Integer.parseInt(human[0]);
            String hum_indx = humans_index_by_generation.get(gen);
            if (hum_indx == null) hum_indx = "";
            humans_index_by_generation.put(gen, hum_indx + Integer.toString(humans_list.size() - 1));
        }
        return new FamilyTree<T>(gen, humans_index_by_generation, humans_list);
    }
}

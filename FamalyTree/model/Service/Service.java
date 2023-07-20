package homeWork.FamalyTree.model.Service;


import java.io.File;
import java.time.LocalDate;
import java.util.List;

import homeWork.FamalyTree.model.FamalysTree.FamalyTree;
import homeWork.FamalyTree.model.Human.Gender;
import homeWork.FamalyTree.model.Human.Human;
import homeWork.FamalyTree.model.Service.SaveLoad.FileHandler;

public class Service {
    private long idHuman;
    private FamalyTree<Human> famalyTree;

    public Service(){
        famalyTree = new FamalyTree<>();
    }
    
    public void addHuman(String name, String last_name, LocalDate DOB, LocalDate DOD, Gender gender, String father, String mother, List<String> children) {
        Human human = new Human(idHuman++, name, last_name, DOB, DOD, gender);
        famalyTree.addHumman(human);
        
    }
    public String getHumanInfo(){
        StringBuilder sb = new StringBuilder();
        for (Human human: famalyTree){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString(){
        return getHumanInfo();
    }

    public void sortByAge() {
        famalyTree.sortByAge();
    }

    public void sortByName() {
        famalyTree.sortByName();
    }

    public void SaveData(FamalyTree<Human> list, File file){
        FileHandler<Human> fileHandler = new FileHandler<>();
        fileHandler.Save(list, file);
    }

    public void LoadData(FamalyTree<Human> list, File file){
        FileHandler<Human> fileHandler = new FileHandler<>();        
        fileHandler.LoadData(list, file);        
    }
    
        
}

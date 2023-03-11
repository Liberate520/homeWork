import java.io.FileNotFoundException;
import java.io.IOException;
    
    public class FamilyTreeService {
        private final Writable fileHandler;
        private FamilyTree<Human> familyTree;
        public void load() throws FileNotFoundException, IOException{
            familyTree = (FamilyTree<Human>) fileHandler.read();
        }
    
        public FamilyTreeService() {
            this.fileHandler = new FileHandler("familydata");
            familyTree = new FamilyTree<>();
        }
    
        public String showAll(){
            return familyTree.getInfo();
        }
    
        public void save() throws FileNotFoundException{
            fileHandler.write(familyTree);
        }
    
                public String showEntry(String name) {
            return familyTree.getByName(name).getInfo();
        }
    
       public boolean addEntry(String name, String gender, Integer birthYear,
                         String fatherName, String motherName) {
        Gender enumGender;
        if(gender.equalsIgnoreCase("m")){
            enumGender = Gender.male;
        } else {
            enumGender = Gender.female;
        }
        
        Human father = familyTree.getByName((fatherName));
        Human mother = familyTree.getByName(motherName);
        Human child = new Human(name, enumGender, birthYear, father, mother);
        return familyTree.addHuman(child);
    }            
    }





















//     // public void addHuman(String name, String gender, Integer yearofbirth, String father, String mother) {
//     //     familyTree.addHuman(new Human(name, gender, yearofbirth, father, mother));        
//     // }

//     // public void addHuman(Human human) {
//     // }
    
//     public String getAllHumanToString() {
//         String res = "Генеологическое дерево: ";
//         List<T> list1 = new ArrayList<>();
//         for (int i = 0; i < humans.size(); i++) {
//             list1.add(humans.get(i));
//         }
//         for (int i = 0; i < humans.size(); i++) {
//             res = res + "\n" + (i + 1) + "). " + humans.get(i).getInfo();
//         }
//         return res;
//     }


    
// }

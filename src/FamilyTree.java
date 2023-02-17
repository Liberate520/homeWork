import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamilyTree {

    private List<Person> listOfPersons;
    private List<FamilyCell> listOfCells;
    private Map<String, FamilyCell> familyEnvironment = new HashMap<>();

    public FamilyTree(List<Person> listOfPersons1, List<FamilyCell> listOfCells1) {
        this.listOfPersons = listOfPersons1;
        this.listOfCells = listOfCells1;
        familyEnvironment= Tree(listOfPersons, listOfCells);

    }
    private Map<String, FamilyCell> Tree(List<Person> listOfPersons, List<FamilyCell> listAllFamilies){
        Map<String, FamilyCell> familyEnvironment = new HashMap<>();
        for (int i=0; i<listOfPersons.size(); i++){
            familyEnvironment.put(listOfPersons.get(i).getName(), listAllFamilies.get(i));
        }
        return familyEnvironment;
    }

    public FamilyCell getNameForSearch(String nameForSearch){
        FamilyCell currentFamily = new FamilyCell();
        if (familyEnvironment.containsKey(nameForSearch)){
            currentFamily = familyEnvironment.get(nameForSearch);
        }
        else{
            currentFamily = null;
        }
        return currentFamily;
    }


}
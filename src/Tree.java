package OOPjavaTree.src;

import Data.OperationData;

import java.util.Arrays;
import java.util.List;

public class Tree {
    private List<String> branch;


    public Tree(List<String> branch) {
        this.branch = branch;
    }

    public List<String> getBranch() {
        return branch;
    }

    public List<String> searchFamily(String scan, List<String> resultFind, String path) {

        OperationData file = new OperationData();
        List<String> data = loadData(file, path);
        int count = 1;
        for (int i = 0; i < data.size(); i+=3) {
            String[] subData = data.get(i).split(" ");
            if (subData[0].equals(scan)) {
                System.out.printf("\n%d: %s", count++, data.get(i));
                resultFind.add(data.get(i));
            }
        }
        return resultFind;
    }

    public Human getPerson(String person, String path){

        String[] parsePerson = person.split(" ");
        Human obj = new Human();
        obj.setFamily(parsePerson[0]);
        obj.setName(parsePerson[1]);
        obj.setBurndate(parsePerson[2]);
        getFamily(obj, path, person);
        return obj;
    }

    public void getFamily (Human object, String path, String person) {

        OperationData file = new OperationData();
        List<String> data = loadData(file, path);
        for (int i =0; i < data.size(); i+=3) {
            if (person.equals(data.get(i))) {
                String[] valChildren = data.get(i+1).split("/");
                String[] valParents = data.get(i+2).split("/");
                for (String child : valChildren) {
                    object.setChildren(child);
                }
                for (String parent : valParents) {
                    object.setParents(parent);
                }
            }
        }
    }

    public List<String> loadData(OperationData file, String path){
        return Arrays.asList(file.loadData(path).split(";"));
    }
}
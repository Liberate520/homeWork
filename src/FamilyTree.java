

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable,Iterable<Integer> {
    FamilyTree(ArrayList<Human> humanList){
        this.humanList =humanList;
        this.end = humanList.size();
    }
    int start = 0;
    int end;
    @Override
    public Iterator iterator() {


        return new Iterator(start);
    }
    class Iterator implements java.util.Iterator<Integer>{

        public Iterator(int current){
            this.current=current;
        }
        int current;
        @Override
        public boolean hasNext() {
            return current<=end;
        }

        @Override
        public Integer next() {
            return current++;
        }
    }

    List<Human> humanList = new ArrayList<>();
    public Human getHumanById(int Index){
        for (Human hum: humanList
             ) {
            if (hum.id==Index) return hum;
        }
        return null;
    }

    HashMap<Integer,LinkedList<Edge>> hashMap = new HashMap<>();
     public LinkedList<Edge> addEdge(Node node){
         LinkedList<Edge> l= new LinkedList<>();
         if(node.human.GetChildrensList().size()!=0)
         {

             for (Human human: node.human.GetChildrensList())
             {
                l.add(new Edge(node,human.getDateOfBirth().getYear() - node.human.getDateOfBirth().getYear(),human));
                 addNode(new Node(human));
             }
         }
         else {
             l.add(new Edge(node));
         }
         return l;
    }
    void addNode(Node node){

        if(!hashMap.containsKey(node.human.getId())){
            hashMap.put(node.human.getId(),addEdge(node));
        }
        else{
            System.out.println("Вершина существует");

        }

    }
    void buildTree(){

        String totalText="";
            for(Map.Entry<Integer, LinkedList<Edge>> m: hashMap.entrySet()){
                for (int i=0;i<m.getValue().size();i++){
                    Human human =  getHumanById(m.getKey());
                    if(human.GetChildrensList().size()!=0){
                        String str= ("\n"+human.getName()+" Сделал --> " +m.getValue().get(i).children.getName() + " в " +m.getValue().get(i).ageCreatedChildren+"\n");
                        System.out.println(str);
                        totalText+=str;

                    }
                    else {
                        String str ="\n" + human.getName()+" --> " + " Не сделал детей\n";
                        System.out.println(str);
                        totalText+=str;

                    }

                }
                FileHandler fileHandler = new FileHandler();
                fileHandler.tryWriteFamilyTreeFile(totalText);

        }
    }
}
































































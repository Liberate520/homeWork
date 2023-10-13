package Presenter;

import Model.FamTree.FamTree;
import Model.FamTree.Human.Gender;
import Model.FamTree.Human.Human;
import Model.FamTree.Human.HumanBuilder;

import java.io.Serializable;

public class Service implements Serializable {
        private HumanBuilder humanbuilder;
        private FamTree famtree;

    public Service(){
            humanbuilder = new HumanBuilder();
            famtree = new FamTree();
        }
        public void addHuman(String firstName, String lastName, Gender sex, int age){
            Human human;
            human = humanbuilder.createHuman(firstName, lastName, sex, age);
            famtree.addHum(human);
        }
        public String getHumanListInfo(){
            StringBuilder sb = new StringBuilder();


                sb.append(famtree.getTreeInf());


            return sb.toString();
        }
        public void sortName(){
            famtree.sortName();
        }
        public void sortAge(){
            famtree.sortAge();
        }
}

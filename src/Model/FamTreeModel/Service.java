package Model.FamTreeModel;

import Model.FamTreeModel.FileWork.FileWork;
import Model.FamTreeModel.Human.Gender;
import Model.FamTreeModel.Human.Human;
import Model.FamTreeModel.Human.HumanBuilder;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Service implements Serializable {
        private HumanBuilder humanbuilder;
        private FileWork fileWork;
        private FamTreeModel famtree;


    public Service(){
            humanbuilder = new HumanBuilder();
            famtree = new FamTreeModel();
            fileWork = new FileWork();
        }
        public void saveTree(String path){
                        fileWork.write(famtree, path);
        }

        public void loadTree(String path){
            this.famtree =  (FamTreeModel) fileWork.read(path);

        }
        public void addHuman(String firstName, String lastName, Gender sex, int age){
            Human human;
            human = humanbuilder.build(firstName, lastName, sex, age);
            famtree.addMemb(human);
        }
        public String getHumanListInfo(){
           return  famtree.getTreeInf();
        }
        public void addHumanChildren(long id, String name, String sname, Gender sex, int age){
            Human human = humanbuilder.build(name, sname, sex, age);
            famtree.addChildrens(id,human);
            famtree.addMemb(human);
        }
        public Human getHumanById(Long id){
            return (Human) famtree.getMemberById(id);
        }
        public List<Human> getHumanByFullName(String name, String soname){

            return Collections.singletonList((Human) famtree.getByFullName(name, soname));
        }
        public void sortName(){
            famtree.sortName();
        }
        public void sortAge(){
            famtree.sortAge();
        }
}

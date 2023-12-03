package service;

import Animal.Human.Gender;
import Animal.Human.Human;
import FamalyTree.FamalyTree;
import FileWork.Filehundler;

public class Service {
    private FamalyTree<Human> famalyTree;
    private Filehundler filehundler;

    public Service(String nameFile){
        this.famalyTree = (FamalyTree<Human>)(loadInFile(nameFile));
    }

    public Service(){
        this.famalyTree = new FamalyTree<>();
    }

    private Object loadInFile(String nameFile){
        filehundler = new Filehundler();
        return filehundler.loadInFile(nameFile);
    }

    public void addHuman(String name, int year_bd, int m_bd, int day_bd, int year_dd,
                         int m_dd, int day_dd, Gender gender){
        this.famalyTree.addT(new Human(name,year_bd,m_bd,day_bd,year_dd,m_dd,day_dd,gender));
    }

    public void addHuman(String name, int year_bd, int m_bd, int day_bd, Gender gender){
        this.famalyTree.addT(new Human(name, year_bd, m_bd, day_bd, gender));
    }

    public String getTreeInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Список генеологического дерева:\n");
        for(Human human : famalyTree){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName(){
        this.famalyTree.sortByName();
    }
    public void sortByAge(){
        this.famalyTree.sortByAge();
    }
    public void sortByGender(){
        this.famalyTree.sortByGender();
    }
    public void sortByChildren(){
        this.famalyTree.sortByChildren();
    }

    public void addHumanRelatives(int idHuman0, int idHuman1, int typeRel){
        this.famalyTree.addTRelatives(idHuman0, idHuman1, typeRel);
    }

    public boolean saveInFile(String nameFile){
        Filehundler filehundler = new Filehundler();
        return filehundler.saveInFile(this.famalyTree, nameFile);
    }

    public Human getHumanId (int id){
        return famalyTree.searchID(id);
    }

    public Object getFamaliObject(){
        return famalyTree;
    }
}

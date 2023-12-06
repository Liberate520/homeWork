package service;

import Animal.Human.Gender;
import Animal.Human.Human;
import FamalyTree.FamalyTree;
import FileWork.Filehundler;
import FileWork.Writeble;

public class Service {
    private FamalyTree<Human> famalyTree;
    private Writeble writeble;

    public Service(String nameFile){
        this.famalyTree = (FamalyTree<Human>)(loadInFile(nameFile));
    }

    public Service(){
        this.famalyTree = new FamalyTree<>();
    }

    private Object loadInFile(String nameFile){
        writeble = new Filehundler();
        return writeble.loadInFile(nameFile);
    }

    public void addHuman(String name, int year_bd, int m_bd, int day_bd, int year_dd,
                         int m_dd, int day_dd, Gender gender){
        this.famalyTree.addT(new Human(name,year_bd,m_bd,day_bd,year_dd,m_dd,day_dd,gender));
    }

    public void addHuman(String name, int year_bd, int m_bd, int day_bd, Gender gender){
        this.famalyTree.addT(new Human(name, year_bd, m_bd, day_bd, gender));
    }

    public String getTreeInfo(){
        return famalyTree.getTreeInfo();
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
        writeble = new Filehundler();
        return writeble.saveInFile(this.famalyTree, nameFile);
    }

    public Human getHumanId (int id){
        return famalyTree.searchID(id);
    }

    public Object getFamaliObject(){
        return famalyTree;
    }
}

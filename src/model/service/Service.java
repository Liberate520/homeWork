package service;

import Animal.Human.Gender;
import Animal.Human.Human;
import FamalyTree.FamalyTree;
import FileWork.Filehundler;

public class Service {
    private FamalyTree<Human> famalyTree;

    public Service(String nameFile){
        Filehundler filehundler = new Filehundler();
        this.famalyTree = (FamalyTree<Human>)(filehundler.LoadInFile(nameFile));
    }

    public Service(){
        this.famalyTree = new FamalyTree<>();
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

    public void addHumanRelatives(int idHuman0, int idHuman1, int index){
        this.famalyTree.addTRelatives(idHuman0, idHuman1, index);
    }

    public boolean saveInFile(String nameFile){
        Filehundler filehundler = new Filehundler();
        return filehundler.SaveInFile(this.famalyTree, nameFile);
    }

    public Human getHumanId (int id){
        return famalyTree.searchID(id);
    }
}

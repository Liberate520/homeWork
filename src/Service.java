import Animal.Human.Human;
import FamalyTree.FamalyTree;
import FileWork.Filehundler;

public class Service {
    private FamalyTree<Human> famalyTree;

    public Service(String nameFile){
        Filehundler filehundler = new Filehundler();
        this.famalyTree = (FamalyTree<Human>)(filehundler.LoadInFile(nameFile));
        famalyTree.PrintTree();
    }

    public Service(){
        this.famalyTree = new FamalyTree<Human>();
    }

    public boolean addHuman(){

        return true;
    }

    public void addTRelatives(){

    }
}

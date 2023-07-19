package module.service;

import module.familystructure.FamilyTree;
import module.human.Human;

import module.writeAndread.Filehandler;
import module.writeAndread.Writable;

import java.io.IOException;

public class Service {
    private final FamilyTree<Human> family;
    private Writable writable;

    public Service(FamilyTree<Human> family) {
        this.family = family;
    }
    public void sortByName(){
        family.sortByName();
    }
    public void sortByChild() {
        family.sortByChild();
    }
    public void write(){
        this.write(family);
    }
    public void write(FamilyTree<Human> family) {
        Filehandler<Human> txt = new Filehandler<>();
        txt.write(family);
    }
    public FamilyTree<Human> read() throws IOException, ClassNotFoundException {
        Filehandler<Human> txt = new Filehandler<>();
        return (FamilyTree<Human>) txt.read("lib.txt");
    }

}
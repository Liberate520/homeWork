

import java.io.IOException;

import model.FamilyTree;
import model.Service;
import model.FileHandler;
import presenter.Presenter;
import view.Console;
import view.View;

public class MainMVP{
   
  public static void main(String[] args) throws IOException,
  ClassNotFoundException {

   FileHandler fileHandler = new FileHandler("familyTree", "out");
   FamilyTree<model.human.Human> familyTree = new FamilyTree<>();

   Service service = new Service(familyTree, fileHandler);
   View view = new Console();

   Presenter presenter = new Presenter(view, service);
   presenter.createInitialTree();

   view.start();
  }
}

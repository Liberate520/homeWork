package org.example.model.communication;

import org.example.model.Human;
import org.example.model.Tree;
import org.example.model.add_load_save_tree.LoadTree;
import org.example.model.add_load_save_tree.SaveTree;
import org.example.model.add_remove_human.AddHuman;
import org.example.model.add_remove_human.RemoveHuman;
import org.example.model.editing.date.DateBirth;
import org.example.model.editing.date.DateDeath;
import org.example.model.editing.gender.EditGender;
import org.example.model.editing.kindred.EBrothersAndSisters;
import org.example.model.editing.kindred.EChildren;
import org.example.model.editing.kindred.EFather;
import org.example.model.editing.kindred.EMother;
import org.example.model.editing.name.EditingName;
import org.example.model.print.PrintHuman;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class SystemModelCommunication implements Service{
    private Tree <Human> tree = new Tree<>();


    @Override
    public ArrayList<Map<String, String>>  getAListPrintHuman(){ // отдает в меню текст вывода отдельных Human, и всего списка
        return new PrintHuman(tree).getList();
    }

    @Override
    public void communicator(String command, String text, Integer index) throws IOException {
        switch (command) {
            case "addH" -> new AddHuman().addHuman(text, null, LocalDate.now(), null, "", tree);
            case "remove" -> new RemoveHuman().removeHuman(index, tree);
            case "dateB" -> new DateBirth().dateCreator(text, index, tree);
            case "dateD" -> new DateDeath().dateCreator(text, index, tree);
            case "EditingName" ->  new EditingName().editingName(text, index, tree);
            case "gender" -> new EditGender().editGender(text, index, tree);
            case "mother" -> new EMother().addRelatives(Integer.parseInt(text) - 1, index, tree);
            case "father" -> new EFather().addRelatives(Integer.parseInt(text) - 1, index, tree);
            case "children" -> new EChildren().addRelatives(Integer.parseInt(text) - 1, index, tree);
            case "brothersAndSisters" -> new EBrothersAndSisters().addRelatives(Integer.parseInt(text) - 1, index, tree);
            case "load" -> this.tree = new LoadTree().getTree();
            case "save" -> new SaveTree(tree).saveTree();
        }
    }


}

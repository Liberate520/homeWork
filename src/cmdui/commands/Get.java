package cmdui.commands;

import java.util.ArrayList;
import familytree.FamilyTree;
import familytree.FamilyTree.SortMode;

class Get extends Command {
    Get(FamilyTree familyTree) {
        super(familyTree);
    }

    @Override
    public String syntax() {
        return "GET [/sort <name|year>] [/id <id>|/name <имя>]";
    }

    @Override
    public String description() {
        return "Получить информацию о членах древа";
    }

    @Override
    public String toString() {
        return "GET";
    }

    @Override
    protected String processCommand() {
        if (!command.equalsIgnoreCase("GET"))
            return null;
        
        ArrayList<String> sort = params.get("/sort");
        if (sort != null) {
            if(sort.get(0).equals("name"))
                familyTree.setSortMode(SortMode.name);
            else if(sort.get(0).equals("year"))
                familyTree.setSortMode(SortMode.birthDay);
            else
                return syntaxError();
        }
        else  familyTree.setSortMode(SortMode.noSort);

        ArrayList<String> id = params.get("/id");
        ArrayList<String> name = params.get("/name");
        if (id != null)
            return success(id.get(0), null);
        else if(name != null)
            return success(null, name.get(0));
        else
            return success(null, null);
    }

    private String success(String id, String name) {
        if(id != null)
            return familyTree.getMemeberById(Integer.parseInt(id)).toString();
        if(name != null)
            return familyTree.toString();
        return familyTree.toString();
    }
}

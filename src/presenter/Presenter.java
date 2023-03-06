package presenter;

import api.AddFieldResult;
import api.DbProceed;
import api.Gender;
import ui.View;

import java.io.IOException;

public class Presenter
{
    private View view;
    private DbProceed dbProceed;

    public Presenter(View view, DbProceed dbProceed) {
        this.view = view;
        this.dbProceed = dbProceed;
        view.setPresenter(this);
    }

    static Integer addFieldCounter = 0;

    public String printTree()
    {
        String result = "";
        result = dbProceed.printTree();
        return result;
    }

    public AddFieldResult addFieldsOfPerson(Object field)
    {
        return dbProceed.addFieldsOfPerson(field);
    }

    public String addPerson(
            boolean isTsar,
            String name,
            String middleName,
            String surname,
            Gender gender,
            Integer yearOfBirth,
            Integer yearOfDeath,
            Integer leaderNumber,
            Integer yearOfReignStart,
            Integer yearOfReignStop,
            String spouse,
            String father,
            String mother
            )
    {
        String result = "";

        result = dbProceed.addPerson(
            isTsar,
            name,
            middleName,
            surname,
            gender,
            yearOfBirth,
            yearOfDeath,
            leaderNumber,
            yearOfReignStart,
            yearOfReignStop,
            spouse,
            father,
            mother
            );
        return result;
    }

    public String findPerson(String name)
    {
        String result = "";
        result = dbProceed.findPerson(name);
        return result;
    }

    public String saveTreeToFile() throws IOException {
        String result = "";
        result = dbProceed.saveTreeToFile();
        return result;
    }

    public String sortTreeByName() {
        String result = "";
        result = dbProceed.sortTreeByName();
        return result;
    }
    public String sortTreeByDate() {
        String result = "";
        result = dbProceed.sortTreeByDate();
        return result;
    }
}


import family_tree.model.file_system.FS;
import family_tree.model.file_system.OOS;

import family_tree.view.ConsoleUI;
import family_tree.view.View;

public class Main {
    public static void main(String[] args)
    {
        View view = new ConsoleUI();
        FS fileOperations = new FS(new OOS());
        String file_path = "tree23.out";
        if(!fileOperations.IsFileExist(file_path))
        {           
            view.start();
            fileOperations.Save(view, file_path);
        }
        else
        {
            view = (View)fileOperations.Read(file_path);
            view.start();
            fileOperations.Save(view, file_path);
        }

    }
}

package family_tree.backend.config;

import family_tree.backend.dump_file.FileHandler;

import java.io.File;

public class Config implements BaseInit{

    public Config config;

    FileHandler fileHandler = new FileHandler();

    public static String getFilePath(){
        String path = "";
        String file = "dbase.dump";
        return path + file;
    }
    public static boolean checkFile(){
        return new File(getFilePath()).isFile();
    }

    public String baseInit(){
        if(checkFile()){
            return getFilePath();
        }
        return null;
    }
}



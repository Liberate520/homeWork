package model.file;
import java.io.*;

import model.Tree;
import model.person.Person;

public class FileBinary implements Files  {
    private String file_name;

    public FileBinary(String file_name){
       this.file_name = file_name;
    }

    public FileBinary(){
        this("bd.bin");
    }

    private Boolean fileExist(String file_name) {
        File file = new File(file_name);
        return file.exists();
    }

    @Override
    public Boolean saveFile(Tree<Person> family) {
        String bd_file = new File(this.file_name).getAbsolutePath();
 
        try (FileOutputStream fos = new FileOutputStream(bd_file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
                )
        {
            System.out.println("HERE! " + file_name);
            oos.writeObject(family);
            System.out.println("Successfully written data to the file");
            oos.flush();
            oos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Tree<Person> readFile() throws ClassNotFoundException {
        Tree<Person> family = new Tree<Person>();
        String bd_file = new File(this.file_name).getAbsolutePath();

        if (!fileExist(bd_file)) {
            return new Tree<Person>();
        }
 
        try (FileInputStream fis = new FileInputStream(bd_file);
            ObjectInputStream ois = new ObjectInputStream(fis);
                )
        {
            family =(Tree<Person>) ois.readObject();
            System.out.println("Successfully read data from the file");
            ois.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            return new Tree<Person>();
        }
        return family;

    }

    @Override
    public String getFile_name() {
        return this.file_name;
    }

    @Override
    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

}

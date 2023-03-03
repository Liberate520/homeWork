package org.example.model.file;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;


public abstract class FileManipulator implements FileOperable {


    protected LocalDate localDateInStr(String date){
        if (date.equals("null")){
            return null;
        } else {
            ArrayList<String> list = new ArrayList<>(Arrays.asList(date.split("-")));
            return LocalDate.of(Integer.parseInt(list.get(0)), Integer.parseInt(list.get(1)), Integer.parseInt(list.get(2)));
        }
    }
}

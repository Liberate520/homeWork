package model.service;

import model.Data;
import model.file.DataFileManager;
import model.tree.Tree;

import java.io.IOException;

public class FileService {
    public void loadData() throws IOException, ClassNotFoundException {
        DataFileManager datafilemanager = new DataFileManager();
        Tree ft = (Tree) datafilemanager.loadData();
        PrintService.printList(ft.getPersonList());
    }

    public void saveData() throws IOException {
        DataFileManager datafilemanager = new DataFileManager();
        datafilemanager.saveData(Data.getData());
    }
}

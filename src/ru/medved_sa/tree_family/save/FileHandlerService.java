package ru.medved_sa.tree_family.save;


import ru.medved_sa.tree_family.save.ioUtils.IOUtils;

import java.io.Serializable;

public class FileHandlerService extends IOUtils implements Writable {
    private String filePath = "src/ru/medved_sa/tree_family/save/familyTree.out";

    public String getFilePath() {
        return filePath;
    }

    @Override
    public boolean saveFile(Serializable serializable, String filePath) {
        return super.saveFile(serializable, filePath);
    }

    @Override
    public Object readFile(String filePath) {
        return super.readFile(filePath);
    }
}

package ru.medved_sa.tree_family.save;


import ru.medved_sa.tree_family.save.ioUtils.IOUtils;

import java.io.Serializable;

public class FileHandlerService extends IOUtils implements Writable {
    private String filePath = "src/ru/medved_sa/tree_family/save/familyTree.out";

    public FileHandlerService() {
        this.filePath = filePath;
    }

    @Override
    public boolean saveFile(Serializable serializable) {
        return super.saveFile(serializable, filePath);
    }

    @Override
    public Object readFile() {
        return super.readFile(filePath);
    }
}

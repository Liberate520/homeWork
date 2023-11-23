package ru.medved_sa.tree_family.model.save;


import ru.medved_sa.tree_family.model.save.ioUtils.IOUtils;

import java.io.Serializable;

public class FileHandlerService extends IOUtils implements Writable {
    private String filePath = "src/ru/medved_sa/tree_family/model/save/familyTree.out";

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

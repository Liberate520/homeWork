package FamilyTree_homework.writer;

public interface Writable {
        boolean save(FamilyTree<Human> tree);
        FamilyTree<Human> read();
        void setFilePath(String filePath);
    }
}

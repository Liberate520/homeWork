package homeWork.FamalyTree.SaveLoad;

import java.io.File;

import homeWork.FamalyTree.FamalyTree;

public interface SaveLoad {
    void Save(FamalyTree list, File file);
    void LoadDate(FamalyTree list, File file);
}


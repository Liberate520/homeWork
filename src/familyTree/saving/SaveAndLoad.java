package familyTree.saving;

import familyTree.tree.FamilyTree;

import java.io.Serializable;

public interface SaveAndLoad {

    /**
     * Сохранение объекта в файл
     * @param serial объект FamilyTree
     * @param pathStr путь сохранения
     */
    void savingTree(Serializable serial, String pathStr);

    /**
     * Загрузка объекта из файла
     * @param pathStr путь к файлу
     * @return объект FamilyTree
     */
    public FamilyTree loadingTree(String pathStr);
}

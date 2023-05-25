package oop.familyTree.MVP.model;

import oop.familyTree.human.Human;
import oop.familyTree.tree.FamilyTree;

public interface SaveAndLoad {

    /**
     * Сохранение созданного древа в файл
     * @param path путь для сохранения
     * @param familyTree объект для сохранения
     */
    void saving(String path, FamilyTree<Human> familyTree);

    /**
     * Загрузка сохранённого файла
     * @param path путь к файлу
     * @return объект FamilyTree
     */
    FamilyTree<Human> loading(String path);
}

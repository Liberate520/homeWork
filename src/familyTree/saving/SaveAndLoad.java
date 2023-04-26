package familyTree.saving;

import familyTree.ServiceForTree;

import java.io.Serializable;

public interface SaveAndLoad {

    /**
     * Сохранение объекта в файл
     * @param serial объект FamilyTree
     * @param pathStr путь сохранения
     */
    void savingWork(Serializable serial, String pathStr);

    /**
     * Загрузка объекта из файла
     * @param pathStr путь к файлу
     * @return объект FamilyTree
     */
    public ServiceForTree loadingWork(String pathStr);
}

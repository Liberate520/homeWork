package Model.GenealogicalTree;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Model.FileHandler;
import Model.Writable;
import Model.GenealogicalTree.Comporator.GenTreeIterator;

public class GenealogicalTree<T extends Animal> implements Serializable, Iterable<T> {
    private List<T> allListTree;
    private Writable<T> writable;

    public GenealogicalTree(Writable<T> writable) {
        allListTree = new ArrayList<>();
        this.writable = writable;
    }

    public void addIndividual(T somebody) {
        if (!allListTree.contains(somebody)){
            allListTree.add(somebody);
            if (somebody.getFather() != null){
                somebody.getFather().addChild(somebody);
            }
            if (somebody.getMother() != null){
                somebody.getMother().addChild(somebody);
            }
            if (somebody.getPartner() != null){
                somebody.getPartner().setPartner(somebody);;
            }
        }
    }

    public void addIndividual(String string, Sex man, int i) {
    }
    
    /**
     * Метод поиска человека по имени и его детей
     * @param searchName принимает введенное пользователем значение 
     */
    public T searchGetHuman (String searchName) {
        for (T individual : allListTree) {
            if (individual.getName().equals(searchName)) {
                return individual;
            } 
        }
        return null;
    }
    
    public String searchForName (String searchName) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nРезультат поиска: \n");
        T res = null;
        for (T individual : allListTree) {
            if (individual.getName().equals(searchName)) {
                res = individual;
            } 
        }
        if (res != null) {
            sb.append(res.toString());
            sb.append("\n");
            sb.append("Мать: ");
            if (res.getMother() != null) {
                sb.append(res.getMother().getName());
            } else {
                sb.append("не указана");
            }
            sb.append(", отец: ");
            if (res.getFather() != null) {
                sb.append(res.getFather().getName());
            } else {
                sb.append("не указан");
            }
            sb.append(", партнер: ");
            if (res.getPartner() != null) {
                sb.append(res.getPartner().getName());
            } else {
                sb.append("не указан");
            }
            sb.append("\n");
            sb.append(res.childrenInfo());
            sb.append("\n");
        } else {
            sb.append(searchName);
            sb.append(" не найден\n");
        }
        return sb.toString();
    }

    /**
     * Метод печати всех человек из генеалогического древа
     */
    public void printGenTree() {
        for (T individual : allListTree) {
            System.out.println(individual);
        }
    }
    
    public List<T> getAllListTree() {
        return allListTree;
    }

    public void setWritable(Writable<T> writable) {
        this.writable = writable;
    }

    public GenealogicalTree<T> readFamilyTree() 
        throws ClassNotFoundException, IOException {
        if (writable != null) {
            if (writable instanceof FileHandler) {
                if (writable.read() == null) {
                    System.out.println("FamilyTree в файле нет! Создаём новое FamilyTree.");
                    return new GenealogicalTree<T>(writable);
                } else {
                    System.out.println("FamilyTree загружено из файла.");
                    return (GenealogicalTree<T>) writable.read();
                }
            }
        } else {
            System.out.println("Файл не загружен!");
            return null;
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new GenTreeIterator<T>(allListTree);
    }

    public void getMarried(T o1, T o2) {
        o1.setPartner(o2);
        o2.setPartner(o1);
    }

}

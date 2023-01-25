package Cache;

import Homework_5.Designer_Human;
import Homework_5.Femily_Tree;

import java.util.ArrayList;
import java.util.List;

public class CacheLimitations<T> {
    /**
     *ОПИСАНИЕ КЛАССА
     *Класс для кеширования списков
     */
    ArrayList<T> element;
    int size;

    public CacheLimitations() {
        this.size = size;
        element = new ArrayList<>(); //создаем экземпляр

    }

    public void addEl(T Element) { //метод добавления элемента
        int curSize = element.size(); //текущий размер
        if (curSize >= size) {
            for (int i = 0; i < curSize - size + 1; i++) {
                element.remove(0);//при переполнении кэша удаляем более старые записи
            }
            element.add(Element); //добавляем в конец
        }


    }

    public T getEl(int i) { //получаем элемент списка под номером
        if (i >= element.size()) {
            return null;
        }
        return element.get(i); //вернем нужный элемент.
    }

    public List<T> getAllEL() { ////получаем все элементы списка
        return element;

    }

    /**
     *
     * метод вызова кеша
     */
    public void cacheMetod(Femily_Tree femily_tree) {
    /*
    параметризуем список
    */
        CacheLimitations<Designer_Human> cache = new CacheLimitations<Designer_Human>(); //параметризуем список людей и устанавливаем размер кэша
        for (Designer_Human H1 : femily_tree) {
            cache.addEl(H1);
        }
        cache.getAllEL().forEach(System.out::println); //выводим кэш на экран

    }
}

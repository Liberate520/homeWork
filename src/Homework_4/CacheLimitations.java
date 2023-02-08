package Homework_4;

import java.util.ArrayList;
import java.util.List;

public class CacheLimitations<T> { //Класс для кеширования списков

    ArrayList<T> element;
    int size;

    public CacheLimitations(int size) {
        this.size = size;
        element = new ArrayList<>(); //создаем экземпляр

    }

    public void addEl(T Element) { //метод добавления элемента
        int curSize = element.size(); //текущий размер
        if (curSize >= size) {
            for (int i = 0; i < curSize - size + 1; i++) {
                element.remove(0);//при переполнение кэша удаляем более старые записи
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
}

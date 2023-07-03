

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;


public class Main {

    public static void main(String[] args) {
        ArrayList<Person> arhive = new ArrayList<>();                                       // Внесение членов семьи в архив
        int index =10;
        /*10*/arhive.add(new Person(index++,12,0,"mam","Никита","20.12.85"));
        /*11*/arhive.add(new Person(index++,12,15, "man", "Кирилл", "24.02.79"));
        /*12*/arhive.add(new Person(index++,17,16, "woman", "Елена", "23.02.49", "12.09.12"));
        /*13*/arhive.add(new Person(index++,11,0, "woman", "Юля", "14.04.92"));
        /*14*/arhive.add(new Person(index++,11,0, "woman", "Марина", "6.09.95"));
        /*15*/arhive.add(new Person(index++,1,11, "woman", "Светлана", "18.10.76"));
        /*16*/arhive.add(new Person(index++,1,12, "man", "Валерий", "23.02.55"));
        /*17*/arhive.add(new Person(index++,0,0, "woman", "Мария", "7.03.04", "5.12.83"));
        /*18*/arhive.add(new Person(index++,17,0, "woman", "Татьяна", "24.07.38", "02.02.15"));
        /*19*/arhive.add(new Person(index++,18,0, "woman", "Ирина", "23.05.63"));
        /*20*/arhive.add(new Person(index++,18,0, "man", "Александр", "1.11.65", "29.08.05"));

                                        // Сортировка дерева на родственные связи

        LinkedList<Person> child = new LinkedList<>();                        //Создание списка только всех детей
        Person founder=arhive.get(0);                                   // переменная для хранения основателя древа (для старта там помечается любой первый член семьи)

        for (Person human:arhive) {                                           // Проверяет все записи архива на родство
            if (human.getId_parent()>10){
                child.add(human);
            }
            if (human.getId_parent()==0){                                     // Находит основателя древа
                founder=human;
            }
        }
        ArrayList<Person> end_list= new ArrayList<>();
        ArrayList<Person> temp_list= new ArrayList<>();
        end_list.add(founder);                                                // Вносит основателя в итоговый список

        while(child.size()!=0){                                               // Пока список детей не пустой
            for (Person parent: end_list) {                                   // Переберает итоговый список 
                temp_list.add(parent);                                        // Вносим текущую запись во временный лист
                for (int i = 0; i < child.size(); i++) {
                    if(parent.getId()==child.get(i).getId_parent()){          // Проверяет является ли текущая запись ребенком предыдущей записи
                        temp_list.add(child.get(i));                          // вносим ребенка во временный лист
                        child.remove(child.get(i));                           // удаляем ребенка из списка детей
                        i--;                                                  // после удаления ребенка из списка нужно уменьшить i, чтобы не перепрыгнуть через запись.
                    }
                }
            }
            end_list=temp_list;                                               // временный лист поместить в итоговый
            temp_list=new ArrayList<>();                                      // очистить временный лист
        }                                                                     // по итогу у нас отсортированный лист с номерами членой семьи в последовательном порядке для печати.

                                // Вывод сортированного дерева в консоль

        StringBuilder show_wood = new StringBuilder();                  // создание билдера для быстрого формирования вывода
        Stack <Integer> parents = new Stack<>();                        // создания стека родителей (для правильного формирования принадлежности детей (отступ))

        int id_consort = end_list.get(0).getId_consort();         // Переменная для запоминания супруга главного родителя
        int id_main_parent = end_list.get(0).getId();             // Запоминание номера родителя (для поиска детей)
        parents.push(id_main_parent);                                   // Внесение в стек основателя древа
        int count_parents_stack = 1;                                    // Счетчик родителей в стеке (так как нет реализации Stack.size)
        show_wood.append(end_list.get(0).show_person());          // Внесение в вывод основателя древа
        
                                // запись супруга в вывод 
        if (id_consort>10){                                             // Проверка на присуствие супруга
            for (Person person : arhive) {                              // Переберает всех членов архива
                if (person.getId()==id_consort){                        // Пока не найдет совпадение номена супруга и номером члена семьи в архиве
                    show_wood.append("  И  ");                      // Добавляет в вывод супруга
                    show_wood.append(person.show_person());
                }
            }
        }
        show_wood.append("\n");                               

        
        for (int i=1; i<end_list.size(); i++ ) {                        // Переберает весх членов в сформированном списке дерева
            if (end_list.get(i).getId_parent()==id_main_parent){        // Проверяет является ли этот член семьи ребенком по отношению к предыдущей записи
                for (int j=0; j<count_parents_stack; j++) {             // Формирует нужный размер отступа для наглядного понятия принадлежности детей к родителям
                    show_wood.append("     ");
                }
                show_wood.append(end_list.get(i).show_person());        // Запись ребенка в вывод

                id_consort = end_list.get(i).getId_consort();           // запись супруга 
                    if (id_consort>10){                                 // если такой есть архиве          
                        for (Person person : arhive) {
                            if (person.getId()==id_consort){
                                show_wood.append("  И  ");
                                show_wood.append(person.show_person());
                            }
                        }
                    }
                show_wood.append("\n");
                parents.push(id_main_parent);                           // Внесение в стек родителей номена ребенка, для поиска у него детей
                count_parents_stack++;                                  // Увеличение счетчика стека родителей
                id_main_parent=end_list.get(i).getId();                 // запоминание номер ребенка для проверки наличия у него детей
            }
            else{                                                       // Если этот член семьи не является ребенком по отношению к предыдущей записи
                id_main_parent=parents.pop();                           // изымаем номер родителя из стека родителей
                count_parents_stack--;                                  // уменьшаем счетчик стека родителей
                i--;                                                    // для повторной проверки текущей записи на принадлежность к родителям стека
            }
        }



        System.out.println(show_wood);                                  // Демонстрация полного делева
    }
}
/*
p.s. Да в домашнем задании не было задачи по сортировке и выводу полного дерева, но я зациклился на демонстрации всего дерева. 
И у меня очень много времени ушло на создание алгоритма сортировки и запоминание дерева. 
Алгоритм уже был готов перед занятиями в пятницу и хотелось его доделать, но требовалась вторая часть, по его печати. 
Несмотря на то что эта часть была проще, оформить ее получилось только в понедельник днем + оформление комментариев (надеюсь они облегчили понимание кода).
Основные проблемы кода, это затруднение мышления в рамках ООП, буду над этим работать.
Следующее задание с записью в файл я вставлю в этот проект без сильного изменения (в свезись малым временем) и пришлю чуть позже. 
А вот к пятнице я постараюсь модернизировать проект, выделив в майн только меню программы, а все метода разложу по файлам.
*/
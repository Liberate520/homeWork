package tree;

import java.util.List;

/*
* Описание родственных связей надо сделать, человек может быть и родителем и ребенком
* */
public class Human {
    private String name;
    private int age;
    Human father;
    Human mother;
    List<Human> children;
}

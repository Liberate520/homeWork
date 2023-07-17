package faminly_tree.model.save_in_file;

import faminly_tree.model.human.Human;
import faminly_tree.model.tree.FamiliItem;
import faminly_tree.model.tree.FamilyTree;

import java.io.*;
//Нарушение принципа разделения интерфейсов. Это была первая работа с интерфейсом, еще без особого понимания,
// поэтому все свалено в кучу. Необходимо разделить интерфейс для человека и дерева и, как следствие,
// классы их наследующие тоже будут разделены.
//
//Еще один вариант: интерфейс WriteAndRead удалить, данный класс переписать, как SaveInFile<E extends Serializable>.
//оставить два метода write и read, передавать в них путь и дженерик. В методе read возвращать object и кастовать его к
// нужному типу непосредственно при вызове метода. (Я пока искала пути, пробовала переписать, чтобы он через дженерик
// сам кастовался, но шла ошибка типа, не смогла ее решить иным способом)
public class SaveInFile implements WriteAndRead{

    @Override
    public void write(String path, Human human) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(human);
        objectOutputStream.close();
    }

    @Override
    public void write(String path, FamilyTree tree) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(tree);
        objectOutputStream.close();
    }

    @Override
    public Human readHuman(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        Human human = (Human) objectInputStream.readObject();
        objectInputStream.close();
        return human;
    }

    @Override
    public FamilyTree readTree(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        FamilyTree tree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return tree;
    }
}

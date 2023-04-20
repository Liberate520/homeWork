package familyTree;

import familyTree.comparators.MemberComparatorByBirthday;
import familyTree.comparators.MemberComparatorByName;
import familyTree.comparators.ByNumberChildComparator;
import familyTree.member.FamilyMember;
import familyTree.member.Gender;
import familyTree.member.Human;
import service.FileHandler;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class Service {
    private int id;
    private FamilyTree<Human> tree;
    private FileHandler handler;

    public Service(FamilyTree<Human> tree) {
        this.tree = tree;
        this.handler = new FileHandler();
    }
    public FamilyTree<Human> getTree() {
        return tree;
    }
    public FileHandler getHandler() {
        return handler;
    }
    public void setTree(FamilyTree<Human> tree) {
        this.tree = tree;
    }
    public void setHandler(FileHandler handler) {
        this.handler = handler;
    }
    public void addHuman(String name, String surname, Gender gender, String dateBirth, Human father, Human mother) {

        tree.add(new Human(id++, name, surname, gender, dateBirth, father, mother));
    }

    public String printTree(){
        return tree.getInfo();
    }

//    public void printTrees(){
//        tree.printTree();
//    }

    public void save(String fileName){
        if (handler != null && tree != null) {
            try {
                File file = new File(fileName);
                if (!file.exists()) {
                    file.createNewFile();
                }
                handler.write(tree, fileName);
            } catch (IOException e) {
                throw new RuntimeException("Ошибка при записи файла: " + e.getMessage(), e);
            }
        } else {
            //System.out.println("Что-то пошло не так. Handler: " + handler + ", tree: " + tree);
            throw new RuntimeException("Дерево пустое\n");
        }
    }

    public void load(String fileName) {
        if (handler != null) {
            try {
                tree = (FamilyTree<Human>) handler.read(fileName);
            } catch (IOException e) {
                throw new RuntimeException("Ошибка чтения файла: " + e.getMessage(), e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Такой класс не создан: " + e.getMessage(), e);
            } catch (ClassCastException e) {
                throw new RuntimeException("Недопустимое приведение класса: " + e.getMessage(), e);
            }
        } else {
            throw new RuntimeException("Что-то пошло не так\n");
        }
    }

    public void sortByName () {
        tree.getMembers().sort(new MemberComparatorByName());
    }
    public void sortByBirthday () {
        tree.getMembers().sort(new MemberComparatorByBirthday());
    }
    public void sortByNumChild () {
        tree.getMembers().sort(new ByNumberChildComparator());
    }

    public void clearTree() {
        List<Human> members = tree.getMembers();
        members.clear();
        tree.setMembers(members);

    }

    public Human searchMemberByName(String name) {
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Имя не может быть пустым.\n");
            }
            for (Human member : tree.getMembers()) {
                if (member.getName().equalsIgnoreCase(name.trim())) {
                    return member;
                }
            }
            throw new IllegalArgumentException("Человек с именем '" + name + "' не найден в дереве.\n");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void removeMember(String name) {
        if (tree.getMembers().isEmpty()) {
            System.out.println("Дерево пустое.\n");
            return;
        }
        Human memberToRemove = null;
        for (Human member : tree.getMembers()) {
            if (member.getName().equalsIgnoreCase(name.trim())) {
                memberToRemove = member;
                break;
            }
        }
        if (memberToRemove == null) {
            System.out.println("Человек с именем '" + name + "' не найден в дереве.\n");
            return;
        }
        if (memberToRemove.getChildren().size() > 0) {
            System.out.println("Невозможно удалить человека, у которого есть дети.\n");
            return;
        }
        tree.remove(memberToRemove);
        System.out.println("Человек с именем '" + name + "' удален из дерева.\n");
    }



}

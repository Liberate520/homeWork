import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humanList;
    private static final long serialVersionUID =1L;
    public FamilyTree(){ this(new ArrayList<>());}
    public FamilyTree(List<Human> humanList) { this.humanList =humanList;}
    public ArrayList<Human> getFamily(){
        return (ArrayList<Human>) humanList;
    }



//    public void getSisAndBro(Human human){
//        for(Human person: humanList){
//            if(person.getFather().getName().equals(person.getFather().getName())){
//                person.addBrother(person);
//            }
//        }
//    }

    /**
     *
     * TODO Пока не совсем пойму как автоматизировать добавления братьев и систер в списки по примеру метода addChild
     * Для того что бы была автоматизация, надо создавать отдельный конструктор в классе Хьюман, метод add в классе FamilyTree
     * c if реализацией на проверку гендерности, пример написан выше, но подразумевает один список без разделения
     *
     */

    public boolean add(Human human){
        if(human == null){
            return false;
        }
        if(!humanList.contains(human)){
            humanList.add(human);
            if (human.getFather() != null){
                human.getFather().addChild(human);
            }
            if (human.getMother() != null){
                human.getMother().addChild(human);
            }
            return true;
        }
        return  false;
    }

    public Human getByName(String name) {
        for (Human human : humanList) {
            if (human.getName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null;
    }

    public String getHumanList(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human: humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Human human: humanList){
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator(){
        Iterator<Human> iterator = new Iterator<Human>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < humanList.size();
            }

            @Override
            public Human next() {
                return humanList.get(index++);
            }
        };
        return iterator;
    }
}

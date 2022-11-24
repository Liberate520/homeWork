import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Link {
    Map<Human, String> firstHuman;
    Map<Human, String> secondHuman;

    String kinship;

    public Link(Human firstHuman, String firstKinship, Human secondHuman, String secondKinship) {
        this.firstHuman = new HashMap<Human, String>();
        this.secondHuman = new HashMap<Human, String>();

        this.firstHuman.put(firstHuman, firstKinship);
        this.secondHuman.put(secondHuman, secondKinship);

        String[] massStrings;
        massStrings = new String[] {"Отец", "Мать"};
        if (Arrays.asList(massStrings).contains(firstKinship)){
            firstHuman.addChildren(secondHuman, this);
            secondHuman.addParent(firstHuman, this);
        }
        massStrings = new String[] {"Сын", "Дочь"};
        if (Arrays.asList(massStrings).contains(firstKinship)){
            firstHuman.addParent(secondHuman, this);
            secondHuman.addChildren(firstHuman, this);
        }
        massStrings = new String[] {"Брат", "Сестра"};
        if (Arrays.asList(massStrings).contains(firstKinship)){
            firstHuman.addNearCons(secondHuman, this);
            secondHuman.addNearCons(firstHuman, this);
        }
//        if (firstKinship == "Супруг"){
//            firstHuman.setWife(secondHuman, this);
//            secondHuman.setWife(firstHuman, this);
//        }


    }

    public static void autoLinks (Human member){
        for (Human link : member.getChildrens().keySet()) { // перебираем известных детей
            autoLinks(member, link, -1);
        }
        for (Human link : member.getParents().keySet()) { // перебираем известных родителей
            autoLinks(member, link, 1);
        }
        for (Human link : member.getNearCons().keySet()) { // перебираем известных братьев и сестёр
            autoLinks(member, link, 0);
        }
    }

    public static void autoLinks (Human member, Human toMember, int layer){

        // Перебираем родителей вызова (искл: l -1, 0)

        // Перебираем братьев вызова (искл: l -1)
        if (layer > -1) {
            Map<Human, Link> consB = toMember.getNearCons(); // получаем мой список братьев
            Map<Human, Link> consP = toMember.getNearCons(); // получаем мой список потомков
            for (Map.Entry link : member.getNearCons().entrySet()) {

                if (layer + 0 == 0) { //означает что мы братья
                    if (!consB.containsKey(link.getKey())); {// сравниваем братьев
                        new Link(toMember, "Брат", (Human) link.getKey(), "Брат");// добавляем нам брата
                    }
                }

                if (layer + 0 == 1){ //они мои потомки
                    if (!consP.containsKey(link.getKey())); {// сравниваем детей
                        new Link(toMember, "Брат", (Human) link.getKey(), "Брат");// добавляем нам детей
                    }
                }
            }
        }

        // Перебираем потомков вызова (искл: l 0, 1)
        if (layer == -1) {
            Map<Human, Link> consB = toMember.getNearCons(); // получаем мой список братьев
            Map<Human, Link> consP = toMember.getNearCons(); // получаем мой список потомков
            for (Map.Entry link : member.getChildrens().entrySet()) {

                if (layer - 1 == -2) { //означает что мы братья
                    if (!consB.containsKey(link.getKey())); {// сравниваем братьев
                        new Link(toMember, "Брат", (Human) link.getKey(), "Брат");// добавляем нам брата
                    }
                }

            }
        }


    }

}

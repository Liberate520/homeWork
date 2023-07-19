package family_tree.model.human;

import family_tree.model.Gender;
import family_tree.model.Informer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InformerHuman implements Informer<Human>, Serializable {

    @Override
    public String getInfo(Human h) {
        StringBuilder result = new  StringBuilder();
        result.append("{");
        result.append(String.format("id: %d, ", h.id));
        result.append(String.format("Имя: %s, ", h.name));
        result.append(String.format("Дата рождения: %s, ", h.dateBirth.toString()));
        result.append(String.format("Пол: %s, ", h.gender== Gender.Male ? "мужской":"женский"));
        result.append(String.format("Отец: %s, ", (h.father==null ? "Нет данных" : h.father.getName())));
        result.append(String.format("Мать: %s, ", (h.mother==null ? "Нет данных" : h.mother.getName())));
        if(h.children.isEmpty()){
            result.append("Дети: нет, ");
        }else{
            List<String> childrenNames = new ArrayList<>();
            for(Human child : h.children)
                childrenNames.add(child.getName());
            result.append(String.format("Дети: %s, ", String.join(",", childrenNames)));
        }
        if(h.spouse == null){
            result.append(String.format("Семейное положение: %s", h.gender== Gender.Male ? "не женат" : "не замужем"));
        }else{
            result.append(String.format("Семейное положение: %s", h.gender== Gender.Male ? "женат" : "замужем"));
        }
        result.append("}");
        return result.toString();
    }
}

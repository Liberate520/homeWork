package src;

import javax.swing.event.HyperlinkEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class FamilyTree {


    public FamilyTree(List<Human> family) {
        this.family = family;
    }
    public FamilyTree() {
        this(null);
    }

    public List<Human> getFamily() {
        return family;
    }

    private List<Human> family = new ArrayList<>();



    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("------------------------\n");
        for (Human h:
             family) {
            result.append(h.getLastName()).append(" ").append(h.getFirstName()).append(" ").append(h.getPatronymic()).append("\n");
        }

        return result.toString();
    }

    public void addToFamily(Human human){
        if(this.family == null) {
            this.family = new ArrayList<>();
        }
        this.family.add(human);
    }



    private List<Human> findFamilyList(String lastName){
        List<Human> result = new ArrayList<>();
        for (Human human:
             family) {
            if(Objects.equals(human.getLastName(), lastName)){
                result.add(human);
            }
        }
        return result;
    }

    public String findFamily(String name){
        StringBuilder result = new StringBuilder();
        List<Human> lst = findFamilyList(name);
        if(!lst.isEmpty()){
            for (Human h:
                    lst) {
                result.append(h.getLastName()).append(" ").append(h.getFirstName()).append(" ").append(h.getPatronymic()).append("\n");
            }
        } else {
            result.append("Нет результатов удовлетворящих критериям поиска");
        }
        return result.toString();
    }

    public void getStatistics(Human human){
        if(family.contains(human)) {
            StringBuilder result = new StringBuilder();
            List<Human> children = getChildrenList(human);
            result.append("---------------------------\n");
            result.append("ФИО: ").append(human.getLastName()).append(" ").append(human.getFirstName()).append(" ").append(human.getPatronymic());
            result.append("\n");
            result.append("Родился ").append(human.getDateOfBorn()).append(" г. в ").append(human.getPlaceOfBirth()).append("\n");
            if (!human.isAlive()) {
                result.append("Умер ").append(human.getDateOfDeath()).append(" г\n");
                result.append("Прожил ").append(human.getAge()).append(" полных лет\n");
            }
            result.append("Имеет ").append(human.getChildren().size()).append(" детей и ").append(children.size() - human.getChildren().size()).append(" внуков");
            System.out.println(result);
        }
    }
    public List<Human> getChildrenList(Human human){
        List<Human> hlist = new ArrayList<>();
        hlist.add(human);
        List<Human> result = createChildrenList(hlist);
        result.remove(0);
        return result;
    }
    private List<Human> createChildrenList(List<Human> lst) {
        List<Human> result = new ArrayList<>(lst);
        int st = lst.size();
        for (Human h :
                lst) {
                if(!h.getChildren().isEmpty()){
                    for (Human hh :
                            h.getChildren()) {
                        if(!result.contains(hh)){
                            result.add(hh);
                        }
                    }
                }

        }
        if(result.size()==lst.size()){
            return result;
        } else {
            result = createChildrenList(result);
        }
        return result;
    }



    public List<Human> findHumans(
            String gender,
            String firstName,
            String patronymic,
            String lastName,
            String dateOfBornFrom,
            String dateOfBornTo,
            String dateOfDeathFrom,
            String dateOfDeathTo,
            String placeOfBirth
    ){
        List<Human> result = new ArrayList<>();
        List<Human> resultTemp = new ArrayList<>();

//        HashMap<String, Integer> startDateFrom = new HashMap<>();
//        HashMap<String, Integer> startDateTo = new HashMap<>();
//        HashMap<String, Integer> endDateFrom = new HashMap<>();
//        HashMap<String, Integer> endDateTo = new HashMap<>();
//
//        Validation isValDay = new Validation();
//
//
        Dates day = new Dates();
//        if(isValDay.isDateValid(dateOfBornFrom, false)) {
//            startDateFrom = day.parseDate(dateOfBornFrom);
//        } else {
//            dateOfBornFrom = "";
//        }
//
//        if(isValDay.isDateValid(dateOfBornTo, false)) {
//            startDateTo = day.parseDate(dateOfBornTo);
//        } else {
//            dateOfBornTo = "";
//        }
//
//        if(isValDay.isDateValid(dateOfDeathFrom, false)) {
//            endDateFrom = day.parseDate(dateOfDeathFrom);
//        } else {
//            dateOfDeathFrom = "";
//        }
//
//        if(isValDay.isDateValid(dateOfDeathTo, false)) {
//            endDateTo = day.parseDate(dateOfDeathTo);
//        } else {
//            dateOfDeathTo = "";
//        }


        if(gender.isEmpty()){
            result.addAll(family);
        } else {
            for (Human h :
                    family) {
                if(Objects.equals(h.getGender(), gender)){
                    result.add(h);
                }
            }
        }

        if(!firstName.isEmpty() && !result.isEmpty()){
            for (Human h :
                    result) {
                if(Objects.equals(h.getFirstName(), firstName)){
                    resultTemp.add(h);
                }
            }
            result.retainAll(resultTemp);
            resultTemp.clear();
        }

        if(!patronymic.isEmpty() && !result.isEmpty()){
            for (Human h :
                    result) {
                if(Objects.equals(h.getPatronymic(), patronymic)){
                    resultTemp.add(h);
                }
            }
            result.retainAll(resultTemp);
            resultTemp.clear();
        }

        if(!lastName.isEmpty() && !result.isEmpty()){
            for (Human h :
                    result) {
                if(Objects.equals(h.getLastName(), lastName)){
                    resultTemp.add(h);
                }
            }
            result.retainAll(resultTemp);
            resultTemp.clear();
        }

        if(!placeOfBirth.isEmpty() && !result.isEmpty()){
            for (Human h :
                    result) {
                if(Objects.equals(h.getPlaceOfBirth(), placeOfBirth)){
                    resultTemp.add(h);
                }
            }
            result.retainAll(resultTemp);
            resultTemp.clear();
        }

        if(!dateOfBornFrom.isEmpty() && !result.isEmpty()){
            for (Human h :
                    result) {
                if(day.datesCompare(dateOfBornFrom, h.getDateOfBorn())) {
                    resultTemp.add(h);
                }
            }
            result.retainAll(resultTemp);
            resultTemp.clear();
        }

        if(!dateOfBornTo.isEmpty() && !result.isEmpty()){
            for (Human h :
                    result) {
                if(day.datesCompare(h.getDateOfBorn(), dateOfBornTo)) {
                    resultTemp.add(h);
                }
            }
            result.retainAll(resultTemp);
            resultTemp.clear();
        }

        if(!dateOfDeathFrom.isEmpty() && !result.isEmpty()){
            for (Human h :
                    result) {
                if(day.datesCompare(dateOfDeathFrom, h.getDateOfDeath())) {
                    resultTemp.add(h);
                }
            }
            result.retainAll(resultTemp);
            resultTemp.clear();
        }

        if(!dateOfDeathTo.isEmpty() && !result.isEmpty()){
            for (Human h :
                    result) {
                if(day.datesCompare(h.getDateOfDeath(), dateOfDeathTo)) {
                    resultTemp.add(h);
                }
            }
            result.retainAll(resultTemp);
            resultTemp.clear();
        }

        return result;
    }
}

package family_tree;


import java.time.LocalDate;
import java.util.HashSet;

public class Family_tree {

    private final HashSet<Person> family;
    private int inn;

    public Family_tree() {
        family = new HashSet<>();
        inn = 0;
    }

    public void addPerson(Person person) {
        if (person.getInn() == 0) {
            this.inn++;
            person.setInn(this.inn);
        }

        this.family.add(person);

        if (person.getChildren() != null) {
            this.family.addAll(person.getChildren());
        }
        if (person.getFather() != null) {
            this.family.add(person.getFather());
        }
        if (person.getMother() != null) {
            this.family.add(person.getMother());
        }
    }

    //TODO после развода из дерева исключается тот у которого не осталось других связей
    public boolean divorce(Person fPartner, Person sPartner) {
        if (fPartner.divorce(sPartner)) {
            // пробуем удалить обоих партнеров (в функции удаления прописана проверка на оставшиеся связи)
            this.removePerson(fPartner);
            this.removePerson(sPartner);
            return true;
        }
        return false;
    }

    public void marriage(Person fPartner, Person sPartner) {

        if (fPartner.marriage(sPartner)) {
            this.family.add(fPartner);
            this.family.add(sPartner);
        }
    }

    /**
     * возвращает строку с данными Person для записи ее в файл
     *
     * @param forFile
     * @return строка
     */
    public String getAllTreeStr(boolean forFile) {

        if (this.family == null) {
            return "";
        } else {
            StringBuilder info = new StringBuilder();
            for (Person item : this.family) {
                info.append(forFile ? item.getString() : item.getFullInfo());
                info.append("\n");
            }
            return new String(info);
        }


    }

    //TODO в процессе ТЕСТА. удалить можно только запись которая не связана ни с кем из дерева.

    /**
     * удалят объект из дерева, если у него нет связей с другими объектами из дерева (муж, дети, родители)
     *
     * @param person
     */
    public void removePerson(Person person) {
        if (this.family.contains(person.getMother()) || this.family.contains(person.getFather())) {
            return;
        } else if ((person.getHusband() != null) && (this.family.contains(person.getHusband()))) {
            return;
        }
        for (Person item : person.getChildren()) {
            if (this.family.contains(item)) {
                return;
            }
        }
        this.family.remove(person);
    }

    /**
     * метод для конвертации строки в дату при восстановлении дерева из файла
     *
     * @param stringDate - дата в формате YYYY-MM-DD
     * @return дату типа LocalDate
     */
    private LocalDate convertdate(String stringDate) {
        String temp[] = stringDate.split("-");
        int tday = Integer.parseInt(temp[2]);
        int tmont = Integer.parseInt(temp[1]);
        int tyear = Integer.parseInt(temp[0]);
        return LocalDate.of(tyear, tmont, tday);
    }
    //TODO в процессе разработки и ТЕСТА.

    /**
     * добавляет строки данных в дерево
     *
     * @param readInFile
     */
    public void fillInFile(String readInFile) {
        String[] temp = readInFile.split("\n");

        for (String item : temp) {
            String[] line = item.split(" ");

            LocalDate dataB = line[4].equals("null") ? null: convertdate(line[4]);
            LocalDate dataM = line[5].equals("null") ? null: convertdate(line[5]);
            Gender gender = line[3].equals("Male") ? Gender.Male : Gender.Female;
            this.addPerson(new Person(line[1], line[2], gender, dataB, dataM, Integer.parseInt(line[0])));
        }
        this.recoveryLink(temp);

    }

    /**
     * восстановление связей в дереве после восстановления ее из файла
     * @param lineData
     */
    private void recoveryLink(String[] lineData) {
        for (String item : lineData) {
            String[] line = item.split(" ");
            Person person = this.getForInn(Integer.parseInt(line[0]));

            if (!line[6].equals("null")) {
                person.setParents(this.getForInn(Integer.parseInt(line[6])));
            }
            if (!line[7].equals("null")) {
                person.setParents(this.getForInn(Integer.parseInt(line[7])));
            }
            if ((!line[8].equals("null"))) {
                person.marriage(this.getForInn(Integer.parseInt(line[8])));
            }
        }

    }

    /**
     * возвращает ссылку на объект класса Person по ИНН
     *
     * @param innPers - код Person (либо сформированный автоматически либо залитый из файла при восстановлении БД)
     * @return объект класса Person
     */
    public Person getForInn(int innPers) {
        for (Person item : this.family) {
            if (item.getInn() == innPers) {
                return item;
            }
        }
        return null;
    }

    //TODO восстановление из файла. сделать как отдельный класс?


}

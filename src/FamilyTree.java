
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyTree implements Informationable{

    private final String NO_DATA = "Нет данных";
    private final Person person;
    private final List<Relative> relatives;

    public FamilyTree(Person person) {
        if (person != null)
            this.person = person;
        else this.person = new Person();
        this.relatives = this.person.getRelatives();
    }

    @Override
    public String getInfo() {

        StringBuilder sb = new StringBuilder();

         sb.append("Генеалогическое древо человека - ").append(getFullName(person)).append(": \n");
         this.relatives.forEach(x -> sb.append(x.toString()).append("\n"));

                 return sb.toString();

//                .append("Отец - ").append(getFullName(getRelativeByFamilyStatus(person, FamilyStatus.FATHER))).append("\n")
//                .append("Мать - ").append(getFullName(getRelativeByFamilyStatus(person, FamilyStatus.MOTHER))).append("\n")
//                .append("Супруг(-а) - ").append(getFullName(getRelativeByFamilyStatus(person, FamilyStatus.SPOUSE))).append("\n")
//                .append("Дети: ")
//                .append("\n").append(getRelativesFullNameByFamilyStatus(person, FamilyStatus.CHILD)).append("\n")
//                .append("Дедушка по материнской линии - ")
//                .append(getFullName(getRelativeByFamilyStatus
//                        (getRelativeByFamilyStatus(person, FamilyStatus.MOTHER), FamilyStatus.FATHER))).append("\n")
//                .append("Бабушка по материнской линии - ")
//                .append(getFullName(getRelativeByFamilyStatus
//                        (getRelativeByFamilyStatus(person, FamilyStatus.MOTHER), FamilyStatus.MOTHER))).append("\n")
//                .append("Дедушка по отцовской линии - ")
//                .append(getFullName(getRelativeByFamilyStatus
//                        (getRelativeByFamilyStatus(person, FamilyStatus.FATHER), FamilyStatus.FATHER))).append("\n")
//                .append("Бабушка по отцовской линии - ")
//                .append(getFullName(getRelativeByFamilyStatus
//                        (getRelativeByFamilyStatus(person, FamilyStatus.FATHER), FamilyStatus.MOTHER))).append("\n")
//                .append("Братья: ").append("\n")
//                .append(getRelativesFullNameByFamilyStatus(person, FamilyStatus.BROTHER)).append("\n")
//                .append("Сестры: ").append("\n")
//                .append(getRelativesFullNameByFamilyStatus(person, FamilyStatus.SISTER)).append("\n")
//                .append("Тёти: ")
//                .append("\n").append(getRelativesFullNameByFamilyStatus(person, FamilyStatus.AUNT)).append("\n")
//                .append("Дяди: ")
//                .append("\n").append(getRelativesFullNameByFamilyStatus(person, FamilyStatus.UNCLE)).append("\n")
//                .append("Внуки: ")
//                .append("\n").append(getRelativesFullNameByFamilyStatus(person, FamilyStatus.GRANDCHILD)).append("\n")
//                .toString();
    }

    public String getFullName(Person person) {
        if (person == null || person.getFullName().isBlank())
            return NO_DATA;
        else return person.getFullName();
    }

    public Person getRelativeByFamilyStatus(FamilyStatus status){
        return this.relatives.stream().filter(x -> x.getStatus().equals(status)).findFirst()
                .orElse(new Relative()).getPerson();
    }

    public Set<Person> getRelativesByFamilyStatus(FamilyStatus status){
        return this.relatives.stream().filter(x -> x.getStatus().equals(status))
                .map(Relative::getPerson).collect(Collectors.toSet());
    }

    public String getRelativesFullNameByFamilyStatus(Person person, FamilyStatus status){
        if (person == null) person = this.person;
        Set<Relative> relatives = this.relatives.stream().filter(x -> x.getStatus().equals(status))
                .collect(Collectors.toSet());
        if (relatives.isEmpty())
            return NO_DATA;
        else {
            StringBuilder sb = new StringBuilder();
            relatives.forEach(x -> sb.append("\t- ").append(getFullName(x.getPerson())).append("\n"));
            return sb.toString();
        }
    }

    public Person searchByName(String name) {
        return this.relatives.stream().filter(x -> x.getPerson().getFirstName().equalsIgnoreCase(name))
                .findFirst().orElse(new Relative()).getPerson();
    }
}

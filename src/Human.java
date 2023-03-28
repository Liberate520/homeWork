import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Human {
    public String name, surname;
    private static Integer humansCount = 0;
    public Integer humanId; 
    private Gender gender;
    private Integer birthYear;
    public Human mother, father;
    private List <Human> childs = new ArrayList<>();
    private List <Human> spouse = new ArrayList<>();
    public Human(String name, String surname, Gender gender, Integer birthYear, Human mother, Human father)
    {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthYear = birthYear;
        this.father = father;
        this.mother = mother;
        this.humanId = humansCount;
        addChild(mother, father, this);
        FamilyTree.humans.add(this);
    }

    public Human(String name, String surname, Gender gender, Integer birthYear)
    {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthYear = birthYear;
        humanId = ++humansCount;
        FamilyTree.humans.add(this);
    }
    public static List<Human> getByName(String name)
    {
        Predicate<Human> byName = human -> human.name.equals(name);
        List<Human> Humans = FamilyTree.humans.stream().filter(byName)
                .collect(Collectors.toList());
        return Humans;
    }
    public static List<Human> getBySurname(String surname)
    {
        Predicate<Human> bySurname = human -> human.surname.equals(surname);
        List<Human> Humans = FamilyTree.humans.stream().filter(bySurname)
                .collect(Collectors.toList());
        return Humans;
    }
    public List<Human> parents()
    {
        List<Human> parents = new ArrayList<>();
        if(mother!= null && father != null)
        {
        parents.add(father);
        parents.add(mother);
        }
        return parents;
    }
    public List<Human> childs()
    {
        return this.childs;
    }
    public List<Human> spouse()
    {
        return spouse;
    }

    public List<Human> brotherAndSisters()
    {
        List<Human> brohersAndSisters = new ArrayList<>();
        brohersAndSisters = this.father.childs();
        brohersAndSisters.remove(this);
        return brohersAndSisters;
    }

    public List<Human> grandMothers()
    {
        return grand(Gender.Male);
    }
    public List<Human> grandFathers()
    {
        return grand(Gender.Female);
    }

    public List<Human> grandChildrens()
    {
        List<Human> grandChildrens = new ArrayList<>();
        for (Human human : this.childs) {
            grandChildrens.addAll(human.childs);
        }
        return grandChildrens;
    }
    
    public void addChild(Human mother, Human father, Human child)
    {
        mother.childs.add(child);
        father.childs.add(child);
    }
    public void addSpouse(Human human)
    {
        if (spouse.isEmpty()) 
        {
            AddSpouse(human);
            human.AddSpouse(this);
        }
        else
        {
            spouse.clear();
            AddSpouse(human);
            human.AddSpouse(this);
        }
    }
    @Override
    public String toString() {
        return name +" "+ surname +" "+ Integer.toString(birthYear) +" "+  gender;
    }
    private List<Human> grand(Gender gender)
    {
        List<Human> grands = new ArrayList<>();
        grands = this.father.parents();
        grands.addAll(this.mother.parents());
        grands.removeIf(grand -> grand.gender.equals(gender));
        return grands;
    }
    private void AddSpouse(Human human)
    {
        spouse.add(human);
    }

    

}

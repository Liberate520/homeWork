import Model.Child;
import Model.Identity;
import Model.Role;
import Model.Parent;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Research {
    private final List<Role> roles;

    public HashSet<Identity> getIdentities() {
        HashSet<Identity> identities = new HashSet<>();
        for (Role role: roles) {
            identities.add(role.identity);
        }
        return identities;
    }

    public Research(List<Role> roles) {
        this.roles = roles;
    }
    protected Role findPerson(String firstName, String lastName, String className) throws ClassNotFoundException {
        Class myClass = Class.forName(className);
        for (Role person : roles) {
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName) && myClass.isInstance(person)) {
                return person;
            }
        }
        return null;
    }
    protected Role findPerson(String name, String className) throws ClassNotFoundException {
        String[] result = name.split(" ");
        return findPerson(result[0], result[1], className);
    }

    public Role findPerson(String name) throws ClassNotFoundException {
        return findPerson(name, "Model.Role");
    }

    public void whoYourChildren(String name) throws ClassNotFoundException {
        Role person = findPerson(name, "Model.Parent");
        if (person != null)
            ((Parent)person).whoYourChildren();
        else
            System.out.println("Not Fount children for " + name);
    }
    public void whoYourMother(String name) throws ClassNotFoundException {
        ((Child)findPerson(name, "Model.Child")).whoYourMother();
    }
    public void whoYourFather(String name) throws ClassNotFoundException {
        ((Child) findPerson(name, "Model.Child")).whoYourFather();
    }

    public void printAllRoles() {
        for (Role man: roles) {
            String role = man.getClass().toString().substring(12) + " role";
            System.out.println(man + " - " + role);
        }
    }
    public void printAllPeople() {
        List<Identity> identities = getIdentities().stream().sorted(Comparator.comparing(Identity::toString)).toList();
        for (Identity identity : identities) {
            System.out.println(identity.toString());
        }
    }
}

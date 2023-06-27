import java.util.ArrayList;
import java.util.List;

public class Persona extends TreeNode implements Finder{

    private List<Persona> children = new ArrayList<>();
    private List<Persona> parents = new ArrayList<>();
    enum Sex {MALE, FEMALE}
    private Sex sex;

    public Persona(String name, String surname, Sex sex, Persona parent){
        this.setName(name);
        this.setSurname(surname);
        this.sex = sex;
        if (checkParent(parent))
        {
            this.parents.add(parent);
            parent.children.add(this);
        }

    }

    public String getSex(){
        return String.valueOf(this.sex);
    }

    private boolean checkParent(Persona persona){
        return persona != null;
    }

    @Override
    public List<Persona> getParents() {
        return parents;
    }

    @Override
    public List<Persona> getChildren() {
        return children;
    }

    @Override
    public List<Persona> getSubParents() {
        List<Persona> result = new ArrayList<>();
        List<Persona> subResult = this.getParents();
        for (Persona per : subResult) {
            for (Persona subPar : per.getParents()) {
                result.add(subPar);
            }
        }
        return result;
    }

    @Override
    public List<Persona> getSubChildren() {
        List<Persona> result = new ArrayList<>();
        List<Persona> subResult = this.getChildren();
        for (Persona per : subResult) {
            for (Persona subChil : per.getChildren()) {
                result.add(subChil);
            }
        }
        return result;
    }
}

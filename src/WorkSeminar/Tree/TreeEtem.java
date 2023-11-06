package WorkSeminar.Tree;

import WorkSeminar.Persona.Gender;
import WorkSeminar.Persona.Persona;

import java.time.LocalDate;
import java.util.List;

public interface TreeEtem  {
    String getName();
    int addAge();
    Gender getGender();
    void setDathday(LocalDate dathday);
    void setId(long l);
    long getId();

   //void addKid(P person);
   //<P> void addKid(P person);
   //void addKid(Object person);
    void addKid(Persona person);



    /*
    <E> List<E> addParents();
    Persona getPartner();
    <E> void setPartner(E partner);
    <E>List<E> getKids();
    <E> boolean addKid(E kid);
    <E> void addParent(E persona);*/

}

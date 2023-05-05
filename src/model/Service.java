package model;

import java.io.IOException;

public interface Service {
    void addHuman(String family, String name);
   // public getByHuman ();
    void sortByName();
    void sortByFamily();
     public String searchHuman(String family, String name);
    public String searchMather(String family, String name);
    public String searchParents(String family, String name);
    public String searchChild(String family, String name);
    public void clearTree();


}

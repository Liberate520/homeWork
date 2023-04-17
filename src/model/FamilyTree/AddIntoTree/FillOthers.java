package model.FamilyTree.AddIntoTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Persons.Others;

public class FillOthers<T extends Others>
 {
   
    private List<Others> list = new ArrayList<>();

    public List<Others> fillOthers()
    {

        Others others1 = new Others(1, "иван", "инженер");
        Others others2 = new Others(2, "петр", "программист");
        
        List<Others> listOfOthers = new ArrayList<>(Arrays.asList(others1, others2));
       return listOfOthers;
    }
}

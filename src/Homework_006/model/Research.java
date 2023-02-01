package Homework_006.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Research<T extends BaseType> {

    private FamilyTree<T> ft;

    public Research(FamilyTree ft) {
        this.ft = ft;
    }

    public List<T> getBrothersAndSistersById(int id) {
        List<Integer> parent_ids = this.ft.getHumanById(id).getRelativesIds('p');
        HashSet<Integer> broAndSis_ids = new HashSet<>();
        for (Integer p_id : parent_ids) {
            for (Integer ch_id : this.ft.getHumanById(p_id).getRelativesIds('c')) {
                if (ch_id != id) {
                    broAndSis_ids.add(ch_id);
                }
            }
        }

        List<T> broAndSis = new ArrayList<>();
        for(int ch_id:broAndSis_ids){
            broAndSis.add(ft.getHumanById(ch_id));
        }
        return broAndSis;
    }



    public List<T> getParentsById(int id) {
        T child = this.ft.getHumanById(id);
        List<Integer> ids = child.getRelativesIds('p');
        List<T> parents = new ArrayList<>();
        for (int p_id : ids) {
            parents.add(ft.getHumanById(p_id));
        }
        return parents;
    }
}

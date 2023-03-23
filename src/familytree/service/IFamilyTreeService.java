package familytree.service;

import java.util.Date;
import familytree.SortMode;

public interface IFamilyTreeService {
    String addMember(String name, String sex, Date birthDay, int[] parentIds);

    String getMembers(SortMode sortMode, int id, String name);

    String updateMember(int id, String name, Date deathDay);
}

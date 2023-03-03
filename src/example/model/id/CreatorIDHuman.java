package org.example.model.id;

import org.example.model.Human;
import org.example.model.Tree;

import java.util.ArrayList;
import java.util.Arrays;

public class CreatorIDHuman{
    private final Tree <Human> tree;
    private String id;
    private Integer counter;
    {
        counter = 1;
    }

    public CreatorIDHuman(Tree<Human> tree, String id) {
        this.tree = tree;
        this.id = id;
    }


    public String creatorId() {
        if (id.equals("")){
            while (true) {
                boolean flag = false;
                for (int i = 0; i < tree.getIdStorage().getIds().size(); i++) {
                    if (Integer.parseInt(new ArrayList<>(Arrays.asList(tree.getIdStorage().getIds().get(i)
                            .split(":")) ).get(1)) == counter) {
                        flag = true;
                    }
                }
                if (flag) {
                    counter++;
                } else {
                    return id = "id:" + counter;
                }
            }
        } else {
            tree.getIdStorage().addID(id);
            return id;
        }
    }
}

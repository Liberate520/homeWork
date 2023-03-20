package cmdui.commands;

import familytree.SortMode;

public interface ICmdGet {
    SortMode getSortMode();

    int getId();

    String getName();
}

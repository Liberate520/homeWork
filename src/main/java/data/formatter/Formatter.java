package data.formatter;

import data.BlockNote;

public interface Formatter {


    String stringBlockNote(BlockNote blockNote);

    public BlockNote blockNote(String stringBlockNote);
}

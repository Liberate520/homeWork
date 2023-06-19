package Models.Items;

import java.time.LocalDateTime;

public interface NoteItem{
    Integer getId();
    String getHeader();
    String getContent();
    LocalDateTime getDateOfCreation();
    LocalDateTime getDateOfChange();
    String getShort();
    String getAuthor();
}
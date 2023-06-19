package Models.Items;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post implements NoteItem, Serializable {
    // #region fields
    private Integer id;
    private String header;
    private String content;
    private String author;
    private LocalDateTime dateOfCreation;
    private LocalDateTime dateOfChange;
    // #endregion

    // #region getters
    public Integer getId() {
        return this.id;
    }

    /** заголовок */
    public String getHeader() {
        return this.header;
    }

    /** содержание */
    public String getContent() {
        return this.content;
    }

    /** автор */
    public String getAuthor() {
        return this.author;
    }
    /** дата создания */
    public LocalDateTime getDateOfCreation() {
        return this.dateOfCreation;
    }

    /** дата изменения */
    public LocalDateTime getDateOfChange() {
        return this.dateOfChange;
    }
    // #endregion

    /** статья */
    public Post(int id, String header, String content, String author) {
        LocalDateTime date = LocalDateTime.now();
        apply(id, header, content, author, date, date);
    }

    /** обновить */
    public void update(String header, String content, String author) {
        LocalDateTime date = LocalDateTime.now();
        apply(this.id, header, content, author, this.dateOfCreation, date);
    }

    /** применить */
    private void apply(int id, String header, String content, String author, LocalDateTime dateOfCreation,
            LocalDateTime dateOfChange) {
        this.id = id;
        this.header = header;
        this.content = content;
        this.author = author;
        this.dateOfCreation = dateOfCreation;
        this.dateOfChange = dateOfChange;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Header:   [%d] %s\n", id, header));
        builder.append(String.format("Created:  %s \n", dateFormatter(dateOfCreation)));
        builder.append(String.format("Modified: %s \n", dateFormatter(dateOfChange)));
        builder.append(String.format("Author:   %s \n", author));
        builder.append(String.format("Content:  %s \n", content));
        return builder.toString();
    }

    /** получение короткой инф */
    public String getShort() {
        return String.format("[#%d] (%s) %s by %s", this.id, dateFormatter(dateOfChange), header, author);
    }

    /** строковое представление даты */
    private String dateFormatter(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }
}

package model;

import java.util.Objects;

/**
 * Класс, отвечающий за запись в блокноте
 */
public class Note {
    String content;

    public Note() {
    }

    public Note(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Note other)) {
            return false;
        }
        return Objects.equals(content, other.content);
    }
}

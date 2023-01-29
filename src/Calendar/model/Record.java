package Calendar.model;

import java.io.Serializable;

public class Record implements Serializable {

    private Integer hour;
    private String event;

    public Record(Integer hour, String event) {
        this.hour = hour;
        this.event = event;
    }

    public Integer getHour() {
        return hour;
    }

    public String getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return String.format(" Время: %s, событие - %s\n", hour.toString(), event);

    }
}
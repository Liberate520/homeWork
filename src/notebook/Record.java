package notebook;

import java.util.Date;

public class Record {
    private final int id;
    private String createTime;
    private String record;


    public Record(String record, int id) {
        this.record = record;
        this.id = ++id;
        this.createTime = "   |Created: " + new Date();
    }

    public int getId() {
        return id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
        this.createTime = createTime + ", Changed: " + new Date();
    }

    @Override
    public String toString() {
        return id + ": " + record + createTime;
    }
}

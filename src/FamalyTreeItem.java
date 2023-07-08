import java.util.List;

 public interface FamalyTreeItem {
     List<FamalyTreeItem> getChildren();
     Human getMother();
     void addChild(FamalyTreeItem child);
     Human getFather();
     int getAge();
     String getFirstName();
     void setFather(FamalyTreeItem father);
     void setMother(FamalyTreeItem mother);
 }
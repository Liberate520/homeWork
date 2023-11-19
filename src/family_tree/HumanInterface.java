package family_tree;

import java.time.LocalDate;
import java.util.List;

public interface HumanInterface<T> {
  void setId(Long id);
  long getId();
  List<T> getParent();
  List<T> getChildren();
  String getName();
  void addKid(T t);
  void addParent(T t);
  Gender getGender();
  int getAge(LocalDate birth, LocalDate death);
  LocalDate getDeath();
  LocalDate getBirth();
  void setParentM(T t);
  void setParentF(T t);
}

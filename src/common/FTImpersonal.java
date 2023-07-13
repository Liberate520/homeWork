package common;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FTImpersonal<E> extends Serializable {
	int getId();
	E getFather();
	E getMother();
	void addChild(E human);
	void addParent(E human);
	String getFullName();
	LocalDate getBirthDay();
	List<E> getParents();
	List<E> getChildren();
	void sortByName();
	String getInfo();
	E getByName();


}

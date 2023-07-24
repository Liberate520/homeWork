package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FTImpersonal<E> extends Serializable {
	E getFather();
	E getMother();
	void addChild(E human);
	void addParent(E human);
	String getLastName();
	String getFirstName();
	LocalDate getBirthDay();
	List<E> getParents();
	List<E> getChildren();
//	void sortByName();
	String getInfo();
//	E getByName();


}

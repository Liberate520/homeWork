package write_read;

import tree.FamilyTree;

import java.io.Serializable;

public interface Saveable<E> {
//	boolean save(Serializable serializable, String filePath);
//	Object load(String filePath);
FamilyTree loadFile(String str);
	void saveFile(FamilyTree familyTree, String str);
}

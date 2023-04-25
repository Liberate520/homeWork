import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tree {
	private Map<Person, List<Person>> familyTree;
	public Tree() {
		familyTree = new HashMap<>();
	}
//	public Map<Person, List<Person>> getFamilyTree() {
//		return familyTree;
//	}
//	public void setFamilyTree(Map<Person, List<Person>> familyTree) {
//		this.familyTree = familyTree;
//	}
	public void addChild(Person parent, Person child) {
		if (familyTree.containsKey(parent)) {
			familyTree.get(parent).add(child);
		} else {
			List<Person> children = new ArrayList<>();
			children.add(child);
			familyTree.put(parent, children);
		}
	}
	public List<Person> getChildren(Person parent) {
		return familyTree.get(parent);
	}
}
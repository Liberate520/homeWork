package assignment.pkg2;

import java.io.Serializable;

/**
 * this family tree class acts as an implementation of the family member class
 * @author Taaqif
 */
public class FamilyTree implements Serializable{
    //needed to verion control the serialised files
    private static final long serialVersionUID = 1;

    /**
     * constructs the family tree by setting the root to null
     */
    public FamilyTree() {
        this.root = null;
    }

    private FamilyMember root;

    /**
     * sets the root
     * @param newRoot
     */
    public void setRoot(FamilyMember newRoot){
        this.root = newRoot;
    }

    /**
     *
     * @return
     */
    public boolean hasRoot(){
        return this.root !=null;
    }

    /**
     *
     * @return
     */
    public FamilyMember getRoot(){
        return this.root;
    }
}
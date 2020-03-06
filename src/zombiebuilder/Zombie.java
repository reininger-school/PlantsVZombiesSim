package zombiebuilder;

/*
Represents Zombie enemy. Serves as composite class in composite pattern Serves as composite class in composite pattern.
 */
public class Zombie extends EnemyObject {
    /*
    Return ith child.
     */
    public EnemyObject getChild(int child) {
        return this.children.get(child);
    }

    /*
    Add child EnemyObject.
     */
    public void add(EnemyObject child) {
        this.children.add(child);
    }

    /*
    Remove child.
     */
    public void remove(EnemyObject child) {
        this.children.remove(child);
    }
}

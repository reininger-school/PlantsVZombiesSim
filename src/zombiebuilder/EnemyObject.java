package zombiebuilder;

import java.util.List;

/*
Class representing enemy objects. Serves as Component of Composite pattern.
 */
public abstract class EnemyObject {
    private int health;
    private List<EnemyObject> children;

    /*
    Take damage.
     */
    public int takeDamage(int d) {
        return 0;
    }

    /*
    Return ith child.
     */
    public EnemyObject getChild(int child) {
        return null;
    }

    /*
    Actions to perform on death.
     */
    public void Die() {
    }

    /*
    Add child EnemyObject.
     */
    public void add(EnemyObject child) {
    }

    public void remove(EnemyObject child){}
}

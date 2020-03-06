package zombiegame.zombiebuilder;

/*
Represents Zombie enemy. Serves as composite class in composite pattern Serves as composite class in composite pattern.
 */
public class Zombie extends EnemyObject {

    /*
    Create new instance of Zombie.
     */
    public Zombie() {
        this.setHealth(50);
    }

    public int getHealth() {
        int health = super.getHealth();
        for (var accessory : this.children) {
            health += accessory.getHealth();
        }
        return health;
    }

    /*
    Return ith child.
     */
    public EnemyObject getChild(int child) {
        if (this.children.size() <= 0) {
            return null;
        }
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

    public int takeDamage(int d) {
        int leftover = d;
        while (this.children.size() > 0 && leftover > 0) {
            leftover = this.children.get(this.children.size()-1).takeDamage(leftover);
            if (this.children.get(this.children.size()-1).Die()) {
                this.children.remove(this.children.size()-1);
            }
        }

        if (leftover > 0) {
            leftover = super.takeDamage(leftover);
        }

        return leftover;
    }

    public String getType() {
        if (this.getChild(0) == null) {
            return "R";
        }
        if (this.getChild(0) instanceof Cone) {
            return "C";
        }
        if (this.getChild(0) instanceof Bucket) {
            return "B";
        }
        if (this.getChild(0) instanceof Door) {
            return "S";
        }
        return null;
    }
}

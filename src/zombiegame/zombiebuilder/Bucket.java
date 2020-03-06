package zombiegame.zombiebuilder;

/*
Represents a zombie bucket. Leaf in composite pattern.
 */
class Bucket extends EnemyObject{
    public Bucket() {
        this.setHealth(100);
    }
}

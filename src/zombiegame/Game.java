package zombiegame;

import zombiegame.zombiebuilder.*;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Vector;

/*
Coordinates Zombie game.
 */
public class Game {
    private ZombieBuilder zombieBuilder = new ZombieBuilder();
    private Scanner input = new Scanner(System.in);
    private PrintStream out = System.out;
    private Vector<Zombie> zombies = new Vector<Zombie>();
    private Runnable state = this::mainMenu;

    /*
    Return new regular zombie.
     */
    private Zombie constructZombie() {
        this.zombieBuilder.buildZombie();
        return this.zombieBuilder.getZombie();
    }

    /*
    Return new cone zombie.
     */
    private Zombie constructConeZombie() {
        this.zombieBuilder.buildZombie();
        this.zombieBuilder.buildCone();
        return this.zombieBuilder.getZombie();
    }

    /*
    Return new bucket zombie.
     */
    private Zombie constructBucketZombie() {
       this.zombieBuilder.buildZombie();
       this.zombieBuilder.buildBucket();
       return this.zombieBuilder.getZombie();
    }

    /*
    Return new door zombie.
     */
    private Zombie constructDoorZombie() {
        this.zombieBuilder.buildZombie();
        this.zombieBuilder.buildDoor();
        return this.zombieBuilder.getZombie();
    }
    
    private void printZombies() {
        this.out.print("[");

        for (var zombie : this.zombies) {
            this.out.printf("%s/%d, ", zombie.getType(), zombie.getHealth());
        }

        if (this.zombies.isEmpty()) {
            this.out.print("]");
        } else {
            this.out.print("\b\b]");
        }

        this.out.print("\n");
    }

    // states
    private void mainMenu() {
        this.out.print("Zombies: ");
        this.printZombies();
        this.out.println("1. Create zombies?\n2. Demo game play?\n3. Exit\n");

        switch (this.input.nextInt()) {
            case 1: this.state = this::createZombieMenu; break;
            case 2: this.state = this::playDemo; break;
            case 3: this.state = null; break;
            default: this.out.println("Invalid entry\n"); break;
        }
    }

    private void createZombieMenu() {
        out.println("Which kind?\n1. Regular\n2. Cone\n3. Bucket\n4. ScreenDoor\n");

        switch (this.input.nextInt()) {
            case 1: this.zombies.add(this.constructZombie()); break;
            case 2: this.zombies.add(this.constructConeZombie()); break;
            case 3: this.zombies.add(this.constructBucketZombie()); break;
            case 4: this.zombies.add(this.constructDoorZombie()); break;
            default: this.out.println("Invalid entry\n"); break;
        }

        this.state = this::mainMenu;
    }

    private void playDemo() {
        this.out.println("Please enter pea shooter damage: ");
        this.simulate(this.input.nextInt());
        this.state = this::mainMenu;
    }

    private void simulate(int damage) {
        int round = 1;

        this.out.println("Start:");
        this.printZombies();

        while (this.zombies.size() > 0) {
            this.zombies.get(0).takeDamage(damage);

            if (this.zombies.get(0).die()) {
                this.zombies.remove(0);
            }

            this.out.println("Round " + round++ + ":");
            this.printZombies();
        }

        this.out.println("All zombies killed.\n");
    }

    public void runApp() {
        while (this.state != null) {
            this.state.run();
        }
    }
}

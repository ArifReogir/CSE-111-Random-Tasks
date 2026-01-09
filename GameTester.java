/*Design a set of classes for a Fantasy Game Character System. There is a parent class called Character. From it, there are two different child classes: Warrior and Mage. Additionally, there is a subclass called Paladin that extends Warrior.
Each character has:
name (String)
level (int)
Lastly, you need to Override the .equals() method inside the parent class   */

public class GameTester { // Driver code
    public static void main(String[] args) {
        Character c1 = new Paladin("Arthur", 10);
        Character c2 = new Mage("Merlin", 12);
        Character c3 = new Warrior("Leon", 10);

        c1.specialMove();
        c2.specialMove();
        c3.specialMove();

        if (c1 instanceof Paladin) {
            Paladin p = (Paladin) c1;
            p.specialMove();
        }

        Warrior w1 = new Warrior("Leon", 10);
        System.out.println("c3 equals w1? " + c3.equals(w1));

        Mage m1 = new Mage("Merlin", 15);
        System.out.println("c2 equals m1? " + c2.equals(m1));
    }
}

// Class starts here

class Character { // Parent class
    public String name;
    public int level;

    public Character(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public void specialMove() {
        System.out.println("Character uses a generic move.");
    }

    public boolean equals(Warrior w) {
        Character c = (Character) w;

        return name.equals(c.name) && level == c.level;
    }
}

class Warrior extends Character {

    public Warrior(String name, int level) {
        super(name, level);
    }

    public void specialMove() {
        System.out.println(name + " performs a heavy sword slash!");
    }

}

class Paladin extends Warrior {

    public Paladin(String name, int level) {
        super(name, level);
    }

    public void specialMove() {
        System.out.println(name + " unleashes a holy strike!");
    }
}

class Mage extends Character {

    public Mage(String name, int level) {
        super(name, level);
    }

    public void specialMove() {
        System.out.println(name + " casts a powerful fireball!");
    }
}
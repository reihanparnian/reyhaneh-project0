import java.util.Arrays;
import java.util.Random;

/**
 * This class simulates a sim person (functionality).
 *
 * @author rparnian
 * @version 1.0 Build 2024.01.30
 */
public class SimPerson {
    private String name;
    private int age;
    private String job;
    private boolean isWizard;
    private final String[] carrying = new String[5];

    /**
     * The default constructor that takes no parameters.
     */
    public SimPerson() {
        this.name = "Jay Doe";
        this.age = 0;
        this.job = "freelancer";
        this.isWizard = false;
    }
    
    /**
     * The constructor that takes in four parameters to assign to each of these 4 instance variables.
     *
     * @param name the name of the sim person.
     * @param age the age of the sim person.
     * @param job the job of the sim person.
     * @param isWizard whether the sim person is a wizard or not.
     */
    public SimPerson(String name,  int age, String job, boolean isWizard) {
        this.name = name;
        this. age = age;
        this.job = job;
        this.isWizard = isWizard;
    }

    /**
     * Get the name of the sim person.
     *
     * @return the name of the sim person.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the age of the sim person.
     *
     * @return the age of the sim person.
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Get the job of the sim person.
     *
     * @return the job of the sim person.
     */
    public String getJob() {
        return this.job;
    }

    /**
     * See if the sim person is a wizard or not.
     *
     * @return whether the sim person is a wizard or not.
     */
    public boolean getIsWizard() {
        return this.isWizard;
    }

    /**
     * Get the things the sim person is carrying.
     *
     * @return a list of the things the sim person is carrying.
     */
    public String getCarrying() {
        return Arrays.toString(carrying);
    }

    /**
     * Change the sim person's age.
     *
     * @param age the new age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Change the sim person's name.
     *
     * @param name the new name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Change the sim person's job.
     *
     * @param job the new job.
     */
    public void setJob(String job) {
        this.job = job;
    }

    int nextSlot = 0;

    /**
     *  takes in a String item to be added to what this SimPerson is carrying.
     *
     * @param item the item that will be added to what the sim person is carrying.
     */
    public void takeItem(String item) {
        carrying[nextSlot] = item;
        System.out.println("Added '" + item + "' to inventory slot " + nextSlot + ".");
        if (nextSlot == carrying.length - 1) {
            nextSlot = 0;
        } else {
            nextSlot++;
        }
    }

    /**
     * takes in a String item to be added to what this SimPerson is carrying,
     * as well as an index position where to place it specifically.
     *
     * @param item the item that will be added to what the sim person is carrying.
     * @param index the index at which we this item will be placed.
     * @return the new state of the list of the things the person is carrying.
     */
    public String takeItemAt(String item, int index) {
        this.carrying[index] = item;
        return "Your new list looks like: " + Arrays.toString(this.carrying) + " now!";
    }

    /**
     * doesn't change your array of what's being carried, but just lets you peek at what is at a provided index position
     *
     * @param index the index of the item we want to look at.
     * @return the item at the specific index provided.
     */
    public String viewItemAt(int index) {
        if (index>=0 && index<=this.carrying.length) {
            return "the item at this index is " + this.carrying[index];
        } else {
            return "We don't have an item with that index.";
        }
    }

    /**
     * removes the element in someone's inventory at a requested index position.
     *
     * @param index the index of the item we want to drop.
     * @return the new state of the list of the things the sim person is carrying.
     */
    public String dropItemAt(int index) {
        if (index>=0 && index<=this.carrying.length) {
            String droppedItem = this.carrying[index];
            this.carrying[index] = null;
            return "the item you dropped is " + droppedItem;
        } else {
            return "We don't have an item with that index.";
        }
    }

    /**
     * allows the sim person (if they're a wizard) to cast a magical spell on the other SimPerson and - provided the spell
     * succeeds by random chance - take the object (if any) in their inventory at that index position by using takeItem().
     *
     * @param magicalSpell the name of the magical spell.
     * @param index the index of the item wanted.
     * @param other the other sim person that we will cast a spell on.
     * @return whether the spell was successful or not.
     */
    public boolean castSpell(String magicalSpell, int index, SimPerson other) {
        if (!this.isWizard) {
            System.out.println(this.name + " is not a wizard and cannot cast spells!");
            return false;
        }

        if (index < 0 || index >= this.carrying.length) {
            System.out.println("Invalid index! Spell failed.");
            return false;
        }

        Random rand = new Random();
        int upperBound = 2;
        int lowerBound = 1;
        int randomInt2 = rand.nextInt(lowerBound, upperBound + 1);
        if (randomInt2 == 1) {
            System.out.println(name + " successfully cast " + magicalSpell + " on " + other.name + " at slot " + index + "!");
            if (other.carrying[index] != null) {
                this.takeItem(other.carrying[index]);
                other.dropItemAt(index);
                System.out.println( "your list looks like : " + Arrays.toString(this.carrying) + " and the other person's list looks like: " +  Arrays.toString(other.carrying));
            } else {
                System.out.println("The spell succeeded, but there was nothing to take.");
            }
            return true;
        } else {
            System.out.println(name + " failed to cast " + magicalSpell + ".");
            return false;
        }
    }

    /**
     *  represents each SimPerson.
     *
     * @return a sentence representing the sim person.
     */
    public String toString() {
        if (isWizard) {
            return this.name + " is a " + this.age + "-year-old " + this.job + " and a wizard.";
        } else {
            return this.name + " is a " + this.age + "-year-old " + this.job + ".";
        }
    }

}


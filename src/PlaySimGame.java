/**
 * This class serves as the main program for playing through a version of the SimPerson game.
 * It demonstrates creating SimPerson objects, modifying their attributes, and interacting with them.
 *
 * @author rparnian
 * @version 1.0 Build 2024.01.30
 */
public class PlaySimGame {
    public static void main(String[] args) {
        System.out.println("Let's create two SimPerson objects.");
        SimPerson person1 = new SimPerson("John", 18, "student", true);
        SimPerson person2 = new SimPerson();

        System.out.println("\ngetting to know each simPerson...");
        System.out.println(person1);
        System.out.println(person2);


        System.out.println("\nAssigning items to each SimPerson...");
        person1.takeItem("book");
        person1.takeItem("lamp");
        person1.takeItem("notebook");
        person1.takeItem("gum");
        person1.takeItem("water");

        person2.takeItem("scissors");
        person2.takeItem("pen");
        person2.takeItem("highlighter");
        person2.takeItem("nuts");
        person2.takeItem("glasses");

        System.out.println("\nCurrent items carried:");
        System.out.println("person1: " + person1.getCarrying());
        System.out.println("person2: " + person2.getCarrying());

        System.out.println("\nSwapping an item at index 1:");
        System.out.println(person1.takeItemAt("light bulb" , 1));
        System.out.println(person1.takeItemAt("pencil" , 1));

        System.out.println("\nViewing items at index 2:");
        System.out.println(person1.viewItemAt(2));
        System.out.println(person2.viewItemAt(2));

        System.out.println("\nDropping items at specified indices:");
        System.out.println(person1.dropItemAt(3));
        System.out.println(person2.dropItemAt(4));

        System.out.println("\nUpdated inventory:");
        System.out.println(person1.getCarrying());
        System.out.println(person2.getCarrying());


        System.out.println("\nChecking wizard status:");
        System.out.println("Wizard status for person1: " + person1.getIsWizard());
        System.out.println("Wizard status for person2: " + person2.getIsWizard());


        System.out.println("\nCasting spells...");
        person1.castSpell("confusion" , 2 , person2);
        person2.castSpell("confusion" , 1 , person1);

        System.out.println("\nUpdating Person1's attributes...");
        person1.setAge(20);
        System.out.println("this person is " + person1.getAge() + " years old.");
        person1.setJob("professor");
        System.out.println("this person is a " + person1.getJob() + ".");
        person1.setName("Jenna");
        System.out.println("this person is named " + person1.getName() + ".");

    }
}

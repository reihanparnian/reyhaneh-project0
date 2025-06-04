/**
 * This class runs test cases to verify the correctness of the SimPerson program.
 */
public class TestSimGame {

    /**
     * Displays the result of a test function.
     * @param result The boolean result of the test (true if passed, false if failed).
     * @param test The name of the function being tested.
     */
    public static void displayTestResult(boolean result , String test){
        if (result){
            System.out.println("PASSED: " + test);
        }else{
            System.out.println("FAILED: " + test);
        }
    }

    /**
     * Tests the toString() method.
     * @return True if the method returns the expected output, false otherwise.
     */
    public static boolean testToString() {
        SimPerson testPerson1 = new SimPerson("Alice", 30, "Engineer", true);
        return testPerson1.toString().equals("Alice is a 30-year-old Engineer and a wizard.");
    }

    /**
     * Tests the defaultSimPerson() method.
     * @return True if the method correctly resets a SimPerson's attributes, false otherwise.
     */
    public static boolean testDefaultSimPerson() {
        SimPerson testPerson2 = new SimPerson();
        return testPerson2.toString().equals("Jay Doe is a 0-year-old freelancer.");
    }

    /**
     * Tests the setAge() and getAge() methods.
     * @return True if the age is correctly updated, false otherwise.
     */
    public static boolean testSetAge() {
        SimPerson testPerson3 = new SimPerson("Alice", 30, "Engineer", true);
        testPerson3.setAge(45);
        int result =  testPerson3.getAge();
        return result == 45;

    }

    /**
     * Tests the takeItem() method.
     * @return True if items are correctly stored, false otherwise.
     */
    public static boolean testTakeItem() {
        SimPerson testPerson4 = new SimPerson("Alice", 30, "Engineer", true);
        testPerson4.takeItem("Book");
        testPerson4.takeItem("Pen");
        testPerson4.takeItem("Notebook");
        testPerson4.takeItem("Phone");
        testPerson4.takeItem("Laptop");
        testPerson4.takeItem("Headphones");
        return testPerson4.getCarrying().equals("[Headphones, Pen, Notebook, Phone, Laptop]");
    }

     /**
     * Tests the takeItemAt() method.
     * @return True if an item is replaced at the correct index, false otherwise.
     */
    public static boolean testTakeItemAt() {
        SimPerson testPerson5 = new SimPerson("Alice", 30, "Engineer", true);
        testPerson5.takeItem("Magic Wand");
        testPerson5.takeItem("Potion");
        testPerson5.takeItemAt("Book", 0);
        return testPerson5.getCarrying().equals("[Book, Potion, null, null, null]");

    }

    /**
     * Tests the castSpell() method.
     * @return True if spells are only cast by wizards and fail for non-wizards, false otherwise.
     */
    public static boolean testCastSpell() {
        SimPerson testPerson6 = new SimPerson("Alice", 30, "Engineer", false);
        SimPerson testPerson7 = new SimPerson("Mary", 30, "Engineer", true);
        boolean result1 = testPerson6.castSpell("Levitate", 0, testPerson7);
        if (result1) {
            return false; // Should fail because testPerson6 is not a wizard
        }
        testPerson7.takeItem("Magic Stone");
        boolean result2 = testPerson7.castSpell("Levitate", 0, testPerson6 );
        return result2; // Should pass because testPerson7 is a wizard
    }

    /**
     * The main method to run all test cases.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args){
        displayTestResult(testToString(), "test Constructor and toString()");
        displayTestResult(testDefaultSimPerson(), "test defaultSimPerson()");
        displayTestResult(testSetAge(), "test setAge() and getAge()");
        displayTestResult(testTakeItem(), "test takeItem()");
        displayTestResult(testTakeItemAt(), "test takeItemAt()");
        displayTestResult(testCastSpell(), "test castSpell()");

    }
}

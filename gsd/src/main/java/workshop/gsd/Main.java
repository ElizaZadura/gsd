package workshop.gsd;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Person eliza = new Person(22, "Eliza", "Zadura", "eliza@zadura.se");
        System.out.println(eliza.getSummary() + "\nRun tests to see what else is here :)");

    }
}

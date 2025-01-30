package workshop.gsd;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        LocalDate deadLine = LocalDate.parse("2025-12-02");
        Person eliza = new Person("Eliza", "Zadura", "eliza@zadura.se");
        TodoItem item = new TodoItem("Item", deadLine, eliza);
        TodoItemTask task = new TodoItemTask(item, eliza);

        System.out.println(eliza.getSummary()  + "\n" + item.getSummary() + "\nRun tests to see what else is here :)");
        System.out.println(task.getSummary());

    }
}

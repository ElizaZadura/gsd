package workshop.gsd;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {

        try {
            LocalDate deadLine = LocalDate.parse("2025-12-02");
            Person eliza = new Person("Eliza", "Zadura", "eliza@zadura.se");
            TodoItem item = new TodoItem("Item", deadLine, eliza);
            TodoItemTask task = new TodoItemTask(item, eliza);
            task.setAssignee(eliza);

            logSummaries(eliza.toString(), item.toString(), task.toString());
        } catch (Exception e) {
            logger.log(Level.SEVERE, String.format("An error occurred: %s", e.getMessage()), e);
        }
    }

    private static void logSummaries(String... summaries) {
        String message = String.join("\n", summaries);
        logger.log(Level.INFO, message);
    }
}

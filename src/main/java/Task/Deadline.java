package Task;

/**
 * Represents a task with a deadline.
 * A Deadline task includes a description and a due date/time.
 */
public class Deadline extends Task {

    protected String by;

    /**
     * Creates a new Deadline task with the given description and due date/time.
     *
     * @param description The description of the Deadline task.
     * @param by The due date/time of the task.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
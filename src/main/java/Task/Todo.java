package Task;

/**
 * Represents a Todo task, which is a basic task with only a description.
 * A Todo does not have a deadline or a specific time associated with it.
 */
public class Todo extends Task {

    /**
     * Creates a new Todo task with the given description.
     *
     * @param description The description of the Todo task.
     */
    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}

package Task;

/**
 * Represents a task with a description and completion status.
 * A task can be marked as complete or incomplete.
 */
public class Task {
    protected String description;
    protected boolean isCompleted;

    /**
     * Creates a new task with the given description.
     * By default, the task is set to incomplete.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /**
     * Returns the status icon of the task.
     * "X" represents a completed task, while " " represents an incomplete task.
     *
     * @return "X" if the task is completed, otherwise " ".
     */
    public String getStatusIcon() {
        return (isCompleted ? "X" : " "); // mark done task with X
    }

    public void markAsComplete() {
        isCompleted = true;
    }

    public void markAsIncomplete() {
        isCompleted = false;
    }

    public String getDescription() {
        return description;
    }

}

public class Task {
    protected String description;
    protected boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    public String getStatusIcon() {
        return (isCompleted ? "X" : " "); // mark done task with X
    }

    public void markAsComplete() {
        isCompleted = true;
    }

    public void markAsIncomplete() {
        isCompleted = false;
    }

}

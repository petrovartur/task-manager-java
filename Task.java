public class Task {

    private int id;
    private String title;
    private String description;
    private TaskStatus status;
    private Priority priority;
    private int assigneeId;
    private int projectId;

    public Task(int id, String title, String description,
                TaskStatus status,
                Priority priority,
                int assigneeId,
                int projectId) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.assigneeId = assigneeId;
        this.projectId = projectId;
    }

    public int getId() {
        return id;
    }

    public int getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(int assigneeId) {
        this.assigneeId = assigneeId;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Task ID=" + id +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                ", assigneeId=" + assigneeId;
    }
}

package sets.hashset.challenge;

import java.util.Objects;

enum Status {
    IN_QUEUE,
    ASSIGNED,
    IN_PROGRESS
}

enum Priority {
    HIGH,
    MEDIUM,
    LOW
}

public class Task implements Comparable<Task> {

    private String project;
    private String description;
    private Priority priority;
    private Status status;
    private String assignee;

    public Task(String project, String description, String assignee, Priority priority, Status status) {
        this.project = project;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.assignee = assignee;
    }

    public Task(String project, String description, String assignee, Priority priority) {
        this(project, description, assignee, priority, assignee == null ? Status.IN_QUEUE : Status.ASSIGNED);
    }

    public Task(String project, String description, Priority priority) {
        this(project, description, null, priority);
    }

    @Override
    public int compareTo(Task task) {
        int result = project.compareTo(task.project);
        if (result == 0) {
            result = description.compareTo(task.description);
        }
        return result;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(project, task.project) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project, description);
    }

    @Override
    public String toString() {
        return "%-20s %-25s %-10s %-10s %s".formatted(project, description, priority,
                assignee, status);
    }
}

package sets.hashset.challenge;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Task> tasks = TaskData.getTasks("all");
        sortAndPrint("All Tasks", tasks);

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
        Set<Task> annsTasks = TaskData.getTasks("ann");
        sortAndPrint("Ann's Tasks", annsTasks, sortByPriority);

        //////////////////////////////////////////////////////

        Set<Task> allTasks = TaskData.getTasks("all");
        Set<Task> annTasks = TaskData.getTasks("ann");
        Set<Task> bobTasks = TaskData.getTasks("bob");
        Set<Task> carolTasks = TaskData.getTasks("carol");

        Set<Task> fullTasksSet = getUnion(List.of(allTasks, annTasks, bobTasks, carolTasks));
        sortAndPrint("Full Task List", fullTasksSet);

        Comparator<Task> sortByAssigneeAndProjectAndDescription = Comparator.comparing(Task::getAssignee)
                .thenComparing(Task::getProject)
                .thenComparing(Task::getDescription);
        Set<Task> AssignedTasksSet = getUnion(List.of(annTasks, bobTasks, carolTasks));
        sortAndPrint("Task Assigned To At Least One Of Team Members", AssignedTasksSet, sortByAssigneeAndProjectAndDescription);

        Set<Task> tasksWithoutAssigneeSet = getDifference(fullTasksSet, AssignedTasksSet);
        sortAndPrint("Tasks Without Assignee", tasksWithoutAssigneeSet);

        Set<Task> tasksWithMultipleAssignees = getUnion(List.of(
                getIntersect(annTasks, bobTasks),
                getIntersect(bobTasks, carolTasks),
                getIntersect(annTasks, carolTasks)));
        sortAndPrint("Tasks Assigned To Multiple Employees", tasksWithMultipleAssignees);

    }

    public static void sortAndPrint(String header, Collection<Task> collection) {
        sortAndPrint(header, collection, null);
    }

    public static void sortAndPrint(String header, Collection<Task> collection, Comparator<Task> sorter) {
        String lineSeparator = "-".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);

        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);
    }

    private static Set<Task> getUnion(List<Set<Task>> sets) {
        Set<Task> unionSet = new HashSet<>();
        for (Set<Task> set : sets) {
            unionSet.addAll(set);
        }
        return unionSet;
    }

    private static Set<Task> getIntersect(Set<Task> setA, Set<Task> setB) {
        Set<Task> intersectAB = new HashSet<>(setA);
        intersectAB.retainAll(setB);
        return intersectAB;
    }

    private static Set<Task> getDifference(Set<Task> setA, Set<Task> setB) {
        Set<Task> diffAB = new HashSet<>(setA);
        diffAB.removeAll(setB);
        return diffAB;
    }




}

package sets.hashset.challenge;

import java.util.*;

public class TaskData {

    private static final String tasks = """
            Infrastructure, Logging, High
            Infrastructure, DB Access, Medium
            Infrastructure, Security, High
            Infrastructure, Password Policy, Medium
            Data Design, Task Table, Medium
            Data Design, Employee Table, Medium
            Data Design, Cross Reference Tables, High
            Data Design, Encryption Policy, High
            Data Access, Write Views, Low
            Data Access, Set Up Users, Low
            Data Access, Set Up Access Policy, Low
            """;

    private static final String annsTasks = """
            Infrastructure, Security, High, In Progress
            Infrastructure, Password Policy,Medium, In Progress
            Research, Cloud solutions, Medium, In Progress
            Data Design, Encryption Policy, High
            Data Design, Project Table, Medium
            Data Access, Write Views,Low, In Progress
            """;

    private static final String bobsTasks = """
            Infrastructure, Security, High, In Progress
            Infrastructure, Password Policy, Medium
            Data Design,Encryption Policy,High
            Data Access,Write Views, Low, In Progress
            """;

    private static final String carolsTasks = """
            Infrastructure, Logging, High, In Progress
            Infrastructure, DB Access, Medium
            Infrastructure, Password Policy, Medium
            Data Design, Task Table, High
            Data Access, Write Views, Low
            """;

    public static Set<Task> getTasks(String owner) {
        Set<Task> taskList = new HashSet<>();
        String user = ("ann,bob,carol".contains(owner.toLowerCase())) ? owner : null;
        String selectedList = switch(owner.toLowerCase()) {
          case "ann" -> annsTasks;
          case "bob" -> bobsTasks;
          case "carol" -> carolsTasks;
          default -> tasks;
        };

        Scanner scanner = new Scanner(selectedList);
        while (scanner.hasNext()) {
            String[] lineData = scanner.nextLine().split(",");
            Arrays.asList(lineData).replaceAll(String::trim);

            Status status = (lineData.length <= 3) ? Status.IN_QUEUE :
                    Status.valueOf(lineData[3].
                            toUpperCase().replace(' ', '_'));

            Priority priority = Priority.valueOf(lineData[2].toUpperCase());
            taskList.add(new Task(lineData[0], lineData[1], user,
                    priority, status));
        }

        return taskList;
    }
}

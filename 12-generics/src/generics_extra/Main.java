package generics_extra;

import generics_extra.model.LPAComparator;
import generics_extra.model.LPAStudent;
import generics_extra.model.Student;
import generics_extra.util.QueryItem;
import generics_extra.util.QueryList;

import java.util.Comparator;
import java.util.List;

record Employee(String name) implements QueryItem {

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}

public class Main {

    public static void main(String[] args) {

        QueryList<LPAStudent> queryList = new QueryList<>();
        for (int i = 0; i < 25; i++) {
            queryList.add(new LPAStudent());
        }

        System.out.println("Ordered");
        queryList.sort(Comparator.naturalOrder());
        printList(queryList);

        System.out.println("Matches");
        var matches = queryList
                .getMatches("PercentComplete", "50")
                        .getMatches("Course", "Python");

        matches.sort(new LPAComparator());
        printList(matches);

        System.out.println("Ordered");
        matches.sort(Comparator.naturalOrder());
        printList(matches);

    }

    public static void printList(List<? extends Student> students) {

        for (var student : students) {
            System.out.println(student);
        }
    }
}

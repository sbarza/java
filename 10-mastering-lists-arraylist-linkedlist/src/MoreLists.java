import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MoreLists {

    public static void main(String[] args) {

        String[] items = {"apples", "bananas", "milk", "eggs"};

        List<String> list = List.of(items);
        System.out.println(list);
        System.out.println(list.getClass().getName());
        System.out.println("=============================\n");

        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("yogurt");
        System.out.println(groceries);
        System.out.println("=============================\n");

        ArrayList<String> nextList = new ArrayList<>(
                List.of("pickles", "mustard", "cheese"));
        System.out.println(nextList);
        System.out.println("=============================\n");

        groceries.addAll(nextList);
        System.out.println(groceries);
        System.out.println("=============================\n");

        System.out.println("Third item = " + groceries.get(2));
        System.out.println("=============================\n");

        if (groceries.contains("mustard")) {
            System.out.println("List contains mustard");
            System.out.println("=============================\n");
        }

        groceries.add("yogurt");
        System.out.println(groceries);
        System.out.println("first = " + groceries.indexOf("yogurt"));
        System.out.println("last = " + groceries.lastIndexOf("yogurt"));
        System.out.println("=============================\n");

        System.out.println(groceries);
        groceries.remove(1);
        System.out.println(groceries);
        groceries.remove("yogurt");
        System.out.println(groceries);
        System.out.println("=============================\n");

        groceries.removeAll(List.of("apples", "eggs"));
        System.out.println(groceries);
        System.out.println("=============================\n");

        groceries.retainAll(List.of("apples", "milk", "mustard", "cheese"));
        System.out.println(groceries);
        System.out.println("=============================\n");

        groceries.clear();
        System.out.println(groceries);
        System.out.println("isEmpty = " + groceries.isEmpty());
        System.out.println("=============================\n");

        groceries.addAll(List.of("apples", "milk", "mustard", "cheese"));
        groceries.addAll(Arrays.asList("eggs", "pickles", "mustard", "ham"));
        System.out.println(groceries);
        System.out.println("=============================\n");

        System.out.println(groceries);
        groceries.sort(Comparator.naturalOrder());
        System.out.println(groceries);

        groceries.sort(Comparator.reverseOrder());
        System.out.println(groceries);
        System.out.println("=============================\n");
        System.out.println(groceries.size());

        var groceryArray = groceries.toArray(new String[groceries.size()]);
        System.out.println(Arrays.toString(groceryArray));
        System.out.println("=============================\n");

    }
}

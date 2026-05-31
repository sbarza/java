import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class IntroLinkedLists {

    public static void main(String[] args) {
        LinkedList<String> places = new LinkedList<>();

        places.add("Sydney");
        places.add(0, "Canberra");
        System.out.println(places);

        addMoreElements(places);
        System.out.println(places);

//        removeElements(places);
//        System.out.println(places);

        gettingElements(places);

    }

    private static void removeElements(LinkedList<String> list) {
        list.remove(4);
        list.remove("Brisbane");

        System.out.println(list);
        String s1 = list.remove();
        System.out.println(s1 + " was removed");

        String s2 = list.removeFirst();
        System.out.println(s2 + " was removed");

        String s3 = list.removeLast();
        System.out.println(s3 + " was removed");

        // Queue/Deque poll methods
        String p1 = list.poll();
        System.out.println(p1 + " was removed");

        String p2 = list.pollFirst();
        System.out.println(p2 + " was removed");

        String p3 = list.pollLast();
        System.out.println(p3 + " was removed");

        list.push("Sydney");
        list.push("Brisbane");
        list.push("Canberra");
        System.out.println(list);

        // Stack pop methods
        String p4 = list.pop();
        System.out.println(p4 + " was removed");

    }

    private static void addMoreElements(LinkedList<String> list) {
        list.addFirst("Darwin");
        list.addLast("Hobart");

        // Queue methods
        list.offer("Melbourne");
        list.offerFirst("Brisbane");
        list.offerLast("Toowoomba");

        // Stack methods
        list.push("Alice Springs");

    }

    private static void gettingElements(LinkedList<String> list) {
        System.out.println();

        System.out.println(list);
        System.out.println("Retrieved Element = " + list.get(4));

        System.out.println("First Element = " + list.getFirst());
        System.out.println("Last Element = " + list.getLast());

        System.out.println("Darwin is at position: " + list.indexOf("Darwin"));
        System.out.println("Melbourne is at position: " + list.lastIndexOf("Melbourne"));

        // Queue retrieval method
        System.out.println(list);
        System.out.println("Element from element() = " + list.element());

        // Stack retrieval methods
        System.out.println(list);
        System.out.println("Element from peek() = " + list.peek());
        System.out.println("Element from peekFirst() = " + list.peekFirst());
        System.out.println("Element from peekLast() = " + list.peekLast());

    }
}

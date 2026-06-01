import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LinkedListChallenge {

    record Town(String name, int distance) {

        @Override
        public String toString() {
            return "%s (%d)".formatted(name, distance);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Town town) {
                return name.equalsIgnoreCase(town.name);
            }
            return false;
        }
    }

    public static void main(String[] args) {

        LinkedList<Town> towns = new LinkedList<>();

        addTown(towns, new Town("Adelaide", 1374));
        addTown(towns, new Town("Alice Springs", 2771));
        addTown(towns, new Town("Sydney", 0));
        addTown(towns, new Town("Brisbane", 917));
        addTown(towns, new Town("Darwin", 3975));
        addTown(towns, new Town("Melbourne", 877));
        addTown(towns, new Town("Perth", 3923));

        ListIterator<Town> iterator = towns.listIterator();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean isForward = true;

        showMenu();
        while (!quit) {
            if (!iterator.hasPrevious()) {
                System.out.println("Originating : " + iterator.next());
            }

            if (!iterator.hasNext()) {
                System.out.println("Final : " + iterator.previous());
            }

            System.out.print("Enter Value: ");
            String sOption = scanner.nextLine().toUpperCase();
            char option = sOption.charAt(0);

            switch (option) {
                case 'F' :
                    System.out.println("User wants to go forward");
                    // Adjusting Iterator's pointer
                    if (!isForward) {
                        isForward = true;
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                    }
                    if (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }

                    break;

                case 'B' :
                    System.out.println("User wants to go backward");
                    // Adjusting Iterator's pointer
                    if (isForward) {
                        isForward = false;
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println(iterator.previous());
                    }
                    break;

                case 'M' :
                    showMenu();
                    break;

                case 'L' :
                    System.out.println(towns);
                    break;

                default :
                    quit = true;
                    break;
            }
            System.out.println();

        }
    }

    private static void addTown(LinkedList<Town> list, Town town) {
        if (list.contains(town)) {
            System.out.println("Found duplicate: " + town);
            return;
        }

        ListIterator<Town> iterator = list.listIterator();
        boolean foundLocation = false;
        while (iterator.hasNext() && !foundLocation) {
            Town currentTown = iterator.next();

            if (town.distance < currentTown.distance) {
                foundLocation = true;
            }
        }

        // Set cursor's iterator to point correctly
        if (foundLocation) {
            iterator.previous();
        }

        iterator.add(town);
    }

    private static void listTowns(ListIterator<Town> iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
     }

    private static void showMenu() {
        String menuOptions = """
                Available actions (select word or letter):
                (F)orward
                (B)ackward
                (L)ist
                (M)enu
                (Q)uit""";

        System.out.println(menuOptions);
    }

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayVSArrayList {

    public static void main(String[] args) {

        // Creating List from Array: Arrays.asList() and List.of()

        // 1# Arrays.asList() method:
        // Accepts varargs as parameter (Array or arbitrary number of values)
        // Any change made to the List is a change to the array that backs it.
        // This also means that an ArrayList created by this method is not resizable.
        // This method returns a special List that is mutable, but not resizable.
        // Operations like add or remove will throw UnsupportedOperationException
        String[] array = {"First", "Second", "Third"};
        var list = Arrays.asList(array);

        list.set(0, "one");

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(array));
        System.out.println("================");
        System.out.println("List:");
        System.out.println(list);
        System.out.println();

        Arrays.sort(array);
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(array));
        System.out.println("================");
        System.out.println("List:");
        System.out.println(list);

        System.out.println();

        List<String> newList = Arrays.asList("Sunday", "Monday", "Tuesday");
        System.out.println(newList);
        // The code below throws UnsupportedOperationException
        // newList.remove("Monday");
        // System.out.println(newList);


        // 2# List.of() method:
        // Accepts varargs as parameter (Array or arbitrary number of values)
        // Returns a special immutable List.
        // Any change to this list throws UnsupportedOperationException
        var listOne = List.of("Sunday", "Monday");
        // Throws UnsupportedOperationException
        // listOne.set(0, "Tuesday");

        // Creating Array from List
        // List.toArray() method
        // This method takes one argument which should be an instance of a typed array.
        // This method return an array of the same type.
        // If the length of the array we pass has more elements than the list,
        // extra elements will be filled with the default values for the type.
        // If the length of the array we pass has less elements than the list,
        // the method will still return an array, with the same number of elements in it, as the list.
        ArrayList<String> stringList = new ArrayList<>(List.of("Jan", "Feb", "Mar"));
        var stringArray = stringList.toArray(new String[0]);
        System.out.println(Arrays.toString(stringArray));



    }

}

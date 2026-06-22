package custom_functional_interface;

public class Main {

    public static void main(String[] args) {

        String firstName = "sérgio";
        String lastName = "barza";

        String result = calculator(
                (s1, s2) -> s1.substring(0, 1).toUpperCase() + s1.substring(1).toLowerCase() + " " + s2.substring(0, 1).toUpperCase() + s2.substring(1).toLowerCase(),
                firstName,
                lastName);

        System.out.println(result);
    }

    public static <T> T calculator(Operation<T> function, T op1, T op2) {
        return function.operate(op1, op2);
    }

}

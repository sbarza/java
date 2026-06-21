package custom_functional_interface;

@FunctionalInterface
public interface Operation<T> {

    T operate(T value1, T value2);
}

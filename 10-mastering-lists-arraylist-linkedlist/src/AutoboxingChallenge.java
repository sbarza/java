import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class AutoboxingChallenge {

    record Customer(String name, ArrayList<Double> transactions) {

        public Customer(String name) {
            this(name, new ArrayList<>());
        }

        @Override
        public String toString() {
            return "%s: Transactions => %s".formatted(name, transactions);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Customer customer) {
                return this.name.equalsIgnoreCase(customer.name);
            }

            return false;
        }
    }

    static class Bank {
        private final String name;
        private final ArrayList<Customer> customers;

        public Bank(String name) {
            this.name = name;
            this.customers = new ArrayList<>();
        }

        public boolean addCustomer(String name) {
            Customer customer = findCustomer(name);

            if (customer != null) {
                System.out.println("Found duplicate: " + customer);
                return false;
            }

            customers.add(new Customer(name));
            return true;
        }

        public boolean addTransaction(String name, double value) {
            Customer customer = findCustomer(name);

            if (customer == null) {
                System.out.printf("Customer %s not found%n", name);
                return false;
            }

            customer.transactions().add(value);
            return true;
        }

        public void printStatement(String name) {
           Customer customer = findCustomer(name);

           if (customer == null) {
               System.out.printf("Customer %s not found%n", name);
               return;
           }

            System.out.println("-".repeat(30));
            System.out.printf("Customer Name: %s%n", name);
            Iterator<Double> iterator = customer.transactions.iterator();
            System.out.println("Transactions:");
            while (iterator.hasNext()) {
                double value = iterator.next();
                System.out.printf("$%10.2f (%s)%n", value, value < 0 ? "debit" : "credit");
            }
        }

        private Customer findCustomer(String customerName) {
            Customer c = new Customer(customerName);
            int index = customers.indexOf(c);

            if (index < 0) {
                return null;
            } else {
                return customers.get(index);
            }
        }

    }

    public static void main(String[] args) {
        Bank bank = new Bank("Bank Of America");
        bank.addCustomer("Ann");
        bank.addCustomer("Bob");
        bank.addCustomer("Dianna");
        bank.addCustomer("Brian");
        bank.addTransaction("Brian", 50.0);
        bank.addTransaction("Brian", -20.0);
        bank.printStatement("Brian");

    }
}

package maps.hashmap;

import sets.hashset.Contact;
import sets.hashset.ContactData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainMap {

    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        System.out.println("-----------------------------");

        Map<String, Contact> contacts = new HashMap<>();

        for (Contact contact : fullList) {
            contacts.put(contact.getName(), contact);
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("-----------------------------");
        System.out.println(contacts.get("Charlie Brown"));

        System.out.println(contacts.get("Chuck Brown"));

        Contact defaultContact = new Contact("Chuck Brown");
        System.out.println(contacts.getOrDefault("Chuck Brown", defaultContact));

        System.out.println("-----------------------------");
        contacts.clear();
        for (Contact contact : fullList) {
            Contact duplicate = contacts.put(contact.getName(), contact);
            if (duplicate != null) {
//                System.out.println("duplicate = " + duplicate);
//                System.out.println("current = " + contact);
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("----------------------------");
        contacts.clear();

        for (Contact contact : fullList) {
            contacts.putIfAbsent(contact.getName(), contact);
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("----------------------------");
        contacts.clear();

        for (Contact contact : fullList) {
            Contact duplicate = contacts.putIfAbsent(contact.getName(), contact);
            if (duplicate != null) {
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("----------------------------");
        contacts.clear();
        fullList.forEach(contact -> contacts.merge(contact.getName(), contact,
                Contact::mergeContactData
                ));
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("----------------------------");
        contacts.clear();
        Contact sergio = new Contact("Sérgio Barza");

        Contact result = contacts.merge(defaultContact.getName(), defaultContact,
                (c1, c2) -> {
                    System.out.println("Contact 1: " + c1);
                    System.out.println("Contact 2: " + c2);
                    return c1.mergeContactData(c2);
                });

        System.out.println("Contact from merge result method: " + result);

        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("----------------------------");
        contacts.clear();
        contacts.put(defaultContact.getName(), null);

        Contact result2 = contacts.merge(defaultContact.getName(), defaultContact,
                (c1, c2) -> {
                    System.out.println("Contact 1: " + c1);
                    System.out.println("Contact 2: " + c2);
                    return c1.mergeContactData(c2);
                });

        System.out.println("Contact from merge result method: " + result2);

        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("----------------------------");
        contacts.clear();
        contacts.put(sergio.getName(), sergio);

        Contact result3 = contacts.merge(sergio.getName(), defaultContact,
                (c1, c2) -> {
                    System.out.println("Contact 1: " + c1);
                    System.out.println("Contact 2: " + c2);
                    var c = c1.mergeContactData(c2);
                    System.out.println("Result Contact: " + c);
                    return c;
                });

        System.out.println("Contact from merge result method: " + result3);

        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

    }

}

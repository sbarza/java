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
        Contact sergio = new Contact("Sérgio Barza", "sb@gmail.com");
        Contact ana = new Contact("Ana Karla Barza", "akb@gmail.com");

        // No mapping in the map with key "Ana Karla Barza"
        // The value returned is the value passed in the parameter (ana contact)
        // The BiFunction is not computed
        // The key is now associated with ana contact
        Contact result = contacts.merge(ana.getName(), ana,
                (c1, c2) -> {
                    System.out.println("Contact 1: " + c1);
                    System.out.println("Contact 2: " + c2);
                    return c1.mergeContactData(c2);
                });

        System.out.println("Contact from merge result method: " + result);

        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("----------------------------");
        contacts.clear();
        contacts.put(ana.getName(), null);

        // There is a mapping with key "Ana Karla Barza" to value null
        // The value returned is the value passed in the parameter (ana contact)
        // The BiFunction is not computed
        // The key is now associated with ana contact
        Contact result2 = contacts.merge(ana.getName(), ana,
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

        // There is a mapping with key "Sérgio Barza" to value sergio contact
        // The value returned is the value returned from the remappingFunction
        // The BiFunction is computed
        // The key is now associated with the value returned from the remappingFunction
        Contact result3 = contacts.merge(sergio.getName(), ana,
                (c1, c2) -> {
                    System.out.println("Contact 1: " + c1);
                    System.out.println("Contact 2: " + c2);
                    var c = c1.mergeContactData(c2);
                    System.out.println("Result Contact: " + c);
                    return c;
                });

        System.out.println("Contact from merge result method: " + result3);

        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("----------------------------");
        contacts.clear();
        contacts.put(sergio.getName(), sergio);

        // There is a mapping with key "Sérgio Barza" to value sergio contact
        // The value returned is the value returned from the remappingFunction (in this case, null)
        // The BiFunction is computed
        // The entry for this specified key is removed, as the BiFunction returned null
        Contact result4 = contacts.merge(sergio.getName(), ana,
                (c1, c2) -> {
                    System.out.println("Contact 1: " + c1);
                    System.out.println("Contact 2: " + c2);
                    Contact c = null;
                    System.out.println("Result Contact: " + c);
                    return c;
                });

        System.out.println("Contact from merge result method: " + result4);
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        //
        System.out.println("----------------------------");
        contacts.clear();
        fullList.forEach(contact -> contacts.merge(contact.getName(), contact,
                Contact::mergeContactData
        ));
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("----------------------------");
        for (String  contactName : new String[] {"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}) {
//            contacts.compute(contactName, (k, v) -> new Contact(k));
//            contacts.computeIfAbsent(contactName, k -> new Contact(k));
            contacts.computeIfAbsent(contactName, k -> new Contact(k));

        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("----------------------------");
        for (String  contactName : new String[] {"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}) {
            contacts.computeIfPresent(contactName, (k, v) -> {
                v.addEmail("Fun Place");
                return v;
            });
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("----------------------------");
        contacts.replaceAll((k, v) -> {
            String newEmail = k.replaceAll(" ", "") + "@funplace.com";
            v.replaceEmailIfExists("DDuck@funplace.com", newEmail);
            return v;
        });
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("----------------------------");
        Contact daisy = new Contact("Daisy Jane Duck", "daisyj@duck.com");

        Contact replacedContact = contacts.replace("Daisy Duck", daisy);
        System.out.println("daisy = " + daisy);
        System.out.println("replacedContact = " + replacedContact);
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value = " + v));

        System.out.println("----------------------------");
        Contact updatedDaisy = replacedContact.mergeContactData(daisy);
        System.out.println("updatedDaisy = " + updatedDaisy);
        boolean success = contacts.replace("Daisy Duck", daisy, updatedDaisy);
        if (success) {
            System.out.println("Successfully replaced element");
        } else {
            System.out.printf("Did not match on both key: %s and value: %s %n".formatted("Daisy Duck", replacedContact));
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));

        System.out.println("----------------------------");
        success = contacts.remove("Daisy Duck", daisy);
        if (success) {
            System.out.println("Successfully removed element");
        } else {
            System.out.printf("Did not match on both key: %s and value: %s %n".formatted("Daisy Duck", daisy));
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value= " + v));
    }

}

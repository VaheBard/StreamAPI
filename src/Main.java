import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        /* this is the commented out code in order to make sure that everything works correctly*/
//        Person person1 = new Person("Gerhard", "Shryoder", 66, Sex.MAN, Education.HIGHER);
//        Person person2 = new Person("Anna", "Shryodera", 6, Sex.WOMAN, Education.HIGHER);
//        Person person3 = new Person("Mehatel", "Katu", 46, Sex.MAN, Education.HIGHER);
//        Person person4 = new Person("Yana", "Dreyk", 33, Sex.WOMAN, Education.HIGHER);
//        Person person5 = new Person("Yanm", "Inch", 23, Sex.MAN, Education.HIGHER);
//        Person person6 = new Person("Sonya", "Talker", 76, Sex.WOMAN, Education.HIGHER);
//        Person person7 = new Person("Dard", "Bard", 8, Sex.MAN, Education.HIGHER);
//        Person person8 = new Person("Vika", "Akim", 12, Sex.WOMAN, Education.HIGHER);
//        Person person9 = new Person("Hard", "Mard", 34, Sex.MAN, Education.HIGHER);
//        Person person10 = new Person("Ger", "Shr", 38, Sex.WOMAN, Education.HIGHER);
//        Collection<Person> persons = new ArrayList<>();
//        persons.add(person1);
//        persons.add(person2);
//        persons.add(person3);
//        persons.add(person4);
//        persons.add(person5);
//        persons.add(person6);
//        persons.add(person7);
//        persons.add(person8);
//        persons.add(person9);
//        persons.add(person10);
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }


        long count = persons.stream()
                .filter(p -> p.getAge() < 18)
                .count();
        System.out.println("Number of teenagers = " + count);

        persons.stream()
                .filter(s -> s.getSex() == Sex.MAN)
                .filter(s -> s.getAge() > 18 && s.getAge() < 27).
                map(Person::getFamily)
                .toList().
                forEach(System.out::println);

        persons.stream()
                .filter(f -> f.getEducation() == Education.HIGHER)
                .filter(f -> f.getSex() == Sex.WOMAN && f.getAge() > 18 && f.getAge() < 60 ||
                        f.getSex() == Sex.MAN && f.getAge() > 18 && f.getAge() < 65).
                sorted(Comparator.comparing(Person::getFamily)).
                map(Person::getFamily).
                toList().

                forEach(System.out::println);


    }

}


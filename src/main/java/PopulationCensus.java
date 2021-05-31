import java.util.*;
import java.util.stream.Collectors;

public class PopulationCensus {
    private Map<Integer, Person> populationCensus = new HashMap<>();


    public void addPerson(Person person) {
        populationCensus.put(person.getPersonID(), person); // HashMap с ключем PersonID
    }

    public Person removePerson(Integer personID) {
        return populationCensus.remove(personID);
    }

    public boolean listByName(String[] familyName) {
        populationCensus.values().stream()
                .filter(person -> (person.getFamily().equalsIgnoreCase(familyName[0])
                        && person.getName().equalsIgnoreCase(familyName[1])))
                .forEach(System.out::println);
        return isAvailableListByName(familyName);
    }

    private boolean isAvailableListByName(String[] familyName) {
        boolean isEmptyListByName = populationCensus.values().stream()
                .anyMatch(person -> (person.getFamily().equalsIgnoreCase(familyName[0])
                        && person.getName().equalsIgnoreCase(familyName[1])));
        System.out.print((isEmptyListByName) ? ""
                : "\t\t" + familyName[0] + " " + familyName[1] + " в базе данных переписи населения отсутствует.\n");
        return isEmptyListByName;
    }


    public int ageGroup(int age1, int age2) {

        long count = Arrays.stream(populationCensus.values().toArray(new Person[0]))
                .filter(person -> person.getAge() > age1 && person.getAge() < age2)
                .count();

        return (int) count;
    }

    public List<Person> ableBodiedPeople() {

        return populationCensus.values().stream()
                .filter(person -> person.getEducation() == Education.HIGHER)
                .filter(person -> (person.getSex() == Sex.FEMALE && person.getAge() > 17 && person.getAge() < 60)
                        || (person.getSex() == Sex.MALE && person.getAge() > 17 && person.getAge() < 65))
                .sorted(Comparator.comparing(Person::getFamily)
                        .thenComparing(Person::getName)
                        .thenComparing(Person::getPersonID))
                .collect(Collectors.toList());
    }

    public int ableBodiedPeopleCount() {

        long ableBodiedPeople = populationCensus.values().stream()
                .filter(person -> person.getEducation() == Education.HIGHER)
                .filter(person -> (person.getSex() == Sex.FEMALE && person.getAge() > 17 && person.getAge() < 60)
                        || (person.getSex() == Sex.MALE && person.getAge() > 17 && person.getAge() < 65))
                .count();

        return (int) ableBodiedPeople;
    }

    public List<String> conscriptFamilyList() {
        return populationCensus.values().stream()
                .filter(person -> person.getAge() > 17 && person.getAge() < 28)
                .filter(person -> person.getSex() == Sex.MALE)
                .map(Person::getFamily)
                .collect(Collectors.toList());
    }

    public void printPopulationCensus() {
        populationCensus.values().stream()
                .forEach(System.out::println);
    }
}


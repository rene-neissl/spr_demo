package api_test.demo;

public class Person {
    private final long _id;
    private final String _firstName;
    private final String _lastName;
    private final int _age;

    public Person(long id, String firstName, String lastName, int age) {
        _id = id;
        _firstName = firstName;
        _lastName = lastName;
        _age = age;
    }

    public long getId() { return _id; }

    public String getFirstName() { return _firstName; }

    public String getLastName() { return _lastName; }

    public int getAge() { return _age; }
}

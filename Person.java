public class Person {
    private String name;
    private String surname;
    private String email;

    public Person(String name, String surname, String email) {
        this.name = name; //name variable(defined in this Person class) = name(within this method)
        this.surname = surname;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

/*
https://www.freecodecamp.org/news/default-constructor-in-java/
Task 9) Create a new class file called Person (Person.java) with a constructor and the
        following attributes: name, surname, and email. Add a constructor that takes the 3
        variables as input to create an object Person. */


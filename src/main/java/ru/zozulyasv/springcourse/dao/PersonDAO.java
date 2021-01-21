package ru.zozulyasv.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.zozulyasv.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int PEOPLE_COUNT;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Nikita"));
        people.add(new Person(++PEOPLE_COUNT, "Boka"));
        people.add(new Person(++PEOPLE_COUNT, "Joka"));
        people.add(new Person(++PEOPLE_COUNT, "Nikolay"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

}

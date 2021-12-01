package ru.zozulyasv.springcourse.models;

/**
 * todo Document type Project
 */
public class Project {
    private int id;
    private String name;

    public Project() {

    }

    public Project(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}

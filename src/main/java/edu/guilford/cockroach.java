package edu.guilford;

public class cockroach {
    //attributes
    private String name;

    //constructor

    //constructor with default name as "cool cockroach"
    public cockroach() {
        this.name = "cool cockroach";
    }

    public cockroach(String name) {
        this.name = name;
    }

    //methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

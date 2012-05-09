package com.jaritimonen.jdave.domain;

public class CustomerDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String company;

    public long getId() {
        return id;
    }

    private CustomerDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    private CustomerDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    private CustomerDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCompany() {
        return company;
    }

    private CustomerDTO setCompany(String company) {
        this.company = company;
        return this;
    }

    public static CustomerDTO newInstance(final long id, final String firstName, final String lastName, final String company) {
        return new CustomerDTO().setId(id).setFirstName(firstName).setLastName(lastName).setCompany(company);
    }
}

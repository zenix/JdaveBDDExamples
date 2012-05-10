/**
 *  Copyright 2012 Jari Timonen
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
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

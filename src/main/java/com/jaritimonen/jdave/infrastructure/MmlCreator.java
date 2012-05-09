package com.jaritimonen.jdave.infrastructure;

import com.jaritimonen.jdave.domain.CustomerDTO;

public class MmlCreator {

    public String createFrom(final CustomerDTO customerDTO) {
        if(customerDTO == null){
            throw new IllegalArgumentException("CustomerDTO must not be null");
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id:")
                .append(customerDTO.getId())
                .append(":firstName:")
                .append(customerDTO.getFirstName())
                .append(":lastName:")
                .append(customerDTO.getLastName())
                .append(":company:")
                .append(customerDTO.getCompany());
        return stringBuilder.toString();
    }

}

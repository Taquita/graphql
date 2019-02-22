package com.example.graphql.services;

import com.example.graphql.domains.Address;
import com.example.graphql.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends GenericService<Address, Long> {

    private final AddressRepository repository;

    @Autowired
    public AddressService(AddressRepository repository) {
        super(repository);
        this.repository= repository;
    }
}

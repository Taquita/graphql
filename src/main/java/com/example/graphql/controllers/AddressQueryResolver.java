package com.example.graphql.controllers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.domains.Address;
import com.example.graphql.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressQueryResolver implements GraphQLQueryResolver {


    private final AddressService addressService;

    @Autowired
    public AddressQueryResolver(AddressService addressService) {
        this.addressService = addressService;
    }

    public Address getAddress(Long id) { return addressService.getById(id); }

    public List<Address> getAddresses() { return addressService.list(); }
}

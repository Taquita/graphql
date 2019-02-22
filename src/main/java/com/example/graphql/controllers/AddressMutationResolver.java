package com.example.graphql.controllers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.domains.Address;
import com.example.graphql.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressMutationResolver implements GraphQLMutationResolver {

    private final AddressService addressService;

    @Autowired
    public AddressMutationResolver(AddressService addressService) {
        this.addressService = addressService;
    }

    public Address createAddress(Address address) {
        return this.addressService.create(address);
    }

    public Address updateAddress(Address address) {
        return this.addressService.update(address);
    }

    public void removeAddress(Long id) {
        this.addressService.remove(id);
    }

}

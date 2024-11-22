/*
 * @ (#) AddressServiceImpl.java    1.0    22/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package org.example.dangbaothong_21014091_springapi.services.impl;/*
 * @description:
 * @author: Bao Thong
 * @date: 22/11/2024
 * @version: 1.0
 */

import org.example.dangbaothong_21014091_springapi.entities.Address;
import org.example.dangbaothong_21014091_springapi.repositories.AddressRepository;
import org.example.dangbaothong_21014091_springapi.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        return this.addressRepository.save(address);
    }
}

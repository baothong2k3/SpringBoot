/*
 * @ (#) CatergoryServiceImpl.java    1.0    23/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package iuh.dangbaothong_21014091_thymeleaf.services.impl;/*
 * @description:
 * @author: Bao Thong
 * @date: 23/11/2024
 * @version: 1.0
 */

import iuh.dangbaothong_21014091_thymeleaf.entities.Catergory;
import iuh.dangbaothong_21014091_thymeleaf.repositories.CatergoryRepository;
import iuh.dangbaothong_21014091_thymeleaf.services.CatergoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CatergoryServiceImpl implements CatergoryService {
    @Autowired
    private CatergoryRepository catergoryRepository;

    @Transactional
    @Override
    public Catergory saveCatergory(Catergory catergory) {
        return catergoryRepository.save(catergory);
    }

    @Override
    public List<Catergory> findAllCatergories() {
        return catergoryRepository.findAll();
    }

    @Override
    public Catergory findCatergoryById(int id) {
        return catergoryRepository.findById(id);
    }
}

/*
 * @ (#) CatergoryService.java    1.0    23/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package iuh.dangbaothong_21014091_thymeleaf.services;/*
 * @description:
 * @author: Bao Thong
 * @date: 23/11/2024
 * @version: 1.0
 */

import iuh.dangbaothong_21014091_thymeleaf.entities.Catergory;

import java.util.List;

public interface CatergoryService {
    public Catergory saveCatergory(Catergory catergory);
    public List<Catergory> findAllCatergories();
    public Catergory findCatergoryById(int id);
}

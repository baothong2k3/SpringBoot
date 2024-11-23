/*
 * @ (#) CatergoryRepository.java    1.0    23/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package iuh.dangbaothong_21014091_thymeleaf.repositories;/*
 * @description:
 * @author: Bao Thong
 * @date: 23/11/2024
 * @version: 1.0
 */

import iuh.dangbaothong_21014091_thymeleaf.entities.Catergory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "catergory", path = "catergory", exported = false)
public interface CatergoryRepository extends JpaRepository<Catergory, Integer> {
    public Catergory findById(int id);
}

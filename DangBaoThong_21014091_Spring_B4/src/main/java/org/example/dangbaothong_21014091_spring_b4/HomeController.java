/*
 * @ (#) HomeController.java    1.0    14/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package org.example.dangbaothong_21014091_spring_b4;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/11/2024
 * @version: 1.0
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String showMyPage() {
        return "main-menu";
    }
}

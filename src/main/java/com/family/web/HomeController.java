package com.family.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Q_先森 on 2017/11/10.
 */
@Controller
public class HomeController {

    @RequestMapping("/index")
    String index(){
        return "index";
    }
}

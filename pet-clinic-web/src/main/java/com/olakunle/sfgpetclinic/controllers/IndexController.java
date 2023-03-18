package com.olakunle.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

  @GetMapping("/")
    public String Index() {
        return "index";
    }

    @GetMapping("/oups")
    public String oups() {
        return "notimplemented";
    }


}

package com.lucas.service.web;


import com.lucas.service.service.CountryService;
import com.zpark.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Lucas
 * @Date 2019/12/17 14:13
 * @Version 1.0
 */
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    CountryService countryService;



//    @RequestMapping("/{id}")
//    public User selectUser(@PathVariable("id") Long id) {
//        return userService.queryById(id);
//    }

    @RequestMapping(value = {"findall"})
    public String findAll() {
        List<Country> countries = countryService.queryAll();
        StringBuilder sb = new StringBuilder();//abc + efg = abcefg
        for (Country country: countries) {
            sb.append(country.toString());
        }
        return sb.toString();
    }
}

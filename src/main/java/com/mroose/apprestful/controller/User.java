package com.mroose.apprestful.controller;

import com.mroose.apprestful.model.Account;
import com.mroose.apprestful.model.Summary;
import com.mroose.apprestful.service.MethodsForControllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class User {
    @Autowired
    private MethodsForControllers methodsForControllers;

    @RequestMapping(value = "/api/v1/user", method = RequestMethod.POST)
    public void addUser(@RequestBody Map<String, String> user) {
        methodsForControllers.saveAccount(new Account(
                user.get("username"),
                user.get("password"),
                "USER"
        ));
        methodsForControllers.saveSummary(new Summary(
                user.get("username"),
                user.get("fio"),
                user.get("city"),
                user.get("position"),
                Integer.parseInt(user.get("salary")),
                Integer.parseInt(user.get("age")),
                Integer.parseInt(user.get("experience")),
                LocalDate.parse(user.get("employmentDate"))
        ));
    }

    @RequestMapping(value = "/api/v1/user", method = RequestMethod.GET)
    public Summary getSummaryByUsername(Principal principal) {
        return methodsForControllers.getSummaryByUsername(principal.getName());
    }

    @RequestMapping(value = "/api/v1/user", method = RequestMethod.PUT)
    public void updateSummary(Principal principal,
                              @RequestBody Map<String, String> user) {
        methodsForControllers.saveSummary(new Summary(
                principal.getName(),
                user.get("fio"),
                user.get("city"),
                user.get("position"),
                Integer.parseInt(user.get("salary")),
                Integer.parseInt(user.get("age")),
                Integer.parseInt(user.get("experience")),
                LocalDate.parse(user.get("employmentDate"))
        ));
    }

    @RequestMapping(value = "/api/v1/user", method = RequestMethod.DELETE)
    public void deleteUser(Principal principal) {
        methodsForControllers.deleteAccount(principal.getName());
    }
}
package com.mroose.apprestful.controller;

import com.mroose.apprestful.model.Account;
import com.mroose.apprestful.model.Summary;
import com.mroose.apprestful.service.MethodsForControllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class Admin {
    @Autowired
    private MethodsForControllers methodsForControllers;

    @RequestMapping(value = "/api/v1/user", method = RequestMethod.GET)
    public List<Summary> getSummaryList() {
        return methodsForControllers.getSummaryList();
    }

    @RequestMapping(value = "/api/v1/user", method = RequestMethod.POST)
    public void addUser(@RequestBody Map<String, String> user) {
        methodsForControllers.saveAccount(new Account(
                user.get("username"),
                user.get("password"),
                user.get("role")
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

    @RequestMapping(value = "/api/v1/user/{username}", method = RequestMethod.GET)
    public Summary getSummaryByUsername(@PathVariable String username) {
        return methodsForControllers.getSummaryByUsername(username);
    }

    @RequestMapping(value = "/api/v1/user/{username}", method = RequestMethod.PUT)
    public void updateSummary(@PathVariable String username,
                              @RequestBody Map<String, String> user) {
        methodsForControllers.saveSummary(new Summary(
                username,
                user.get("fio"),
                user.get("city"),
                user.get("position"),
                Integer.parseInt(user.get("salary")),
                Integer.parseInt(user.get("age")),
                Integer.parseInt(user.get("experience")),
                LocalDate.parse(user.get("employmentDate"))
        ));
    }

    @RequestMapping(value = "/api/v1/user/{username}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String username) {
        methodsForControllers.deleteAccount(username);
    }
}

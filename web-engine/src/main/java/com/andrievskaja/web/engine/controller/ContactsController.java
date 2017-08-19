/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrievskaja.web.engine.controller;

import com.andrievskaja.business.service.ContactsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Людмила
 */
@Controller
@RequestMapping("/hello")
public class ContactsController {

    @Autowired
    private ContactsService contactsService;
    /**
     *
     * @author nameFilter
     * @param nameFilter regular expression
     * @return Gson
     */
    @ResponseBody
    @RequestMapping("/contacts")
    public String getContacts(@RequestParam String nameFilter) {
        String contacts = new Gson().toJson(contactsService.listContactsSort(nameFilter));  
        return contacts;
    }
}

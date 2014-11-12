/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orchestra.portale.controller;

import com.orchestra.portale.persistence.mongo.documents.PoiMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mekko
 */
@Controller
public class WelcomeController {

    @Autowired
    MongoOperations mongoOps;
    
    @RequestMapping("/test1")
    public ModelAndView createMongoPoiTest() {
        ModelAndView model = new ModelAndView("welcome");
        PoiMongo poi = new PoiMongo();
        poi.setName("Prova");
        mongoOps.save(poi);
        return model;
    }
    
    @RequestMapping("/gettest1")
    public ModelAndView getTest1() {
        ModelAndView model = new ModelAndView("test1");
        PoiMongo poi = mongoOps.findById(new String("54639f0a2736609ee2ea50a8"), PoiMongo.class);
        model.addObject("poi", poi);
        return model;
    }
}

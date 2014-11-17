/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orchestra.portale.controller;

import com.orchestra.portale.persistence.mongo.documents.PoiMongo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author mekko
 */
@Controller
public class DummyPoiController {

    @Autowired
    MongoOperations mongoOps;

    @RequestMapping("/poitest")
    public ModelAndView dummyPoi() {
        ModelAndView model = new ModelAndView("viewpoi");

        //Find all pois
        List<PoiMongo> pois = mongoOps.findAll(PoiMongo.class);

        model.addObject("poi", pois.get(0));

        return model;

    }
}

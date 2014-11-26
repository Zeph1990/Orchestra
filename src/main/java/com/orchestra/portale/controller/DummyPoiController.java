/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orchestra.portale.controller;

import com.orchestra.portale.persistence.mongo.documents.AbstractPoiComponent;
import com.orchestra.portale.persistence.mongo.documents.CoverImgComponent;
import com.orchestra.portale.persistence.mongo.documents.ImageGalleryComponent;
import com.orchestra.portale.persistence.mongo.documents.PoiMongo;
import com.orchestra.portale.persistence.mongo.documents.TitleComponent;
import com.orchestra.portale.persistence.mongo.repositories.PoiMongoRepository;
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
    PoiMongoRepository mongoRepo;

    @RequestMapping("/poitest")
    public ModelAndView dummyPoi() {
        ModelAndView model = new ModelAndView("viewpoi");

        //Find all pois
        PoiMongo poi = mongoRepo.findAll().iterator().next();

        model.addObject("poi", poi);

        for (AbstractPoiComponent comp : poi.getComponents()) {
            try {
                
                String slug = comp.slug();
                int index = slug.lastIndexOf(".");
                String cname = slug.substring(index+1).replace("Component", "").toLowerCase();
                
                Class c = Class.forName(slug);
                model.addObject(cname, c.cast(comp));
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return model;

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orchestra.portale.controller;

import com.orchestra.portale.persistence.mongo.documents.AbstractPoiComponent;
import com.orchestra.portale.persistence.mongo.documents.CoverComponent;
import com.orchestra.portale.persistence.mongo.documents.ImageGalleryComponent;
import com.orchestra.portale.persistence.mongo.documents.PoiMongo;
import com.orchestra.portale.persistence.mongo.documents.TitleComponent;
import com.orchestra.portale.persistence.mongo.repositories.PoiMongoRepository;
import java.util.Iterator;
import java.util.LinkedList;
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
        Iterator poi_iterator=mongoRepo.findAll().iterator();
        List<PoiMongo> listaPoi = new LinkedList<PoiMongo>();
        model.addObject("poi", listaPoi);
        while (poi_iterator.hasNext()) {
            listaPoi.add((PoiMongo) poi_iterator.next());
                
                
        for (AbstractPoiComponent comp : listaPoi.get(0).getComponents()) {
            try {
                /*if (comp.slug().toLowerCase().contains("title")) {
                    model.addObject("title", Class.forName(comp.slug()).cast(comp));
                } else if (comp.slug().toLowerCase().contains("cover")) {
                    System.out.println("cover");
                    model.addObject("cover", CoverComponent.class.cast(comp));
                } else if (comp.slug().toLowerCase().contains("imagegallery")) {
                    System.out.println("gallery");
                    model.addObject("image_gallery", ImageGalleryComponent.class.cast(comp));
                }*/
                
                String slug = comp.slug();
                int index = slug.lastIndexOf(".");
                String cname = slug.substring(index+1).replace("Component", "").toLowerCase();
                
                Class c = Class.forName(slug);
                model.addObject(cname, c.cast(comp));
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }

        return model;

    }
}

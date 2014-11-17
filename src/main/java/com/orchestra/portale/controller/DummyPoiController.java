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

        /*{ "_id" : "5469f44e27366e05db741c3d" , "_class" : "com.orchestra.portale.persistence.mongo.documents.PoiMongo" , "name" : "Poi prova 0" , "latitude" : 40.0 , "longitude" : 14.0 , "shortDescription" : "Descrizione di prova 0" , "components" : [ { "link" : "link vuoto 0" , "_class" : "cover"} , { "title" : "titolo prova 0" , "_class" : "title"} , { "links" : [ "link vuoto 0"] , "_class" : "image_gallery"}] , "categories" : [ "food"]}*/
        model.addObject("poi", poi);
        
        for (AbstractPoiComponent comp : poi.getComponents()) {
            if (comp.slug().toLowerCase().contains("title")) {
                System.out.println("titolo");
                model.addObject("title", TitleComponent.class.cast(comp));
            } else if (comp.slug().toLowerCase().contains("cover")) {
                System.out.println("cover");
                model.addObject("cover", CoverComponent.class.cast(comp));
            } else if (comp.slug().toLowerCase().contains("imagegallery")) {
                System.out.println("gallery");
                model.addObject("image_gallery", ImageGalleryComponent.class.cast(comp));
            }
        }
        
        
        return model;

    }
}

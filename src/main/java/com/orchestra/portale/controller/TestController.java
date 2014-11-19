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
import com.orchestra.portale.persistence.sql.entities.Category;
import com.orchestra.portale.persistence.sql.entities.CompCategoryComponent;
import com.orchestra.portale.persistence.sql.entities.CompPoiCategory;
import com.orchestra.portale.persistence.sql.entities.Component;
import com.orchestra.portale.persistence.sql.entities.Poi;
import com.orchestra.portale.persistence.sql.repositories.CategoryRepository;
import com.orchestra.portale.persistence.sql.repositories.CompCategoryComponentRepository;
import com.orchestra.portale.persistence.sql.repositories.CompPoiCategoryRepository;
import com.orchestra.portale.persistence.sql.repositories.ComponentRepository;
import com.orchestra.portale.persistence.sql.repositories.PoiRepository;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller per effettuare test. Le chiamate vanno effettuate in sequenza
 * test1, test2, test3
 *
 * @author mekko
 */
@Controller
public class TestController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ComponentRepository componentRepository;

    @Autowired
    CompCategoryComponentRepository compCategoryComponentRepository;

    @Autowired
    PoiRepository poiRepository;

    @Autowired
    CompPoiCategoryRepository compPoiCategoryRepository;

    @Autowired
    MongoOperations mongoOps;
    
    @Autowired
    PoiMongoRepository poiMongoRepo;

    @RequestMapping("/test1")
    public ModelAndView insertCategories() {
        ModelAndView model = new ModelAndView("testview");
        String msg = "ok";

        try {

            Category food = new Category();
            Category nightlife = new Category();
            Category hotels = new Category();

            food.setParent(null);
            nightlife.setParent(null);
            hotels.setParent(null);            
            
            food.setSlug("food");
            nightlife.setSlug("nightlife");
            hotels.setSlug("hotels");

            categoryRepository.save(food);
            categoryRepository.save(nightlife);
            categoryRepository.save(hotels);


            /* CHILD CATEGORIES */
             Category restaurant = new Category();
             Category disco = new Category();
             Category hostels = new Category();
            
             restaurant.setSlug("restaurant");
             disco.setSlug("disco");
             hostels.setSlug("hostels");
            
             //Retrieve root categories
             Category foodout = categoryRepository.findBySlug("food");
             Category nightlifeout = categoryRepository.findBySlug("nightlife");
             Category hotelsout = categoryRepository.findBySlug("hotels");
            
             //Set parent categoris
             restaurant.setParent(foodout);
             disco.setParent(nightlifeout);
             hostels.setParent(hotelsout);
            
             //Save child categories
             categoryRepository.save(restaurant);
             categoryRepository.save(disco);
             categoryRepository.save(hostels);
             
        } catch (RuntimeException e) {
            msg = "error";
            e.printStackTrace();
        }

        model.addObject("msg", msg);

        return model;
    }

    @RequestMapping("/test2")
    public ModelAndView insertComponents() {
        ModelAndView model = new ModelAndView("testview");
        String msg = "ok";

        try {
              Component title = new Component();
             title.setSlug("title");
            
             Component imageGallery = new Component();
             imageGallery.setSlug("imagegallery");
            
             Component cover = new Component();
             cover.setSlug("cover");
            
             componentRepository.save(title);
             componentRepository.save(imageGallery);
             componentRepository.save(cover);
            
             List<Category> categories = categoryRepository.findAll();
            
             for (Category cat : categories) {
             CompCategoryComponent comp1 = new CompCategoryComponent();
             CompCategoryComponent comp2 = new CompCategoryComponent();
             CompCategoryComponent comp3 = new CompCategoryComponent();
                
             comp1.setIdcategory(cat);
             comp1.setIdcomponent(title);
             comp1.setRequired(true);
                
             comp2.setIdcategory(cat);
             comp2.setIdcomponent(imageGallery);
             comp2.setRequired(true);
                
             comp3.setIdcategory(cat);
             comp3.setIdcomponent(cover);
             comp3.setRequired(true);
                
             compCategoryComponentRepository.save(comp1);
             compCategoryComponentRepository.save(comp2);
             compCategoryComponentRepository.save(comp3);
                 
             }
             
        } catch (RuntimeException e) {
            msg = "error";
            e.printStackTrace();
        }

        model.addObject("msg", msg);
        return model;
    }
    
    
    /**
     * Create ten stubs Poi into the database.
     *
     * @return
     */
    @RequestMapping("/test3")
    public ModelAndView insertStubPois() {
        ModelAndView model = new ModelAndView("testview");
        String msg = "ok";
        try {
            //Create Pois
            PoiMongo[] mongoPois = new PoiMongo[10];
            Poi[] pois = new Poi[10];

            for (int i = 0; i < mongoPois.length; i++) {
                //Set pois attributes
                mongoPois[i] = new PoiMongo();
                mongoPois[i].setLatitude(40.0 + (0.1 * i));
                mongoPois[i].setLongitude(14.0 + (0.1 * i));
                mongoPois[i].setName("Poi prova " + i);
                mongoPois[i].setShortDescription("Descrizione di prova " + i);

                //Set poi category
                if (i < 3) {
                    LinkedList<String> categories = new LinkedList<String>();
                    categories.add("food");
                    mongoPois[i].setCategories(categories);
                } else if (i >= 3 && i < 6) {
                    LinkedList<String> categories = new LinkedList<String>();
                    categories.add("nightlife");
                    mongoPois[i].setCategories(categories);
                } else {
                    LinkedList<String> categories = new LinkedList<String>();
                    categories.add("hotels");
                    mongoPois[i].setCategories(categories);
                }

                //Set mongo components
                CoverComponent cover = new CoverComponent();
                cover.setLink("link vuoto " + i);

                ImageGalleryComponent imageGallery = new ImageGalleryComponent();
                LinkedList<String> links = new LinkedList<String>();
                links.add("link vuoto " + i);
                imageGallery.setLinks(links);

                TitleComponent title = new TitleComponent();
                title.setTitle("titolo prova " + i);

                List<AbstractPoiComponent> components = new LinkedList<AbstractPoiComponent>();
                components.add(cover);
                components.add(title);
                components.add(imageGallery);

                mongoPois[i].setComponents(components);

                poiMongoRepo.save(mongoPois[i]);

                //Insert poi in sql schema
                pois[i] = new Poi();
                pois[i].setIdmongo(mongoPois[i].getId());
                pois[i].setLatitude(mongoPois[i].getLatitude());
                pois[i].setLongitude(mongoPois[i].getLongitude());
                pois[i].setName(mongoPois[i].getName());
                pois[i].setShortDescription(mongoPois[i].getShortDescription());

                //Save POI 
                poiRepository.save(pois[i]);

                //Associate poi and category
                Category cat = categoryRepository.findBySlug(mongoPois[i].getCategories().get(0));
                CompPoiCategory compPoiCategory = new CompPoiCategory();

                compPoiCategory.setIdcategory(cat);
                compPoiCategory.setIdpoi(pois[i]);

                //Save assosiacion
                compPoiCategoryRepository.save(compPoiCategory);

            }
        } catch (RuntimeException e) {
            msg = "error";
            e.printStackTrace();
        }
        model.addObject("msg", msg);
        return model;
    }
}

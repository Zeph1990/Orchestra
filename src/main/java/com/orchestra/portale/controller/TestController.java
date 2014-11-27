/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orchestra.portale.controller;

import com.orchestra.portale.persistence.mongo.documents.AbstractPoiComponent;
import com.orchestra.portale.persistence.mongo.documents.CoverImgComponent;
import com.orchestra.portale.persistence.mongo.documents.DescriptionComponent;
import com.orchestra.portale.persistence.mongo.documents.ImageGalleryComponent;
import com.orchestra.portale.persistence.mongo.documents.CompletePOI;
import com.orchestra.portale.persistence.mongo.documents.Section;
import com.orchestra.portale.persistence.mongo.documents.TitleComponent;
import com.orchestra.portale.persistence.mongo.repositories.PoiMongoRepository;
import com.orchestra.portale.persistence.sql.repositories.CategoryRepository;
import com.orchestra.portale.persistence.sql.repositories.CompCategoryComponentRepository;
import com.orchestra.portale.persistence.sql.repositories.CompPoiCategoryRepository;
import com.orchestra.portale.persistence.sql.repositories.ComponentRepository;
import com.orchestra.portale.persistence.sql.repositories.PoiRepository;
import java.util.ArrayList;
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

    @RequestMapping("/elimina")
    public ModelAndView elimina() {
        ModelAndView model = new ModelAndView("testview");
        String msg = "ok";

        try {
        
            poiMongoRepo.deleteAll();

        } catch (RuntimeException e) {
            msg = "error";
            e.printStackTrace();
        }

        model.addObject("msg", msg);

        return model;
    }

    @RequestMapping("/insertMongo")
    public ModelAndView insertSectionsList() {

        ModelAndView model = new ModelAndView("testview");
        String msg = "ok";

        try {
            
            CompletePOI poi = new CompletePOI();
            
            poi.setName("Pio Monte Della Misericordia");
            ArrayList<String> categories=new ArrayList<String>();
            categories.add("Museo");
            poi.setCategories(categories);
            poi.setLocation(new double[] { 40.85123, 14.258117 });
            poi.setAddress("Via dei Tribunali 253, 80138 Napoli");
            poi.setShortDescription("Bellissimo posto!");
            
            ArrayList<AbstractPoiComponent> listComponent = new ArrayList<AbstractPoiComponent>();
            
            //componente DescriptionComponent
            ArrayList<Section> list = new ArrayList<Section>();
            Section section = new Section();
            section.setTitle("Titolo1");
            section.setDescription("Descrizion1");
            Section section1 = new Section();
            section1.setTitle("Titolo2");
            section1.setDescription("Descrizion2");
            list.add(section);
            list.add(section1);
            DescriptionComponent description_component = new DescriptionComponent();
            description_component.setSectionsList(list);
            listComponent.add(description_component);
            
            //componente titolo
            TitleComponent title=new TitleComponent();
            title.setTitle("Pio Monte Della Misericordia");
            listComponent.add(title);
            
            //componente cover
            CoverImgComponent cover=new CoverImgComponent();
            cover.setLink("pm1.jpg");
            listComponent.add(cover);
            
            //componente galleria immagini
           ImageGalleryComponent img_gallery=new ImageGalleryComponent();
           ArrayList<String> links=new ArrayList<String>();
           links.add("pm1.jpg");
           links.add("pm2.jpg");
           links.add("pm3.jpg");
           img_gallery.setLinks(links);
           listComponent.add(img_gallery);

           poi.setComponents(listComponent);

            poiMongoRepo.save(poi);
        } catch (RuntimeException e) {
            msg = "error";
            e.printStackTrace();
        }

        model.addObject("msg", msg);

        return model;
    }
}

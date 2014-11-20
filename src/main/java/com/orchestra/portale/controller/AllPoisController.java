/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orchestra.portale.controller;

import com.orchestra.portale.persistence.mongo.documents.PoiMongo;
import com.orchestra.portale.persistence.mongo.repositories.PoiMongoRepository;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Alex
 */
 @Controller
public class AllPoisController {

    @Autowired
    PoiMongoRepository mongoRepo;
 
    @RequestMapping("/allpois")
    public ModelAndView allPois(){
        ModelAndView model = new ModelAndView("viewpois");
        
        //Find all pois
        Iterator poi_iterator=mongoRepo.findAll().iterator();
        List<PoiMongo> listaPoi = new LinkedList<PoiMongo>();
        model.addObject("ListaPoi", listaPoi);
        while (poi_iterator.hasNext()) {
            listaPoi.add((PoiMongo) poi_iterator.next());
           
        }
       return model;
    }
 }
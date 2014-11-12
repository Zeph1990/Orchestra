/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orchestra.portale.persistence.mongo.documents;

import org.springframework.data.annotation.TypeAlias;

/**
 *
 * @author mekko
 */
public abstract class AbstractComponent {
    /**
     * Return the slug of the component, identified by the tag @TypeALias.
     * @return Component's slug, or null if @TypeAlias was not defined. 
     */
    public String slug() {
        String res;
        
        Class<? extends AbstractComponent> c = this.getClass();
        TypeAlias a = c.getAnnotation(TypeAlias.class);
        res = (a != null) ? a.value() : null;
        
        return res;
    }
}

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
@TypeAlias("cover")
public class CoverComponent extends AbstractComponent {

    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}

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
@TypeAlias("title")
public class TitleComponent extends AbstractComponent {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

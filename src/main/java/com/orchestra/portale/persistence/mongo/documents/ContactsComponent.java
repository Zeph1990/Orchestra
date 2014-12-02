/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.orchestra.portale.persistence.mongo.documents;

import java.util.ArrayList;
import org.springframework.data.annotation.TypeAlias;


@TypeAlias("com.orchestra.portale.persistence.mongo.documents.ContactsComponent")
public class ContactsComponent extends AbstractPoiComponent{
    private ArrayList<PhoneContact> phoneList;
    private ArrayList<EmailContact> emailsList;
    private String facebook;
    private String twitter;

    public ArrayList<PhoneContact> getPhoneList() {
        return phoneList;
    }

    public ArrayList<EmailContact> getEmailsList() {
        return emailsList;
    }

    public void setPhoneList(ArrayList<PhoneContact> phoneList) {
        this.phoneList = phoneList;
    }

    public void setEmailsList(ArrayList<EmailContact> emailsList) {
        this.emailsList = emailsList;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getTwitter() {
        return twitter;
    }
    
    
}

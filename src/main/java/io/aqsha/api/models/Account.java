//package io.aqsha.api.models;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
//public class Account {
//    //http://127.0.0.1:8080/aqsha/add?saving=%22%22&email=%22yernar@gmail.com%22
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private Integer id;
//    private Integer ownerId;
//    private double saving;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getOwnerId() {
//        return ownerId;
//    }
//
//    public void setOwnerId(Integer id) {
//        this.ownerId = ownerId;
//    }
//
//    public double getSaving() {
//        return saving;
//    }
//
//    //possibly wrong
//    public void setSaving(double saving) {
//        this.saving = saving;
//    }
//
//
//}
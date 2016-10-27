package com.example.hectorvera.ezinfo.POJO;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

/**
 * Entity mapped to table "INFORMATION".
 */
public class Information {

    private Long id;
    private String Name;
    private String Content;
    private Long isTopLevel;
    private Relation relation = null;

    public Information() {
    }

    public Information(Long id) {
        this.id = id;
    }

    public Information(Long id, String Name, String Content, Long isTopLevel) {
        this.id = id;
        this.Name = Name;
        this.Content = Content;
        this.isTopLevel = isTopLevel;
    }


    public Information(String Name, String Content, Long isTopLevel) {
        //this.id = id;
        this.Name = Name;
        this.Content = Content;
        this.isTopLevel = isTopLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public Long getIsTopLevel() {
        return isTopLevel;
    }

    public void setIsTopLevel(Long isTopLevel) {
        this.isTopLevel = isTopLevel;
    }

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    public void setRelation(Long parentId, Long contentId, Long rank){
        this.relation = new Relation(parentId,contentId,rank);
    }

    public String toString(){
        return id + " Title: " + getName() + " Content: " + getContent()
                + " Top Level: " + getIsTopLevel();
    }
}
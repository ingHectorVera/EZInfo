package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class Main {

    public static void main(String[] args)throws Exception{
        Schema schema = new Schema(1, "com.example.hectorvera.ezinfo.db");
        Entity information = schema.addEntity("Information");
        information.addIdProperty().autoincrement();
        information.addStringProperty("Name");
        information.addStringProperty("Content");
        information.addStringProperty("urlImage");
        information.addStringProperty("urlVideo");
        information.addBooleanProperty("isTopLevel");

        Entity relation = schema.addEntity("Relation");
        relation.addLongProperty("ParentId");
        relation.addLongProperty("ContentId");
        relation.addLongProperty("Rank");

        DaoGenerator generator = new DaoGenerator();
        generator.generateAll(schema, "./app/src/main/java");

    }
}

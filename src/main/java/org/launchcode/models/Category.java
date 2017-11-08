package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JosephT on 6/25/2017.
 */
@Entity
public class Category {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @NotNull
    public Category(){}
    public Category(String name){ }

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Report> report = new ArrayList<>();

}

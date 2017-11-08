package org.launchcode.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * Created by JosephT on 7/28/2017.
 */

@MappedSuperclass
public abstract class UserEntity {

    private int uid;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "uid", unique = true)
    public int getUid(){ return this.uid; }

    protected void setUid(){ this.uid = uid; }
}

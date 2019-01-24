package com.example.tinyurl.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tinyurl", schema = "ad_2ee6f66e6edd16f")
public class TinyUrlEntity {

    @Id
    @GeneratedValue(generator = "true", strategy = GenerationType.IDENTITY)
    long id;

    @Column(name="url_id")
    long urlId;

    @Column(name="tiny_url")
    String tinyUrl;

    @Column(name="actual_url")
    String actualUrl;

    @Column(name="created_ts")
    Date createdTimeStamp;

    @Column(name="updated_ts")
    Date updatedTimeStamp;

    @Column(name="created_by")
    String createdBy;

    @Column(name="updated_by")
    String updatedBy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUrlId() {
        return urlId;
    }

    public void setUrlId(long urlId) {
        this.urlId = urlId;
    }

    public String getTinyUrl() {
        return tinyUrl;
    }

    public void setTinyUrl(String tinyUrl) {
        this.tinyUrl = tinyUrl;
    }

    public String getActualUrl() {
        return actualUrl;
    }

    public void setActualUrl(String actualUrl) {
        this.actualUrl = actualUrl;
    }

    public Date getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(Date createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    public Date getUpdatedTimeStamp() {
        return updatedTimeStamp;
    }

    public void setUpdatedTimeStamp(Date updatedTimeStamp) {
        this.updatedTimeStamp = updatedTimeStamp;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }


}

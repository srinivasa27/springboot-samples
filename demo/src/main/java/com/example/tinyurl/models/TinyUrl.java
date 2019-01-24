package com.example.tinyurl.models;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class TinyUrl {

    @ApiModelProperty(notes = "The database generated  ID")
    long id;
    @ApiModelProperty(notes = "Computed custom url ID")
    long urlId;
    @ApiModelProperty(notes = "Tiny URL")
    String tinyUrl;
    @ApiModelProperty(notes = "Actual URL")
    String actualUrl;

    public TinyUrl(long id, long urlId, String tinyUrl, String actualUrl) {
        this.id = id;
        this.urlId = urlId;
        this.tinyUrl = tinyUrl;
        this.actualUrl = actualUrl;
    }

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


    @Override
    public String toString() {
        return "TinyUrl{" +
                "id=" + id +
                ", urlId=" + urlId +
                ", tinyUrl='" + tinyUrl + '\'' +
                ", actualUrl='" + actualUrl + '\'' +
                '}';
    }
}

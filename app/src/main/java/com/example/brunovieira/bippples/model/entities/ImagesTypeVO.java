package com.example.brunovieira.bippples.model.entities;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.io.Serializable;

/**
 * Created by bruno.vieira on 03/05/2016.
 */
@JsonObject
public class ImagesTypeVO implements Serializable {

    private static final long serialVersionUID = 7244360580699827352L;

    @JsonField
    private String hidpi;

    @JsonField
    private String normal;

    @JsonField
    private String teaser;

    public ImagesTypeVO() {
    }

    public String getHidpi() {
        return hidpi;
    }

    public void setHidpi(String hidpi) {
        this.hidpi = hidpi;
    }

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }
}

package com.example.brunovieira.bippples.model.entities;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.io.Serializable;

/**
 * Created by bruno.vieira on 03/05/2016.
 */
@JsonObject
public class ShotsVO implements Serializable {
    private static final long serialVersionUID = 3898391012947970045L;

    @JsonField
    private long id;

    @JsonField
    private String title;

    @JsonField
    private String description;

    @JsonField(name = "images")
    private ImagesTypeVO imagesTypeVO;

    @JsonField(name = "views_count")
    private int viewCount;

    @JsonField(name = "likes_count")
    private int likesCount;

    @JsonField(name = "comments_count")
    private int commentsCount;

    public ShotsVO() {
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ImagesTypeVO getImagesTypeVO() {
        return imagesTypeVO;
    }

    public void setImagesTypeVO(ImagesTypeVO imagesTypeVO) {
        this.imagesTypeVO = imagesTypeVO;
    }
}

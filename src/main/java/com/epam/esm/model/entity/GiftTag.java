package com.epam.esm.model.entity;

import java.util.List;
import java.util.Objects;

public class GiftTag {
    private String tagName;
    private String giftName;
    private double price;
    private int duration;
    private String description;
    private String createDate; //use not String param
    private String lastUpdateDate; // use not String param

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiftTag giftTag = (GiftTag) o;
        return Double.compare(giftTag.price, price) == 0 && duration == giftTag.duration && Objects.equals(tagName, giftTag.tagName) && Objects.equals(giftName, giftTag.giftName) && Objects.equals(description, giftTag.description) && Objects.equals(createDate, giftTag.createDate) && Objects.equals(lastUpdateDate, giftTag.lastUpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagName, giftName, price, duration, description, createDate, lastUpdateDate);
    }

    @Override
    public String toString() {
        return "GiftTag{" +
                "tagName='" + tagName + '\'' +
                ", giftName='" + giftName + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                ", createDate='" + createDate + '\'' +
                ", lastUpdateDate='" + lastUpdateDate + '\'' +
                '}';
    }
}

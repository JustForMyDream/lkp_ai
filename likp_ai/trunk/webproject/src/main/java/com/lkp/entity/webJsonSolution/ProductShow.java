package com.lkp.entity.webJsonSolution;

import java.util.List;

/**
 *
 */
public class ProductShow {
    private String id;
    private String productShowTitle;
    private String productShowMusic;
    private List<ProducteShowItem> productShowItem;
    private ProductCover productShowCover;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductShowTitle() {
        return productShowTitle;
    }

    public void setProductShowTitle(String productShowTitle) {
        this.productShowTitle = productShowTitle;
    }

    public String getProductShowMusic() {
        return productShowMusic;
    }

    public void setProductShowMusic(String productShowMusic) {
        this.productShowMusic = productShowMusic;
    }

    public List<ProducteShowItem> getProductShowItem() {
        return productShowItem;
    }

    public void setProductShowItem(List<ProducteShowItem> productShowItem) {
        this.productShowItem = productShowItem;
    }

    public ProductCover getProductShowCover() {
        return productShowCover;
    }

    public void setProductShowCover(ProductCover productShowCover) {
        this.productShowCover = productShowCover;
    }
}

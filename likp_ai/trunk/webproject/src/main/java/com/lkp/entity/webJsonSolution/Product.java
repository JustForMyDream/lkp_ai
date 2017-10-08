package com.lkp.entity.webJsonSolution;

import java.util.List;

/**
 *
 */
public class Product {
    private String id;
    private String cpfwId;
    private ProductCover productCover;
    private String productName;
    private Integer productPrice;
    private String productDes;
    private String productTime;
    private String productSute;
    private String productMakeUp;
    private String productPeople;
    private String productSituation;
    private String orgPicNum;
    private String fixPicNum;
    private List<ProductOrther> productOrther;
    private List<Shiwu> shiwu;
    private List<ProductOrther> shiwujiaofu;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpfwId() {
        return cpfwId;
    }

    public void setCpfwId(String cpfwId) {
        this.cpfwId = cpfwId;
    }

    public ProductCover getProductCover() {
        return productCover;
    }

    public void setProductCover(ProductCover productCover) {
        this.productCover = productCover;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDes() {
        return productDes;
    }

    public void setProductDes(String productDes) {
        this.productDes = productDes;
    }

    public String getProductTime() {
        return productTime;
    }

    public void setProductTime(String productTime) {
        this.productTime = productTime;
    }

    public String getProductSute() {
        return productSute;
    }

    public void setProductSute(String productSute) {
        this.productSute = productSute;
    }

    public String getProductMakeUp() {
        return productMakeUp;
    }

    public void setProductMakeUp(String productMakeUp) {
        this.productMakeUp = productMakeUp;
    }

    public String getProductPeople() {
        return productPeople;
    }

    public void setProductPeople(String productPeople) {
        this.productPeople = productPeople;
    }

    public String getProductSituation() {
        return productSituation;
    }

    public void setProductSituation(String productSituation) {
        this.productSituation = productSituation;
    }

    public String getOrgPicNum() {
        return orgPicNum;
    }

    public void setOrgPicNum(String orgPicNum) {
        this.orgPicNum = orgPicNum;
    }

    public String getFixPicNum() {
        return fixPicNum;
    }

    public void setFixPicNum(String fixPicNum) {
        this.fixPicNum = fixPicNum;
    }

    public List<ProductOrther> getProductOrther() {
        return productOrther;
    }

    public void setProductOrther(List<ProductOrther> productOrther) {
        this.productOrther = productOrther;
    }

    public List<Shiwu> getShiwu() {
        return shiwu;
    }

    public void setShiwu(List<Shiwu> shiwu) {
        this.shiwu = shiwu;
    }

    public List<ProductOrther> getShiwujiaofu() {
        return shiwujiaofu;
    }

    public void setShiwujiaofu(List<ProductOrther> shiwujiaofu) {
        this.shiwujiaofu = shiwujiaofu;
    }
}

package com.example.administrator.nationaldrugs.Model;

import static com.example.administrator.nationaldrugs.Webservice.Const.tet;
import static com.example.administrator.nationaldrugs.Webservice.Const.value;

/**
 * Created by Administrator on 2016/11/15.
 */

public class Reference {
    private String rfeid;
    private String drugid;
    private String title;
    private String magazine;
    private String author;
    private String gov;
    private String province;
    private String year;
    private String vol;
    private String page;
    private String abs;

    public String getRfeid() {
        return rfeid;
    }

    public void setRfeid(String rfeid) {
        this.rfeid = rfeid;
    }

    public String getDrugid() {
        return drugid;
    }

    public void setDrugid(String drugid) {
        this.drugid = drugid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title.equals(value)?tet:title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author.equals(value)?tet:author;
    }

    public String getMagazine() {
        return magazine;
    }

    public void setMagazine(String magazine) {
        this.magazine = magazine.equals(value)?tet:magazine;
    }

    public String getGov() {
        return gov;
    }

    public void setGov(String gov) {
        this.gov = gov.equals(value)?tet:gov;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province.equals(value)?tet:province;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year.equals(value)?tet:year;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol.equals(value)?tet:vol;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page.equals(value)?tet:page;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs.equals(value)?tet:abs;
    }
}

package com.example.administrator.nationaldrugs.Model;

import static com.example.administrator.nationaldrugs.Webservice.Const.tet;
import static com.example.administrator.nationaldrugs.Webservice.Const.value;

/**
 * Created by Administrator on 2016/11/15.
 */

public class Share {
    private String shid;
    private String drugid;
    private String ishareway;
    private String iobtainway;
    private String man;
    private String depart;
    private String mcode;
    private String tel;
    private String email;

    public String getShid() {
        return shid;
    }

    public void setShid(String shid) {
        this.shid = shid;
    }

    public String getDrugid() {
        return drugid;
    }

    public void setDrugid(String drugid) {
        this.drugid = drugid;
    }

    public String getIshareway() {
        return ishareway;
    }

    public void setIshareway(String ishareway) {
        this.ishareway = ishareway.equals(value)?tet:ishareway;
    }

    public String getIobtainway() {
        return iobtainway;
    }

    public void setIobtainway(String iobtainway) {
        this.iobtainway = iobtainway.equals(value)?tet:iobtainway;
    }

    public String getMan() {
        return man;
    }

    public void setMan(String man) {
        this.man = man.equals(value)?tet:man;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart.equals(value)?tet:depart;
    }

    public String getMcode() {
        return mcode;
    }

    public void setMcode(String mcode) {
        this.mcode = mcode.equals(value)?tet:mcode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel.equals(value)?tet:tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {this.email = email.equals(value)?tet:email;}
}

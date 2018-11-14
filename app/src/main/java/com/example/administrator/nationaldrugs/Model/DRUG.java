package com.example.administrator.nationaldrugs.Model;

import static com.example.administrator.nationaldrugs.Webservice.Const.tet;
import static com.example.administrator.nationaldrugs.Webservice.Const.value;

/**
 * Created by Administrator on 2016/11/16.
 */

public class DRUG {
    private String drugid;
    private String nationName;
    private String transltName;
    private String name;
    private String position;

    public String getdrugid() {
        return drugid;
    }

    public void setdrugid(String drugid) {
        this.drugid = drugid;
    }

    public String getnationName() {
        return nationName;
    }

    public void setnationName(String nationName) {this. nationName = nationName.equals(value)?tet:nationName;}

    public String gettransltName() {
        return transltName;
    }

    public void settransltName(String transltName) {this. transltName = transltName.equals(value)?tet:transltName;}

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this. name = name.equals(value)?tet:name;
    }

    public String getposition() {
        return position;
    }

    public void setposition(String position) {this. position = position.equals(value)?tet:position;}
}

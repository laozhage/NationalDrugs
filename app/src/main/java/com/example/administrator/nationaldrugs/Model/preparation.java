package com.example.administrator.nationaldrugs.Model;

import static com.example.administrator.nationaldrugs.Webservice.Const.tet;
import static com.example.administrator.nationaldrugs.Webservice.Const.value;

/**
 * Created by Administrator on 2016/11/15.
 */

public class preparation {
    private String ppid;
    private String drugid;
    private String pName;
    private String about;

    public String getPpid() {
        return ppid;
    }

    public void setPpid(String ppid) {
        this.ppid = ppid.equals(value)?tet:ppid;
    }

    public String getDrugid() {
        return drugid;
    }

    public void setDrugid(String drugid) {
        this.drugid = drugid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName.equals(value)?tet:pName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about.equals(value)?tet:about;
    }
}

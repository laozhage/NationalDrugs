package com.example.administrator.nationaldrugs.Model;

import static com.example.administrator.nationaldrugs.Webservice.Const.tet;
import static com.example.administrator.nationaldrugs.Webservice.Const.value;

/**
 * Created by Administrator on 2016/11/15.
 */

public class right {
    private String rtid;
    private String rshid;
    private String drugid;
    private String rttype;
    private String rtname;
    private String rtcontent;

    public String getRtid() {
        return rtid;
    }

    public void setRtid(String rtid) {
        this.rtid = rtid;
    }

    public String getRshid() {
        return rshid;
    }

    public void setRshid(String rshid) {
        this.rshid = rshid;
    }

    public String getDrugid() {
        return drugid;
    }

    public void setDrugid(String drugid) {
        this.drugid = drugid;
    }

    public String getRttype() {
        return rttype;
    }

    public void setRttype(String rttype) {
        this.rttype = rttype.equals(value)?tet:rttype;
    }

    public String getRtname() {
        return rtname;
    }

    public void setRtname(String rtname) {
        this.rtname = rtname.equals(value)?tet:rtname;
    }

    public String getRtcontent() {
        return rtcontent;
    }

    public void setRtcontent(String rtcontent) {this.rtcontent = rtcontent.equals(value)?tet:rtcontent;}
}

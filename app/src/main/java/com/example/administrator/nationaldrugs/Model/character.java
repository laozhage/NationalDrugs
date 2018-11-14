package com.example.administrator.nationaldrugs.Model;

import static com.example.administrator.nationaldrugs.Webservice.Const.tet;
import static com.example.administrator.nationaldrugs.Webservice.Const.value;

/**
 * Created by Administrator on 2016/11/15.
 */

public class character {
    private String cc14;
    private String cc15;
    private String cc16;
    private String cc17;
    private String cc18;
    private String cc19;
    private String cc20;

    public String getCc20() {
        return cc20;
    }

    public void setCc20(String cc20) {this.cc20 = cc20.equals(value)?tet:cc20;
    }

    public String getCc14() {
        return cc14;
    }

    public void setCc14(String cc14) {
        this.cc14 = cc14.equals(value)?tet:cc14;
    }

    public String getCc15() {
        return cc15;
    }

    public void setCc15(String cc15) {
        this.cc15 = cc15.equals(value)?tet:cc15;
    }

    public String getCc16() {
        return cc16;
    }

    public void setCc16(String cc16) {
        this.cc16 = cc16.equals(value)?tet:cc16;
    }

    public String getCc17() {return cc17;}

    public void setCc17(String cc17) {
        this.cc17 = cc17.equals(value)?tet:cc17;
    }

    public String getCc18() {
        return cc18;
    }

    public void setCc18(String cc18) {
        this.cc18 = cc18.equals(value)?tet:cc18;
    }

    public String getCc19() {
        return cc19;
    }

    public void setCc19(String cc19) {
        this.cc19 = cc19.equals(value)?tet:cc19;
    }


}

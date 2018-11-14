package com.example.administrator.nationaldrugs.Model;

import static com.example.administrator.nationaldrugs.Webservice.Const.tet;
import static com.example.administrator.nationaldrugs.Webservice.Const.value;

/**
 * Created by Administrator on 2016/11/21.
 */

public class passport {
    private String drugid;
    private String nationName;
    private String transltName;
    private String name;
    private String position;
    private String channel;
    private String effect;
    private String func;
    private String usef;
    private String Observe;
    private String standard;
    private String useGUID;
    private String classify;
    private String subjectno;
    private String bdel;

    public String getDrugid() {
        return drugid;
    }

    public void setDrugid(String drugid) {
        this.drugid = drugid;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {this.nationName = nationName.equals(value)?tet:nationName;}

    public String getTransltName() {
        return transltName;
    }

    public void setTransltName(String transltName) {
        this.transltName = transltName.equals(value)?tet:transltName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.equals(value)?tet:name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position.equals(value)?tet:position;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel.equals(value)?tet:channel;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect.equals(value)?tet:effect;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func.equals(value)?tet:func;
    }

    public String getUsef() {
        return usef;
    }

    public void setUsef(String usef) {
        this.usef = usef.equals(value)?tet:usef;
    }

    public String getObserve() {
        return Observe;
    }

    public void setObserve(String observe) {
        Observe = observe.equals(value)?tet:observe;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard.equals(value)?tet:standard;
    }

    public String getUseGUID() {
        return useGUID;
    }

    public void setUseGUID(String useGUID) {
        this.useGUID = useGUID.equals(value)?tet:useGUID;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify.equals(value)?tet:classify;
    }

    public String getSubjectno() {
        return subjectno;
    }

    public void setSubjectno(String subjectno) {
        this.subjectno = subjectno.equals(value)?tet:subjectno;
    }

    public String getBdel() {
        return bdel;
    }

    public void setBdel(String bdel) {
        this.bdel = bdel.equals(value)?tet:bdel;
    }
}

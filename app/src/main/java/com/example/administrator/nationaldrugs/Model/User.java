package com.example.administrator.nationaldrugs.Model;

/**
 * Created by Administrator on 2016/11/16.
 */

public class User {
    private String truename;
    private String pwd;
    public String gettruename()
    {
        return truename;
    }
    public void setuserid(String truename)
    {
        this.truename=truename;
    }
    public String getpwd()
    {
        return pwd;
    }
    public void setpwd(String pwd)
    {
        this.pwd=pwd;
    }
}

package com.example.administrator.nationaldrugs.Model;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.example.administrator.nationaldrugs.Webservice.Const.tet;
import static com.example.administrator.nationaldrugs.Webservice.Const.value;

/**
 * Created by Administrator on 2016/11/15.
 */

public class chemistry {
    private String cmid;
    private String rshid;
    private String drugid;
    private String cmname;
    private String cmformula;
    private Bitmap cmpic;
    private String path;
    public Bitmap getCmpic() {return cmpic;}

    public void setCmpic(Bitmap cmpic) {this.cmpic = cmpic;}

    public String getCmformula() {return cmformula;}

    public void setCmformula(String cmformula) {this.cmformula = cmformula.equals(value)?tet:cmformula;}

    public String getCmname() {
        return cmname;
    }

    public void setCmname(String cmname) {
        this.cmname = cmname.equals(value)?tet:cmname;
    }

    public String getDrugid() {
        return drugid;
    }

    public void setDrugid(String drugid) {this.drugid = drugid;}

    public String getRshid() {
        return rshid;
    }

    public void setRshid(String rshid) {
        this.rshid = rshid;
    }

    public String getCmid() {
        return cmid;
    }

    public void setCmid(String cmid) {
        this.cmid = cmid;
    }
    public static Bitmap getBitmap(String path) {

        try {

            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                InputStream inputStream = conn.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public String getPath() {return path;}

    public void setPath(String path) {this.path = path;}
}

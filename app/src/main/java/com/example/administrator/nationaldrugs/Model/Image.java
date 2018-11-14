package com.example.administrator.nationaldrugs.Model;

import android.graphics.Bitmap;

import static com.example.administrator.nationaldrugs.Webservice.Const.tet;
import static com.example.administrator.nationaldrugs.Webservice.Const.value;

/**
 * Created by Administrator on 2016/11/22.
 */

public class Image {
    private String imagename;
    private String path;
    private Bitmap image;
    public String getimagename() {
        return imagename;
    }

    public void setimagename(String imagename) {
        this.imagename = imagename.equals(value)?tet:imagename;
    }

    public Bitmap getimage() {return image;}

    public void setImage(Bitmap image) {this.image = image;}
    public String getPath() {return path;}

    public void setPath(String path) {this.path = path;}
}

package com.example.administrator.nationaldrugs.Webservice;

/**
 * Created by Administrator on 2016/10/24.
 */

import com.example.administrator.nationaldrugs.Model.DRUG;
import com.example.administrator.nationaldrugs.Model.Heredity;
import com.example.administrator.nationaldrugs.Model.Image;
import com.example.administrator.nationaldrugs.Model.Reference;
import com.example.administrator.nationaldrugs.Model.Research;
import com.example.administrator.nationaldrugs.Model.Share;
import com.example.administrator.nationaldrugs.Model.User;
import com.example.administrator.nationaldrugs.Model.character;
import com.example.administrator.nationaldrugs.Model.chemistry;
import com.example.administrator.nationaldrugs.Model.passport;
import com.example.administrator.nationaldrugs.Model.preparation;
import com.example.administrator.nationaldrugs.Model.right;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import static com.example.administrator.nationaldrugs.Webservice.Const.*;

public class WebserviceTest {

    /*
    民族文字名称查询,返回Passport表的前5列数据
     */
    public static List<DRUG>getDrug(String nationName)
    {
        final HttpTransportSE trans=new HttpTransportSE(localURL);
        trans.debug=true;
        SoapObject soapObject=new SoapObject(NAMESPACE,MethodName);
        soapObject.addProperty("nationName",nationName);
        final SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet=true;
        envelope.bodyOut=soapObject;
        //envelope.setOutputSoapObject(soapObject);
        FutureTask<List<DRUG>> future = new FutureTask<List<DRUG>>(
                new Callable<List<DRUG>>() {

                    @Override
                    public List<DRUG> call() throws Exception {
                        // 调用Web Service
                        List<DRUG>list=new ArrayList<>();
                        trans.call(NAMESPACE+MethodName, envelope);
                        // 获取返回信息
                        if (envelope.getResponse() != null) {
                            SoapObject result = (SoapObject) envelope.bodyIn;
                           //SoapObject result = (SoapObject) envelope.getResponse();
                            SoapObject soap=(SoapObject)result.getProperty(0);
                            // 解析返回信息
                            for (int i = 0; i < soap.getPropertyCount(); i=i+5) {
                                // 获取药名
                                DRUG drug=new DRUG();
                                drug.setdrugid((soap.getPropertyAsString(i)));
                                drug.setnationName(soap.getPropertyAsString(i+1));
                                drug.settransltName(soap.getPropertyAsString(i+2));
                                drug.setname(soap.getPropertyAsString(i+3));
                                drug.setposition(soap.getPropertyAsString(i+4));
                                list.add(drug);
                            }
                            return list;
                        }
                        return null;
                    }
                });
        new Thread(future).start();
        try {
            return future.get();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    /*
    登录信息
     */
    public static List<User>getUser(String truename)
    {

        final HttpTransportSE trans=new HttpTransportSE(localURL);
        trans.debug=true;
        SoapObject soapObject=new SoapObject(NAMESPACE,MethodName11);
        soapObject.addProperty("truename",truename);
        final SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet=true;
        envelope.bodyOut=soapObject;
        //envelope.setOutputSoapObject(soapObject);
        FutureTask<List<User>> future = new FutureTask<List<User>>(
                new Callable<List<User>>() {

                    @Override
                    public List<User> call() throws Exception {
                        // 调用Web Service
                        List<User> list=new ArrayList<>();
                        trans.call(NAMESPACE+MethodName11, envelope);
                        // 获取返回信息
                        if (envelope.getResponse() != null) {
                            SoapObject result = (SoapObject) envelope.bodyIn;
                            //SoapObject result = (SoapObject) envelope.getResponse();
                            SoapObject soap=(SoapObject)result.getProperty(0);
                            // 解析返回信息
                            for (int i = 0; i < soap.getPropertyCount(); i=i+1) {
                                // 获取药名
                                User user =new User();
                                user.setuserid((soap.getPropertyAsString(i)));
                                list.add(user);
                            }
                            return list;
                        }
                        return null;
                    }
                });
        new Thread(future).start();
        try {
            return future.get();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public static List<User>addUser(User user)
    {
        final HttpTransportSE trans=new HttpTransportSE(localURL);
        trans.debug=true;
        SoapObject soapObject=new SoapObject(NAMESPACE,MethodName12);
        soapObject.addProperty("truename",user.gettruename());
        soapObject.addProperty("pwd",user.getpwd());
        final SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet=true;
        envelope.bodyOut=soapObject;
        //envelope.setOutputSoapObject(soapObject);
        FutureTask<List<User>> future = new FutureTask<List<User>>(
                new Callable<List<User>>() {

                    @Override
                    public List<User> call() throws Exception {
                        // 调用Web Service
                        List<User> list=new ArrayList<>();
                        trans.call(NAMESPACE+MethodName12, envelope);
                        // 获取返回信息
                        if (envelope.getResponse() != null) {
                            SoapObject result = (SoapObject) envelope.bodyIn;
                            //SoapObject result = (SoapObject) envelope.getResponse();
                            SoapObject soap=(SoapObject)result.getProperty(0);
                            // 解析返回信息
                            for (int i = 0; i < soap.getPropertyCount(); i=i+1) {
                                // 获取药名
                                User user =new User();
                                user.setuserid((soap.getPropertyAsString(i)));
                                user.setpwd(soap.getPropertyAsString(i+1));
                                list.add(user);
                            }
                            return list;
                        }
                        return null;
                    }
                });
        new Thread(future).start();
        try {
            return future.get();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public static List<passport>getPassport(String drugid)
    {
        final HttpTransportSE trans=new HttpTransportSE(localURL);
        trans.debug=true;
        SoapObject soapObject=new SoapObject(NAMESPACE,MethodName1);
        soapObject.addProperty("id",drugid);
        final SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet=true;
        envelope.bodyOut=soapObject;
        //envelope.setOutputSoapObject(soapObject);
        FutureTask<List<passport>> future = new FutureTask<>(
                new Callable<List<passport>>() {

                    @Override
                    public List<passport> call() throws Exception {
                        // 调用Web Service
                        List<passport>list=new ArrayList<>();
                        trans.call(NAMESPACE+MethodName1, envelope);
                        // 获取返回信息
                        if (envelope.getResponse() != null) {
                            SoapObject result = (SoapObject) envelope.bodyIn;
                            //SoapObject result = (SoapObject) envelope.getResponse();
                            SoapObject soap=(SoapObject)result.getProperty(0);
                            // 解析返回信息
                            for (int i = 0; i < soap.getPropertyCount(); i=i+13) {
                                // 获取药名
                                passport drug=new passport();
                                drug.setNationName(soap.getPropertyAsString(i));
                                drug.setTransltName(soap.getPropertyAsString(i+1));
                                drug.setName(soap.getPropertyAsString(i+2));
                                drug.setPosition(soap.getPropertyAsString(i+3));
                                drug.setChannel(soap.getPropertyAsString(i+4));
                                drug.setEffect(soap.getPropertyAsString(i+5));
                                drug.setFunc(soap.getPropertyAsString(i+6));
                                drug.setUsef(soap.getPropertyAsString(i+7));
                                drug.setObserve(soap.getPropertyAsString(i+8));
                                drug.setStandard(soap.getPropertyAsString(i+9));
                                drug.setUseGUID(soap.getPropertyAsString(i+10));
                                drug.setClassify(soap.getPropertyAsString(i+11));
                                drug.setSubjectno(soap.getPropertyAsString(i+12));
                                list.add(drug);
                            }
                            return list;
                        }
                        return null;
                    }
                });
        new Thread(future).start();
        try {
            return future.get();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public static List<preparation>getpreparation(String drugid)
    {
        final HttpTransportSE trans=new HttpTransportSE(localURL);
        trans.debug=true;
        SoapObject soapObject=new SoapObject(NAMESPACE,MethodName2);
        soapObject.addProperty("id",drugid);
        final SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet=true;
        envelope.bodyOut=soapObject;
        //envelope.setOutputSoapObject(soapObject);
        FutureTask<List<preparation>> future = new FutureTask<>(
                new Callable<List<preparation>>() {

                    @Override
                    public List<preparation> call() throws Exception {
                        // 调用Web Service
                        List<preparation>list=new ArrayList<>();
                        trans.call(NAMESPACE+MethodName2, envelope);
                        // 获取返回信息
                        if (envelope.getResponse() != null) {
                            SoapObject result = (SoapObject) envelope.bodyIn;
                            //SoapObject result = (SoapObject) envelope.getResponse();
                            SoapObject soap=(SoapObject)result.getProperty(0);
                            // 解析返回信息
                            for (int i = 0; i < soap.getPropertyCount(); i=i+2) {
                                // 获取药名
                                preparation drug=new preparation();
                                drug.setpName(soap.getPropertyAsString(i));
                                drug.setAbout(soap.getPropertyAsString(i+1));
                                list.add(drug);
                            }
                            return list;
                        }
                        return null;
                    }
                });
        new Thread(future).start();
        try {
            return future.get();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static List<character>getcharacter(String drugid)
    {
        final HttpTransportSE trans=new HttpTransportSE(localURL);
        trans.debug=true;
        SoapObject soapObject=new SoapObject(NAMESPACE,MethodName3);
        soapObject.addProperty("id",drugid);
        final SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet=true;
        envelope.bodyOut=soapObject;
        //envelope.setOutputSoapObject(soapObject);
        FutureTask<List<character>> future = new FutureTask<>(
                new Callable<List<character>>() {

                    @Override
                    public List<character> call() throws Exception {
                        // 调用Web Service
                        List<character>list=new ArrayList<>();
                        trans.call(NAMESPACE+MethodName3, envelope);
                        // 获取返回信息
                        if (envelope.getResponse() != null) {
                            SoapObject result = (SoapObject) envelope.bodyIn;
                            //SoapObject result = (SoapObject) envelope.getResponse();
                            SoapObject soap=(SoapObject)result.getProperty(0);
                            // 解析返回信息
                            for (int i = 0; i < soap.getPropertyCount(); i=i+7) {
                                // 获取药名
                                character drug=new character();
                                drug.setCc14(soap.getPropertyAsString(i));
                                drug.setCc15(soap.getPropertyAsString(i+1));
                                drug.setCc16(soap.getPropertyAsString(i+2));
                                drug.setCc17(soap.getPropertyAsString(i+3));
                                drug.setCc18(soap.getPropertyAsString(i+4));
                                drug.setCc19(soap.getPropertyAsString(i+5));
                                drug.setCc20(soap.getPropertyAsString(i+6));
                                list.add(drug);
                            }
                            return list;
                        }
                        return null;
                    }
                });
        new Thread(future).start();
        try {
            return future.get();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public static List<Research>getResearch(String drugid)
    {
        final HttpTransportSE trans=new HttpTransportSE(localURL);
        trans.debug=true;
        SoapObject soapObject=new SoapObject(NAMESPACE,MethodName4);
        soapObject.addProperty("id",drugid);
        final SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet=true;
        envelope.bodyOut=soapObject;
        //envelope.setOutputSoapObject(soapObject);
        FutureTask<List<Research>> future = new FutureTask<>(
                new Callable<List<Research>>() {

                    @Override
                    public List<Research> call() throws Exception {
                        // 调用Web Service
                        List<Research>list=new ArrayList<>();
                        trans.call(NAMESPACE+MethodName4, envelope);
                        // 获取返回信息
                        if (envelope.getResponse() != null) {
                            SoapObject result = (SoapObject) envelope.bodyIn;
                            //SoapObject result = (SoapObject) envelope.getResponse();
                            SoapObject soap=(SoapObject)result.getProperty(0);
                            // 解析返回信息
                            for (int i = 0; i < soap.getPropertyCount(); i=i+11) {
                                // 获取药名
                                Research drug=new Research();
                                drug.setRsh21(soap.getPropertyAsString(i));
                                drug.setRsh22(soap.getPropertyAsString(i+1));
                                drug.setRsh23(soap.getPropertyAsString(i+2));
                                drug.setRsh24(soap.getPropertyAsString(i+3));
                                drug.setRsh25(soap.getPropertyAsString(i+4));
                                drug.setRsh26(soap.getPropertyAsString(i+5));
                                drug.setRsh27(soap.getPropertyAsString(i+6));
                                drug.setRsh28(soap.getPropertyAsString(i+7));
                                drug.setRsh29(soap.getPropertyAsString(i+8));
                                drug.setRsh30(soap.getPropertyAsString(i+9));
                                drug.setRsh31(soap.getPropertyAsString(i+10));
                                list.add(drug);
                            }
                            return list;
                        }
                        return null;
                    }
                });
        new Thread(future).start();
        try {
            return future.get();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public static List<chemistry>getchemistry(String drugid)
    {
        final HttpTransportSE trans=new HttpTransportSE(localURL);
        trans.debug=true;
        SoapObject soapObject=new SoapObject(NAMESPACE,MethodName5);
        soapObject.addProperty("id",drugid);
        final SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet=true;
        envelope.bodyOut=soapObject;
        //envelope.setOutputSoapObject(soapObject);
        FutureTask<List<chemistry>> future = new FutureTask<>(
                new Callable<List<chemistry>>() {

                    @Override
                    public List<chemistry> call() throws Exception {
                        // 调用Web Service
                        List<chemistry>list=new ArrayList<>();
                        trans.call(NAMESPACE+MethodName5, envelope);
                        // 获取返回信息
                        if (envelope.getResponse() != null) {
                            SoapObject result = (SoapObject) envelope.bodyIn;
                            //SoapObject result = (SoapObject) envelope.getResponse();
                            SoapObject soap=(SoapObject)result.getProperty(0);
                            // 解析返回信息
                            for (int i = 0; i < soap.getPropertyCount(); i=i+3) {
                                // 获取药名
                                chemistry drug=new chemistry();
                                drug.setCmname(soap.getPropertyAsString(i));
                                drug.setCmformula(soap.getPropertyAsString(i+1));
                                drug.setPath(soap.getPropertyAsString(i+2));
                                list.add(drug);
                            }
                            return list;
                        }
                        return null;
                    }
                });
        new Thread(future).start();
        try {
            return future.get();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public static List<right>getright(String drugid)
    {
        final HttpTransportSE trans=new HttpTransportSE(localURL);
        trans.debug=true;
        SoapObject soapObject=new SoapObject(NAMESPACE,MethodName6);
        soapObject.addProperty("id",drugid);
        final SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet=true;
        envelope.bodyOut=soapObject;
        //envelope.setOutputSoapObject(soapObject);
        FutureTask<List<right>> future = new FutureTask<>(
                new Callable<List<right>>() {

                    @Override
                    public List<right> call() throws Exception {
                        // 调用Web Service
                        List<right>list=new ArrayList<>();
                        trans.call(NAMESPACE+MethodName6, envelope);
                        // 获取返回信息
                        if (envelope.getResponse() != null) {
                            SoapObject result = (SoapObject) envelope.bodyIn;
                            //SoapObject result = (SoapObject) envelope.getResponse();
                            SoapObject soap=(SoapObject)result.getProperty(0);
                            // 解析返回信息
                            for (int i = 0; i < soap.getPropertyCount(); i=i+3) {
                                // 获取药名
                                right drug=new right();
                                drug.setRttype(soap.getPropertyAsString(i));
                                drug.setRtname(soap.getPropertyAsString(i+1));
                                drug.setRtcontent(soap.getPropertyAsString(i+2));
                                list.add(drug);
                            }
                            return list;
                        }
                        return null;
                    }
                });
        new Thread(future).start();
        try {
            return future.get();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public static List<Reference>getReference(String drugid)
    {
        final HttpTransportSE trans=new HttpTransportSE(localURL);
        trans.debug=true;
        SoapObject soapObject=new SoapObject(NAMESPACE,MethodName7);
        soapObject.addProperty("id",drugid);
        final SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet=true;
        envelope.bodyOut=soapObject;
        //envelope.setOutputSoapObject(soapObject);
        FutureTask<List<Reference>> future = new FutureTask<>(
                new Callable<List<Reference>>() {

                    @Override
                    public List<Reference> call() throws Exception {
                        // 调用Web Service
                        List<Reference>list=new ArrayList<>();
                        trans.call(NAMESPACE+MethodName7, envelope);
                        // 获取返回信息
                        if (envelope.getResponse() != null) {
                            SoapObject result = (SoapObject) envelope.bodyIn;
                            //SoapObject result = (SoapObject) envelope.getResponse();
                            SoapObject soap=(SoapObject)result.getProperty(0);
                            // 解析返回信息
                            for (int i = 0; i < soap.getPropertyCount(); i=i+9) {
                                // 获取药名
                                Reference drug=new Reference();
                                drug.setTitle(soap.getPropertyAsString(i));
                                drug.setMagazine(soap.getPropertyAsString(i+1));
                                drug.setAuthor(soap.getPropertyAsString(i+2));
                                drug.setGov(soap.getPropertyAsString(i+3));
                                drug.setProvince(soap.getPropertyAsString(i+4));
                                drug.setYear(soap.getPropertyAsString(i+5));
                                drug.setVol(soap.getPropertyAsString(i+6));
                                drug.setPage(soap.getPropertyAsString(i+7));
                                drug.setAbs(soap.getPropertyAsString(i+8));
                                list.add(drug);
                            }
                            return list;
                        }
                        return null;
                    }
                });
        new Thread(future).start();
        try {
            return future.get();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public static List<Heredity>getHeredity(String drugid)
    {
        final HttpTransportSE trans=new HttpTransportSE(localURL);
        trans.debug=true;
        SoapObject soapObject=new SoapObject(NAMESPACE,MethodName8);
        soapObject.addProperty("id",drugid);
        final SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet=true;
        envelope.bodyOut=soapObject;
        //envelope.setOutputSoapObject(soapObject);
        FutureTask<List<Heredity>> future = new FutureTask<>(
                new Callable<List<Heredity>>() {

                    @Override
                    public List<Heredity> call() throws Exception {
                        // 调用Web Service
                        List<Heredity>list=new ArrayList<>();
                        trans.call(NAMESPACE+MethodName8, envelope);
                        // 获取返回信息
                        if (envelope.getResponse() != null) {
                            SoapObject result = (SoapObject) envelope.bodyIn;
                            //SoapObject result = (SoapObject) envelope.getResponse();
                            SoapObject soap=(SoapObject)result.getProperty(0);
                            // 解析返回信息
                            for (int i = 0; i < soap.getPropertyCount(); i=i+27) {
                                // 获取药名
                                Heredity drug=new Heredity();
                                drug.setHdt41(soap.getPropertyAsString(i));
                                drug.setHdt42(soap.getPropertyAsString(i+1));
                                drug.setHdt43(soap.getPropertyAsString(i+2));
                                drug.setHdt44(soap.getPropertyAsString(i+3));
                                drug.setHdt45(soap.getPropertyAsString(i+4));
                                drug.setHdt46(soap.getPropertyAsString(i+5));
                                drug.setHdt47(soap.getPropertyAsString(i+6));
                                drug.setHdt48(soap.getPropertyAsString(i+7));
                                drug.setHdt49(soap.getPropertyAsString(i+8));
                                drug.setHdt50(soap.getPropertyAsString(i+9));
                                drug.setHdt51(soap.getPropertyAsString(i+10));
                                drug.setHdt52(soap.getPropertyAsString(i+11));
                                drug.setHdt53(soap.getPropertyAsString(i+12));
                                drug.setHdt54(soap.getPropertyAsString(i+13));
                                drug.setHdt55(soap.getPropertyAsString(i+14));
                                drug.setHdt56(soap.getPropertyAsString(i+15));
                                drug.setHdt57(soap.getPropertyAsString(i+16));
                                drug.setHdt58(soap.getPropertyAsString(i+17));
                                drug.setHdt59(soap.getPropertyAsString(i+18));
                                drug.setHdt60(soap.getPropertyAsString(i+19));
                                drug.setHdt61(soap.getPropertyAsString(i+20));
                                drug.setHdt62(soap.getPropertyAsString(i+21));
                                drug.setHdt63(soap.getPropertyAsString(i+22));
                                drug.setHdt64(soap.getPropertyAsString(i+23));
                                drug.setHdt65(soap.getPropertyAsString(i+24));
                                drug.setHdt66(soap.getPropertyAsString(i+25));
                                drug.setHdt67(soap.getPropertyAsString(i+26));
                                list.add(drug);
                            }
                            return list;
                        }
                        return null;
                    }
                });
        new Thread(future).start();
        try {
            return future.get();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public static List<Image>getImage(String drugid)
    {
        final HttpTransportSE trans=new HttpTransportSE(localURL);
        trans.debug=true;
        SoapObject soapObject=new SoapObject(NAMESPACE,MethodName9);
        soapObject.addProperty("id",drugid);
        final SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet=true;
        envelope.bodyOut=soapObject;
        //envelope.setOutputSoapObject(soapObject);
        FutureTask<List<Image>> future = new FutureTask<>(
                new Callable<List<Image>>() {

                    @Override
                    public List<Image> call() throws Exception {
                        // 调用Web Service
                        List<Image>list=new ArrayList<>();
                        trans.call(NAMESPACE+MethodName9, envelope);
                        // 获取返回信息
                        if (envelope.getResponse() != null) {
                            SoapObject result = (SoapObject) envelope.bodyIn;
                            //SoapObject result = (SoapObject) envelope.getResponse();
                            SoapObject soap=(SoapObject)result.getProperty(0);
                            // 解析返回信息
                            for (int i = 0; i < soap.getPropertyCount(); i=i+2) {
                                // 获取药名
                                Image drug=new Image();
                                drug.setimagename(soap.getPropertyAsString(i));
                                drug.setPath(soap.getPropertyAsString(i+1));
                                list.add(drug);
                            }
                            return list;
                        }
                        return null;
                    }
                });
        new Thread(future).start();
        try {
            return future.get();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public static List<Image>getImagetype(String drugid,int itype)
    {
        final HttpTransportSE trans=new HttpTransportSE(localURL);
        trans.debug=true;
        SoapObject soapObject=new SoapObject(NAMESPACE,MethodName13);
        soapObject.addProperty("id",drugid);
        soapObject.addProperty("itype",itype);
        final SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet=true;
        envelope.bodyOut=soapObject;
        //envelope.setOutputSoapObject(soapObject);
        FutureTask<List<Image>> future = new FutureTask<>(
                new Callable<List<Image>>() {

                    @Override
                    public List<Image> call() throws Exception {
                        // 调用Web Service
                        List<Image>list=new ArrayList<>();
                        trans.call(NAMESPACE+MethodName13, envelope);
                        // 获取返回信息
                        if (envelope.getResponse() != null) {
                            SoapObject result = (SoapObject) envelope.bodyIn;
                            //SoapObject result = (SoapObject) envelope.getResponse();
                            SoapObject soap=(SoapObject)result.getProperty(0);
                            // 解析返回信息
                            for (int i = 0; i < soap.getPropertyCount(); i=i+2) {
                                // 获取药名
                                Image drug=new Image();
                                drug.setimagename(soap.getPropertyAsString(i));
                                drug.setPath(soap.getPropertyAsString(i+1));
                                list.add(drug);
                            }
                            return list;
                        }
                        return null;
                    }
                });
        new Thread(future).start();
        try {
            return future.get();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public static List<Share>getShare(String drugid)
    {
        final HttpTransportSE trans=new HttpTransportSE(localURL);
        trans.debug=true;
        SoapObject soapObject=new SoapObject(NAMESPACE,MethodName10);
        soapObject.addProperty("id",drugid);
        final SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet=true;
        envelope.bodyOut=soapObject;
        //envelope.setOutputSoapObject(soapObject);
        FutureTask<List<Share>> future = new FutureTask<>(
                new Callable<List<Share>>() {

                    @Override
                    public List<Share> call() throws Exception {
                        // 调用Web Service
                        List<Share>list=new ArrayList<>();
                        trans.call(NAMESPACE+MethodName10, envelope);
                        // 获取返回信息
                        if (envelope.getResponse() != null) {
                            SoapObject result = (SoapObject) envelope.bodyIn;
                            //SoapObject result = (SoapObject) envelope.getResponse();
                            SoapObject soap=(SoapObject)result.getProperty(0);
                            // 解析返回信息
                            for (int i = 0; i < soap.getPropertyCount(); i=i+7) {
                                // 获取药名
                                Share drug=new Share();
                                drug.setIshareway(soap.getPropertyAsString(i));
                                drug.setIobtainway(soap.getPropertyAsString(i+1));
                                drug.setMan(soap.getPropertyAsString(i+2));
                                drug.setDepart(soap.getPropertyAsString(i+3));
                                drug.setMcode(soap.getPropertyAsString(i+4));
                                drug.setTel(soap.getPropertyAsString(i+5));
                                drug.setEmail(soap.getPropertyAsString(i+6));
                                list.add(drug);
                            }
                            return list;
                        }
                        return null;
                    }
                });
        new Thread(future).start();
        try {
            return future.get();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}

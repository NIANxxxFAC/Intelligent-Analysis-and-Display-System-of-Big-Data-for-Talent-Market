package com.ll.tjpu.live.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class HttpTread extends Thread{
    private String url;
    private String number;
    private String style;
    private String sex;
    private String characher;
    private String type;

    public HttpTread(String url, String number, String style, String sex, String characher, String type) {
        this.url = url;
        this.number = number;
        this.style = style;
        this.sex = sex;
        this.characher = characher;
        this.type = type;
    }

    private void doGet() throws IOException {
        /*将username和password传给Tomcat服务器*/
        url=url+"?number="+number+"&style="+style+"&sex="+sex+"&characher="+characher+"&type="+type;
        try {
            URL httpUrl = new URL(url);
            /*获取网络连接*/
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
            /*设置请求方法为GET方法*/
            conn.setRequestMethod("GET");
            /*设置访问超时时间*/
            conn.setReadTimeout(5000);
            BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String str;
            StringBuffer sb=new StringBuffer();
            //读取服务器返回的信息
            while((str=reader.readLine())!=null)
            {
                sb.append(str);
            }

            //把服务端返回的数据打印出来
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /*在run中调用doGet*/
    @Override
    public void run() {
        try {
            doGet();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

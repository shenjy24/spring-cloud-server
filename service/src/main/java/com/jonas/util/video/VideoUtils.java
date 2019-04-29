package com.jonas.util.video;

import ws.schild.jave.EncoderException;
import ws.schild.jave.MultimediaInfo;
import ws.schild.jave.MultimediaObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 视频工具类
 *
 * @author shenjy 2018/12/03
 */
public class VideoUtils {

    /**
     * 获取视频信息
     *
     * @param file
     * @return
     */
    public static MultimediaInfo getVideoInfo(File file) {
        if (null == file) {
            return null;
        }

        try {
            MultimediaObject multimediaObject = new MultimediaObject(file);
            MultimediaInfo info = multimediaObject.getInfo();
            return info;
        } catch (EncoderException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void toBDFile(String urlStr, String bdUrl) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        DataInputStream in = new DataInputStream(conn.getInputStream());
        byte[] data = toByteArray(in);
        in.close();
        FileOutputStream out = new FileOutputStream(bdUrl);
        out.write(data);
        out.close();
    }

    public static byte[] toByteArray(InputStream in) throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n = 0;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }

    public static void main(String[] args) throws IOException {
        String url = "https://shenjy-in.oss-cn-hangzhou.aliyuncs.com/video/%E5%8D%A1%E9%B2%812.mp4";

        File tmpFile = File.createTempFile("temp", ".tmp");
        toBDFile(url, tmpFile.getCanonicalPath());

        //文件大小 bytes
        System.out.println(tmpFile.length());

        System.out.println(getVideoInfo(tmpFile));
    }
}

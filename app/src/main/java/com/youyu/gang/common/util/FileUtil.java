package com.youyu.gang.common.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 */
public class FileUtil {

    public static void saveFileToLocal(InputStream is, String filePath) {
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            saveFile(is, fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveFileToLocal(InputStream is, File file) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            saveFile(is, fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void saveFile(InputStream is, FileOutputStream fos) {
        try {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.flush();
            fos.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Bitmap getLocalPic(String localPath) {
        Bitmap bitmap = null;
        File file = new File(localPath);
        if (file.exists()) {
            bitmap = BitmapFactory.decodeFile(localPath);
            bitmap = ThumbnailUtils.extractThumbnail(bitmap, 100, 100);
        }
        return bitmap;
    }

    /**
     * must be run in new thread
     * */
    public static boolean downloadShareImage(String sourceUrl, String fileName) {
        File file = new File(SDUtil.getShareDirPath() + fileName);
        return downloadFile(sourceUrl, file);
    }

    /**
     * must be run in new thread
     * */
    public static boolean downloadVideo(String sourceUrl, String fileName) {
        File file = new File(SDUtil.getVideoDirPath() + fileName);
        return downloadFile(sourceUrl, file);
    }
    /**
     * must be run in new thread
     * */
    static boolean downloadFile(String sourceUrl, File file) {
        try {
            URL url = new URL(sourceUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (file.exists()) {
                return true;
            } else {
                InputStream is = conn.getInputStream();
                saveFileToLocal(is, file);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean saveAvatar(Bitmap bm, File file) {
        try {
            FileOutputStream out = new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

package com.youyu.gang.common.util;

import android.content.Context;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 */
public class ResourceMgr {

    Context context;

    final String VIDEO_NAME = "launch.m4v";
    final String VIDEO_PATH= SDUtil.getVideoDirPath();

    final String P_LIST_NAME = "JXAddress.plist";
    final String P_LIST_PATH = SDUtil.getFileDirPath();

    public ResourceMgr(Context context){
        this.context = context;
    }

    public boolean hasVideo(){
        return hasFile(VIDEO_PATH,VIDEO_NAME);
    }

    public boolean hasPList(){
        return hasFile(P_LIST_PATH,P_LIST_NAME);
    }

    public String getVideoPath(){
        return VIDEO_PATH + File.separator + VIDEO_NAME;
    }

    public String getPListPath(){
        return P_LIST_PATH + File.separator + P_LIST_NAME;
    }

    public void loadResource(){
            copyVideo();
            copyPList();
    }

    boolean hasFile(String path,String name){
        File file = new File(path,name);
        return file.exists();
    }

    public void copyVideo() {
        if(hasVideo()){
            return;
        }
        copyAssetsFile(VIDEO_PATH,VIDEO_NAME);
    }

    public void copyPList() {
        if(hasPList()){
            return;
        }
        copyAssetsFile(P_LIST_PATH, P_LIST_NAME);
    }

    void copyAssetsFile(String path,String name){
        try {
            InputStream is = context.getAssets().open(name);
            String filePath = path + File.separator + name;
            FileUtil.saveFileToLocal(is,filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

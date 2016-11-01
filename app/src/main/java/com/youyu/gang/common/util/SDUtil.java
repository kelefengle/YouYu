package com.youyu.gang.common.util;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;

import java.io.File;

/**
 * SD card util
 */
public class SDUtil {

    static SDUtil Instance = null;

    public static SDUtil getInstance() {
        synchronized (SDUtil.class) {
            if (Instance == null) {
                Instance = new SDUtil();
            }
        }
        return Instance;
    }

    private SDUtil() {
    }

    static String ROOT_PATH;

    static String APP_DIR_NAME = "JinXiang";
    static String APP_DIR_PATH;

    static String VIDEO_DIR_NAME = "video";
    static String VIDEO_DIR_PATH;

    static String PICTURE_DIR_NAME = "picture";
    static String PICTURE_DIR_PATH;

    static String AVATAR_DIR_NAME = "avatar";
    static String AVATAR_DIR_PATH;

    static String SHARE_DIR_NAME = "share";
    static String SHARE_DIR_PATH;

    static String FILE_DIR_NAME = "file";
    static String FILE_DIR_PATH;

    static String LOG_DIR_NAME = "log";
    static String LOG_DIR_PATH;

    static int ERROR;

    public void init() {
        if (isSDCardExist()) {
            ROOT_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
        } else {
            ROOT_PATH = "mnt/sdcard";
        }

        APP_DIR_PATH = ROOT_PATH + File.separator + APP_DIR_NAME;
        VIDEO_DIR_PATH = APP_DIR_PATH + File.separator + VIDEO_DIR_NAME;
        PICTURE_DIR_PATH = APP_DIR_PATH + File.separator + PICTURE_DIR_NAME;
        SHARE_DIR_PATH = APP_DIR_PATH + File.separator + SHARE_DIR_NAME;
        FILE_DIR_PATH = APP_DIR_PATH + File.separator + FILE_DIR_NAME;
        LOG_DIR_PATH = APP_DIR_PATH + File.separator + LOG_DIR_NAME;

        AVATAR_DIR_PATH = PICTURE_DIR_PATH + File.separator + AVATAR_DIR_NAME;

        mkDir(APP_DIR_PATH);
        mkDir(VIDEO_DIR_PATH);
        mkDir(PICTURE_DIR_PATH);
        mkDir(SHARE_DIR_PATH);
        mkDir(FILE_DIR_PATH);
        mkDir(LOG_DIR_PATH);

        mkDir(AVATAR_DIR_PATH);
    }

    // 判断是否已经安装SD卡
    boolean isSDCardExist() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    /**
     * 创建目录
     * */
    void mkDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static String getVideoDirPath() {
        return VIDEO_DIR_PATH;
    }

    public static String getFileDirPath() {
        return FILE_DIR_PATH;
    }

    public static String getLogDirPath() {
        return LOG_DIR_PATH;
    }

    public static String getAvatarDirPath() {
        return AVATAR_DIR_PATH;
    }

    public static String getShareDirPath() {
        return SHARE_DIR_PATH;
    }

    // 内存剩余空间
    long getAvailableInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize;
        long availableBlocks;
        if (Build.VERSION.SDK_INT < 18) {
            blockSize = stat.getBlockSize();
            availableBlocks = stat.getAvailableBlocks();
        } else {
            blockSize = stat.getBlockSizeLong();
            availableBlocks = stat.getAvailableBlocksLong();
        }
        return availableBlocks * blockSize;
    }

    // 内存总空间
    public long getTotalInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize;
        long totalBlocks;
        if (Build.VERSION.SDK_INT < 18) {
            blockSize = stat.getBlockSize();
            totalBlocks = stat.getBlockCount();
        } else {
            blockSize = stat.getBlockSizeLong();
            totalBlocks = stat.getBlockCountLong();
        }
        return totalBlocks * blockSize;
    }

    // SD卡剩余空间
    public long getAvailableExternalMemorySize() {
        if (isSDCardExist()) {
            File path = Environment.getExternalStorageDirectory();
            StatFs stat = new StatFs(path.getPath());
            long blockSize;
            long availableBlocks;
            if (Build.VERSION.SDK_INT < 18) {
                blockSize = stat.getBlockSize();
                availableBlocks = stat.getAvailableBlocks();
            } else {
                blockSize = stat.getBlockSizeLong();
                availableBlocks = stat.getAvailableBlocksLong();
            }
            return availableBlocks * blockSize;
        } else {
            return ERROR;
        }
    }

    // SD卡总空间
    public long getTotalExternalMemorySize() {
        if (isSDCardExist()) {
            File path = Environment.getExternalStorageDirectory();
            StatFs stat = new StatFs(path.getPath());
            long blockSize;
            long totalBlocks;
            if (Build.VERSION.SDK_INT < 18) {
                blockSize = stat.getBlockSize();
                totalBlocks = stat.getBlockCount();
            } else {
                blockSize = stat.getBlockSizeLong();
                totalBlocks = stat.getBlockCountLong();
            }
            return totalBlocks * blockSize;
        } else {
            return ERROR;
        }
    }

    // 判断SD卡下external_sd文件夹的总大小
    public long getTotalExternal_SDMemorySize() {
        if (isSDCardExist()) {
            File path = Environment.getExternalStorageDirectory();
            File externalSD = new File(path.getPath() + "/external_sd");
            if (externalSD.exists() && externalSD.isDirectory()) {
                StatFs stat = new StatFs(path.getPath() + "/external_sd");
                long blockSize;
                long totalBlocks;
                if (Build.VERSION.SDK_INT < 18) {
                    blockSize = stat.getBlockSize();
                    totalBlocks = stat.getBlockCount();
                } else {
                    blockSize = stat.getBlockSizeLong();
                    totalBlocks = stat.getBlockCountLong();
                }
                if (getTotalExternalMemorySize() != -1
                        && getTotalExternalMemorySize() != totalBlocks * blockSize) {
                    return totalBlocks * blockSize;
                } else {
                    return ERROR;
                }
            } else {
                return ERROR;
            }

        } else {
            return ERROR;
        }
    }

    // 判断SD卡下external_sd文件夹的可用大小
    public long getAvailableExternal_SDMemorySize() {
        if (isSDCardExist()) {
            File path = Environment.getExternalStorageDirectory();
            File externalSD = new File(path.getPath() + "/external_sd");
            if (externalSD.exists() && externalSD.isDirectory()) {
                StatFs stat = new StatFs(path.getPath() + "/external_sd");

                long blockSize;
                long availableBlocks;
                if (Build.VERSION.SDK_INT < 18) {
                    blockSize = stat.getBlockSize();
                    availableBlocks = stat.getAvailableBlocks();
                } else {
                    blockSize = stat.getBlockSizeLong();
                    availableBlocks = stat.getAvailableBlocksLong();
                }
                if (getAvailableExternalMemorySize() != -1
                        && getAvailableExternalMemorySize() != availableBlocks * blockSize) {
                    return availableBlocks * blockSize;
                } else {
                    return ERROR;
                }
            } else {
                return ERROR;
            }
        } else {
            return ERROR;
        }
    }
}

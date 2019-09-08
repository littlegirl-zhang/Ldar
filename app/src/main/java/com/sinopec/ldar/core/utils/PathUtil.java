package com.sinopec.ldar.core.utils;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import android.content.Context;
import android.os.Environment;

import java.io.File;

public class PathUtil {
    public static String pathPrefix;
    public static final String imagePathName = "/image/";
    public static final String filePathName = "/file/";
    private static File storageDir = null;
    private static PathUtil instance = null;
    private File imagePath = null;
    private File filePath;

    private PathUtil() {
    }

    public static PathUtil getInstance() {
        if (instance == null) {
            instance = new PathUtil();
        }

        return instance;
    }

    public void initDirs(String user, Context context) {
        String packageName = context.getPackageName();
        pathPrefix = "/Android/data/" + packageName + "/";

        this.imagePath = generateImagePath(user, context);
        if (!this.imagePath.exists()) {
            this.imagePath.mkdirs();
        }

        this.filePath = generateFiePath(user, context);
        if (!this.filePath.exists()) {
            this.filePath.mkdirs();
        }

    }

    public File getImagePath() {
        return this.imagePath;
    }


    public File getFilePath() {
        return this.filePath;
    }


    private static File getStorageDir(Context context) {
        if (storageDir == null) {
            File var1 = Environment.getExternalStorageDirectory();
            if (var1.exists()) {
                return var1;
            }

            storageDir = context.getFilesDir();
        }

        return storageDir;
    }

    private static File generateImagePath(String filePathName, Context context) {
        String var3 = pathPrefix + filePathName + "/image/";
        return new File(getStorageDir(context), var3);
    }

    private static File generateVoicePath(String filePathName, Context context) {
        String var3 = pathPrefix + filePathName + "/voice/";
        return new File(getStorageDir(context), var3);
    }

    private static File generateFiePath(String filePathName, Context context) {
        String var3 = pathPrefix + filePathName + "/file/";
        return new File(getStorageDir(context), var3);
    }

    public static File getTempPath(File file) {
        File f = new File(file.getAbsoluteFile() + ".tmp");
        return f;
    }
}


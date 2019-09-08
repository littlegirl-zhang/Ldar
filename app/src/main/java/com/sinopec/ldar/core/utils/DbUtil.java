package com.sinopec.ldar.core.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.sinopec.ldar.core.dao.DaoMaster;
import com.sinopec.ldar.core.dao.DaoSession;

import java.io.File;

/**
 *
 */
public class DbUtil {

    private static DbUtil INSTANCE;
    private DaoSession mDaoSession;

    public DaoSession getmDaoSession() {
        return mDaoSession;
    }

    public static DbUtil getInstance() {
        if (INSTANCE == null) {
            synchronized (DbUtil.class) {
                INSTANCE = new DbUtil();
            }
        }
        return INSTANCE;
    }

    public void initGreenDao(Context context, String username) {
        PathUtil.getInstance().initDirs(username, context);
        MySQLiteOpenHelper helper = new MySQLiteOpenHelper(context, username, null);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster master = new DaoMaster(database);
        mDaoSession = master.newSession();
    }

    class MySQLiteOpenHelper extends DaoMaster.OpenHelper {
//        public MySQLiteOpenHelper(Context context, String name) {
//            super(context, name);
//        }

        public MySQLiteOpenHelper(final Context context, String name, SQLiteDatabase.CursorFactory factory) {
            super(new ContextWrapper(context) {
                @Override
                public File getDatabasePath(String name) {
                    // 判断是否存在sd卡
                    boolean sdExist = android.os.Environment.MEDIA_MOUNTED.equals(android.os.Environment.getExternalStorageState());
                    if (!sdExist) {// 如果不存在,
                        Log.e("SD卡管理：", "SD卡不存在，请加载SD卡");
                        return null;
                    } else {// 如果存在
                        // 判断目录是否存在，不存在则创建该目录
//
                        File dbFile = new File(PathUtil.getInstance().getFilePath(), "ldar.db");
                        return dbFile;
                    }
                }

                @Override
                public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
                    SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), factory);
                    return result;
                }

                @Override
                public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
                    SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), factory);

                    return result;
                }
            }, name, factory);
        }

    }
}

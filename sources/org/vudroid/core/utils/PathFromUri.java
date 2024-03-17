package org.vudroid.core.utils;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

public class PathFromUri {
    public static String retrieve(ContentResolver contentResolver, Uri uri) {
        if (uri.getScheme().equals("file")) {
            return uri.getPath();
        }
        Cursor query = contentResolver.query(uri, new String[]{"_data"}, (String) null, (String[]) null, (String) null);
        if (query.moveToFirst()) {
            return query.getString(0);
        }
        throw new RuntimeException("Can't retrieve path from uri: " + uri.toString());
    }
}

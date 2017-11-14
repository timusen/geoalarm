package com.chadov.getalarm.data;

import android.provider.BaseColumns;

public class DbContract {

    private DbContract() {
    }

    public static final class LocationEntry implements BaseColumns {
        public final static String TABLE_NAME = "locations";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_NAME = "name";
        public final static String COLUMN_RADIUS = "radius";
        public final static String COLUMN_LATITUDE = "latitude";
        public final static String COLUMN_LONGITUDE = "longitude";
        public final static String COLUMN_ACTIVE = "active";

        public static final int ACTIVE_OFF = 0;
        public static final int ACTIVE_ON = 1;
    }
}

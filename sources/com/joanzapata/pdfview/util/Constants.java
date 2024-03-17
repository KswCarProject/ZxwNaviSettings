package com.joanzapata.pdfview.util;

public interface Constants {
    public static final boolean DEBUG_MODE = false;
    public static final int GRID_SIZE = 7;
    public static final int LOADED_SIZE = 3;
    public static final int MASK_ALPHA = 20;
    public static final float MINIMAP_MAX_SIZE = 200.0f;
    public static final float PART_SIZE = 256.0f;
    public static final float THUMBNAIL_RATIO = 0.2f;

    public interface Cache {
        public static final int CACHE_SIZE = ((int) Math.pow(7.0d, 2.0d));
        public static final int THUMBNAILS_CACHE_SIZE = 4;
    }

    public interface Pinch {
        public static final float MAXIMUM_ZOOM = 10.0f;
        public static final float MINIMUM_ZOOM = 1.0f;
        public static final int QUICK_MOVE_THRESHOLD_DISTANCE = 50;
        public static final int QUICK_MOVE_THRESHOLD_TIME = 250;
    }
}

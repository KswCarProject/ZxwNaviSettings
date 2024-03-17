package com.joanzapata.pdfview;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.joanzapata.pdfview.model.PagePart;
import com.joanzapata.pdfview.util.Constants;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Vector;

class CacheManager {
    private PriorityQueue<PagePart> activeCache = new PriorityQueue<>(Constants.Cache.CACHE_SIZE, new PagePartComparator());
    private PriorityQueue<PagePart> passiveCache = new PriorityQueue<>(Constants.Cache.CACHE_SIZE, new PagePartComparator());
    private Vector<PagePart> thumbnails = new Vector<>();

    public void cachePart(PagePart pagePart) {
        makeAFreeSpace();
        this.activeCache.offer(pagePart);
    }

    public void makeANewSet() {
        this.passiveCache.addAll(this.activeCache);
        this.activeCache.clear();
    }

    private void makeAFreeSpace() {
        while (this.activeCache.size() + this.passiveCache.size() >= Constants.Cache.CACHE_SIZE && !this.passiveCache.isEmpty()) {
            this.passiveCache.poll().getRenderedBitmap().recycle();
        }
        while (this.activeCache.size() + this.passiveCache.size() >= Constants.Cache.CACHE_SIZE && !this.activeCache.isEmpty()) {
            this.activeCache.poll().getRenderedBitmap().recycle();
        }
    }

    public void cacheThumbnail(PagePart pagePart) {
        if (this.thumbnails.size() >= 4) {
            this.thumbnails.remove(0).getRenderedBitmap().recycle();
        }
        this.thumbnails.add(pagePart);
    }

    public boolean upPartIfContained(int i, int i2, float f, float f2, RectF rectF, int i3) {
        PagePart pagePart = new PagePart(i, i2, (Bitmap) null, f, f2, rectF, false, 0);
        PagePart find = find(this.passiveCache, pagePart);
        if (find != null) {
            this.passiveCache.remove(find);
            find.setCacheOrder(i3);
            this.activeCache.offer(find);
            return true;
        } else if (find(this.activeCache, pagePart) != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean containsThumbnail(int i, int i2, float f, float f2, RectF rectF) {
        PagePart pagePart = new PagePart(i, i2, (Bitmap) null, f, f2, rectF, true, 0);
        Iterator<PagePart> it = this.thumbnails.iterator();
        while (it.hasNext()) {
            if (it.next().equals(pagePart)) {
                return true;
            }
        }
        return false;
    }

    private PagePart find(PriorityQueue<PagePart> priorityQueue, PagePart pagePart) {
        Iterator<PagePart> it = priorityQueue.iterator();
        while (it.hasNext()) {
            PagePart next = it.next();
            if (next.equals(pagePart)) {
                return next;
            }
        }
        return null;
    }

    public Vector<PagePart> getPageParts() {
        Vector<PagePart> vector = new Vector<>(this.passiveCache);
        vector.addAll(this.activeCache);
        return vector;
    }

    public Vector<PagePart> getThumbnails() {
        return this.thumbnails;
    }

    public void recycle() {
        Iterator<PagePart> it = this.activeCache.iterator();
        while (it.hasNext()) {
            it.next().getRenderedBitmap().recycle();
        }
        Iterator<PagePart> it2 = this.activeCache.iterator();
        while (it2.hasNext()) {
            it2.next().getRenderedBitmap().recycle();
        }
        Iterator<PagePart> it3 = this.thumbnails.iterator();
        while (it3.hasNext()) {
            it3.next().getRenderedBitmap().recycle();
        }
        this.passiveCache.clear();
        this.activeCache.clear();
        this.thumbnails.clear();
    }

    class PagePartComparator implements Comparator<PagePart> {
        PagePartComparator() {
        }

        public int compare(PagePart pagePart, PagePart pagePart2) {
            if (pagePart.getCacheOrder() == pagePart2.getCacheOrder()) {
                return 0;
            }
            return pagePart.getCacheOrder() > pagePart2.getCacheOrder() ? 1 : -1;
        }
    }
}

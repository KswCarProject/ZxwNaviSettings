package org.vudroid.pdfdroid.codec;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import java.nio.ByteBuffer;
import org.vudroid.core.codec.CodecPage;

public class PdfPage implements CodecPage {
    private long docHandle;
    private long pageHandle;

    private static native void free(long j);

    private static native void getMediaBox(long j, float[] fArr);

    private native void nativeCreateView(long j, long j2, int[] iArr, float[] fArr, int[] iArr2);

    private static native long open(long j, int i);

    private static native void render(long j, long j2, int[] iArr, float[] fArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2);

    public boolean isDecoding() {
        return false;
    }

    public void waitForDecode() {
    }

    private PdfPage(long j, long j2) {
        this.pageHandle = j;
        this.docHandle = j2;
    }

    public int getWidth() {
        return (int) getMediaBox().width();
    }

    public int getHeight() {
        return (int) getMediaBox().height();
    }

    public Bitmap renderBitmap(int i, int i2, RectF rectF) {
        Matrix matrix = new Matrix();
        float f = (float) i;
        matrix.postScale(f / getMediaBox().width(), ((float) (-i2)) / getMediaBox().height());
        float f2 = (float) i2;
        matrix.postTranslate(0.0f, f2);
        matrix.postTranslate((-rectF.left) * f, (-rectF.top) * f2);
        matrix.postScale(1.0f / rectF.width(), 1.0f / rectF.height());
        return render(new Rect(0, 0, i, i2), matrix);
    }

    static PdfPage createPage(long j, int i) {
        return new PdfPage(open(j, i), j);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        recycle();
        super.finalize();
    }

    public synchronized void recycle() {
        long j = this.pageHandle;
        if (j != 0) {
            free(j);
            this.pageHandle = 0;
        }
    }

    private RectF getMediaBox() {
        float[] fArr = new float[4];
        getMediaBox(this.pageHandle, fArr);
        return new RectF(fArr[0], fArr[1], fArr[2], fArr[3]);
    }

    public Bitmap render(Rect rect, Matrix matrix) {
        int[] iArr = {rect.left, rect.top, rect.right, rect.bottom};
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = {fArr[0], fArr[3], fArr[1], fArr[4], fArr[2], fArr[5]};
        int width = rect.width();
        int height = rect.height();
        int[] iArr2 = new int[(width * height)];
        nativeCreateView(this.docHandle, this.pageHandle, iArr, fArr2, iArr2);
        return Bitmap.createBitmap(iArr2, width, height, Bitmap.Config.RGB_565);
    }
}

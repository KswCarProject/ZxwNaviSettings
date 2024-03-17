package com.joanzapata.pdfview;

class SpiralLoopManager {
    private SpiralLoopListener listener;

    public interface SpiralLoopListener {
        boolean onLoop(int i, int i2);
    }

    private boolean isValidCell(int i, int i2, int i3, int i4) {
        return i >= 0 && i < i3 && i2 >= 0 && i2 < i4;
    }

    public SpiralLoopManager(SpiralLoopListener spiralLoopListener) {
        if (spiralLoopListener != null) {
            this.listener = spiralLoopListener;
            return;
        }
        throw new IllegalArgumentException("SpiralLoopListener must not be null");
    }

    public void startLoop(int i, int i2, int i3, int i4) {
        int i5 = i2 * i;
        this.listener.onLoop(i3, i4);
        int i6 = 1;
        int i7 = 1;
        int i8 = 1;
        while (i6 < i5) {
            for (int i9 = 0; i9 < i7; i9++) {
                i3 += i8;
                if (isValidCell(i3, i4, i, i2)) {
                    i6++;
                    if (!this.listener.onLoop(i3, i4)) {
                        return;
                    }
                }
            }
            for (int i10 = 0; i10 < i7; i10++) {
                i4 += i8;
                if (isValidCell(i3, i4, i, i2)) {
                    i6++;
                    if (!this.listener.onLoop(i3, i4)) {
                        return;
                    }
                }
            }
            i7++;
            i8 *= -1;
        }
    }
}

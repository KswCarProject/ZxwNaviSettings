package com.joanzapata.pdfview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.animation.DecelerateInterpolator;

class AnimationManager {
    private ValueAnimator animation;
    /* access modifiers changed from: private */
    public PDFView pdfView;

    public AnimationManager(PDFView pDFView) {
        this.pdfView = pDFView;
    }

    public void startXAnimation(float f, float f2) {
        ValueAnimator valueAnimator = this.animation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        this.animation = ofFloat;
        ofFloat.setInterpolator(new DecelerateInterpolator());
        this.animation.addUpdateListener(new XAnimation());
        this.animation.setDuration(400);
        this.animation.start();
    }

    public void startYAnimation(float f, float f2) {
        ValueAnimator valueAnimator = this.animation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        this.animation = ofFloat;
        ofFloat.setInterpolator(new DecelerateInterpolator());
        this.animation.addUpdateListener(new YAnimation());
        this.animation.setDuration(400);
        this.animation.start();
    }

    public void startZoomAnimation(float f, float f2) {
        ValueAnimator valueAnimator = this.animation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        this.animation = ofFloat;
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ZoomAnimation zoomAnimation = new ZoomAnimation();
        this.animation.addUpdateListener(zoomAnimation);
        this.animation.addListener(zoomAnimation);
        this.animation.setDuration(400);
        this.animation.start();
    }

    public void stopAll() {
        ValueAnimator valueAnimator = this.animation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.animation = null;
        }
    }

    class XAnimation implements ValueAnimator.AnimatorUpdateListener {
        XAnimation() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AnimationManager.this.pdfView.moveTo(((Float) valueAnimator.getAnimatedValue()).floatValue(), AnimationManager.this.pdfView.getCurrentYOffset());
        }
    }

    class YAnimation implements ValueAnimator.AnimatorUpdateListener {
        YAnimation() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AnimationManager.this.pdfView.moveTo(AnimationManager.this.pdfView.getCurrentXOffset(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    class ZoomAnimation implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        ZoomAnimation() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AnimationManager.this.pdfView.zoomCenteredTo(((Float) valueAnimator.getAnimatedValue()).floatValue(), new PointF((float) (AnimationManager.this.pdfView.getWidth() / 2), (float) (AnimationManager.this.pdfView.getHeight() / 2)));
        }

        public void onAnimationEnd(Animator animator) {
            AnimationManager.this.pdfView.loadPages();
        }
    }
}

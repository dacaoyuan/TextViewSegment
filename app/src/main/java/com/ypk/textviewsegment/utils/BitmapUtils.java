package com.ypk.textviewsegment.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/**
 * @Author: YuanPeikai
 * @CreateDate: 2020/7/15 13:14
 * @Description:
 */
public class BitmapUtils {
    // 等比缩放图片
    public static Bitmap zoomImg(Bitmap bm, int newWidth, int newHeight) {
        System.out.println("URLImageParser.zoomImg newWidth=" + newWidth + " newHeight=" + newHeight);
        // 获得图片的宽高
        int width = bm.getWidth();
        int height = bm.getHeight();
        // 计算缩放比例
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // 得到新的图片
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
        return newbm;
    }

}

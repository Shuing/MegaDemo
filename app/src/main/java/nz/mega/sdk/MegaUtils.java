/**
 * MegaUtils.java
 * Utils class
 * <p/>
 * (c) 2013-2014 by Mega Limited, Auckland, New Zealand
 * <p/>
 * This file is part of the MEGA SDK - Client Access Engine.
 * <p/>
 * Applications using the MEGA API must present a valid application key
 * and comply with the the rules set forth in the Terms of Service.
 * <p/>
 * The MEGA SDK is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * @copyright Simplified (2-clause) BSD License.
 * <p/>
 * You should have received a copy of the license along with this
 * program.
 */
package nz.mega.sdk;

import android.graphics.Bitmap;
import android.graphics.Rect;

import java.io.File;

public class MegaUtils {
    private static int THUMBNAIL_SIZE = 120;
    private static int PREVIEW_SIZE = 1000;

    public static boolean createThumbnail(File image, File thumbnail) {
        if (!image.exists())
            return false;

        if (thumbnail.exists())
            thumbnail.delete();

        String path = image.getAbsolutePath();
        int orientation = AndroidGfxProcessor.getExifOrientation(path);

        Rect rect = AndroidGfxProcessor.getImageDimensions(path, orientation);
        if (rect.isEmpty())
            return false;

        int w = rect.right;
        int h = rect.bottom;

        if ((w == 0) || (h == 0)) return false;
        if (w < h) {
            h = h * THUMBNAIL_SIZE / w;
            w = THUMBNAIL_SIZE;
        } else {
            w = w * THUMBNAIL_SIZE / h;
            h = THUMBNAIL_SIZE;
        }
        if ((w == 0) || (h == 0)) return false;

        int px = (w - THUMBNAIL_SIZE) / 2;
        int py = (h - THUMBNAIL_SIZE) / 3;

        Bitmap bitmap = AndroidGfxProcessor.getBitmap(path, rect, orientation, w, h);
        bitmap = AndroidGfxProcessor.extractRect(bitmap, px, py, THUMBNAIL_SIZE, THUMBNAIL_SIZE);
        if (bitmap == null)
            return false;

        return AndroidGfxProcessor.saveBitmap(bitmap, thumbnail);
    }

    public static boolean createPreview(File image, File preview) {
        if (!image.exists())
            return false;

        if (preview.exists())
            preview.delete();

        String path = image.getAbsolutePath();
        int orientation = AndroidGfxProcessor.getExifOrientation(path);
        Rect rect = AndroidGfxProcessor.getImageDimensions(path, orientation);

        int w = rect.right;
        int h = rect.bottom;

        if ((w == 0) || (h == 0)) return false;
        if (h > w) {
            w = w * PREVIEW_SIZE / h;
            h = PREVIEW_SIZE;
        } else {
            h = h * PREVIEW_SIZE / w;
            w = PREVIEW_SIZE;
        }
        if ((w == 0) || (h == 0)) return false;

        Bitmap bitmap = AndroidGfxProcessor.getBitmap(path, rect, orientation, w, h);
        return AndroidGfxProcessor.saveBitmap(bitmap, preview);
    }
}

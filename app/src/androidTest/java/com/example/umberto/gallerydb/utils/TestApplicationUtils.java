package com.example.umberto.gallerydb.utils;

import android.content.Intent;
import android.net.Uri;
import android.test.AndroidTestCase;

import com.example.umberto.gallerydb.R;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;

/**
 * Created by Umberto Sidoti on 08/07/2015.
 */
public class TestApplicationUtils extends AndroidTestCase {

    public void testGetIntentFileChooser() {
        Intent intent = ApplicationUtils.getIntentFileChooser();
        assertNotNull(intent);
        assertEquals(Intent.ACTION_GET_CONTENT, intent.getAction());
        assertEquals(getContext().getString(R.string.mime_audio_video_image), intent.getType());
    }

    public void testGetObjectFromUri(){
        GenericObject obj=ApplicationUtils.getObjectFromUri(null);
        assertNull(obj);

        String test="content://media/external/images/media/false_uri";
        obj=ApplicationUtils.getObjectFromUri(Uri.parse(test));
        assertNull(obj);

    }

}

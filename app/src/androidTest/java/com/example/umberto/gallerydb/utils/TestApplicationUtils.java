package com.example.umberto.gallerydb.utils;

import android.content.Intent;
import android.test.AndroidTestCase;

import com.example.umberto.gallerydb.R;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;
import com.example.umberto.gallerydb.mockObject.MockGenericObject;

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

    public void testGetLineOneText(){

        GenericObject mockGeneric= MockGenericObject.getGenericObject(MockGenericObject.TYPE_1);
        String test=ApplicationUtils.getLineOneText(mockGeneric);
        assertEquals(MockGenericObject.resultLineOne[MockGenericObject.TYPE_1],test);

        mockGeneric= MockGenericObject.getGenericObject(MockGenericObject.TYPE_2);
        test=ApplicationUtils.getLineOneText(mockGeneric);
        assertEquals(MockGenericObject.resultLineOne[MockGenericObject.TYPE_2],test);
    }

}

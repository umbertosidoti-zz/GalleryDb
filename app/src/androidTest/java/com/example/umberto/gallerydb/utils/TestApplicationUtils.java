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

    private static final String PREFIX_TITLE="Title: ";
    private static final String PREFIX_FILE="File name: ";
    private static final String PREFIX_ARTIST="Artist: ";

    private static final String[] resultLineOne={
            "Test1.mp3",
            "Test title1",
    };
    private static final String[] resultLineTwo={
            "unknown",
            "",
            "Test artist1",
    };

    public void testGetIntentFileChooser() {
        Intent intent = ApplicationUtils.getIntentFileChooser();
        assertNotNull(intent);
        assertEquals(Intent.ACTION_GET_CONTENT, intent.getAction());
        assertEquals(getContext().getString(R.string.mime_audio_video_image), intent.getType());
    }

    public void testGetLineOneText(){

        GenericObject mockGeneric= MockGenericObject.getGenericObject(MockGenericObject.TYPE_AUDIO_META_EMPTY);
        String test=ApplicationUtils.getLineOneText(mockGeneric);
        assertEquals(PREFIX_FILE+resultLineOne[MockGenericObject.TYPE_AUDIO_META_EMPTY],test);

        mockGeneric= MockGenericObject.getGenericObject(MockGenericObject.TYPE_AUDIO_META_TITLE);
        test=ApplicationUtils.getLineOneText(mockGeneric);
        assertEquals(PREFIX_TITLE+resultLineOne[MockGenericObject.TYPE_AUDIO_META_TITLE],test);
    }

    public void testGetLineTwoText(){

        GenericObject mockGeneric= MockGenericObject.getGenericObject(MockGenericObject.TYPE_AUDIO_META_EMPTY);
        String test=ApplicationUtils.getLineTwoText(mockGeneric);
        assertEquals(PREFIX_ARTIST+resultLineTwo[MockGenericObject.TYPE_AUDIO_META_EMPTY],test);

        mockGeneric= MockGenericObject.getGenericObject(MockGenericObject.TYPE_AUDIO_META_ARTIST);
        test=ApplicationUtils.getLineTwoText(mockGeneric);
        assertEquals(PREFIX_ARTIST+resultLineTwo[MockGenericObject.TYPE_AUDIO_META_ARTIST],test);
    }

}

package com.example.umberto.gallerydb.mockObject;

import com.example.umberto.gallerydb.business.GalleryObject;
import com.example.umberto.gallerydb.business.interfaces.GenericObject;

import org.json.JSONObject;

/**
 * Created by Umberto Sidoti on 08/07/2015.
 */
public class MockGenericObject {

    public static final int TYPE_AUDIO_META_EMPTY =0;
    public static final int TYPE_AUDIO_META_TITLE =1;
    public static final int TYPE_AUDIO_META_ARTIST =2;
    public static final int TYPE_AUDIO_META_BOTH =3;

    private static final String[] urlList={
            "content://com.estrongs.files/mnt/sdcard/Alarms/Test1.mp3",
            "content://com.estrongs.files/mnt/sdcard/Image/Test2.mp3",
            "content://com.estrongs.files/mnt/sdcard/Image/Test3.mp3",
            "content://com.estrongs.files/mnt/sdcard/Image/Test4.mp3"};

    private static final int[] jsonTypeList={
            MockJsonObject.TYPE_NO_METADATA,
            MockJsonObject.TYPE_ONLY_TITLE,
            MockJsonObject.TYPE_ONLY_ARTIST,
            MockJsonObject.TYPE_TITLE_ARTIST};

    private static final int[] objectTypeList={
            GenericObject.AUDIO_TYPE,
            GenericObject.AUDIO_TYPE,
            GenericObject.AUDIO_TYPE,
            GenericObject.AUDIO_TYPE};


    public static GenericObject getGenericObject(int type){
        return getGenericObject(urlList[type],
                MockJsonObject.getMockJsonObject(jsonTypeList[type]),
                objectTypeList[type]
                );
    }
    public static GenericObject getGenericObject(String url,JSONObject jsonObj,int type){

        GenericObject obj= new GalleryObject();
        obj.setType(type);
        obj.setMetadata(jsonObj);
        obj.setUriString(url);
        return obj;
    }

}

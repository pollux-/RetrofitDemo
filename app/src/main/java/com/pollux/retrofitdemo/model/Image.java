package com.pollux.retrofitdemo.model;

import java.util.List;

/**
 * Created by SreeKumar on 14/10/15
 */
public class Image {


    public Photos photos;

    public static class Photos {


        public List<Photo> photo;

        public static class Photo {

            public String id;
            public String secret;
            public String server;
            public String farm;

        }


    }

}

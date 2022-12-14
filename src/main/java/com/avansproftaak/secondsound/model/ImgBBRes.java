package com.avansproftaak.secondsound.model;

@lombok.Data
public class ImgBBRes {
    private Detail data;

    private boolean success;

    private String status;

    @lombok.Data
    public static class Detail {
        private String display_url;

        private String size;

        private String delete_url;

        private String expiration;

        private String id;

        private String time;

        private String title;

        private String url_viewer;

        private String url;

    }
}
package com.amira.navigationdrawer.ui.gallery.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CarModel {
    private String MessageText;
    private String status;
    @SerializedName( "GalleryMainImage" )
    private String GalleryMainImage;
    @SerializedName( "Galleries" )
    private ArrayList<GalleriesBean> Galleries;

    public String getMessageText() {
        return MessageText;
    }

    public void setMessageText(String MessageText) {
        this.MessageText = MessageText;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGalleryMainImage() {
        return GalleryMainImage;
    }

    public void setGalleryMainImage(String GalleryMainImage) {
        this.GalleryMainImage = GalleryMainImage;
    }


    public ArrayList<GalleriesBean> getGalleries() {
        return Galleries;
    }

    public void setGalleries(ArrayList<GalleriesBean> galleries) {
        Galleries = galleries;
    }

    public  class GalleriesBean {
        private String id;
        private String name;
        private ArrayList<GalleryImagesBean> GalleryImages;
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ArrayList<GalleryImagesBean> getGalleryImages() {
            return GalleryImages;
        }

        public void setGalleryImages(ArrayList<GalleryImagesBean> GalleryImages) {
            this.GalleryImages = GalleryImages;
        }

        public  class GalleryImagesBean implements Parcelable {
            private String id;
            private String image;

            protected GalleryImagesBean(Parcel in) {
                id = in.readString();
                image = in.readString();
            }

            public  final Creator<GalleryImagesBean> CREATOR = new Creator<GalleryImagesBean>() {
                @Override
                public GalleryImagesBean createFromParcel(Parcel in) {
                    return new GalleryImagesBean( in );
                }

                @Override
                public GalleryImagesBean[] newArray(int size) {
                    return new GalleryImagesBean[size];
                }
            };

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString( id );
                dest.writeString( image );
            }
        }
    }
}

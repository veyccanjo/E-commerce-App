package com.example.sample_exercise;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class ProductItem implements Parcelable {
    String title;
    String price;
    private int imageResId;

    private int iconResID;

    public ProductItem(String title, String price, int imageResId,int iconResID) {
        this.title = title;
        this.price = price;
        this.imageResId = imageResId;
        this.iconResID=iconResID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;

    }

    public int getIconResID() {
        return iconResID;
    }

    public void setIconResID(int iconResID) {
        this.iconResID = iconResID;
    }

    protected ProductItem(Parcel in) {
        title = in.readString();
        price = in.readString();
        imageResId = in.readInt();
        iconResID = in.readInt();
    }
    public static final Creator<ProductItem> CREATOR = new Creator<ProductItem>() {
        @Override
        public ProductItem createFromParcel(Parcel in) {
            return new ProductItem(in);
        }

        @Override
        public ProductItem[] newArray(int size) {
            return new ProductItem[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(price);
        dest.writeInt(imageResId);
        dest.writeInt(iconResID);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}

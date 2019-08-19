package io.tigranes.universe.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class NasaInformationEndPoint implements Parcelable {

    private String description;
    private String title;
    private String nasa_id;
    private String date_created;

    public NasaInformationEndPoint(String description, String title, String nasa_id, String date_created) {
        this.description = description;
        this.title = title;
        this.nasa_id = nasa_id;
        this.date_created = date_created;
    }

    public NasaInformationEndPoint() {
    }

    protected NasaInformationEndPoint(Parcel in) {
        description = in.readString();
        title = in.readString();
        nasa_id = in.readString();
        date_created = in.readString();
    }

    public static final Creator<NasaInformationEndPoint> CREATOR = new Creator<NasaInformationEndPoint>() {
        @Override
        public NasaInformationEndPoint createFromParcel(Parcel in) {
            return new NasaInformationEndPoint(in);
        }

        @Override
        public NasaInformationEndPoint[] newArray(int size) {
            return new NasaInformationEndPoint[size];
        }
    };

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNasa_id() {
        return nasa_id;
    }

    public void setNasa_id(String nasa_id) {
        this.nasa_id = nasa_id;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(description);
        parcel.writeString(title);
        parcel.writeString(nasa_id);
        parcel.writeString(date_created);
    }
}

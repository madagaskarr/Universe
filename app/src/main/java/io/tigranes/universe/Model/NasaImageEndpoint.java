package io.tigranes.universe.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class NasaImageEndpoint implements Parcelable {

    private String href;

    public NasaImageEndpoint(String href) {
        this.href = href;
    }

    public NasaImageEndpoint() {
    }

    protected NasaImageEndpoint(Parcel in) {
        href = in.readString();
    }

    public static final Creator<NasaImageEndpoint> CREATOR = new Creator<NasaImageEndpoint>() {
        @Override
        public NasaImageEndpoint createFromParcel(Parcel in) {
            return new NasaImageEndpoint(in);
        }

        @Override
        public NasaImageEndpoint[] newArray(int size) {
            return new NasaImageEndpoint[size];
        }
    };

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(href);
    }
}

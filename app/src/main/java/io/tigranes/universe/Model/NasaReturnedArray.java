package io.tigranes.universe.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class NasaReturnedArray implements Parcelable {

    List<NasaImageEndpoint> links;
    List<NasaInformationEndPoint> data;

    public NasaReturnedArray(List<NasaImageEndpoint> links, List<NasaInformationEndPoint> data) {
        this.links = links;
        this.data = data;
    }

    public NasaReturnedArray() {
    }

    protected NasaReturnedArray(Parcel in) {
        links = in.createTypedArrayList(NasaImageEndpoint.CREATOR);
        data = in.createTypedArrayList(NasaInformationEndPoint.CREATOR);
    }

    public static final Creator<NasaReturnedArray> CREATOR = new Creator<NasaReturnedArray>() {
        @Override
        public NasaReturnedArray createFromParcel(Parcel in) {
            return new NasaReturnedArray(in);
        }

        @Override
        public NasaReturnedArray[] newArray(int size) {
            return new NasaReturnedArray[size];
        }
    };

    public List<NasaImageEndpoint> getLinks() {
        return links;
    }

    public void setLinks(List<NasaImageEndpoint> links) {
        this.links = links;
    }

    public List<NasaInformationEndPoint> getData() {
        return data;
    }

    public void setData(List<NasaInformationEndPoint> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(links);
        parcel.writeTypedList(data);
    }
}

package io.tigranes.universe.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class NasaJsonReturnModel implements Parcelable {
    List<NasaReturnedArray> items;

    public NasaJsonReturnModel(List<NasaReturnedArray> items) {
        this.items = items;
    }

    protected NasaJsonReturnModel(Parcel in) {
        items = in.createTypedArrayList(NasaReturnedArray.CREATOR);
    }

    public static final Creator<NasaJsonReturnModel> CREATOR = new Creator<NasaJsonReturnModel>() {
        @Override
        public NasaJsonReturnModel createFromParcel(Parcel in) {
            return new NasaJsonReturnModel(in);
        }

        @Override
        public NasaJsonReturnModel[] newArray(int size) {
            return new NasaJsonReturnModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(items);
    }

    public NasaJsonReturnModel() {
    }

    public List<NasaReturnedArray> getItems() {
        return items;
    }

    public void setItems(List<NasaReturnedArray> items) {
        this.items = items;
    }
}

package mobiler.abbosbek.alquranjava.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import mobiler.abbosbek.alquranjava.model.Surah;

public class SurahResponse {

    @SerializedName("data")
    private List<Surah> list;

    public List<Surah> getList() {
        return list;
    }

    public void setList(List<Surah> list) {
        this.list = list;
    }
}

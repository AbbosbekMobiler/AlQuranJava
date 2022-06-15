package mobiler.abbosbek.alquranjava.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import mobiler.abbosbek.alquranjava.model.SurahDetail;

public class SurahDetailResponse {

    @SerializedName("result")
    private List<SurahDetail> list;

    public List<SurahDetail> getList() {
        return list;
    }

    public void setList(List<SurahDetail> list) {
        this.list = list;
    }
}

package mobiler.abbosbek.alquranjava.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import mobiler.abbosbek.alquranjava.repository.SurahDetailRepo;
import mobiler.abbosbek.alquranjava.response.SurahDetailResponse;

public class SurahDetailViewModel extends ViewModel {

    public SurahDetailRepo surahDetailRepo;

    public SurahDetailViewModel(){
        surahDetailRepo = new SurahDetailRepo();
    }

    public LiveData<SurahDetailResponse> getSurahDetail(String lan,int id){
        return surahDetailRepo.getSurahDetail(lan,id);
    }
}

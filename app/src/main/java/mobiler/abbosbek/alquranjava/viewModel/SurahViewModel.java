package mobiler.abbosbek.alquranjava.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import mobiler.abbosbek.alquranjava.model.Surah;
import mobiler.abbosbek.alquranjava.repository.SurahRepo;
import mobiler.abbosbek.alquranjava.response.SurahResponse;

public class SurahViewModel extends ViewModel {
    private SurahRepo surahRepo;

    public SurahViewModel(){
        surahRepo = new SurahRepo();

    }

    public LiveData<SurahResponse> getSurah(){
        return surahRepo.getSurah();
    }
}

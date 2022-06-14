package mobiler.abbosbek.alquranjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import mobiler.abbosbek.alquranjava.adapter.SurahAdapter;
import mobiler.abbosbek.alquranjava.model.Surah;
import mobiler.abbosbek.alquranjava.viewModel.SurahViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SurahAdapter surahAdapter;
    private List<Surah> list;
    private SurahViewModel surahViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.surahRV);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        surahViewModel = new ViewModelProvider(this).get(SurahViewModel.class);
        surahViewModel.getSurah().observe(this,surahResponse -> {
            for (int i=0; i<surahResponse.getList().size();i++){
                list.add(new Surah(surahResponse.getList().get(i).getNumber(),
                        String.valueOf(surahResponse.getList().get(i).getName()),
                        String.valueOf(surahResponse.getList().get(i).getEnglishName()),
                        String.valueOf(surahResponse.getList().get(i).getEnglishNameTranslation()),
                        surahResponse.getList().get(i).getNumberOfArrays(),
                        String.valueOf(surahResponse.getList().get(i).getEnglishName())
                ));
            }

            if (list.size() != 0){
                surahAdapter = new SurahAdapter(this,list);
                recyclerView.setAdapter(surahAdapter);
                surahAdapter.notifyDataSetChanged();
            }

        });
    }
}
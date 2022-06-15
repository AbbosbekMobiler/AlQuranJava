package mobiler.abbosbek.alquranjava.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mobiler.abbosbek.alquranjava.R;
import mobiler.abbosbek.alquranjava.adapter.SurahDetailAdapter;
import mobiler.abbosbek.alquranjava.common.Common;
import mobiler.abbosbek.alquranjava.model.SurahDetail;
import mobiler.abbosbek.alquranjava.viewModel.SurahDetailViewModel;

public class SurahDetailActivity extends AppCompatActivity {

    private TextView surahName,surahType,surahTranslation;
    private int no;
    private RecyclerView recyclerView;
    private List<SurahDetail> list;
    private SurahDetailAdapter adapter;
    private SurahDetailViewModel surahDetailViewModel;
    private String urdu = "urdu_junagarhi";
    private String hindi = "hindi_omari";
    private String english = "english_hilali_khan";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_detail);

        surahName = findViewById(R.id.surah_name);
        surahType = findViewById(R.id.type);
        surahTranslation = findViewById(R.id.translation);
        recyclerView = findViewById(R.id.surah_detail_rv);


        no = getIntent().getIntExtra(Common.SURAH_NO,0);
        surahName.setText(getIntent().getStringExtra(Common.SURAH_NAME));
        surahTranslation.setText(getIntent().getStringExtra(Common.SURAH_TRANSLATION));
        surahType.setText(getIntent().getStringExtra(Common.SURAH_TYPE)+" "+getIntent().getStringExtra(Common.SURAH_TOTAL_AYA)+" AYA");


        recyclerView.setHasFixedSize(true);
        list = new ArrayList<>();

        surahTranslation(urdu,no);

    }

    private void surahTranslation(String lan, int no) {

        if (list.size()>0){
            list.clear();
        }

        surahDetailViewModel = new ViewModelProvider(this).get(SurahDetailViewModel.class);
        surahDetailViewModel.getSurahDetail(lan,no).observe(this, surahDetailResponse -> {

            for (int i=0;i<surahDetailResponse.getList().size();i++){
                list.add(new SurahDetail(surahDetailResponse.getList().get(i).getId(),
                        surahDetailResponse.getList().get(i).getSura(),
                        surahDetailResponse.getList().get(i).getAya(),
                        surahDetailResponse.getList().get(i).getArabic_text(),
                        surahDetailResponse.getList().get(i).getTranslation(),
                        surahDetailResponse.getList().get(i).getFootnotes()
                        ));
            }

            if (list.size() != 0){
                adapter = new SurahDetailAdapter(this,list);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
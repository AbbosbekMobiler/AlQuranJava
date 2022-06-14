package mobiler.abbosbek.alquranjava.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mobiler.abbosbek.alquranjava.R;
import mobiler.abbosbek.alquranjava.model.Surah;

public class SurahAdapter extends RecyclerView.Adapter<SurahAdapter.ViewHolder> {

    private Context context;
    private List<Surah> list;

    public SurahAdapter(Context context, List<Surah> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.surah_layout,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.surahNo.setText(String.valueOf(list.get(position).getNumber()));
        holder.englishName.setText(list.get(position).getEnglishName());
        holder.arabicName.setText(list.get(position).getName());
        holder.totalAya.setText("Aya : "+String.valueOf(list.get(position).getNumberOfArrays()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView surahNo,arabicName,englishName,totalAya;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            surahNo = itemView.findViewById(R.id.surahNumber);
            arabicName = itemView.findViewById(R.id.arabic_name);
            englishName = itemView.findViewById(R.id.english_name);
            totalAya = itemView.findViewById(R.id.total_aya);
        }
    }
}

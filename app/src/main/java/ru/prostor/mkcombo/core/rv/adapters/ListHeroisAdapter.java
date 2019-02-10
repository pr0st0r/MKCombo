package ru.prostor.mkcombo.core.rv.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import ru.prostor.mkcombo.core.Hero;
import ru.prostor.mkcombo.core.rv.holders.ListHeroisHolder;

public class ListHeroisAdapter extends RecyclerView.Adapter<ListHeroisHolder> {

    private List<Hero> mHeroList;
    private Context mContext;

    public ListHeroisAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public ListHeroisHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        return new ListHeroisHolder(layoutInflater, viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHeroisHolder listHeroisHolder, int i) {
        listHeroisHolder.bind(mHeroList.get(i));
    }

    @Override
    public int getItemCount() {
        return mHeroList.size();
    }

    public void setHeroList(List<Hero> heroList) {
        mHeroList = heroList;
    }
}

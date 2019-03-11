package ru.prostor.mkcombo.core.pager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.ArrayRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import ru.prostor.mkcombo.R;
import ru.prostor.mkcombo.core.custom.ComboTextView;

public class ComboAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private String[] mCombo;

    public ComboAdapter(@NonNull Context context,@LayoutRes int resource) {
        super(context, resource);
        mContext = context;
    }

    @SuppressLint("SetTextI18n")
    @Override
    @NonNull
    public View getView(int position, View convertView,@NonNull ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = View.inflate(mContext, R.layout.item_combo, null);

        TextView title_combo = view.findViewById(R.id.title_combo);
        ComboTextView combo = view.findViewById(R.id.combo);

        String[] structure = mCombo[position].split(":");

        title_combo.setText(structure[0] + " - урон:" + structure[1]);

        combo.setComboText(structure[2]);

        return view;
    }

    @Override
    public int getCount() {
        return mCombo.length;
    }

    public void setCombo(@ArrayRes int combo) {
        mCombo = mContext.getResources().getStringArray(combo);
    }

}

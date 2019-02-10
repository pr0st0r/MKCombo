package ru.prostor.mkcombo.core.pager;


import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import ru.prostor.mkcombo.R;

public class ComboAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private String[] mCombo;

    public ComboAdapter(Context context, int resource) {
        super(context, resource);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(mContext, R.layout.item_combo, null);

        TextView title_combo = view.findViewById(R.id.title_combo);
        TextView combo = view.findViewById(R.id.combo);

        String[] structure = mCombo[position].split(":");

        title_combo.setText(structure[0] + " - урон:" + structure[1]);

        SpannableStringBuilder str = convertCombo(structure[2]);
        combo.setText(str);

        return view;
    }

    @Override
    public int getCount() {
        return mCombo.length;
    }

    public void setCombo(int combo) {
        mCombo = mContext.getResources().getStringArray(combo);
    }


    /**
     * Преобразовать комбинацию
     * @param str - комбинация
     * @return
     */
    SpannableStringBuilder convertCombo(String str){
        SpannableStringBuilder strCombo = new SpannableStringBuilder("");

        String[] elements = str.split(" ");

        for(int i = 0; i < elements.length; i++){
            String elem = elements[i];
            try {
                int num = Integer.parseInt(elem);
                strCombo.append(" ");
                switch (num){
                    case 1:
                        strCombo.setSpan(new ImageSpan(getContext(), R.drawable.ps_square), strCombo.length() - 1, strCombo.length(), Spannable.SPAN_COMPOSING);
                        break;
                    case 2:
                        strCombo.setSpan(new ImageSpan(getContext(), R.drawable.ps_triangle), strCombo.length() - 1, strCombo.length(), Spannable.SPAN_COMPOSING);
                        break;
                    case 3:
                        strCombo.setSpan(new ImageSpan(getContext(), R.drawable.ps_x), strCombo.length() - 1, strCombo.length(), Spannable.SPAN_COMPOSING);
                        break;
                    case 4:
                        strCombo.setSpan(new ImageSpan(getContext(), R.drawable.ps_circle), strCombo.length() - 1, strCombo.length(), Spannable.SPAN_COMPOSING);
                        break;
                }
            }catch (NumberFormatException e){
                strCombo.append(elem);
                if(elem.equals("+")) continue;
            }

            if(i != elements.length - 1 && !elements[i + 1].equals("+")) strCombo.append(", ");
        }

        return strCombo;
    }

}

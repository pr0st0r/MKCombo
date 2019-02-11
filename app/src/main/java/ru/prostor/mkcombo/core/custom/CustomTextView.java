package ru.prostor.mkcombo.core.custom;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;

import ru.prostor.mkcombo.R;


public class CustomTextView extends android.support.v7.widget.AppCompatTextView {

    public CustomTextView(Context context) {
        super(context);
    }

    public void setComboText(String text){
        super.setText(convertCombo(text));
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

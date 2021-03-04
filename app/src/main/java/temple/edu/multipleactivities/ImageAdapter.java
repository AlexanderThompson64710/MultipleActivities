package temple.edu.multipleactivities;

import android.content.Context;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> items;
    int[] imageRes;
    String instruction = "Select item from list";

    public ImageAdapter (Context context, ArrayList items, int[] imageRes) {
        this.context = context;
        this.items = items;
        this.imageRes = imageRes;
    }

    private boolean isTitle(int position)
    {
        return position == 0;
    }

    @Override
    public int getCount() {
        return items.size()+1;
    }

    @Override
    public Object getItem(int position) {
        if (isTitle(position))
            return null;
        else
            return items.get(position + 1);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView dogTextView;

        // Create centered TextView
        if ((dogTextView = (TextView) convertView) == null) {
            dogTextView = new TextView(context);
            dogTextView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            dogTextView.setGravity(Gravity.CENTER_HORIZONTAL);
            dogTextView.setTextSize(22);
        }

        // Show instruction instead of item if at first position
        if (isTitle(position))
            dogTextView.setText(instruction);
        else
            dogTextView.setText(items.get(position - 1));

        return dogTextView;
    }
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        if (isTitle(position)) return getView(position, null, parent);

        TextView textView;
        ImageView imageView;

        LinearLayout linearLayout;

        if (convertView instanceof TextView || convertView == null) {
            linearLayout = new LinearLayout(context);
            textView = new TextView(context);
            imageView = new ImageView(context);
            textView.setPadding(10,15,15,15);
            textView.setTextSize(22);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.addView(imageView);
            imageView.getLayoutParams().height = 150;
            imageView.getLayoutParams().width = 150;
            linearLayout.addView(textView);
        } else {
            linearLayout = (LinearLayout) convertView;
            imageView = (ImageView) linearLayout.getChildAt(0);
            textView = (TextView) linearLayout.getChildAt(1);
        }

        imageView.setImageResource(imageRes[position - 1]);
        textView.setText(items.get(position - 1));

        return linearLayout;
    }

}

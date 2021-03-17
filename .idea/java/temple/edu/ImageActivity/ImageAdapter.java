package temple.edu.ImageActivity;

import android.content.Context;
import android.graphics.Color;
import android.util.Pair;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> items;
    int[] imageRes;
    String instruction = "Select item from list";

    public ImageAdapter(Context context, ArrayList items, int[] imageRes) {
        this.context = context;
        this.items = items;
        this.imageRes = imageRes;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView textView;
        ImageView imageView;

        FrameLayout frameLayout;

        if (convertView == null) {
            frameLayout = new FrameLayout(context);
            textView = new TextView(context);
            imageView = new ImageView(context);
            textView.setPadding(10,15,15,15);
            textView.setTextSize(14);
            frameLayout.addView(imageView);
            imageView.getLayoutParams().height = 340;
            imageView.getLayoutParams().width = 340;
            frameLayout.addView(textView);
            textView.setGravity(Gravity.CENTER);
            textView.setHeight(340);
            textView.setTextColor(Color.WHITE);
            //textView.setLayoutParams(new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        } else {
            frameLayout = (FrameLayout) convertView;
            imageView = (ImageView) frameLayout.getChildAt(0);
            textView = (TextView) frameLayout.getChildAt(1);
        }

        imageView.setImageResource(imageRes[position]);
        textView.setText(items.get(position));

        return frameLayout;
    }



    //public Integer[] dogArr = {R.drawable.labrador, R.drawable.pug, R.drawable.husky, R.drawable.dane, R.drawable.bernese};
}


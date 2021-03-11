package temple.edu.ImageActivity;

import android.content.Context;
import android.util.Pair;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    Context context;
    String[] items;
    int[] imageRes;
    String instruction = "Select item from list";

    public ImageAdapter(Context context, String[] items, int[] imageRes) {
        this.context = context;
        this.items = items;
        this.imageRes = imageRes;
    }

    public ImageAdapter(DisplayActivity displayActivity) {
    }

    @Override
    public int getCount() {
        return imageRes.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;
        TextView textView;

        if (convertView == null) {
            textView = new TextView(context);
            textView.setText(items[position]);
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(250, 250));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(imageRes[position]);
        return imageView;
    }



    public Integer[] dogArr = {R.drawable.labrador, R.drawable.pug, R.drawable.husky, R.drawable.dane, R.drawable.bernese};
}


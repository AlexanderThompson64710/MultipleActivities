package temple.edu.ImageActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayActivity extends Activity {

    String[] dogList = {""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        int position = intent.getExtras().getInt("id");
        dogList = intent.getExtras().getStringArray("name");
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        //textView2.setText(dogList[position]);
        imageView.setImageResource(intent.getIntExtra("id", 0));


    }
}
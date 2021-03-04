package temple.edu.multipleactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class DisplayActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    int[] imageArray;
    int position = 0;
    ArrayList dogArr;
    int start = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        imageView = findViewById(R.id.imageView);

        Bundle bundle = getIntent().getExtras();
        imageArray = bundle.getIntArray("imageArr");
        position = bundle.getInt("position");
        dogArr = bundle.getIntegerArrayList("dogArr");

        if (bundle != null)
        {
            int[] resId = bundle.getIntArray("imageArr");
            int pos = bundle.getInt("position");
            ArrayList dog = bundle.getIntegerArrayList("dogArr");
            imageView.setImageResource(resId[pos-1]);
            //textView = (TextView) dog.get(pos+1);
        }

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
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

    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        Bundle bundle = getIntent().getExtras();
        imageArray = bundle.getIntArray("imageArr");
        position = bundle.getInt("position");

        if (bundle != null)
        {
            imageArray = bundle.getIntArray("imageArr");
            position = bundle.getInt("position");
            imageView.setImageResource(imageArray[position-1]);
        }
        if(position == 1)
            textView.setText("Labrador Retriever" + "\n" + "This dog loves swimming.");
        else if(position == 2)
            textView.setText("Pug" + "\n" + "This dog loves sleeping.");
        else if(position == 3)
            textView.setText("Husky" + "\n" + "This dog loves the cold.");
        else if(position == 4)
            textView.setText("Great Dane" + "\n" + "This dog loves leaning.");
        else if(position == 5)
            textView.setText("Bernese Mountain Dog" + "\n" + "This dog loves snow.");

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

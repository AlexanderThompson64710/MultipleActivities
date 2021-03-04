package temple.edu.multipleactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    ImageView imageView;
    Spinner spinner;
    TextView textView;
    Bundle bundle = new Bundle();

    int[] dogImagesArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        ArrayList dogArray = new ArrayList<String>();
        //dogArray.add(0, "Click here" + "\n" + "Name, description, and picture of dog shown.");
        dogArray.add("Labrador Retriever" + "\n" + "This dog loves swimming.");
        dogArray.add("Pug" + "\n" + "This dog loves sleeping.");
        dogArray.add("Husky" + "\n" + "This dog loves the cold.");
        dogArray.add("Great Dane" + "\n" + "This dog loves leaning.");
        dogArray.add("Bernese Mountain Dog" + "\n" + "This dog loves snow.");

        dogImagesArray = new int[]{R.drawable.labrador, R.drawable.pug, R.drawable.husky, R.drawable.dane, R.drawable.bernese};

        ImageAdapter adapter = new ImageAdapter(this, dogArray, dogImagesArray);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intent launchIntent = new Intent(SelectionActivity.this, DisplayActivity.class);

                if(position > 0) {
                    launchIntent.putExtra("imageArr", dogImagesArray);
                    launchIntent.putExtra("position", position);
                    launchIntent.putExtra("dogArr", dogArray);
                    startActivity(launchIntent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
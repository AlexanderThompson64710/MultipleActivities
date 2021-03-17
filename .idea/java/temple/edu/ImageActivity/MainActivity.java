package temple.edu.ImageActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_DESCRIPTION = "description";
    public static final String EXTRA_IMAGE = "image";

    GridView gridView;
    int[] dogImagesArray;
    ArrayList<String> dogArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Item Selection");

        gridView = findViewById(R.id.gridView);
        gridView.setNumColumns(3);

        dogArray = new ArrayList<String>();
        dogArray.add("Labrador Retriever");
        dogArray.add("Carline");
        dogArray.add("Rauque");
        dogArray.add("Grand Danois\n");
        dogArray.add("Chien De Montagne Bernois\n");

        dogImagesArray = new int[]{R.drawable.labrador, R.drawable.pug, R.drawable.husky, R.drawable.dane, R.drawable.bernese};

        ImageAdapter adapter = new ImageAdapter(this, dogArray, dogImagesArray);
        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showPicture(position);
            }
        });

    }
    private void showPicture (int position) {
        Intent launchIntent = new Intent(this, DisplayActivity.class);
        launchIntent.putExtra(EXTRA_DESCRIPTION, dogArray.get(position));
        launchIntent.putExtra(EXTRA_IMAGE, dogImagesArray[position]);

        // Ensure that we are notified in onActivityResult() when DisplayActivity closes
        startActivity(launchIntent);
    }
}

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

    ImageView imageView;
    int position = 0;
    TextView textView;
    String[] dogName = new String[] {"Labrador Retriever", "Pug", "Husky", "Great Dane", "Bernese Mountain Dog"};
    int[] dogImagesArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.textView);

        ArrayList dogArray = new ArrayList<String>(position);
        //dogArray.add(0, "Click here" + "\n" + "Name, description, and picture of dog shown.");
        dogArray.add("Labrador Retriever" + "\n" + "This dog loves swimming.");
        dogArray.add("Pug" + "\n" + "This dog loves sleeping.");
        dogArray.add("Husky" + "\n" + "This dog loves the cold.");
        dogArray.add("Great Dane" + "\n" + "This dog loves leaning.");
        dogArray.add("Bernese Mountain Dog" + "\n" + "This dog loves snow.");

        dogImagesArray = new int[]{R.drawable.labrador, R.drawable.pug, R.drawable.husky, R.drawable.dane, R.drawable.bernese};

        ImageAdapter adapter = new ImageAdapter(this, dogName, dogImagesArray);
        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, "You Clicked at " +dogName[+ position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("id", dogImagesArray[position]);
                intent.putExtra("name", dogName[position]);

                startActivity(intent);
            }
        });

    }
}

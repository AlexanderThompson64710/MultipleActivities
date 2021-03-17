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

    TextView descriptionTextView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        descriptionTextView = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);

        Intent launchIntent = getIntent();

        descriptionTextView.setText(launchIntent.getStringExtra(MainActivity.EXTRA_DESCRIPTION));
        imageView.setImageResource(launchIntent.getIntExtra(MainActivity.EXTRA_IMAGE, R.drawable.ic_launcher_foreground));


    }
}
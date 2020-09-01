package edu.cnm.deepdive.recyclerview;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "MainActivity";

  //vars
  private ArrayList<String> mNames = new ArrayList<>();
  private ArrayList<String> mImagesUrls = new ArrayList<>();
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Log.d(TAG, "onCreate: started.");

    initImageBitmaps();
  }

  private void initImageBitmaps() {
    Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

    mImagesUrls.add("https://upload.wikimedia.org/wikipedia/commons/e/ea/2015-06-19_Glacier_National_Park_%28U.S.%29_8633.jpg");
    mNames.add("Glacier NP");

    mImagesUrls.add("https://upload.wikimedia.org/wikipedia/commons/0/00/Double-O-Arch_Arches_National_Park_2.jpg");
    mNames.add("Arches NP");

    mImagesUrls.add("https://upload.wikimedia.org/wikipedia/commons/9/90/JOSHUA_TREE_NATIONAL_PARK_%2815112433079%29.jpg");
    mNames.add("Joshua Tree NP");

    mImagesUrls.add("https://upload.wikimedia.org/wikipedia/commons/1/19/Pulpit_Terraces%2C_Yellowstone_National_Park%2C_Wyoming%2C_1898.jpg");
    mNames.add("Yellow Stone NP");

    mImagesUrls.add("https://upload.wikimedia.org/wikipedia/commons/6/68/Everglades_National_Park_cypress.jpg");
    mNames.add("Everglades NP");

    mImagesUrls.add("https://upload.wikimedia.org/wikipedia/commons/0/02/White_sands_moon_%26_clouds.jpg");
    mNames.add("White Sands NP");

    mImagesUrls.add("https://upload.wikimedia.org/wikipedia/commons/a/af/Grand_Canyon_view_from_Pima_Point_2010.jpg");
    mNames.add("Grand Canyon NP");

    mImagesUrls.add("https://upload.wikimedia.org/wikipedia/commons/1/10/Zion_angels_landing_view.jpg");
    mNames.add("Zion NP");

    initRecyclerView();

  }

  private void initRecyclerView() {
    RecyclerView recyclerView = findViewById(R.id.recycler_view);
    RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImagesUrls);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
  }


}
package enzo.brembilla.projet_mobile;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PaysActivity extends Activity{

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pays);
        getIncomingIntent();
    }

    private void getIncomingIntent(){
        String paysName = getIntent().getStringExtra("paysName");
        String paysAlphaCode = getIntent().getStringExtra("paysAlphaCode");
        String paysCapital = getIntent().getStringExtra("paysCapital");
        String paysRegion = getIntent().getStringExtra("paysRegion");
        String paysSubregion = getIntent().getStringExtra("paysSubregion");
        int paysPopulation = getIntent().getIntExtra("paysPopulation", 0);
        String paysFlag = getIntent().getStringExtra("paysFlag");
        setCard(paysName, paysAlphaCode, paysCapital, paysRegion, paysSubregion, paysPopulation, paysFlag);
    }

    private void setCard(String paysName, String paysAlphacode, String paysCapital, String paysRegion, String paysSubregion, int paysPopulation, String paysFlag){
        TextView name = findViewById(R.id.PaysName);
        name.setText("Name : " + paysName);
        TextView alphaCode = findViewById(R.id.PaysAlphaCode);
        alphaCode.setText("Alpha code : " + paysAlphacode);
        TextView capital = findViewById(R.id.PaysCapital);
        capital.setText("Capital : " + paysCapital );
        TextView region = findViewById(R.id.PaysRegion);
        region.setText("Continent : " + paysRegion);
        TextView subregion = findViewById(R.id.PaysSubregion);
        subregion.setText("Sous-continent : " + paysSubregion);
        TextView population = findViewById(R.id.PaysPopulation);
        population.setText("Population : " + paysPopulation + " habitants");
        ImageView flag = findViewById(R.id.PaysFlag);
        Glide.with(this).load(paysFlag).into(flag);
    }
}


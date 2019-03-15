package com.example.android.inclassassignment07_johnb;


import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView dinoInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void addDino(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivityForResult(intent, Keys.GET_DINO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        dinoInfo = findViewById(R.id.dino_info_text_view);
        if (requestCode == Keys.GET_DINO && resultCode == RESULT_OK) {
            Dino creature = (Dino) data.getSerializableExtra(Keys.KEY_DINO);
            String dinoText = dinoInfo.getText().toString();
            if (dinoText.equals("")) {
                dinoInfo.setText(creature.toString());
            } else {
                dinoInfo.setText(dinoInfo.getText() + "\n\n" + creature.toString());

            }
        }
    }
}
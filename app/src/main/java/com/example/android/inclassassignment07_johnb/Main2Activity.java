package com.example.android.inclassassignment07_johnb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Main2Activity extends AppCompatActivity {

    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox checkBoxWings = findViewById(R.id.wings_checkbox);
                EditText nameField = findViewById(R.id.edit_text_first);
                EditText legs = findViewById(R.id.edit_text_second);
                String name = nameField.getText().toString();
                int numberOfLegs = Integer.parseInt(legs.getText().toString());
                RadioGroup dietOptions = findViewById(R.id.diet_button_group);
                int diet = dietOptions.getCheckedRadioButtonId();
                String dietInfo = setDietType(diet);
                boolean hasWings = checkBoxWings.isChecked();

                Dino creature = new Dino(name);
                creature.setHasWings(hasWings);
                creature.setNumberOfLegs(numberOfLegs);
                creature.setDiet(dietInfo);

                Intent data = new Intent();
                data.putExtra(Keys.KEY_DINO, creature);
                setResult(RESULT_OK, data);
                finish();


            }
        });
    }

    private String setDietType(int dietSelection) {
        String dietInfo;
        if (dietSelection == R.id.meat_button) {
            dietInfo = "Carnivore";
        } else if (dietSelection == R.id.plants_button) {
            dietInfo = "Herbivore";
        } else if (dietSelection == R.id.both_button) {
            dietInfo = "Omnivore";
        } else {
            dietInfo = "No dietary information given";
        }
        return dietInfo;
    }


}

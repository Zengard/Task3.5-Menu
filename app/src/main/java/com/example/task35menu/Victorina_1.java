package com.example.task35menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Victorina_1 extends AppCompatActivity {
    private Button button;
    private RadioGroup radioGroup ;
    public RadioButton radioButton;
    public int numbers = 0;
    public EditText etFName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victorina_1);

        final TextView textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        radioGroup = (RadioGroup)  findViewById(R.id.radioGroup);
        etFName = (EditText) findViewById(R.id.etFName);

        View.OnClickListener oclBtnOk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                if (radioButton == findViewById(R.id.radioButton2))
                {
                    numbers = numbers + 1;
                }
                textView.setText("Your choice: " + radioButton.getText());

                Intent intent = new Intent(Victorina_1.this, Victorina_2.class);
                intent.putExtra("numbers_2", numbers);
                intent.putExtra("name_1", etFName.getText().toString());
                startActivity(intent);

            }
        };

        button.setOnClickListener(oclBtnOk);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();

        switch (id) {
            case R.id.gallery:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Victorina_1.this, Gallery.class);
                startActivity(intent);
                break;
            case R.id.menu:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Victorina_1.this, MainActivity.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}

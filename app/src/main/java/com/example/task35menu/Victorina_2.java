package com.example.task35menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Victorina_2 extends AppCompatActivity {

    Button button2;
    RadioGroup radioGroup2 ;
    RadioButton radioButton2;

    public int numbers_2;
    public String name_1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victorina_2);
        Intent mIntent = getIntent();
        numbers_2 = mIntent.getIntExtra("numbers_2", 0);
        name_1 = mIntent.getStringExtra("name_1");
        final TextView textView = (TextView) findViewById(R.id.textView2);
        button2 = (Button) findViewById(R.id.button2);
        radioGroup2 = (RadioGroup)  findViewById(R.id.radioGroup2);

        View.OnClickListener oclBtnOk2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup2.getCheckedRadioButtonId();
                radioButton2 = findViewById(radioId);
                if (radioButton2 == findViewById(R.id.radioButton5))
                {
                    numbers_2 = numbers_2 + 1;
                }
                textView.setText("Your choice: " + numbers_2);
                Intent intent = new Intent(Victorina_2.this, Victorina_3.class);
                intent.putExtra("numbers_3", numbers_2);
                intent.putExtra("name_2", name_1);
                startActivity(intent);
            }
        };

        button2.setOnClickListener(oclBtnOk2);

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
                Intent intent = new Intent(Victorina_2.this, Gallery.class);
                startActivity(intent);
                break;
            case R.id.menu:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Victorina_2.this, MainActivity.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}

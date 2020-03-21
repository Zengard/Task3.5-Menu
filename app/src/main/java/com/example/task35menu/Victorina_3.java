package com.example.task35menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Victorina_3 extends AppCompatActivity {

    public int numbers_3;
    public TextView recordName_1;
    public TextView recordName_2;
    public TextView recordName_3;
    SharedPreferences sPref;
    final String SAVED_TEXT_1 = "saved_text_1";
    final String SAVED_TEXT_2 = "saved_text_2";
    final String SAVED_TEXT_3 = "saved_text_3";
    String name_2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victorina_3);

        Intent mIntent2 = getIntent();
        numbers_3 = mIntent2.getIntExtra("numbers_3", 0);
        name_2 = mIntent2.getStringExtra("name_2");
        final TextView textView = (TextView) findViewById(R.id.textView3);

        recordName_1 = (TextView) findViewById(R.id.recordName_1);
        recordName_2 = (TextView) findViewById(R.id.recordName_2);
        recordName_3 = (TextView) findViewById(R.id.recordName_3);

        button3 = (Button) findViewById(R.id.button3);

        loadText_1();
        loadText_2();
        loadText_3();

        View.OnClickListener oclBtnOk3 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText( numbers_3 + "/2" );

                if(numbers_3 == 2)
                {
                    recordName_1.setText(name_2 + " - " + numbers_3);
                    sPref = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor ed = sPref.edit();
                    ed.putString(SAVED_TEXT_1, recordName_1.getText().toString());
                    ed.commit();
                }
                else
                if(numbers_3 == 1)
                {
                    recordName_2.setText(name_2 + " - " + numbers_3);
                    sPref = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor ed = sPref.edit();
                    ed.putString(SAVED_TEXT_2, recordName_2.getText().toString());
                    ed.commit();
                }
                else
                if(numbers_3 == 0)
                {
                    recordName_3.setText(name_2 + " - " + numbers_3);
                    sPref = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor ed = sPref.edit();
                    ed.putString(SAVED_TEXT_3, recordName_3.getText().toString());
                    ed.commit();
                }


            }
        };

        button3.setOnClickListener(oclBtnOk3);

    }

 public void loadText_3()
 {
     sPref = getPreferences(MODE_PRIVATE);
     String savedText = sPref.getString(SAVED_TEXT_3, "");
     recordName_3.setText(savedText);
 }
    public void loadText_1()
    {
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT_1, "");
        recordName_1.setText(savedText);
    }
    public void loadText_2()
    {
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT_2, "");
        recordName_2.setText(savedText);
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
                Intent intent = new Intent(Victorina_3.this, Gallery.class);
                startActivity(intent);
                break;
            case R.id.menu:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Victorina_3.this, MainActivity.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}

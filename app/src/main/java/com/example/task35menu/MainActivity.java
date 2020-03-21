package com.example.task35menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();

        switch (id) {
            case R.id.new_game:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Victorina_1.class);
                startActivity(intent);
                break;
            case R.id.gallery:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(MainActivity.this, Gallery.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

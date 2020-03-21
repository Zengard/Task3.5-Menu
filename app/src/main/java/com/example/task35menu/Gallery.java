package com.example.task35menu;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Gallery extends AppCompatActivity {
    int imageIDX = 0;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        ImageButton btnLeft = findViewById(R.id.imageButton_left);
        ImageButton btnRight = findViewById(R.id.imageButton_right);

        btnLeft.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageIDX--;
                if (imageIDX < 0)
                    imageIDX = 2;
                changeImage();
            }
        });

        btnRight.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageIDX++;
                if (imageIDX > 2)
                    imageIDX = 0;
                changeImage();
            }
        });

        Drawable drawable;
        LinearLayout layout;

        drawable = getResources().getDrawable(R.drawable.canyon,null);
        drawable.setAlpha(60);

        layout= findViewById(R.id.mainLayout);
        layout.setBackground(drawable);
    }

    public int GetImageID()
    {
        int imgID;
        switch (imageIDX) {
            case 0: imgID = R.drawable.tiger; break;
            case 1: imgID = R.drawable.tiger_2; break;
            case 2: imgID = R.drawable.tiger_3; break;
            default: imgID = R.drawable.tiger; break;
        }
        return imgID;

    }
    private void changeImage()
    {
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(GetImageID());
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
                Intent intent = new Intent(Gallery.this, Victorina_1.class);
                startActivity(intent);
                break;
            case R.id.menu:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Gallery.this, MainActivity.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}

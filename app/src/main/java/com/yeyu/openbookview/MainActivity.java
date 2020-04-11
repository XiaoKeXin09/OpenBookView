package com.yeyu.openbookview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.yeyu.openbookview.view.OpenBookView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private OpenBookView openBookview;
    private ImageView bookshlefBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookshlefBook = findViewById(R.id.iv_bookshlef_book);
        openBookview = findViewById(R.id.openbookview);
        bookshlefBook.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        openBookview.setVisibility(View.VISIBLE);
        Bitmap bitmap = ((BitmapDrawable) bookshlefBook.getBackground()).getBitmap();
        openBookview.openAnimation(bitmap, bookshlefBook.getLeft(), bookshlefBook.getTop(), bookshlefBook.getWidth(), bookshlefBook.getHeight(), new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                Intent intent = new Intent(MainActivity.this, BrowserBookActivity.class);
                startActivityForResult(intent, RESULT_FIRST_USER);
                overridePendingTransition(0, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = ((BitmapDrawable) bookshlefBook.getBackground()).getBitmap();
        openBookview.closeAnimation(bitmap, bookshlefBook.getWidth(), bookshlefBook.getHeight(), new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                openBookview.setVisibility(View.INVISIBLE);
            }
        });

    }
}

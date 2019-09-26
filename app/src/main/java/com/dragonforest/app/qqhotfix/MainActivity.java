package com.dragonforest.app.qqhotfix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dragonforest.app.qqhotfix.util.BugTest;
import com.dragonforest.app.qqhotfix.util.FixUtil;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_test:
                Toast.makeText(this, BugTest.getMessage(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

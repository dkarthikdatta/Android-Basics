package com.example.myapplication.arch.noArch;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class NoArchActivity extends AppCompatActivity {

    TextView countView;
    Button increase;
    Button decrease;
    int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_arch);
        countView = findViewById(R.id.counter);
        increase = findViewById(R.id.increase);
        decrease = findViewById(R.id.decrease);

        increase.setOnClickListener(v -> countView.setText(String.valueOf(++count)));

        decrease.setOnClickListener(v -> countView.setText(String.valueOf(--count)));
    }


}

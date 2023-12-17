package com.example.percobaan4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edWidht, edHeight, edLenght;
    private Button btnCalculate;
    private TextView tvResult;
    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edWidht = findViewById(R.id.edt_widht);
        edHeight = findViewById(R.id.edt_height);
        edLenght = findViewById(R.id.edt_lenght);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);
        btnCalculate.setOnClickListener(this);
        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calculate) {
            String inputLenght = edLenght.getText().toString().trim();
            String inputWidht = edWidht.getText().toString().trim();
            String inputHeight = edHeight.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(inputLenght)) {
                isEmptyFields = true;
                edLenght.setError("Field ini tidak boleh kosng");
            }
            if (TextUtils.isEmpty(inputWidht)) {
                isEmptyFields = true;
                edWidht.setError("Field ini tidak boleh kosng");
            }
            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                edHeight.setError("Field ini tidak boleh kosng");
            }
            if (!isEmptyFields) {
                double volume = Double.parseDouble(inputLenght) * Double.parseDouble(inputWidht) * Double.parseDouble(inputHeight);
                tvResult.setText(String.valueOf(volume));
            }
        }
    }
}
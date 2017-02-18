package com.netflix.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    private int todoPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        EditText etEditItem = (EditText) findViewById(R.id.etEditItem);
        etEditItem.setText("");
        etEditItem.append(getIntent().getStringExtra("todoText"));

        todoPosition = getIntent().getIntExtra("todoPosition", 0);
    }

    public void onEditItem(View v) {
        EditText etEditItem = (EditText) findViewById(R.id.etEditItem);
        String todoText = etEditItem.getText().toString();

        Intent data = new Intent();

        data.putExtra("todoText", todoText);
        data.putExtra("todoPosition", todoPosition);

        setResult(RESULT_OK, data);
        finish();
    }
}

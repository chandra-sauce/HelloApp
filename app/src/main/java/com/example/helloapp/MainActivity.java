package com.example.helloapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textViewGreeting;
    private EditText editTextName;
    private Button buttonSayHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewGreeting = (TextView) findViewById(R.id.textViewGreeting);
        buttonSayHello = (Button) findViewById(R.id.buttonSayHello);
        editTextName = (EditText) findViewById(R.id.editTextName);
    }

    public void onClickSayHello(View v) {
        // Get the name
        String name = editTextName.getText().toString().trim();

        if (name.isEmpty()) {
            // Remind the user to enter the name
            textViewGreeting.setText("Please enter a name");
        } else {
            textViewGreeting.setText("Bye, " + name + "!");
        }
    }
}

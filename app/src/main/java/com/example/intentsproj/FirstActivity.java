package com.example.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class FirstActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Log.i("Lifecycle", "OnCreate() Invoked");

        final EditText fno1 = (EditText)findViewById(R.id.editText1);
        final EditText fno2 = (EditText)findViewById(R.id.editText2);

        button = (Button) findViewById(R.id.button_send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                String num1 = fno1.getText().toString();
                String num2 = fno2.getText().toString();


                openSecondActivity();
            }
        });
    }

    public void openSecondActivity(){
        final EditText fno1 = (EditText)findViewById(R.id.editText4);
        final EditText fno2 = (EditText)findViewById(R.id.editText5);

        String number1 = fno1.getText().toString();
        String number2 = fno2.getText().toString();

        Intent intent = new Intent(FirstActivity.this,SecondActivity.class);

        intent.putExtra("number1",fno1.getText().toString());
        intent.putExtra("number2",fno2.getText().toString());

        Context context = getApplicationContext();
        CharSequence message = "You just clicked the OK button";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration); toast.show();

        toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);

        startActivity(intent);
    }
}

package ro.pub.cs.system.eim.practicaltest01var06;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Random;

public class PracticalTest01Var06MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button;
    private TextView text_1, text_2, text_3;
    private CheckBox box_1, box_2, box_3;
    private int i_1, i_2, i_3, c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__practical_test01_var06_main);

        button = findViewById(R.id.button);
        text_1 = findViewById(R.id.text_1);
        text_2 = findViewById(R.id.text_2);
        text_3 = findViewById(R.id.text_3);
        box_1 = findViewById(R.id.check_1);
        box_2 = findViewById(R.id.check_2);
        box_3 = findViewById(R.id.check_3);

        //Intent intent = getIntent();
        /*if (intent != null) {
            i_1 = Integer.valueOf(intent.getStringExtra("first"));
            i_2 = Integer.valueOf(intent.getStringExtra("second"));
            i_3 = Integer.valueOf(intent.getStringExtra("third"));

            text_1.setText(String.valueOf(i_1));
            text_2.setText(String.valueOf(i_2));
            text_3.setText(String.valueOf(i_3));
        }*/
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Random rand = new Random();
        i_1 = rand.nextInt() % 4;
        i_2 = rand.nextInt() % 4;
        i_3 = rand.nextInt() % 4;
        c = 0;

        if(box_1.isChecked() == false) {
            if (i_1 <= 0){
                text_1.setText("*");
                Log.i("NumberGenerated", "First box: *");
            }
            else {text_1.setText(String.valueOf(i_1));
                Log.i("NumberGenerated", "First box: " + i_1);}
        } else c++;

        if(box_2.isChecked() == false) {
            if (i_2 <= 0){
                text_2.setText("*");
                Log.i("NumberGenerated", "Second box: *");
            }
            else {text_2.setText(String.valueOf(i_2));
                Log.i("NumberGenerated", "Second box: " + i_2);}
        } else c++;

        if(box_3.isChecked() == false) {
            if (i_3 <= 0) {
                text_3.setText("*");
                Log.i("NumberGenerated", "Third box: *");
            } else {
                text_3.setText(String.valueOf(i_3));
                Log.i("NumberGenerated", "Third box: " + i_3);
            }
        } else c++;

        Intent intent = new Intent(this, Practicaltest01Var06SecondaryActivity.class);

        intent.putExtra("first", String.valueOf(i_1));
        intent.putExtra("second", String.valueOf(i_2));
        intent.putExtra("third", String.valueOf(i_3));
        intent.putExtra("checked", String.valueOf(c));
        startActivity(intent);
        }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("first", i_1);
        outState.putInt("second", i_2);
        outState.putInt("third", i_3);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        i_1 = savedInstanceState.getInt("first");
        text_1.setText(String.valueOf(i_1));

        i_2 = savedInstanceState.getInt("second");
        text_2.setText(String.valueOf(i_2));

        i_3 = savedInstanceState.getInt("third");
        text_3.setText(String.valueOf(i_3));
    }
}
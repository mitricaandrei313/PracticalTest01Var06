package ro.pub.cs.system.eim.practicaltest01var06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Practicaltest01Var06SecondaryActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView text;
    private Button button;
    private int i_1, i_2, i_3, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practicaltest01_var06_secondary);

        text = findViewById(R.id.scor);
        button = findViewById(R.id.button2);

        Intent intent = getIntent();
        i_1 = Integer.valueOf(intent.getStringExtra("first"));
        i_2 = Integer.valueOf(intent.getStringExtra("second"));
        i_3 = Integer.valueOf(intent.getStringExtra("third"));
        c = Integer.valueOf(intent.getStringExtra("checked"));

        String s = "";

        if(i_1 <= 0){ i_1 = 0;s += "Gained ";}
        else if(i_2 <= 0){ i_2 = 0;s += "Gained ";}
            else if(i_3 <= 0){ i_3 = 0;s += "Gained ";}
                else if (i_1 == i_2 && i_2 == i_3){
                    s += "Gained ";
                }

        if (c == 0){
            s += "100";
        } else if (c == 1){
            s += "50";
        } else if (c == 2) {
            s += "10";
        }

        text.setText(s);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
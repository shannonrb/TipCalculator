package edu.scranton.bannens2.tipcalculatorfinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText enteramount;
    private EditText numberpeople;
    private SeekBar seekbar_tip_sleekbar;
    private TextView seekbar_text_amount;
    private Button caluclate_button;
    private TextView text_your_tip_is;
    private TextView total_amount_final;
    private TextView total_tip_perperson;
    private TextView total_amount_perperson;

    private int seekbarpercentage;
    private float enterbillfloat;
    private float enterpeoplefloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteramount = findViewById(R.id.id_enteramount);
        numberpeople = findViewById(R.id.id_numberpeople);
        seekbar_tip_sleekbar = findViewById(R.id.id_seekbar);
        seekbar_text_amount = findViewById(R.id.id_text_seekpercentage);
        caluclate_button = findViewById(R.id.id_submitbutton);
        text_your_tip_is = findViewById(R.id.id_text_yourtip_is);
        total_amount_final = findViewById(R.id.id_text_totalamount);
        total_tip_perperson = findViewById(R.id.id_tip_perperson);
        total_amount_perperson = findViewById(R.id.id_text_totalperperson);

        //----------------------------
        seekbar_text_amount.setText("YOU SELECT " + seekbar_tip_sleekbar.getProgress() + "%");
        //-----------------------------
        caluclate_button.setOnClickListener(this);
        //-----------------------------
        seekbar_tip_sleekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekbar_text_amount.setText("YOU SELECT " + seekbar_tip_sleekbar.getProgress() + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "START", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekbarpercentage = seekbar_tip_sleekbar.getProgress();

            }
        });
    }

    //-----------------------------
    @Override
    public void onClick(View view) {
        calculate();
    }

    public void calculate() {
        float result;
        float total;
        if (!enteramount.getText().toString().equals("")) {

            enterbillfloat = Float.parseFloat(enteramount.getText().toString());
            enterpeoplefloat = Float.parseFloat(numberpeople.getText().toString());
            result=(enterbillfloat*seekbarpercentage/100);
            total=(result/enterpeoplefloat);

            text_your_tip_is.setText("TIP is: " + result);

            total_amount_final.setText("Total Amount is: " + (enterbillfloat + result));

            total_tip_perperson.setText("Total tip per person: " + total);

            total_amount_perperson.setText("Total amount per person:" + (result + total));


        } else {
            Toast.makeText(getApplicationContext(), "Please enter amount", Toast.LENGTH_LONG).show();
        }

    }
    /*THIS IS WHERE I TRIED DOING THE SPINNER
    Spinner spinner = (Spinner) findViewById(R.id.spinner);
    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.number_people, android.R.layout.simple_spinner_item);
    // Specify the layout to use when the list of choices appears
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    // Apply the adapter to the spinner
    spinner.setAdapter(adapter);

    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {
    ...

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }

    Spinner spinner = (Spinner) findViewById(R.id.spinner);
    spinner.setOnItemSelectedListener(this);

     */
}

package sg.edu.rp.c346.id19028654.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {
    EditText etAmount, etNumOfPax, etDiscount;
    ToggleButton tbtnSvs, tbtnGst;
    Button btnSplit, btnReset;
    TextView tvTotal, tvEach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAmount = findViewById(R.id.editTextAmount);
        etNumOfPax = findViewById(R.id.editTextNumOfPax);
        etDiscount = findViewById(R.id.editTextDiscount);
        tbtnSvs = findViewById(R.id.toggleButtonSvs);
        tbtnGst = findViewById(R.id.toggleButtonGst);
        btnSplit = findViewById(R.id.buttonSplit);
        btnReset = findViewById(R.id.buttonReset);
        tvTotal = findViewById(R.id.textViewTotal);
        tvEach = findViewById(R.id.textViewEach);


        btnSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etAmount.getText().toString().trim().length()==0){
                    return;
                }
                if(etNumOfPax.getText().toString().trim().length()==0){
                    return;
                }
                double amt =0.0;
                if(!tbtnSvs.isChecked() && !tbtnGst.isChecked()){
                    amt = Double.parseDouble(etAmount.getText().toString());
                }
                else if(!tbtnSvs.isChecked() && tbtnGst.isChecked()){
                    amt = Double.parseDouble(etAmount.getText().toString())*1.07;
                }
                else if(tbtnSvs.isChecked() && !tbtnGst.isChecked()) {
                    amt = Double.parseDouble(etAmount.getText().toString()) * 1.1;
                }
                else{
                    amt = Double.parseDouble(etAmount.getText().toString()) * 1.17;
                }
                tvTotal.setText("Total Bill: $" + amt);
                int numPax = Integer.parseInt(etNumOfPax.getText().toString());
                tvEach.setText("Each Pays: $" + String.format("%.2f", amt/numPax));


            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etAmount.setText("");
                etDiscount.setText("");
                etNumOfPax.setText("");
                tbtnSvs.setChecked(false);
                tbtnGst.setChecked(false);
                tvTotal.setText("Total Bill: ");
                tvEach.setText("Each Pays: ");
            }
        });

    }
}
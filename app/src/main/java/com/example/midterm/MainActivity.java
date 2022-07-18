package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText myEditRow, myEditColumn;
    private TableLayout myTableLayout;
    private TextView textView, myResultView;
    private TableRow tableRow;
    private CheckBox myCheckBox;

    float total = 0;

    ArrayList<Float> mylist=new ArrayList<>();
    ArrayList<CheckBox> myCheckBoxesList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myEditRow = findViewById(R.id.editRow);
        myEditColumn = findViewById(R.id.editColumn);
        myResultView=findViewById(R.id.resultView);
        myTableLayout=findViewById(R.id.table1);

    }

    public void onReset(View view) {
        int column = Integer.parseInt(myEditColumn.getText().toString());
        int row = Integer.parseInt(myEditRow.getText().toString());
        myEditRow.setText("");
        myEditColumn.setText("");
        myResultView.setText("Result");
        myTableLayout.removeAllViews();
        mylist.clear();
    }

    public void onCalculate(View view) {
        int row = Integer.parseInt(myEditRow.getText().toString());
        float totalRow=0;
        for(int i=0;i<row;i++){
            CheckBox tmp = myCheckBoxesList.get(i);
            if(tmp.isChecked()==true){
                float tmpint = mylist.get(i);
                totalRow = tmpint+ totalRow;
                String tmpStr = String.valueOf(totalRow);
                myResultView.setText(tmpStr);
            }
        }
    }

    public void onCreate(View view) {
        int column = Integer.parseInt(myEditColumn.getText().toString());
        int row = Integer.parseInt(myEditRow.getText().toString());
        Random rand = new Random();
        for (int i = 0; i < row; i++) {
            tableRow = new TableRow(getApplicationContext());
            total=0;
            if(column==0){
                return;
            }
            for (int j = 0; j < column; j++) {
                int tmp = rand.nextInt(20);
                total = total +tmp;
                String tmpStr = String.valueOf(tmp);
                textView = new TextView(getApplicationContext());
                textView.setText("   " +tmpStr);
                tableRow.addView(textView);
            }

            total = total /column;
            myCheckBox = new CheckBox(getApplicationContext());
            myCheckBox.setId(i);
            myCheckBoxesList.add(i,myCheckBox);
            mylist.add(i,total);
            tableRow.addView(myCheckBox);
            myTableLayout.addView(tableRow);
        }
    }
    public void onExit(View view) { finish();
    }
}
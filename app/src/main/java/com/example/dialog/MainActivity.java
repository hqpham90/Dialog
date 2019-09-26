package com.example.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        TextView tv_ketqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder mydialog = new AlertDialog.Builder(this);
        mydialog.setTitle("massage");
        mydialog.setIcon(R.drawable.aaa);
     //   mydialog.setMessage("hello");
        tv_ketqua = (TextView)findViewById(R.id.tv_kq);
        final CharSequence[] items={"Do","Vang","Cam"};
   //     mydialog.setItems(items, new DialogInterface.OnClickListener() {
     //       @Override
       //     public void onClick(DialogInterface dialogInterface, int i) {
         //       tv_ketqua.setText(items[i].toString());
        // }
        //});
        final boolean[] arraycheck = {false, false , false};
        mydialog.setMultiChoiceItems(items, arraycheck, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

            }
        });
        mydialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String st="";
                for(int j = 0; j < items.length; j++)
                    if(arraycheck[j])
                        st += items[j].toString() + "\n";
                tv_ketqua.setText(st);
            }
        });
        mydialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tv_ketqua.setText("You choice No");
            }
        });
        AlertDialog alertDialog = mydialog.create();
        alertDialog.show();
    }
}

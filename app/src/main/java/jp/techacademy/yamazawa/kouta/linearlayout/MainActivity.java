package jp.techacademy.yamazawa.kouta.linearlayout;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mTextView;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
        mEditText = (EditText) findViewById(R.id.editText);
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.button1){
            mTextView.setText(mEditText.getText().toString());
        }else if(v.getId() == R.id.button2){
            showAlertDialog();
        }else if(v.getId() == R.id.button3){
            showTimePickerDialog();
        }else if(v.getId() == R.id.button4){
            showDatePickerDialog();
        }
    }

    private void showAlertDialog(){
            //AlertDialog.Builderクラスを使ってAlertDialogの準備をする
            AlertDialog.Builder alertdialogBuilder = new AlertDialog.Builder(this);
            alertdialogBuilder.setTitle("タイトル");
            alertdialogBuilder.setMessage("メッセージ");

            //肯定ボタンに表示される文字列、押したときのリスナーを設定する
            alertdialogBuilder.setPositiveButton("肯定",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.d("UI_PARTS","肯定ボタン");
                        }
                    });

            //中立ボタンに表示される文字列、押したときのリスナーを設定する
            alertdialogBuilder.setNeutralButton("中立",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.d("UI_PARTS","中立ボタン");
                        }
                    });

            //否定ボタンに表示される文字列、押したときのリスナーを設定する
            alertdialogBuilder.setNegativeButton("否定",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.d("UI_PARTS","否定ボタン");
                        }
                    });

            // AlertDialogを作成して表示する
            AlertDialog alertDialog = alertdialogBuilder.create();
            alertDialog.show();
    }

    private void showTimePickerDialog(){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                    }
                },
                13,//初期値(時間)
                0,    //初期値(分)
                true);
        timePickerDialog.show();
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        Log.d("UI-PARTS", String.valueOf(year) + "/" + String.valueOf(monthOfYear) + "/" + String.valueOf(dayOfMonth));
                    }
                },
                2016,
                6,
                1);
            datePickerDialog.show();
    }
}

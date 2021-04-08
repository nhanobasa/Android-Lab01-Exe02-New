package td.nhan.lab01_exe02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import td.nhan.lab01_exe02.model.Student;

public class MainActivity extends AppCompatActivity {

    List<Student> studentList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerImg = findViewById(R.id.spImg);
        List<Integer> imgList = new ArrayList<>();
        imgList.add(R.drawable.facebook_logo_png_9024);
        imgList.add(R.drawable.google_logo_png_29546);
        imgList.add(R.drawable.iphone_12_red);
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item, imgList);
        spinnerImg.setAdapter(arrayAdapter);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        EditText etId = findViewById(R.id.etId);
        EditText etName = findViewById(R.id.etName);

        EditText etDob = findViewById(R.id.etDob);
        Calendar calendar = Calendar.getInstance();
        int d = calendar.get(Calendar.DAY_OF_MONTH);
        int m = calendar.get(Calendar.MONTH);
        int y = calendar.get(Calendar.YEAR);
        etDob.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, (view, year, month, dayOfMonth) -> {
                    etDob.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                }, y, m, d);

                datePickerDialog.show();
            }
        });
        etDob.setOnClickListener(v -> {

            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, (view, year, month, dayOfMonth) -> {
                etDob.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }, y, m, d);

            datePickerDialog.show();
        });

        RadioButton rbMale = findViewById(R.id.rbMale);
        RadioButton rbFemale = findViewById(R.id.rbFemale);

        ListView listView = findViewById(R.id.listview);
        StudentAdapter studentAdapter = new StudentAdapter(MainActivity.this, studentList, R.layout.lisst_item);
        listView.setAdapter(studentAdapter);

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(v -> {
            int resImg = Integer.parseInt(spinnerImg.getSelectedItem().toString());
            String id = etId.getText().toString();
            String name = etName.getText().toString();
            String dob = etDob.getText().toString();
            String gender = "";
            if (rbMale.isChecked())
                gender = rbMale.getText().toString();
            else
                gender = rbFemale.getText().toString();

            studentList.add(
                    new Student(resImg, id, name, gender, dob)
            );
            studentAdapter.notifyDataSetChanged();

        });

    }
};
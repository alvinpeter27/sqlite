package com.example.sqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText courseNameEdt, courseTracksEdt, courseDurationEdt, courseDescriptionEdt;
    private Button addCourseBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        courseNameEdt=findViewById(R.id.editText);
        courseDurationEdt=findViewById(R.id.edittext2);
        courseDescriptionEdt=findViewById(R.id.edittext3);
        courseTracksEdt=findViewById(R.id.edittext4);
        addCourseBtn=findViewById(R.id.button);

        dbHandler=new DBHandler(MainActivity.this);


        addCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String coursname=courseNameEdt.getText().toString();
                String courseduration=courseDurationEdt.getText().toString();
                String coursedescription=courseDescriptionEdt.getText().toString();
                String tracks=courseTracksEdt.getText().toString();

               if (coursname.isEmpty()&& courseduration.isEmpty()&&coursedescription.isEmpty()&& tracks.isEmpty()){
                   Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                   return;
               }

               dbHandler.addNewCourse(coursname,courseduration,coursedescription,tracks);
                Toast.makeText(MainActivity.this, "Course has been added.", Toast.LENGTH_SHORT).show();

                courseNameEdt.setText("");
                courseDurationEdt.setText("");
                courseTracksEdt.setText("");
                courseDescriptionEdt.setText("");

            }
        });







    }
}
package com.example.mobile_filnalproject.ui.diary;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mobile_filnalproject.R;
import com.example.mobile_filnalproject.ui.home.HomeViewModel;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

import static android.content.Context.MODE_NO_LOCALIZED_COLLATORS;

public class DiaryFragment extends Fragment {

    private MaterialCalendarView calendarView;
    private EditText editDiary;
    private TextView txtDate;
    private Button btnSave;

    private String fileName = "";
    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_diary, container, false);

        this.calendarView = root.findViewById(R.id.calendarView);
        this.editDiary = root.findViewById(R.id.edtDiary);
        this.txtDate = root.findViewById(R.id.txtDate);
        this.btnSave = root.findViewById(R.id.btnSave);

        this.calendarView.state().edit()
                .setFirstDayOfWeek(Calendar.SUNDAY)
                .setMinimumDate(CalendarDay.from(2021,0,1))
                .setMaximumDate(CalendarDay.from(2022,11,31))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();
        this.calendarView.addDecorators(
                new SundayDecorator(),
                new SaturdayDecorator(),
                new OneDayDecorator()
        );

        this.calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                checkedDay(date.getYear(), date.getMonth(), date.getDay());
            }
        });

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        checkedDay(year,month,day);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFile( fileName );
            }
        });

        return root;
    }

    private void checkedDay(int year, int monthOfYear, int dayOfMonth) {
        txtDate.setText(year + " - " + monthOfYear + " - " + dayOfMonth);
        fileName = year + "" + monthOfYear + "" + dayOfMonth + ".txt";

        FileInputStream fis = null;
        try {
            fis = getContext().openFileInput(fileName);

            byte[] fileData = new byte[fis.available()];
            fis.read(fileData);
            fis.close();

            String str = new String(fileData, "UTF-8");

            editDiary.setText(str);
            btnSave.setText("수정");
        } catch (Exception e) {
            editDiary.setText("");
            btnSave.setText("저장");
        }

    }

    @SuppressLint("WrongConstant")
    private void saveFile(String readDay) {
        FileOutputStream fos = null;
        try {
            fos = getContext().openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content = editDiary.getText().toString();

            fos.write(content.getBytes());
            fos.close();

            // getApplicationContext() = 현재 클래스.this ?
            Toast.makeText(root.getContext(), "일기 저장됨", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {}
    }
}
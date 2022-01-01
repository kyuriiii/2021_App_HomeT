package com.example.mobile_filnalproject.ui.home;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mobile_filnalproject.MainActivity;
import com.example.mobile_filnalproject.R;
import com.example.mobile_filnalproject.ui.hometraining.HomeTrainingFragment;

public class HomeFragment extends Fragment {

    private SensorManager sensorManager;
    private Sensor stepCountSensor;
    private TextView txtStep;
    private View root;
    private SensorStepListener sensorStepListener;

    private androidx.cardview.widget.CardView diary,hometraining, homecook, onlinegame;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_home, container, false);

        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        stepCountSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        sensorStepListener = new SensorStepListener();
        txtStep = root.findViewById(R.id.stepCount);
        if ( stepCountSensor == null ) txtStep.setText( "만보기 센서가 없습니다." );

        MainClickListener mainClick = new MainClickListener();

        hometraining = root.findViewById(R.id.hometraining);
        homecook = root.findViewById(R.id.homecook);
        onlinegame = root.findViewById(R.id.onlinegame);
        diary = root.findViewById(R.id.diary);

        hometraining.setOnClickListener(mainClick);
        homecook.setOnClickListener(mainClick);
        onlinegame.setOnClickListener(mainClick);
        diary.setOnClickListener(mainClick);

        return root;
    }

    @Override
    public void onStart(){
        super.onStart();
       if ( stepCountSensor != null ) sensorManager.registerListener(sensorStepListener,stepCountSensor, SensorManager.SENSOR_DELAY_FASTEST);
    }
    @Override
    public void onStop(){
        super.onStop();
        if ( stepCountSensor != null ) sensorManager.unregisterListener(sensorStepListener);
    }

    public class SensorStepListener implements SensorEventListener{
        @Override
        public void onSensorChanged(SensorEvent event){
            if ( event.sensor.getType() == Sensor.TYPE_STEP_COUNTER){ txtStep.setText(String.valueOf(event.values[0])); }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    }

    class MainClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String nav = "";

            if ( v.getId() == R.id.hometraining ) nav = "hometraining";
            else if ( v.getId() == R.id.homecook ) nav = "homecook";
            else if ( v.getId() == R.id.onlinegame ) nav = "onlinegame";
            else if ( v.getId() == R.id.diary ) nav = "diary";

            ((MainActivity)getActivity()).fragmentChange(nav);
        }
    }
}
package com.bj.pijok.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;
import com.bj.pijok.R;
import com.bj.pijok.data.AlcoholEntry;
import com.bj.pijok.data.AlcoholType;
import com.bj.pijok.data.AlcoholTypeProvider;
import com.bj.pijok.data.PartyDataProvider;

public class AddEntryActivity extends FragmentActivity {

    private ViewFlipper viewFlipper;

    private TextView volumeText;
    private TextView alcoholText;

    private SeekBar volumeSeekBar;
    private SeekBar alcoholSeekBar;

    private TimePicker addDrinkTimePicker;

    private Button addDrinkButton;

    private int index = 0;

    private float lastX;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addentry);
        initializeVariables();
        initializeListeners();
        setSeekerBars();
    }

    private void initializeVariables() {
        viewFlipper = (ViewFlipper) findViewById(R.id.view_flipper);

        volumeText = (TextView) findViewById(R.id.volumeText);
        alcoholText = (TextView) findViewById(R.id.alcoholText);

        volumeSeekBar = (SeekBar) findViewById(R.id.volumeSeekerBar);
        alcoholSeekBar = (SeekBar) findViewById(R.id.alcoholSeekerBar);

        addDrinkTimePicker = (TimePicker) findViewById(R.id.addDrinkTimePicker);

        addDrinkButton = (Button) findViewById(R.id.addDrinkButton);
    }

    private void initializeListeners() {
        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                volumeText.setText("" + progressValue + "cl");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        alcoholSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                alcoholText.setText("" + (progressValue * 0.1) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        Activity activity = this;
        addDrinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlcoholType alcoholType = getCurrentAlcoholType();
                AlcoholEntry alcoholEntry = new AlcoholEntry(alcoholType);
                alcoholEntry.setVolume(volumeSeekBar.getProgress());
                alcoholEntry.setAlcoholPercentage(alcoholSeekBar.getProgress());
                alcoholEntry.setHour(addDrinkTimePicker.getCurrentHour());
                alcoholEntry.setMinute(addDrinkTimePicker.getCurrentMinute());
                PartyDataProvider.getInstance(activity).addAlcoholEntry(activity, alcoholEntry);
                finish();
            }
        });
    }

    private AlcoholType getCurrentAlcoholType() {
        return AlcoholTypeProvider.getAlcoholTypes().get(index);
    }

    private void setSeekerBars() {
        AlcoholType alcoholType = getCurrentAlcoholType();

        volumeText.setText("" + alcoholType.getVolume() + "cl");
        volumeSeekBar.setProgress(alcoholType.getVolume());

        alcoholText.setText("" + (alcoholType.getAlcoholPercentage() * 0.1) + "%");
        alcoholSeekBar.setProgress(alcoholType.getAlcoholPercentage());
    }

    public boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction()) {
            // when user first touches the screen to swap
            case MotionEvent.ACTION_DOWN: {
                lastX = touchevent.getX();
                break;
            }
            case MotionEvent.ACTION_UP: {
                float currentX = touchevent.getX();

                // if left to right swipe on screen
                if (lastX < currentX) {
                    if (viewFlipper.getDisplayedChild() == 0)
                        break;

                    viewFlipper.setInAnimation(this, R.anim.in_from_left);
                    viewFlipper.setOutAnimation(this, R.anim.out_to_right);
                    viewFlipper.showPrevious();
                    index--;
                    setSeekerBars();
                }

                // if right to left swipe on screen
                if (lastX > currentX) {
                    if (viewFlipper.getDisplayedChild() == 4)
                        break;

                    viewFlipper.setInAnimation(this, R.anim.in_from_right);
                    viewFlipper.setOutAnimation(this, R.anim.out_to_left);
                    viewFlipper.showNext();
                    index++;
                    setSeekerBars();
                }
                break;
            }
        }
        return false;
    }

}

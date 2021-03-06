package com.android.mig.bakingapp.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.android.mig.bakingapp.R;
import com.android.mig.bakingapp.fragments.StepDetailFragment;
import com.android.mig.bakingapp.models.Step;

import java.util.ArrayList;

public class StepActivity extends AppCompatActivity {

    private static final int INITIAL_POSITION = 0;
    private static final boolean TABLET_FLAG = true;
    public static StepDetailFragment sStepDetailInstance = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);
        // if it's a tablet and it's on landscape mode then add a StepDetailFragment as a static
        // instance to able to handle it from this activity
        if (getResources().getConfiguration().smallestScreenWidthDp >= 600) {
            ArrayList<Step> stepArrayList = getIntent().getParcelableArrayListExtra(getString(R.string.action_steps));
            FragmentManager fragmentManager = getSupportFragmentManager();
            sStepDetailInstance = StepDetailFragment.newtInstance(stepArrayList, INITIAL_POSITION, TABLET_FLAG);

            if (!(savedInstanceState != null)) {
                fragmentManager.beginTransaction()
                        .add(R.id.step_detail_container, sStepDetailInstance)
                        .commit();
            }
        }
    }
}

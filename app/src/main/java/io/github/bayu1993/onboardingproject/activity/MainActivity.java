package io.github.bayu1993.onboardingproject.activity;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import io.github.bayu1993.onboardingproject.fragment.OnboardingFragment;
import io.github.bayu1993.onboardingproject.R;
import io.github.bayu1993.onboardingproject.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private List<OnboardingFragment> fragmentList;
    private final int NUMPAGE = 3;
    private List<ImageView> indicators;
    private LinearLayout layoutIndicator;
    private Button btnSelesai;
    private ViewPager viewPager;
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String desc1 = "Desk slide Desk slideDesk slideDesk slideDesk slide ";
        String desc2 = "Desk slide Desk slideDesk slideDesk slideDesk slide ";
        String desc3 = "Desk slide Desk slideDesk slideDesk slideDesk slide ";
        fragmentList = new ArrayList<>();
        fragmentList.add(OnboardingFragment.newInstance("title 1",desc1,R.drawable.img_slide_1));
        fragmentList.add(OnboardingFragment.newInstance("title 2",desc2,R.drawable.img_slide_1));
        fragmentList.add(OnboardingFragment.newInstance("title 3",desc3,R.drawable.img_slide_1));

        indicators = new ArrayList<>(NUMPAGE);
        layoutIndicator = findViewById(R.id.layout_indicator);
        btnSelesai = findViewById(R.id.btn_selesai);

        btnSelesai.setVisibility(View.GONE);
        btnSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                MainActivity.this.finish();
            }
        });

        viewPager = findViewById(R.id.viewpager);
        ViewPagerAdapter vpAdapter = new ViewPagerAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(vpAdapter);
        viewPager.addOnPageChangeListener(this);
        Log.e(TAG, "onCreate: "+indicators.size() );
        setupPagerIndicator(NUMPAGE);
    }

    private void setupPagerIndicator(final int numpage) {
        for (int i = 0; i < numpage; i++) {
            indicators.add(new ImageView(MainActivity.this));
            indicators.get(i).setImageDrawable(
                    ContextCompat.getDrawable(MainActivity.this,
                            (i == 0) ? R.drawable.dot_indicator : R.drawable.dot_indicator_disable)
            );

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            int margin = getResources().getDimensionPixelSize(R.dimen.dimen_8dp);
            params.setMargins(
                    margin,
                    0,
                    margin,
                    0
            );
            layoutIndicator.addView(indicators.get(i), params);
        }
        indicators.get(0).setSelected(true);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < NUMPAGE; i++) {
            indicators.get(i).setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.dot_indicator_disable));
        }
        indicators.get(position).setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.dot_indicator));

        btnSelesai.setVisibility(
                (position == (NUMPAGE - 1)) ? View.VISIBLE : View.GONE
        );
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

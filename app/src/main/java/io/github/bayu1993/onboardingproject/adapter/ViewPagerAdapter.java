package io.github.bayu1993.onboardingproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import io.github.bayu1993.onboardingproject.fragment.OnboardingFragment;

/**
 * Created by dell on 4/3/18.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter{
    private final List<OnboardingFragment> onboardingFragments;
    public ViewPagerAdapter(FragmentManager fm, List<OnboardingFragment> onboardingFragments) {
        super(fm);
        this.onboardingFragments = onboardingFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return onboardingFragments.get(position);
    }

    @Override
    public int getCount() {
        return onboardingFragments.size();
    }
}

package io.github.bayu1993.onboardingproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.bayu1993.onboardingproject.R;

public class OnboardingFragment extends Fragment {

    private TextView tvTitle;
    private View rootView;
    private TextView tvDesc;
    private ImageView ivSlide;

    public static OnboardingFragment newInstance(String title, String desc, int img) {
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("desc", desc);
        args.putInt("img", img);
        OnboardingFragment fragment = new OnboardingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if (null != bundle){
            String title = bundle.getString("title","title");
            String desc = bundle.getString("desc","description");
            int img = bundle.getInt("img",0);
            tvTitle.setText(title);
            tvDesc.setText(desc);
            ivSlide.setImageResource(img);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_onboarding,container,false);
        tvTitle = rootView.findViewById(R.id.tv_title_slide);
        tvDesc = rootView.findViewById(R.id.tv_desc);
        ivSlide = rootView.findViewById(R.id.iv_slide);
        return rootView;
    }

    public final class BundleKey {
        public BundleKey() {
        }
        public static final String TITLE_KEY = "OnBoardingFragment.BundleKey";
    }
}

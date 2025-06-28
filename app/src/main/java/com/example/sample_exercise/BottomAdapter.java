package com.example.sample_exercise;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class BottomAdapter extends FragmentStateAdapter{

    public BottomAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new home();
            case 1:
                return new cart();
            case 2:
                return new profile();
            case 3:
                return new search();
            default:
                return new home();
        }
    }
    @Override
    public int getItemCount() {
        return 4;
    }
}

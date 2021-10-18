package org.techtown.dongseomap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return Frag_1uit.newlnstance();
            case 1:
                return Frag_2uit.newlnstance();
            case 2:
                return Frag_3uit.newlnstance();
            case 3:
                return Frag_4uit.newlnstance();
            case 4:
                return Frag_5uit.newlnstance();
            case 5:
                return Frag_6uit.newlnstance();
            case 6:
                return Frag_7uit.newlnstance();
            case 7:
                return Frag_8uit.newlnstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 8;
    }
    //상단의 탭 레이아웃 인디케이터 쪽에 텍스트를 선언
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "1층안내";
            case 1:
                return "2층안내";
            case 2:
                return "3층안내";
            case 3:
                return "4층안내";
            case 4:
                return "5층안내";
            case 5:
                return "6층안내";
            case 6:
                return "7층안내";
            case 7:
                return "8층안내";
            default:
                return null;
        }
    }
}

package com.example.dalves.testeblank;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabFragment extends Fragment {

    ViewPager viewPager;

    TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tabLayout = (TabLayout) getActivity().findViewById(R.id.tabs);
        viewPager.setAdapter(new TabPageAdapter(getFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setVisibility(View.VISIBLE);

    }

    public class TabPageAdapter extends FragmentStatePagerAdapter {


        SparseArray<Fragment> fragments = new SparseArray<>();
        SparseArray<String> fragmentTitles = new SparseArray<>();


        public TabPageAdapter(FragmentManager fm) {
            super(fm);
            fragments.put(0, new Fragment());
            fragments.put(1, new Fragment());
            fragments.put(2, new Fragment());

            fragmentTitles.put(0, "First");
            fragmentTitles.put(1, "Second");
            fragmentTitles.put(2, "Third");
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitles.get(position);
        }
    }

    @Override
    public void onDestroyView() {
        tabLayout.setVisibility(View.GONE);
        super.onDestroyView();
    }
}

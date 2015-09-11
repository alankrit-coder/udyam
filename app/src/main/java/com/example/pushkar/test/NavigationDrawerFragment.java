package com.example.pushkar.test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment {
        private RecyclerView recyclerView;
        private ActionBarDrawerToggle mDrawerToggle;
        private DrawerLayout mDrawerlayout;
        private VivzAdapter adapter;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout=inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        recyclerView=(RecyclerView)layout.findViewById(R.id.drawer_list);
        adapter=new VivzAdapter(getActivity(),getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;
    }

   public static List<information> getData(){
      List<information> data=new ArrayList<>();
       int icons[]={R.drawable.fb,R.drawable.fb,R.drawable.fb,R.drawable.fb,R.drawable.fb,R.drawable.fb,R.drawable.fb,R.drawable.fb,};
       String titles[]={"ABOUT","WORKSHOPS","EVENTS","SPONSORS","REGISTER","OUR TEAM","SCHEDULE","CONTACT US"};
       for(int i=0;i<icons.length && i<titles.length;i++) {
           information current = new information();
           current.iconId = icons[i];
           current.title = titles[i];
           data.add(current);

       }
       return data;

   }
    public void setUp( DrawerLayout drawerlayout,Toolbar toolbar) {



        mDrawerlayout=drawerlayout;
        mDrawerToggle=new ActionBarDrawerToggle(getActivity(),drawerlayout,toolbar,R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };




        mDrawerlayout.setDrawerListener(mDrawerToggle);
        mDrawerlayout.post(new Runnable(){
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }
}

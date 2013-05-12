package com.example.rodalies;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

public class Page2Activity extends Fragment {
	private View myFragmentView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	myFragmentView = inflater.inflate(R.layout.activity_page2, container, false);
		
		return myFragmentView;
	}	

}

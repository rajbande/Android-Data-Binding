package com.techteam.databinding.ui.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techteam.databinding.R;
import com.techteam.databinding.databinding.SimpleBinding;
import com.techteam.databinding.viewmodels.User;

public class SimpleFragment extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    SimpleBinding binding = DataBindingUtil.inflate(inflater, R.layout.simple, container, false);
    View view = binding.getRoot();

    /**
     * Note that you don't have to find view by id for TextViews and then set the text.
     */
    User user = new User("Rajkiran", "Bande");
    binding.setUser(user);
    return view;
  }
}
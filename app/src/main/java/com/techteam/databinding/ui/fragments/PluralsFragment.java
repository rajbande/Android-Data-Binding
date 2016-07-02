package com.techteam.databinding.ui.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techteam.databinding.R;
import com.techteam.databinding.databinding.PluralsBinding;
import com.techteam.databinding.viewmodels.Plurals;

public class PluralsFragment extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    PluralsBinding binding = DataBindingUtil.inflate(inflater, R.layout.plurals, container, false);
    View view = binding.getRoot();

    /**
     * The values are fetched from values/plurals.xml and strings.xml through data binding
     * Check layout/plurals.xml for details.
     */
    Plurals plurals = new Plurals("1");
    binding.setPlural(plurals);
    return view;
  }
}
package com.techteam.databinding.ui.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techteam.databinding.R;
import com.techteam.databinding.databinding.TwoWayBinding;
import com.techteam.databinding.viewmodels.SuperUser;

public class TwoWayFragment extends Fragment {

  private View view;
  private SuperUser superUser;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    TwoWayBinding binding = DataBindingUtil.inflate(inflater, R.layout.two_way, container, false);
    view = binding.getRoot();
    initViews(view);

    superUser = new SuperUser("Raj", "Bande");
    binding.setSuperuser(superUser);
    return view;
  }

  private void initViews(final View view) {
    view.findViewById(R.id.btnChange).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        superUser.setFirstName("Rajkiran");
        Snackbar.make(view, "Text changed via binding without findViewById", Snackbar.LENGTH_LONG).show();
      }
    });
  }
}
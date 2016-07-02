package com.techteam.databinding.ui.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.techteam.databinding.R;
import com.techteam.databinding.databinding.ConditionalBinding;
import com.techteam.databinding.viewmodels.Employee;
import com.techteam.databinding.viewmodels.SuperUser;

import static android.text.TextUtils.isEmpty;

public class ConditionalFragment extends Fragment {

  private View view;
  private SuperUser superUser;
  private Employee employee;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    ConditionalBinding binding = DataBindingUtil.inflate(inflater, R.layout.conditional, container, false);
    view = binding.getRoot();
    initViews(view);

    /**
     * Please look at the conditional.xml to check how we set text,
     * visibility, color, etc. based on the age
     */
    employee = new Employee("Rajkiran", "Bande");
    binding.setEmployee(employee);
    return view;
  }

  private void initViews(final View view) {
    view.findViewById(R.id.btnChange).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String age = ((EditText) view.findViewById(R.id.etAge)).getText().toString();
        if (!isEmpty(age)) {
          employee.setAge(Integer.parseInt(age));
        } else {
          Snackbar.make(view, "Please enter valid age", Snackbar.LENGTH_LONG).show();
        }
      }
    });
  }
}
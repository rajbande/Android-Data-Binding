package com.techteam.databinding.ui.fragments;

import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techteam.databinding.R;
import com.techteam.databinding.adapters.RecyclerViewAdapter;
import com.techteam.databinding.ui.ClickCallback;
import com.techteam.databinding.viewmodels.RecyclerItem;
import com.techteam.databinding.viewmodels.ViewModel;


public class RecyclerViewFragment extends Fragment implements ClickCallback {

  private View view;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.recycler_view, container, false);

    ObservableArrayList<RecyclerItem> list = addItems();
    populateList(list);

    /**
     * Nothing much to see in this class. All the magic is inside RecyclerViewAdapter and ViewModel.
     */

    return view;
  }

  private void populateList(ObservableArrayList<RecyclerItem> recyclerItems) {
    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

    RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, recyclerItems);

    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.setAdapter(recyclerViewAdapter);

    /**
     * Use the following line if your data is not known in advance.
     * e.g. Your data is populated on a Network call, then use another constructor provided for
     * adapter and use the following line.
     *
     * recyclerViewAdapter.updateData(recyclerItems);
     */
  }

  private ObservableArrayList<RecyclerItem> addItems() {
    ObservableArrayList<RecyclerItem> list = new ObservableArrayList<>();

    for (int i = 0; i < 50; i++) {
      RecyclerItem item = new RecyclerItem("Clickable Item "+i);
      list.add(item);
    }
    return list;
  }


  @Override
  public void performClickAction(ViewModel viewModel) {
    Snackbar.make(view, "Item clicked: "+((RecyclerItem)viewModel).getTextValue(), Snackbar.LENGTH_SHORT).show();
  }
}
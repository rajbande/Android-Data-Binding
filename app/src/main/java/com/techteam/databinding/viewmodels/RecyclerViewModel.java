package com.techteam.databinding.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.List;

public class RecyclerViewModel extends BaseObservable{
  @Bindable
  public List<RecyclerItem> items;

  public RecyclerViewModel(List<RecyclerItem> items) {
    this.items = items;
  }

  @Bindable
  public List<RecyclerItem> getItems() {
    return items;
  }

  public void setItems(List<RecyclerItem> items) {
    this.items = items;
  }
}

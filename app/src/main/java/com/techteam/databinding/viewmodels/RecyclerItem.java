package com.techteam.databinding.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.techteam.databinding.BR;
import com.techteam.databinding.R;

public class RecyclerItem extends BaseObservable implements ViewModel {
  @Bindable
  private String textValue;

  public RecyclerItem(String textValue) {
    this.textValue = textValue;
  }

  public String getTextValue() {
    return textValue;
  }

  @Override
  public int layoutResId() {
    return R.layout.recycler_view_item;
  }

  @Override
  public int dataBindingVariable() {
    return BR.item;
  }
}

package com.techteam.databinding.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techteam.databinding.ui.ClickCallback;
import com.techteam.databinding.viewmodels.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
  List<? extends ViewModel> viewModelList;
  private ClickCallback clickCallback;

  public RecyclerViewAdapter() {
    this.viewModelList = new ArrayList<>();
  }

  public RecyclerViewAdapter(ClickCallback clickCallback) {
    this.clickCallback = clickCallback;
    this.viewModelList = new ArrayList<>();
  }

  public RecyclerViewAdapter(ClickCallback clickCallback, List<? extends ViewModel> viewModelList) {
    this.clickCallback = clickCallback;
    this.viewModelList = viewModelList;
  }

  public void updateData(List<? extends ViewModel> viewModels) {
    viewModelList = viewModels;
  }

  @Override
  public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int position) {
    ViewModel viewModel = viewModelList.get(position);
    ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewModel.layoutResId(), parent, false);
    return new RecyclerViewHolder(binding);
  }

  @Override
  public void onBindViewHolder(RecyclerViewHolder holder, int position) {

    ViewModel viewModel = viewModelList.get(position);
    holder.bind(viewModel);
  }

  @Override
  public int getItemCount() {
    return viewModelList.size();
  }

  @Override
  public int getItemViewType(int position) {
    return position;
  }

  public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private ViewDataBinding binding;

    public RecyclerViewHolder(ViewDataBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    public void bind(final ViewModel viewModel) {
      binding.setVariable(viewModel.dataBindingVariable(), viewModel);
      binding.executePendingBindings();
      setItemClickListener(viewModel);
    }

    private void setItemClickListener(final ViewModel viewModel) {
      itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          if (clickCallback != null) {
            clickCallback.performClickAction(viewModel);
          }
        }
      });
    }
  }
}

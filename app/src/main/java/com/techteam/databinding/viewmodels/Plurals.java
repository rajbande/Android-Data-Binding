package com.techteam.databinding.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.techteam.databinding.BR;

import static android.text.TextUtils.isEmpty;

public class Plurals extends BaseObservable{
  private String cars = "1";
  private String firstName = "Raj";
  private String lastName = "Bande";

  public Plurals(String cars) {
    this.cars = cars;
  }

  @Bindable
  public String getCars() {
    if (!isEmpty(cars)) {
      return cars;
    }
    return "0";
  }

  public void setCars(String cars) {
    if (!isEmpty(cars)) {
      this.cars = cars;
      notifyPropertyChanged(BR.cars);
    }
  }

  @Bindable
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
    notifyPropertyChanged(BR.firstName);
  }

  @Bindable
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
    notifyPropertyChanged(BR.lastName);
  }
}

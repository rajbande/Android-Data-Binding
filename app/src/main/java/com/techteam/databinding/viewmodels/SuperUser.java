package com.techteam.databinding.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.techteam.databinding.BR;

public class SuperUser extends BaseObservable{
  private String firstName;
  private String lastName;

  /**
   * Observe that this class extends BaseObservable.
   * So if the value of the fields change here, to reflect that on the xml, you call
   * notifyPropertyChanged method in the setters below.
   *
   */
  public SuperUser(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
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
    notifyPropertyChanged(BR.lastName);
    this.lastName = lastName;
  }
}

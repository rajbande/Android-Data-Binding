package com.techteam.databinding.viewmodels;

public class User{
  public String firstName;
  public String lastName;

  /**
   * Observe that this class just has two fields first and last name and this class does not extend BaseObservable.
   * That's it. You don't have to do anything. Whenever you change the value of firstName and lastName in the code,
   * it will auto reflect on xml.
   */
  public User(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
}

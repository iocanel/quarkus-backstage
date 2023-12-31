package io.quarkus.backstage.model;

import io.sundr.builder.VisitableBuilder;
public class UserBuilder extends UserFluent<UserBuilder> implements VisitableBuilder<User,UserBuilder>{
  public UserBuilder() {
    this.fluent = this;
  }
  
  public UserBuilder(UserFluent<?> fluent) {
    this.fluent = fluent;
  }
  
  public UserBuilder(UserFluent<?> fluent,User instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }
  
  public UserBuilder(User instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  UserFluent<?> fluent;
  
  public User build() {
    User buildable = new User(fluent.getKind(),fluent.getApiVersion(),fluent.buildSpec());
    return buildable;
  }
  

}
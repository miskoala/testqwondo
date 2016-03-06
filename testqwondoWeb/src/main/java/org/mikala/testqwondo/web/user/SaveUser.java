package org.mikala.testqwondo.web.user;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.mikala.testqwondo.api.model.User;
import org.mikala.testqwondo.spring.services.UserManagerService;

@ManagedBean
@SessionScoped
public class SaveUser {
  
  @ManagedProperty("#{userManagerService}")
  private UserManagerService userManagerService;
  private User user;
  
  public String save() {
    userManagerService.saveUser(user);
    FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage("Użytkownik "+this.user.getName()+" zapisany"));
    return "";
}
  /**
   * @return the userManagerService
   */
  public UserManagerService getUserManagerService() {
    return userManagerService;
  }
  /**
   * @param userManagerService the userManagerService to set
   */
  public void setUserManagerService(UserManagerService userManagerService) {
    this.userManagerService = userManagerService;
  }
  /**
   * @return the user
   */
  public User getUser() {
    return user;
  }
  /**
   * @param user the user to set
   */
  public void setUser(User user) {
    this.user = user;
  }
  
}

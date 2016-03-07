package org.mikala.testqwondo.web.user;

import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringEscapeUtils;
import org.mikala.testqwondo.api.model.User;
import org.mikala.testqwondo.spring.services.UserManagerService;
import org.springframework.transaction.TransactionSystemException;

@ManagedBean
@RequestScoped
public class SaveUser implements Serializable{
  
  private static final long serialVersionUID = -4553028967702703470L;

  @ManagedProperty("#{userManagerService}")
  private UserManagerService userManagerService;
  private User user;
  
  public String save() {
	try {
		userManagerService.saveUser(user);	
	} catch (TransactionSystemException e) {
		if(e instanceof TransactionSystemException) {
		Throwable ae = e.getApplicationException();
		if(ae instanceof SQLException){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					("Błąd zapisu bazy danych"),(ae.getMessage()));
			FacesContext.getCurrentInstance().addMessage(null,msg);
			return "";
			
		}
		}
	} catch (SQLException e) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				StringEscapeUtils.escapeHtml4(e.getMessage()),StringEscapeUtils.escapeHtml4(e.getMessage()));
		FacesContext.getCurrentInstance().addMessage(null,msg);
		return "";
	}
    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Użytkownik "+this.user.getName()+" zapisany"));
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
    if(user==null) user=new User();
    return user;
  }
  /**
   * @param user the user to set
   */
  public void setUser(User user) {
    this.user = user;
  }
  
}

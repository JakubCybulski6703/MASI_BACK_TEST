package masi_green.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the application_user database table.
 * 
 */
@Entity
@Table(name="application_user")
@NamedQuery(name="ApplicationUser.findAll", query="SELECT a FROM ApplicationUser a")
public class ApplicationUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Boolean active;

	@Column(name="add_date")
	private Timestamp addDate;

	@Column(name="last_modified")
	private Timestamp lastModified;

	private String login;

	private String name;

	private String password;

	private String surname;

	private String email;

	//bi-directional many-to-one association to UserType
	@ManyToOne
	@JoinColumn(name="user_type_id")
	private UserType userType;

	//bi-directional many-to-one association to UserSession
	@OneToMany(mappedBy="applicationUser")
	private List<UserSession> userSessions;

	public ApplicationUser() {
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Timestamp getAddDate() {
		return this.addDate;
	}

	public void setAddDate(Timestamp addDate) {
		this.addDate = addDate;
	}

	public Timestamp getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return this.userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public List<UserSession> getUserSessions() {
		return this.userSessions;
	}

	public void setUserSessions(List<UserSession> userSessions) {
		this.userSessions = userSessions;
	}

	public UserSession addUserSession(UserSession userSession) {
		getUserSessions().add(userSession);
		userSession.setApplicationUser(this);

		return userSession;
	}

	public UserSession removeUserSession(UserSession userSession) {
		getUserSessions().remove(userSession);
		userSession.setApplicationUser(null);

		return userSession;
	}

}

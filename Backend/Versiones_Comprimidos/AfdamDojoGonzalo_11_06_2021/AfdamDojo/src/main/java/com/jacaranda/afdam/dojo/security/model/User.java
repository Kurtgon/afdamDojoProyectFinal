package com.jacaranda.afdam.dojo.security.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jacaranda.afdam.dojo.security.model.enums.UserRole;

@Entity
public class User implements UserDetails {

	// Atributos

	@Id
	@GeneratedValue
	private int id;

	@Column(unique = true)
	private String username;

	private String password;

	@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	private Set<UserRole> roles;

	@CreatedDate
	private LocalDateTime createTime;

	@UpdateTimestamp
	private LocalDateTime updateTime;

	private LocalDateTime deleteTime;

	private LocalDateTime lastPasswordChange;

	private boolean locked;

	private boolean enabled;

	private Integer authenticationAttempts;

	private LocalDateTime passwordPolicyExpDate;

	private static final long serialVersionUID = -5609680583163446168L;

	private static final int MAX_AUTH_ATTEMPTS = 3;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream().map(ur -> new SimpleGrantedAuthority("ROLE_" + ur.name())).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.getDeleteTime() == null;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.getAuthenticationAttempts() < MAX_AUTH_ATTEMPTS;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.getLastPasswordChange().isBefore(this.passwordPolicyExpDate);
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	public boolean isLocked() {
		return locked;
	}

	// Get y Set

	public LocalDateTime getDeleteTime() {
		return deleteTime;
	}

	public Integer getAuthenticationAttempts() {
		return authenticationAttempts;
	}

	public LocalDateTime getLastPasswordChange() {
		return lastPasswordChange;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public void setDeleteTime(LocalDateTime deleteTime) {
		this.deleteTime = deleteTime;
	}

	public void setLastPasswordChange(LocalDateTime lastPasswordChange) {
		this.lastPasswordChange = lastPasswordChange;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public void setAuthenticationAttempts(Integer authenticationAttempts) {
		this.authenticationAttempts = authenticationAttempts;
	}

	public LocalDateTime getPasswordPolicyExpDate() {
		return passwordPolicyExpDate;
	}

	public void setPasswordPolicyExpDate(LocalDateTime passwordPolicyExpDate) {
		this.passwordPolicyExpDate = passwordPolicyExpDate;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}

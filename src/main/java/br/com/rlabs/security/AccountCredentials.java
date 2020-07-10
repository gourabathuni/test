package br.com.rlabs.security;

/**
 * The Account Credentials.
 * 
 * @author Ryan Padilha <ryan.padilha@gmail.com>
 * @since 0.1
 *
 */
public class AccountCredentials {

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AccountCredentials [username=" + username + ", password=" + password + "]";
	}

}

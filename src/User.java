import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
	private String name;
	private String id;
	private String passwordHash;
	
	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPassword(String password) {
		this.passwordHash = this.hashPassword(password);
	}
	
	public boolean login(String password) {
	    String hashedInput = hashPassword(password);
	    return hashedInput.equals(this.passwordHash);
	}
	
	private String hashPassword(String password) {
	    try {
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hashBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
	        // Convert byte array to hex string
	        StringBuilder hexString = new StringBuilder();
	        for (byte b : hashBytes) {
	            hexString.append(String.format("%02x", b));
	        }
	        return hexString.toString();
	    } catch (NoSuchAlgorithmException e) {
	        throw new RuntimeException("Error hashing password", e);
	    }
	}
}

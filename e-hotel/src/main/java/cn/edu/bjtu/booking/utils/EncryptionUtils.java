package cn.edu.bjtu.booking.utils;

public class EncryptionUtils {
	
	public static String hashpassword(String pwd)
	{
		return BCrypt.hashpw(pwd, BCrypt.gensalt());
	}
	
	public static Boolean CheckPwd(String pwd, String hashed)
	{
		return BCrypt.checkpw(pwd, hashed);
	}
}

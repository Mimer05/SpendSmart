
package Backend;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
public class PasswordSecurity {
    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 256;
    
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";
    
    public static byte[] generateSalt(){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }
    
    public static String hashPassword(String password, byte[] salt){
        try{
        PBEKeySpec spec = new PBEKeySpec(
                                        password.toCharArray(),
                                        salt,
                                        ITERATIONS,
                                        KEY_LENGTH);  
        
       SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
       byte[] hash = skf.generateSecret(spec).getEncoded();
       return Base64.getEncoder().encodeToString(hash);
       }
       catch(NoSuchAlgorithmException eAlgo){
          return eAlgo.getMessage();
       }
       catch(InvalidKeySpecException eInvalid){
           return eInvalid.getMessage();
       }
        
    }
    
    public static boolean verifyPassword(String inputPassword, byte[] storedSalt, String storedHash) {
        String newHash = hashPassword(inputPassword, storedSalt);
        return newHash.equals(storedHash);
        
    }
    
}

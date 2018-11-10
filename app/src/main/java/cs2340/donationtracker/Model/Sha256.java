package cs2340.donationtracker.Model;

// This source from http://blog.kindler.io/java-encrypt/


import java.security.MessageDigest;

/**
 * implementation of encryption of a String with the system SHA256.
 */
@SuppressWarnings("ALL")
public class Sha256 {
    /**
     * This method encrypts a String with the system SHA256.
     * @param planText a string which will be encrypted.
     * @return a encrypted String
     */
    @SuppressWarnings("MagicNumber")
    public static String encrypt(String planText) {
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(planText.getBytes());
            byte byteData[] = md.digest();

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

            StringBuffer hexString = new StringBuffer();
            for (int i=0;i<byteData.length;i++) {
                String hex=Integer.toHexString(0xff & byteData[i]);
                if(hex.length()==1){
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}

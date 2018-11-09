package cs2340.donationtracker.Model;

// This source from http://blog.kindler.io/java-encrypt/


import java.security.MessageDigest;

@SuppressWarnings({"MagicNumber", "UtilityClass", "ChainedMethodCall", "ForLoopReplaceableByForEach", "StringBufferMayBeStringBuilder"})
public class Sha256 {   // this class encrypt a String with the system SHA256.
    public static String encrypt(String planText) {
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(planText.getBytes());
            byte byteData[] = md.digest();

            StringBuffer sb = new StringBuffer();
            int numberOfTrailingBits = 0xff;
            int bitBuffer = 0x100;
            int radix = 16;
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & numberOfTrailingBits) + bitBuffer, radix).substring(1));
            }

            StringBuffer hexString = new StringBuffer();
            for (int i=0;i<byteData.length;i++) {
                String hex=Integer.toHexString(byteData[i] & numberOfTrailingBits);
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

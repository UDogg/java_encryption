import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner; // Import statement for Scanner

public class FileEncryptor {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to encrypt or decrypt a file? (encrypt/decrypt)");
        String mode = scanner.nextLine();

        System.out.println("Enter the path to the input file:");
        String inputFile = scanner.nextLine();

        System.out.println("Enter the path to the output file:");
        String outputFile = scanner.nextLine();

        try {
            // Generate a secret AES key
            SecretKeySpec secretKey = generateSecretKey(128);

            // For CBC mode, an IV is necessary
            byte[] iv = new byte[16];
            new SecureRandom().nextBytes(iv);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

            if (mode.equalsIgnoreCase("encrypt")) {
                encrypt(secretKey, ivParameterSpec, inputFile, outputFile);
                System.out.println("Encryption completed successfully.");
            } else if (mode.equalsIgnoreCase("decrypt")) {
                decrypt(secretKey, ivParameterSpec, inputFile, outputFile);
                System.out.println("Decryption completed successfully.");
            } else {
                System.out.println("Invalid mode. Use 'encrypt' or 'decrypt'.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close(); // Close the scanner to prevent resource leaks
        }
    }

       public static SecretKeySpec generateSecretKey(int keySize) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(keySize);
        return new SecretKeySpec(keyGenerator.generateKey().getEncoded(), ALGORITHM);
    }

    public static void encrypt(SecretKeySpec secretKey, IvParameterSpec iv, String inputFile, String outputFile) throws Exception {
        doCrypto(Cipher.ENCRYPT_MODE, secretKey, iv, inputFile, outputFile);
    }

    public static void decrypt(SecretKeySpec secretKey, IvParameterSpec iv, String inputFile, String outputFile) throws Exception {
        doCrypto(Cipher.DECRYPT_MODE, secretKey, iv, inputFile, outputFile);
    }

    private static void doCrypto(int cipherMode, SecretKeySpec secretKey, IvParameterSpec iv, String inputFile, String outputFile) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(cipherMode, secretKey, iv);

        FileInputStream inputStream = new FileInputStream(inputFile);
        byte[] inputBytes = new byte[(int) inputFile.length()];
        inputStream.read(inputBytes);

        byte[] outputBytes = cipher.doFinal(inputBytes);

        FileOutputStream outputStream = new FileOutputStream(outputFile);
        outputStream.write(outputBytes);

        inputStream.close();
        outputStream.close();
    }
}
}

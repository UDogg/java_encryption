# java_encryption
This repository contains java source code on how to encrypt a file using AES.

# 🛡️ File Encryptor 🛡️

File Encryptor is a simple yet powerful Java command-line application that allows users to 🎩 encrypt or 🔓 decrypt files using the AES encryption algorithm with CBC mode and PKCS5 Padding. The application generates a random AES key and IV for each session, ensuring that encryption is secure and unique every time.

## 🌟 Features

- Encrypt files using AES/CBC/PKCS5Padding. 📁➡️🔒
- Decrypt files using the same algorithm and key. 🔓➡️📂
- Generate a random secret key for each encryption/decryption session. 🔑
- Use a random IV (Initialization Vector) for CBC mode. 🔄

## 📚 Requirements

- Java Runtime Environment (JRE) 8 or above. ☕

## 🛠 Compilation

Navigate to the directory containing the file and run the following command to compile `FileEncryptor.java`:

```bash
javac FileEncryptor.java
```  

This generates a FileEncryptor.class bytecode file executable on the Java Virtual Machine (JVM).

## 🚀 Running the Application

Execute the application with Java:  

```bash
java FileEncryptor
```


You'll be prompted for:

- **Mode**: Encrypt or decrypt a file? (🎩 encrypt / 🔓 decrypt)
- **Input File Path**: Path to your target file. 📂
- **Output File Path**: Where to save the output. 💾

## 🎭 Example Usage

### Encrypting a file:

Do you want to encrypt or decrypt a file? (encrypt/decrypt)  
encrypt  
Enter the path to the input file:  
/path/to/input.txt  
Enter the path to the output file:  
/path/to/output.enc  
Encryption completed successfully.  

### Decrypting a file:

Do you want to encrypt or decrypt a file? (encrypt/decrypt)  
decrypt  
Enter the path to the input file:  
/path/to/output.enc  
Enter the path to the output file:  
/path/to/decrypted.txt  
Decryption completed successfully.  


## 📖 Java javax.crypto Documentation Links

- Overview of javax.crypto package: Java Cryptography Architecture (JCA) Reference Guide
- Cipher class: Cipher (Java Platform SE 8)
- SecretKeySpec class: SecretKeySpec (Java Platform SE 8)
- IvParameterSpec class: IvParameterSpec (Java Platform SE 8)

## ⚠ Limitations

The secret key and IV are generated randomly for each session and are not stored, making future decryption without them impossible.










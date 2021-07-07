package kr.pe.gbpark.util;

import org.springframework.stereotype.Component;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.util.Base64;

@Component
public class GbpCrypt {

	public static String encryptAES256(String msg, String key) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidParameterSpecException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
		SecureRandom random = new SecureRandom();
		byte[] bytes = new byte[20];
		random.nextBytes(bytes);

		// Password-Based Key Derivation function 2
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		// 70000번 해시하여 256 bit 길이의 키를 만든다.
		PBEKeySpec spec = new PBEKeySpec(key.toCharArray(), bytes, 70000, 256);

		SecretKey secretKey = factory.generateSecret(spec);
		SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), "AES");

		// 알고리즘/모드/패딩
		// CBC : Cipher Block Chaining Mode
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secret);
		AlgorithmParameters params = cipher.getParameters();
		// Initial Vector(1단계 암호화 블록용)
		byte[] ivBytes = params.getParameterSpec(IvParameterSpec.class).getIV();

		byte[] encryptedTextBytes = cipher.doFinal(msg.getBytes("UTF-8"));

		byte[] buffer = new byte[bytes.length + ivBytes.length + encryptedTextBytes.length];
		System.arraycopy(bytes, 0, buffer, 0, bytes.length);
		System.arraycopy(ivBytes, 0, buffer, bytes.length, ivBytes.length);
		System.arraycopy(encryptedTextBytes, 0, buffer, bytes.length + ivBytes.length, encryptedTextBytes.length);

		return Base64.getEncoder().encodeToString(buffer);
	}

	public static String decryptAES256(String msg, String key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		ByteBuffer buffer = ByteBuffer.wrap(Base64.getDecoder().decode(msg));

		byte[] saltBytes = new byte[20];
		buffer.get(saltBytes, 0, saltBytes.length);
		byte[] ivBytes = new byte[cipher.getBlockSize()];
		buffer.get(ivBytes, 0, ivBytes.length);
		byte[] encryptedTextBytes = new byte[buffer.capacity() - saltBytes.length - ivBytes.length];
		buffer.get(encryptedTextBytes);

		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		PBEKeySpec spec = new PBEKeySpec(key.toCharArray(), saltBytes, 70000, 256);

		SecretKey secretKey = factory.generateSecret(spec);
		SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), "AES");

		cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(ivBytes));

		byte[] decryptedTextBytes = cipher.doFinal(encryptedTextBytes);
		return new String(decryptedTextBytes);
	}

	public String oneWayCrypt(String id, String pw) {
		String result = pw;
		int i = 0;
		do {
			if (i % 2 == 0) {
				result = oneCycle(id, result);
			} else {
				result = oneCycle(result, id);
			}
			i++;
		} while (i != 10000);
		result += "==";
		return result;
	}

	private String oneCycle(String string1, String string2) {
		String result = "";
		try {
			result = sha256(crossString(string1,string2));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return result;
	}

	private String sha256(String msg)  throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(msg.getBytes());
		return byteToHexString(md.digest());
	}

	private String byteToHexString(byte[] data) {
		StringBuilder sb = new StringBuilder();
		for(byte b : data) {
			sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

	public String crossString(String string1, String string2) {
		StringBuilder resultBuilder = new StringBuilder();
		String str1, str2;
		if((string1.length() + string2.length()) % 2 == 1) {
			str1 = string1;
			str2 = string2;
		}else{
			str1 = string2;
			str2 = string1;
		}

		int index = 0;
		int length1 = str1.length();
		int length2 = str2.length();
		int maxlength = Math.max(length1, length2);

		do {
			resultBuilder.append(str1.charAt(index % length1)).append(str2.charAt(index % length2));
			index++;
		} while(index != maxlength);

		return  resultBuilder.toString();
	}
}

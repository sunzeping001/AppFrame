package com.szp.app.frame.utils;

import android.util.Base64;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by sunzeping on 17/9/14.
 * Function : 3des encode and decode
 * Desc :
 */

public class DESEncroyTool {

	/***
	 * 解密方式
	 ***/
	private static final String ENCRYPTION_MANNER = "DESede";

	private static final String SHA1PRNG = "SHA1PRNG";//// SHA1PRNG 强随机种子算法, 要区别4.2以上版本的调用方法

	/**
	 * 生成随机数，可以当做动态的密钥 加密和解密的密钥必须一致，不然将不能解密
	 *
	 * @return
	 */
	public static byte[] generateKey() {
		try {
			SecureRandom localSecureRandom = SecureRandom.getInstance(SHA1PRNG);
			byte[] bytes_key = new byte[24];
			localSecureRandom.nextBytes(bytes_key);
			return bytes_key;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 3DES加密
	 *
	 * @param data 加密数据
	 * @param key  加密密码
	 * @return
	 * @throws Exception
	 */
	public static String encrypt3DES(byte[] data, byte[] key) throws Exception {
		// 恢复密钥
		SecretKey secretKey = new SecretKeySpec(key, ENCRYPTION_MANNER);
		// Cipher完成加密
		Cipher cipher = Cipher.getInstance(ENCRYPTION_MANNER);
		// cipher初始化
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encrypt = cipher.doFinal(data);
		//转码
		return new String(Base64.encode(encrypt, Base64.DEFAULT), "UTF-8");
	}


	/**
	 * 3DES解密
	 *
	 * @param data 加密后的字符串
	 * @param key  加密密码
	 * @return
	 * @throws Exception
	 */
	public static String decrypt3DES(String data, byte[] key) throws Exception {
		// 恢复密钥
		SecretKey secretKey = new SecretKeySpec(key, ENCRYPTION_MANNER);
		// Cipher完成解密
		Cipher cipher = Cipher.getInstance(ENCRYPTION_MANNER);
		// 初始化cipher
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		//转码
		byte[] bytes = Base64.decode(data.getBytes("UTF-8"), Base64.DEFAULT);
		//解密
		byte[] plain = cipher.doFinal(bytes);
		//解密结果转码
		return new String(plain, "utf-8");
	}

}

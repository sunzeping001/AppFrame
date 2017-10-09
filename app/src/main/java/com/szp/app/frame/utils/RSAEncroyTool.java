package com.szp.app.frame.utils;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

/**
 * Created by sunzeping on 17/9/30.
 * Function : rsa encroy
 * Desc :
 */
public class RSAEncroyTool {

	public static final String RSA = "RSA";// 非对称加密密钥算法
	public static final String ECB_PKCS1_PADDING = "RSA/ECB/PKCS1Padding";//加密填充方式
	public static final int DEFAULT_KEY_SIZE = 2048;//秘钥默认长度
	public static final byte[] DEFAULT_SPLIT = "#PART#".getBytes();    // 当要加密的内容超过bufferSize，则采用partSplit进行分块加密
	public static final int DEFAULT_BUFFERSIZE = (DEFAULT_KEY_SIZE / 8) - 11;// 当前秘钥支持加密的最大字节数

	/**
	 * 随机生成RSA密钥对
	 *
	 * @param keyLength 密钥长度，范围：512～2048
	 *                  一般1024
	 * @return
	 */
	public static KeyPair generateRSAKeyPair(int keyLength) {
		try {
			KeyPairGenerator kpg = KeyPairGenerator.getInstance(RSA);
			kpg.initialize(keyLength);
			return kpg.genKeyPair();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 用公钥对字符串进行加密
	 *
	 * @param data 原文
	 */
	public static byte[] encryptByPublicKey(byte[] data, byte[] publicKey) throws Exception {
		// 得到公钥
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKey);
		KeyFactory kf = KeyFactory.getInstance(RSA);
		PublicKey keyPublic = kf.generatePublic(keySpec);
		// 加密数据
		Cipher cp = Cipher.getInstance(ECB_PKCS1_PADDING);
		cp.init(Cipher.ENCRYPT_MODE, keyPublic);
		return cp.doFinal(data);
	}

	/**
	 * 使用私钥进行解密
	 */
	public static byte[] decryptByPrivateKey(byte[] encrypted, byte[] privateKey) throws Exception {
		// 得到私钥
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKey);
		KeyFactory kf = KeyFactory.getInstance(RSA);
		PrivateKey keyPrivate = kf.generatePrivate(keySpec);
		// 解密数据
		Cipher cp = Cipher.getInstance(ECB_PKCS1_PADDING);
		cp.init(Cipher.DECRYPT_MODE, keyPrivate);
		byte[] arr = cp.doFinal(encrypted);
		return arr;
	}

}

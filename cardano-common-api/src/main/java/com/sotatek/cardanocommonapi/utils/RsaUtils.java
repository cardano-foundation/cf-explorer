package com.sotatek.cardanocommonapi.utils;

import com.sotatek.cardanocommonapi.exceptions.BusinessException;
import com.sotatek.cardanocommonapi.exceptions.enums.CommonErrorCode;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RsaUtils {

  /*
   * @author: phuc.nguyen5
   * @since: 11/11/2022
   * description: Parse Private Key from file path
   * @update:
   */
  public static PrivateKey getPrivateKey(String filename) {
    byte[] bytes = readFile(filename);
    return getPrivateKey(bytes);
  }

  /*
   * @author: phuc.nguyen5
   * @since: 11/11/2022
   * description: Parse Private Key from byte
   * @update:
   */
  public static PrivateKey getPrivateKey(byte[] bytes) {
    bytes = Base64.getDecoder().decode(bytes);
    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytes);
    try {
      KeyFactory factory = KeyFactory.getInstance("RSA");
      return factory.generatePrivate(spec);
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
      throw new BusinessException(CommonErrorCode.UNKNOWN_ERROR);
    }
  }

  /*
   * @author: phuc.nguyen5
   * @since: 11/11/2022
   * description: Parse Public Key from file path
   * @update:
   */
  public static PublicKey getPublicKey(String filename) {
    byte[] bytes = readFile(filename);
    return getPublicKey(bytes);
  }

  /*
   * @author: phuc.nguyen5
   * @since: 11/11/2022
   * description: Parse Public Key from byte
   * @update:
   */
  public static PublicKey getPublicKey(byte[] bytes) {
    bytes = Base64.getDecoder().decode(bytes);
    X509EncodedKeySpec spec = new X509EncodedKeySpec(bytes);
    try {
      KeyFactory factory = KeyFactory.getInstance("RSA");
      return factory.generatePublic(spec);
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
      throw new BusinessException(CommonErrorCode.UNKNOWN_ERROR);
    }
  }

  /*
   * @author: phuc.nguyen5
   * @since: 11/11/2022
   * description: read file from resource
   * @update:
   */
  private static byte[] readFile(String filename) {
    try {
      InputStream resourceAsStream = RsaUtils.class.getResourceAsStream(filename);
      assert resourceAsStream != null;
      return resourceAsStream.readAllBytes();
    } catch (IOException e) {
      throw new BusinessException(CommonErrorCode.UNKNOWN_ERROR);
    }
  }
}

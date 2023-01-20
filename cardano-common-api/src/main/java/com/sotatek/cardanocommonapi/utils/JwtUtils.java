package com.sotatek.cardanocommonapi.utils;

import com.sotatek.cardanocommonapi.exceptions.BusinessException;
import com.sotatek.cardanocommonapi.exceptions.enums.CommonErrorCode;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import java.security.PublicKey;
import javax.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.util.StringUtils;

@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwtUtils {

  /*
   * @author: phuc.nguyen5
   * @since: 11/11/2022
   * description: get username from token with rsa public key
   * @update:
   */
  public static String getUserNameFromJwtToken(String token, PublicKey publicKey) {
    return Jwts.parserBuilder().setSigningKey(publicKey).build().parseClaimsJws(token).getBody()
        .getSubject();
  }

  /*
   * @author: phuc.nguyen5
   * @since: 11/11/2022
   * description: get wallet from token with rsa public key
   * @update:
   */
  public static String getWalletIdFromJwtToken(String token, PublicKey publicKey) {
    return Jwts.parserBuilder().setSigningKey(publicKey).build().parseClaimsJws(token).getBody()
        .getId();
  }

  /*
   * @author: phuc.nguyen5
   * @since: 11/11/2022
   * description: parse token from header request
   * @update:
   */
  public static String parseJwt(HttpServletRequest request) {
    final String headerAuthentication = request.getHeader("Authorization");

    if (StringUtils.hasText(headerAuthentication) && headerAuthentication.startsWith("Bearer ")) {
      return headerAuthentication.substring(7);
    }
    return null;
  }

  /*
   * @author: phuc.nguyen5
   * @since: 11/11/2022
   * description: validate token with rsa public key
   * @update:
   */
  public static void validateJwtToken(String token, PublicKey publicKey) {
    try {
      Jwts.parserBuilder().setSigningKey(publicKey).build().parseClaimsJws(token);
    } catch (SignatureException e) {
      log.error("Invalid JWT signature: {}", e.getMessage());
      throw new BusinessException(CommonErrorCode.TOKEN_INVALID_SIGNATURE);
    } catch (MalformedJwtException e) {
      log.error("Invalid JWT token: {}", e.getMessage());
      throw new BusinessException(CommonErrorCode.INVALID_TOKEN);
    } catch (ExpiredJwtException e) {
      log.error("JWT token is expired: {}", e.getMessage());
      throw new BusinessException(CommonErrorCode.TOKEN_EXPIRED);
    } catch (UnsupportedJwtException e) {
      log.error("JWT token is unsupported: {}", e.getMessage());
      throw new BusinessException(CommonErrorCode.TOKEN_UNSUPPORTED);
    } catch (IllegalArgumentException e) {
      log.error("JWT claims string is empty: {}", e.getMessage());
      throw new BusinessException(CommonErrorCode.TOKEN_IS_NOT_EMPTY);
    }
  }
}

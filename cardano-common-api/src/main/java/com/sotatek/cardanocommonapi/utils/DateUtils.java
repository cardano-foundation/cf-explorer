package com.sotatek.cardanocommonapi.utils;

import com.sotatek.cardanocommonapi.exceptions.BusinessException;
import com.sotatek.cardanocommonapi.exceptions.enums.CommonErrorCode;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtils {

  /*
   * @author: phuc.nguyen5
   * @since: 16/11/2022
   * description: format time(millisecond) to string
   * @update:
   */
  public static String formatTimeToDayHourMinute(Long milliSeconds) {
    if (Objects.isNull(milliSeconds)) {
      throw new BusinessException(CommonErrorCode.PARAM_IS_NOT_NULL);
    }
    long day = TimeUnit.MILLISECONDS.toDays(milliSeconds);
    Long dayMillis = TimeUnit.DAYS.toMillis(day);
    long hourOfDay = milliSeconds - dayMillis;
    long hour = TimeUnit.MILLISECONDS.toHours(hourOfDay);
    long hourMillis = TimeUnit.HOURS.toMillis(hour);
    long minuteOfHour = hourOfDay - hourMillis;
    long minute = TimeUnit.MILLISECONDS.toMinutes(minuteOfHour);
    return "End in " + day + " days " + hour + " hours " + minute + " minutes ";
  }
}

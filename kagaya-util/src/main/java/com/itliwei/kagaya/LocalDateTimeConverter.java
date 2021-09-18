package com.itliwei.kagaya;

import org.jooq.Converter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class LocalDateTimeConverter implements Converter<LocalDateTime, Long> {
  @Override
  public Long from(LocalDateTime localDateTime) {
    if (localDateTime == null) {
      return null;
    }
    return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
  }

  @Override
  public LocalDateTime to(Long aLong) {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(aLong), ZoneId.systemDefault());
  }

  @Override
  public Class<LocalDateTime> fromType() {
    return LocalDateTime.class;
  }

  @Override
  public Class<Long> toType() {
    return Long.class;
  }
}

package com.itliwei.kagaya.enums;


public interface IEnum {
  static <T extends IEnum> T findById(int value, Class<T> clz) throws IllegalArgumentException {
    for (T item : clz.getEnumConstants()) {
      if (item.getId() == value) {
        return item;
      }
    }

    throw new IllegalArgumentException("Invalid Enum, id: " + value + " type: " + clz.getName());
  }

  static <T extends IEnum> T findByIdWithNull(int value, Class<T> clz)
      throws IllegalArgumentException {
    for (T item : clz.getEnumConstants()) {
      if (item.getId() == value) {
        return item;
      }
    }
    return null;
  }

  static <T extends IEnum> T findByIdWithDefault(int value, Class<T> clz, T defaultValue)
      throws IllegalArgumentException {
    for (T item : clz.getEnumConstants()) {
      if (item.getId() == value) {
        return item;
      }
    }
    return defaultValue;
  }

  static <T extends IEnum> T findByName(String name, Class<T> clz) throws IllegalArgumentException {
    for (T item : clz.getEnumConstants()) {
      if (item.getName().equals(name)) {
        return item;
      }
    }
    throw new IllegalArgumentException("Invalid Enum, name: " + name + " type: " + clz.getName());
  }

  int getId();

  String getName();
}

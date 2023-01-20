package com.sotatek.cardano.common.enumeration.converter;

import com.sotatek.cardano.common.enumeration.ScriptType;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ScriptTypeConverter implements AttributeConverter<ScriptType, String> {

  @Override
  public String convertToDatabaseColumn(ScriptType attribute) {
    return attribute.getValue();
  }

  @Override
  public ScriptType convertToEntityAttribute(String dbData) {
    return ScriptType.fromValue(dbData);
  }
}

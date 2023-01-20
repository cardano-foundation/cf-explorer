package com.sotatek.cardano.common.enumeration.converter;


import com.sotatek.cardano.common.enumeration.ScriptPurposeType;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ScriptPurposeTypeConverter implements AttributeConverter<ScriptPurposeType, String> {

  @Override
  public String convertToDatabaseColumn(ScriptPurposeType attribute) {
    return attribute.getValue();
  }

  @Override
  public ScriptPurposeType convertToEntityAttribute(String dbData) {
    return ScriptPurposeType.fromValue(dbData);
  }
}

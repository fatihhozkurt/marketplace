package com.fatih.marketplace.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.stereotype.Component;

@Component
@Converter
public class JasyptAttributeConverter implements AttributeConverter<String, String> {

    private static StringEncryptor encryptor;

    public void setEncryptor(StringEncryptor encryptor) {
        JasyptAttributeConverter.encryptor = encryptor;
    }

    @Override
    public String convertToDatabaseColumn(String attribute) {
        if (attribute == null) return null;
        return encryptor.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        return encryptor.decrypt(dbData);
    }
}
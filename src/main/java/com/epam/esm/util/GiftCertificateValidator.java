package com.epam.esm.util;

import com.epam.esm.model.entity.GiftCertificate;

public class GiftCertificateValidator {
    private static final String FORBIDDEN_CHARACTERS = "<>?@#&";
    private static final int MAX_NAME_LENGTH = 100;
    private static final int MAX_DESCRIPTION_LENGTH = 1000;
    private static final int MAX_PRICE = 500;
    private static final int ZERO = 0;
    private static final int MAX_DURATION = 10000;

    public boolean validateCertificate(GiftCertificate certificate) {
        return validateDescription(certificate.getDescription()) && validateDuration(certificate.getDuration())
                && validateName(certificate.getName()) && validatePrice(certificate.getPrice());
    }

    private boolean validateName(String name) {
        return name.length() > ZERO && name.length() < MAX_NAME_LENGTH && !name.contains(FORBIDDEN_CHARACTERS);
    }

    private boolean validateDescription(String description) {
        return description.length() > ZERO && description.length() < MAX_DESCRIPTION_LENGTH
                && !description.contains(FORBIDDEN_CHARACTERS);
    }

    private boolean validatePrice(double price) {
        return price > ZERO && price < MAX_PRICE;
    }

    private boolean validateDuration(int duration) {
        return duration > ZERO && duration < MAX_DURATION;
    }

}

package com.lazareva.phonebook.provider;

import com.lazareva.phonebook.model.PhoneDataModel;

import java.util.Optional;

public interface PhoneDataProvider {
    PhoneDataModel findByNumber(String number);

    PhoneDataModel save(PhoneDataModel model);

    void update(PhoneDataModel phoneDataModel);
}

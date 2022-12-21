package com.lazareva.phonebook.provider.impl;

import com.lazareva.phonebook.jpa.entity.DescriptionEntity;
import com.lazareva.phonebook.jpa.entity.PhoneDataEntity;
import com.lazareva.phonebook.jpa.repositories.DescriptionRepository;
import com.lazareva.phonebook.jpa.repositories.PhoneDataRepository;
import com.lazareva.phonebook.mapper.Mapper;
import com.lazareva.phonebook.model.PhoneDataModel;
import com.lazareva.phonebook.exception.PhoneDataNotFoundException;
import com.lazareva.phonebook.util.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JPAPhoneDataProvider implements com.lazareva.phonebook.provider.PhoneDataProvider {

    private final PhoneDataRepository phoneDataRepository;

    private final Mapper<PhoneDataEntity, PhoneDataModel> mapper;


    @Override
    public PhoneDataModel findByNumber(String number) {
        return mapper.toModel(phoneDataRepository.findById(number).orElseThrow(PhoneDataNotFoundException::new));

    }

    @Override
    public PhoneDataModel save(PhoneDataModel phoneDataModel) {
        PhoneDataEntity phoneDataEntity = mapper.toEntity(phoneDataModel);
        return mapper.toModel(phoneDataEntity);
    }

    @Override
    public void update(PhoneDataModel phoneDataModel) {
        if (!phoneDataRepository.findById(phoneDataModel.getNumber()).isPresent()) {
            throw new RuntimeException("Only existing phone number. It doesn't have phone number");
        }
     phoneDataRepository.save(mapper.toEntity(phoneDataModel));

    }



}

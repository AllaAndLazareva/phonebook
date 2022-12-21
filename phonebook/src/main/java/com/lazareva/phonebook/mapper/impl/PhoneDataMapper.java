package com.lazareva.phonebook.mapper.impl;

import com.lazareva.phonebook.jpa.entity.DescriptionEntity;
import com.lazareva.phonebook.jpa.entity.PhoneDataEntity;
import com.lazareva.phonebook.jpa.repositories.DescriptionRepository;
import com.lazareva.phonebook.jpa.repositories.PhoneDataRepository;
import com.lazareva.phonebook.mapper.Mapper;
import com.lazareva.phonebook.model.DescriptionModel;
import com.lazareva.phonebook.model.PhoneDataModel;
import com.lazareva.phonebook.util.Group;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PhoneDataMapper implements Mapper<PhoneDataEntity, PhoneDataModel> {

    @Getter
    private final DescriptionRepository descriptionRepository;
    private final PhoneDataRepository phoneDataRepository;

    @Override
    public PhoneDataEntity toEntity(PhoneDataModel phoneDataModel) {
        List<String> descriptions = phoneDataModel.getDescriptions();
        PhoneDataEntity phoneDataEntity = null;
        if (phoneDataRepository.findById(phoneDataModel.getNumber()).isPresent()) {
            phoneDataEntity = phoneDataRepository.findById(phoneDataModel.getNumber()).get();
            phoneDataEntity.setGroup(Group.fromString(phoneDataModel.getGroup()));
            setDescriptionEntityToListDescriptions(descriptions, phoneDataEntity);
            phoneDataRepository.save(phoneDataEntity);
            return phoneDataEntity;
        } else {

            phoneDataEntity = new PhoneDataEntity();
            phoneDataEntity.setNumber(phoneDataModel.getNumber());
            phoneDataEntity.setGroup(Group.fromString(phoneDataModel.getGroup()));
            setDescriptionEntityToListDescriptions(descriptions, phoneDataEntity);
            phoneDataRepository.save(phoneDataEntity);
            return phoneDataEntity;
        }

    }


    @Override
    public PhoneDataModel toModel(PhoneDataEntity phoneDataEntity) {
        PhoneDataModel model = new PhoneDataModel();
        model.setNumber(phoneDataEntity.getNumber());
        model.setGroup(phoneDataEntity.getGroup().name());//??????????
        List<String> descriptions = phoneDataEntity.getDescriptions()
                .stream()
                .map(DescriptionEntity::getDescription)
                .collect(Collectors.toList());
        model.setDescriptions(descriptions);
        return model;
    }


    public void setDescriptionEntityToListDescriptions(List<String> descriptions, PhoneDataEntity phoneDataEntity) {
        DescriptionEntity descriptionEntity = new DescriptionEntity();
        for (int i = 0; i < descriptions.size(); i++) {
            descriptionEntity.setDescription(descriptions.get(i));
            descriptionRepository.save(descriptionEntity);
            phoneDataEntity.addDescriptions(descriptionEntity);
        }


    }
}

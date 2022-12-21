package com.lazareva.phonebook.mapper.impl;

import com.lazareva.phonebook.jpa.entity.DescriptionEntity;
import com.lazareva.phonebook.jpa.repositories.DescriptionRepository;
import com.lazareva.phonebook.jpa.repositories.PhoneDataRepository;
import com.lazareva.phonebook.mapper.Mapper;
import com.lazareva.phonebook.model.DescriptionModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DescriptionMapper implements Mapper<DescriptionEntity, DescriptionModel> {

    private PhoneDataRepository repository;
    private final DescriptionRepository descriptionRepository;

    @Override
    public DescriptionEntity toEntity(DescriptionModel model) {
        DescriptionEntity descriptionEntity=descriptionRepository.findById(model.getId()).get();
        descriptionEntity.setDescription(model.getDescription());
        return descriptionEntity;
    }

    @Override
    public DescriptionModel toModel(DescriptionEntity descriptionEntity) {
        DescriptionModel model=new DescriptionModel();
        model.setDescription(descriptionEntity.getDescription());
        return model;
    }
}

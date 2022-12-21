package com.lazareva.phonebook.provider.impl;

import com.lazareva.phonebook.jpa.entity.DescriptionEntity;
import com.lazareva.phonebook.jpa.repositories.DescriptionRepository;
import com.lazareva.phonebook.mapper.Mapper;
import com.lazareva.phonebook.model.DescriptionModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JPADescriptionProvider implements com.lazareva.phonebook.provider.DescriptionProvider {

   private final Mapper<DescriptionEntity, DescriptionModel> mapper;
   private final DescriptionRepository repository;




    @Override
    public void update(DescriptionModel model) {
        if(model.getId()==null){
            throw new RuntimeException("Only existing description. This description doesn't have id.");
        }
        repository.save(mapper.toEntity(model));


    }
}

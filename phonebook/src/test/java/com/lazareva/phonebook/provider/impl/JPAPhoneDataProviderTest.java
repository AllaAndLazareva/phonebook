package com.lazareva.phonebook.provider.impl;

import com.lazareva.phonebook.jpa.entity.PhoneDataEntity;
import com.lazareva.phonebook.jpa.repositories.PhoneDataRepository;
import com.lazareva.phonebook.mapper.Mapper;
import com.lazareva.phonebook.model.PhoneDataModel;
import com.lazareva.phonebook.provider.PhoneDataProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class JPAPhoneDataProviderTest {

    private final String NUMBER="+375333541195";
    @Mock
    private PhoneDataRepository phoneDataRepository;
    @Mock
    private Mapper<PhoneDataEntity, PhoneDataModel> mapper;
    @InjectMocks
    private PhoneDataProvider provider;

    @Test
    void findByNumber() {
//        Mockito.doReturn(new PhoneDataModel()).when(phoneDataRepository)
//                .findById(NUMBER);
//
//        var actualResult = provider.findByNumber(NUMBER);

//        Assertions.assertEquals();
//        Assertions.assertTrue(actualResult.isP);



    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }
}
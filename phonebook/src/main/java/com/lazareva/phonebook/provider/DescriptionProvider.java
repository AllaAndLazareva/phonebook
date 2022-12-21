package com.lazareva.phonebook.provider;

import com.lazareva.phonebook.jpa.entity.DescriptionEntity;
import com.lazareva.phonebook.model.DescriptionModel;

import java.util.Optional;

public interface DescriptionProvider {



   void update(DescriptionModel model);
}

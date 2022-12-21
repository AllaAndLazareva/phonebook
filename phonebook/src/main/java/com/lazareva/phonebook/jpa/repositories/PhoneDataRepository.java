package com.lazareva.phonebook.jpa.repositories;


import com.lazareva.phonebook.jpa.entity.PhoneDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneDataRepository extends JpaRepository<PhoneDataEntity, String> {


}

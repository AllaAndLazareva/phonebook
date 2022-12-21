package com.lazareva.phonebook.jpa.repositories;

import com.lazareva.phonebook.jpa.entity.DescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DescriptionRepository extends JpaRepository<DescriptionEntity, String> {

    Optional<DescriptionEntity> findDescriptionEntityByDescription(String description);
}

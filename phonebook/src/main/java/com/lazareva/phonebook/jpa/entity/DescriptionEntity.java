package com.lazareva.phonebook.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "description")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DescriptionEntity {

    @Id
    @Column (name = "id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "description")
    private String description;







}

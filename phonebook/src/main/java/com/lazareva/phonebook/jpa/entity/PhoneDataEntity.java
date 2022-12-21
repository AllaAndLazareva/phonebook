package com.lazareva.phonebook.jpa.entity;

import com.lazareva.phonebook.model.PhoneDataModel;
import com.lazareva.phonebook.util.Group;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;


import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "phone_data")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDataEntity {

    @Id
    @Column(name = "number")
    @Pattern(regexp = "^(\\+375)\\d{9}$", message = "Phone number is +375.........")
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name="`group`")  //enum
    private Group group;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
   @JoinTable(name = "phone_number_description", joinColumns = @JoinColumn(name = "phone_number"),
           inverseJoinColumns = @JoinColumn(name = "descriptions"))
    @Column(name = "descriptions")
    private List<DescriptionEntity> descriptions;


    public void addDescriptions(DescriptionEntity descriptionEntity){
        if(descriptions==null){
            descriptions= Arrays.asList(descriptionEntity);
            }
        else {
            descriptions.add(descriptionEntity);
            }
        }


    }






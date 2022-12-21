package com.lazareva.phonebook.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PhoneDataModel {

    private String number;
    private String group;
    private List<String> descriptions;
}

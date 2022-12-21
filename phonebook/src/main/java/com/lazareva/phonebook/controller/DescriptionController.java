package com.lazareva.phonebook.controller;

import com.lazareva.phonebook.model.DescriptionModel;
import com.lazareva.phonebook.provider.DescriptionProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/desc")
public class DescriptionController {

private final DescriptionProvider provider;


@PatchMapping
public void update(@RequestBody DescriptionModel model){
    provider.update(model);
}
}

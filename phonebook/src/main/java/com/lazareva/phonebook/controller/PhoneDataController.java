package com.lazareva.phonebook.controller;

import com.lazareva.phonebook.model.PhoneDataModel;
import com.lazareva.phonebook.provider.PhoneDataProvider;
import com.lazareva.phonebook.exception.PhoneDataErrorResponse;
import com.lazareva.phonebook.exception.PhoneDataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phone")
@RequiredArgsConstructor
public class PhoneDataController {

    private final PhoneDataProvider provider;

    @GetMapping(value = "/{number}")
    public ResponseEntity<PhoneDataModel> findByNumber(@PathVariable("number") String number){
        return ResponseEntity.ok(provider.findByNumber(number));
    }

    @PostMapping
    public ResponseEntity<PhoneDataModel> save(@RequestBody PhoneDataModel model){
        return ResponseEntity.ok(provider.save(model));
    }

    @PatchMapping
    public void update(@RequestBody PhoneDataModel model){
        provider.update(model);
    }

    @ExceptionHandler
    private ResponseEntity<PhoneDataErrorResponse> handleException(PhoneDataNotFoundException e){
        PhoneDataErrorResponse response=new PhoneDataErrorResponse("Phone number doesn't exist!");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}

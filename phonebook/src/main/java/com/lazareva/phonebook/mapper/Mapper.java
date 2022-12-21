package com.lazareva.phonebook.mapper;

public interface Mapper <Entity, Model>{

   Entity toEntity (Model model);

   Model toModel (Entity entity);

}

package com.example.backend.module;
//import org.springframework.data.annotation.Id;

public record Todo (

    //@Id need spring web for this?????
   String id, //uuid?
   String description,
   String status
   ){}
//{
//    public Todo(String id, String description, String status) {
//        this.id = id;
//        this.description = description;
//        this.status = "OPEN";
//    }
//}

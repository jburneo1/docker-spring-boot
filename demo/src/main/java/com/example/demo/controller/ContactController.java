package com.example.demo.controller;

import com.example.demo.exception.ModelNotFoundException;
import com.example.demo.model.Contact;
import com.example.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public ResponseEntity<List<Contact>> listar(){
        List<Contact> lista = contactService.listar();
        return new ResponseEntity<List<Contact>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> listarPorId(@PathVariable("id") Long id){
        Contact obj = contactService.leerPorId(id);
        if(obj.getIdContact() == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO " + id);
        }
        return new ResponseEntity<Contact>(obj, HttpStatus.OK);
    }

    @PostMapping("/save")
    public long save(@RequestBody Contact contact) {
        contactService.save(contact);
        return contact.getIdContact();
    }


}

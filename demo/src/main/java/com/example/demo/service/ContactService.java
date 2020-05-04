package com.example.demo.service;

import com.example.demo.model.Contact;
import com.example.demo.repository.IContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private IContact dao;

    public Contact save(Contact t) {
        return dao.save(t);
    }

    public Contact modificar(Contact t) {
        return dao.save(t);
    }

    public List<Contact> listar() {
        return dao.findAll();
    }

    public Contact leerPorId(Long idContact) {
        Optional<Contact> op = dao.findById(idContact);
        return op.isPresent() ? op.get() : new Contact();
    }

}

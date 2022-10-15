package com.example.application.data.service;

import com.example.application.data.entity.Company;
import com.example.application.data.entity.Contact;
import com.example.application.data.entity.Status;
import com.example.application.data.repository.CompanyRepository;
import com.example.application.data.repository.ContactRepository;
import com.example.application.data.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrmService {

    private final CompanyRepository companyRepository;
    private final StatusRepository statusRepository;
    private final ContactRepository contactRepository;

    public CrmService(CompanyRepository companyRepository, StatusRepository statusRepository, ContactRepository contactRepository) {
        this.companyRepository = companyRepository;
        this.statusRepository = statusRepository;
        this.contactRepository = contactRepository;
    }

    public List<Contact> findAllContacts(String stringFilter) {
        if (stringFilter == null || stringFilter.isEmpty()) {
            return contactRepository.findAll();
        } else return contactRepository.search(stringFilter);
    }

    public long countContacts(){
        return contactRepository.count();
    }

    public void saveContacts(Contact contact){
        if(contact==null){
            System.err.println("Contact is null. Are you sure you are connected to the form?");
            return;
        }
        contactRepository.save(contact);
    }

    public List<Company> findAllCompanies(){
        return  companyRepository.findAll();
    }

    public List<Status> findAllStatuses(){
      return statusRepository.findAll();
    }
}


package com.telnet.orep.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telnet.orep.dao.DocumentDao;
import com.telnet.orep.entities.Document;


@Service
public class DocumentService {
	@Autowired
	DocumentDao document;
	public Document save(Document doc)
	{
		return document.save(doc);
		}
}

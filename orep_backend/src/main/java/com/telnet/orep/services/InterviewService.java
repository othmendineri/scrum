package com.telnet.orep.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telnet.orep.dao.InterviewDao;
import com.telnet.orep.entities.Interview;
@Service
public class InterviewService {
	@Autowired
	InterviewDao interviewDao;
	
	public Interview save(Interview interview ) {
		return interviewDao.save(interview);
		
	}
	
	public List<Interview> getinterview()
	{
		
		return interviewDao.findAll();
		}

}

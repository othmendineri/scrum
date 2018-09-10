package com.telnet.orep.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.telnet.orep.dao.JobDao;
import com.telnet.orep.entities.Job;



@Service
public class JobService {
	@Autowired
	JobDao jobRepository;
	public Job save(Job job)
	{
		return jobRepository.save(job);}


public Job update(Job job)
{
	return jobRepository.save(job);}

public Optional<Job> find(Long id) {
	return jobRepository.findById(id);
}

public List<Job> getJobs()
{ return jobRepository.findAll();
	}

	

public boolean delete(Long id) {
	 jobRepository.deleteById(id);
	 return true;
}
}






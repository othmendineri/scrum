package com.telnet.orep.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telnet.orep.dao.JobCategoryDao;
import com.telnet.orep.entities.JobCategory;



@Service
public class JobCategoryService {

	@Autowired
	JobCategoryDao jobCategoryRepository;
	
	public JobCategory save(JobCategory jobCategory)
	{
		return jobCategoryRepository.save(jobCategory);}


public JobCategory update(JobCategory jobCategory)
{
	return jobCategoryRepository.save(jobCategory);}

public Optional<JobCategory> find(Long id) {
	return jobCategoryRepository.findById(id);
}

public List<JobCategory> getJobCategories()
{ return jobCategoryRepository.findAll();
	}

	

public boolean delete(Long id) {
	 jobCategoryRepository.deleteById(id);
	 return true;
}
}










	

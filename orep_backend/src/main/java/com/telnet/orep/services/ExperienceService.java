package com.telnet.orep.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telnet.orep.dao.ExperienceDao;
import com.telnet.orep.entities.Experience;


@Service
public class ExperienceService {
	@Autowired
ExperienceDao experiences;
	
	public Experience save(Experience experience)
	{
		return experiences.save(experience);
		}
public List<Experience> getexperience()
{
	
	return experiences.findAll();
	}
}

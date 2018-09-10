package com.telnet.orep.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telnet.orep.dao.PhaseDao;
import com.telnet.orep.entities.Phase;
@Service
public class PhaseService {
	@Autowired
	PhaseDao phaseRepository;
	public Phase save(Phase phase)
	{
		return phaseRepository.save(phase);}


public Phase update(Phase phase)
{
	return phaseRepository.save(phase);}

public Optional<Phase> find(Long id) {
	return phaseRepository.findById(id);
}

public List<Phase> getPhases()
{ return phaseRepository.findAll();
	}

	

public boolean delete(Long id) {
	phaseRepository.deleteById(id);
	 return true;
}

}

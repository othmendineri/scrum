package com.telnet.orep.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telnet.orep.dao.JobProposalDao;
import com.telnet.orep.entities.JobProposal;

@Service
public class JobProposalService {

	
	@Autowired
	JobProposalDao jobProposalRepository;
	public JobProposal save(JobProposal jobProposal)
	{
		return jobProposalRepository.save(jobProposal);}


public JobProposal update(JobProposal jobProposal)
{
	return jobProposalRepository.save(jobProposal);}

public Optional<JobProposal> find(Long id) {
	return jobProposalRepository.findById(id);
}

public List<JobProposal> getJobsProposal()
{ return jobProposalRepository.findAll();
	}

public List<JobProposal> getJobEmbauche()
{ return jobProposalRepository.findjob();
	}
public List<JobProposal> getJobStage()
{ return jobProposalRepository.findstage();
	}

public boolean delete(Long id) {
	 jobProposalRepository.deleteById(id);
	 return true;
}
public JobProposal findId(Long id) {
return 	jobProposalRepository.findId(id);
}
public List<JobProposal> orderedList()
{ return jobProposalRepository.orderedList();
	}

}










	
package com.careerlink.EasyApply.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.careerlink.EasyApply.dao.JobRepository;
import com.careerlink.EasyApply.entity.Job;
import com.careerlink.EasyApply.service.JobService;


@Service
public class JobServiceIMPL   implements  JobService{
	@Autowired
	JobRepository repo;

	@Override
	public Job addjob(String role, Job job) {
		if(!role.equals("ADMIN")) {
			throw new RuntimeException("only admin can add job"); 
		}
		
		Job savedjob =repo.save(job);
		
		return savedjob;
	}

	@Override
	public List<Job> getJobsAll() {
		List<Job> jobs=	repo.findAll();
		
		return jobs;
	}

	@Override
	public Job getJobById(Long id) {
	Job job = 	repo.findById(id).get();
		
	
		
		return job;
	}
	
	

	@Override
	public Job updateJob(String role, Long id, Job job) {
		if(!role.equals("ADMIN")) {
			throw new RuntimeException("only admin can update"); 
		}
		
	   Job existingdata =	repo.findById(id).get();
	   existingdata.setCompanyName(job.getCompanyName());
	   existingdata.setDiscription(job.getDiscription());
	   existingdata.setLocation(job.getLocation());
	   
	 Job updatedjob=  repo.save(existingdata);
		
		return updatedjob	;
	}

	@Override
	public String deleteJob(String role, Long id) {
		if(!role.equals("ADMIN")) {
			throw new RuntimeException("only admin can update"); 
		}
		
		repo.deleteById(id);
		
		
		
		return "job deleated";
	}

}

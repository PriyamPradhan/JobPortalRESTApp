package com.priyam.jobportalwithrest.service;

import com.priyam.jobportalwithrest.model.JobPost;
import com.priyam.jobportalwithrest.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public void addJob(JobPost jobPost){
        jobRepo.addJobPost(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return jobRepo.getAllJobPosts();
    }

    public JobPost getJob(int i) {

        return jobRepo.getJob(i);
    }

    public void updateJob(JobPost jobPost) {
        jobRepo.updateJobPost(jobPost);
    }

    public void deleteJob(int postId) {
        jobRepo.deletePost(postId);
    }
}

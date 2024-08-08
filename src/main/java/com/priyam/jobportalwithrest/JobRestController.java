package com.priyam.jobportalwithrest;

import com.priyam.jobportalwithrest.model.JobPost;
import com.priyam.jobportalwithrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")       //when we need to connect to frontend
public class JobRestController {

    @Autowired
    private JobService jobService;

    //fetch data from server | produces = "application/xml" -> result will only be in json format, likewise we can use "application/xml"
    @GetMapping(path ="jobPosts", produces = "application/json")
    @ResponseBody
    public List<JobPost> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    @ResponseBody
    public JobPost getJob(@PathVariable("postId") int postId){
        return jobService.getJob(postId);
    }



    //send data to server | consumes = "application/json" -> client can only send json format, xml format will be rejected
    @PostMapping(path = "jobPosts", consumes = "application/json")
    public JobPost addJob(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }


    //update data in server
    @PutMapping("jobPosts")
    public void updateJob(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);
    }

    //delete data form server
    @DeleteMapping("jobPosts/{postId}")
    public String deleteJob(@PathVariable("postId") int postId){
        jobService.deleteJob(postId);
        return "Job deleted";
    }

    //inserted default data
    @GetMapping("load")
    public String loadData(){
        jobService.load();
        return "Data loaded successfully";
    }



}

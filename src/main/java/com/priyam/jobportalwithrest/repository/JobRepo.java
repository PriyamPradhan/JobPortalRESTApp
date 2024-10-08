package com.priyam.jobportalwithrest.repository;

import com.priyam.jobportalwithrest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

    public List<JobPost> findByPostProfileContainingOrPostDescContaining(String PostProfile, String PostDesc);

}














//List<JobPost> jobOpening = new ArrayList<>();
//
//public JobRepo(){
//
//    jobOpening.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
//            List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));
//    jobOpening.add(new JobPost(2, "React Developer", "Must have good experience in core Java and advanced Java", 2,
//            List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));
//    jobOpening.add(new JobPost(3, "SpringBoot Developer", "Must have good experience in core Java and advanced Java", 2,
//            List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));
//}
//
//public List<JobPost> getAllJobPosts() {
//    return jobOpening;
//}
//
//public void addJobPost(JobPost jobPost) {
//    jobOpening.add(jobPost);
//    System.out.println(jobOpening);
//}
//
//public JobPost getJob(int postId) {
//
//    for (JobPost job : jobOpening) {
//        if (job.getPostId() == postId)
//            return job;
//
//    }
//    return null;
//}
//
//public void updateJobPost(JobPost jobPost) {
//    for (JobPost job : jobOpening) {
//        if (job.getPostId() == jobPost.getPostId()){
//            job.setPostProfile(jobPost.getPostProfile());
//            job.setPostDesc(jobPost.getPostDesc());
//            job.setPostTechStack(jobPost.getPostTechStack());
//            job.setReqExperience(jobPost.getReqExperience());
//        }
//    }
//}
//
//public void deletePost(int postId) {
//    for(JobPost jobPost : jobOpening){
//        if(jobPost.getPostId() == postId){
//            jobOpening.remove(jobPost);
//        }
//    }
//}
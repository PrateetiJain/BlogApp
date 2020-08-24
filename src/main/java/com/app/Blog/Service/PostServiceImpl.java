package com.app.Blog.Service;

import com.app.Blog.Model.Post;
import com.app.Blog.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;


    @Override
    public void deletePost(Post post) {
         this.postRepository.delete(post);
    }

    @Override
    public List<Post> getAllPostByDate(Date date) {
        return this.postRepository.getAllByDate(date);
    }

    @Override
    public List<Post> getAllPostById(List<Long> listPostId) {

        return this.postRepository.findAllById(listPostId);
    }

    @Override
    public Post getPostById(Long postId){
        return this.postRepository.findAllById(postId);
    }

    @Override
    public void savePost(Post post) {
        this.postRepository.save(post);
    }



    @Override
    public Page<Post> findPage(String keyword, int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo-1,pageSize,sort);
        if(keyword != null){
            return postRepository.findAllByKeyword(keyword,pageable);
        }
        return  this.postRepository.findAll(pageable);
    }
}

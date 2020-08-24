package com.app.Blog.Service;

import com.app.Blog.Model.Post;
import com.app.Blog.Model.Tags;
import com.app.Blog.Repository.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagsServiceImpl implements TagsService {

    @Autowired
    private TagsRepository tagsRepository;

    @Override
    public void saveTags(Tags tags) {
        this.tagsRepository.save(tags);
    }

    @Override
    public List<Tags> findAll() {
        return this.tagsRepository.findAll();
    }

    @Override
    public List<Post> findAllByTagsName(String searchValue) {
        List<Tags> listTags = findAll();
        List<Post> listPostId = new ArrayList<>();
        for(int i=0;i<listTags.size();i++){
            String[] arr  =  listTags.get(i).getTagName().split(",");
            for(int j=0;j<arr.length;j++){
                if(arr[j].equalsIgnoreCase(searchValue)){
                   listPostId = listTags.get(i).getPost();
                }
            }
        }
        listPostId = listTags.get(0).getPost();
        return listPostId ;
    }
}

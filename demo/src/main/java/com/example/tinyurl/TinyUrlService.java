package com.example.tinyurl;

import com.example.tinyurl.entity.TinyUrlEntity;
import com.example.tinyurl.models.TinyUrl;
import com.example.tinyurl.repository.TinyUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TinyUrlService {

    @Autowired
    TinyUrlRepository repository;

    @Transactional
    public TinyUrl insertUrl(TinyUrl urlInputObj){
        TinyUrl urlResponse = null;
        try {
            TinyUrlEntity url = new TinyUrlEntity();
            url.setUrlId(2);
            url.setTinyUrl(urlInputObj.getTinyUrl());
            url.setActualUrl(urlInputObj.getActualUrl());
            url.setCreatedTimeStamp(new Date());
            url.setCreatedBy("Admin");
            TinyUrlEntity responseObj  = repository.save(url);
            if(responseObj != null){
                urlResponse = new TinyUrl(responseObj.getId(), responseObj.getUrlId(), responseObj.getTinyUrl(), responseObj.getActualUrl());

            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return urlResponse;
    }

    @Transactional
    public TinyUrl updateUrl(TinyUrl urlInputObj){
        TinyUrl urlResponse = null;
        try {
            TinyUrlEntity url = new TinyUrlEntity();
            url.setId(urlInputObj.getId());
            url.setUrlId(urlInputObj.getUrlId());
            url.setTinyUrl(urlInputObj.getTinyUrl());
            url.setActualUrl(urlInputObj.getActualUrl());
            url.setUpdatedTimeStamp(new Date());
            url.setUpdatedBy("Admin");
            TinyUrlEntity responseObj  = repository.save(url);
            if(responseObj != null){
                urlResponse = new TinyUrl(responseObj.getId(), responseObj.getUrlId(), responseObj.getTinyUrl(), responseObj.getActualUrl());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return urlResponse;
    }

    @Transactional
    public TinyUrl deleteUrl(long rowId){
        try {
            TinyUrlEntity url = new TinyUrlEntity();
            url.setId(rowId);
            repository.delete(url);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return new TinyUrl(rowId, 0, null, null);
    }

    @Transactional
    public TinyUrl getUrl(long rowId){
        TinyUrl urlResponse = null;
        try {
            Optional responseObj  = repository.findById(rowId);
            if(responseObj != null){
                TinyUrlEntity response = (TinyUrlEntity)responseObj.get();
                urlResponse = new TinyUrl(response.getId(), response.getUrlId(), response.getTinyUrl(), response.getActualUrl());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return urlResponse;
    }

    @Transactional
    public List<TinyUrl> getAllUrls(){
        List<TinyUrl> urlResponse = null;
        try {
            List<TinyUrlEntity> responseList  = repository.findAll();
            urlResponse = responseList.stream()
                    .map(obj -> new TinyUrl(obj.getId(), obj.getUrlId(), obj.getTinyUrl(), obj.getActualUrl()))
                    .collect(Collectors.toList());
        }catch(Exception e){
            e.printStackTrace();
        }
        return urlResponse;
    }

    public TinyUrlRepository getRepository() {
        return repository;
    }

    public void setRepository(TinyUrlRepository repository) {
        this.repository = repository;
    }
}

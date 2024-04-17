package com.example.myweb.repos;

import com.example.myweb.model.News;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepos extends CrudRepository <News, Long> {

}

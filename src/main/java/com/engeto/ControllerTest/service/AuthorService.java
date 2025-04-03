package com.engeto.ControllerTest.service;

import com.engeto.ControllerTest.model.Author;
import com.engeto.ControllerTest.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.getAll();

    }

    public Optional<Author> getAuthorById(Integer id) {
        return authorRepository.findById(id);
    }
}

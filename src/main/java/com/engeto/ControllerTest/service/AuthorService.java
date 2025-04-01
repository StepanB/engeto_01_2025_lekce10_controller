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
        List<Author> out = jdbcTemplate.query("select * from authors;", new RowMapper<Author>() {
            @Override
            public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
                Author author = new Author();
                author.setId(rs.getInt("id"));
                author.setFirstName(rs.getString("first_name"));
                author.setLastName(rs.getString("last_name"));

                return author;
            }
        });

        return out;

    }

    public Optional<Author> getAuthorById(Integer id) {
        return authorRepository.findById(id);
    }
}

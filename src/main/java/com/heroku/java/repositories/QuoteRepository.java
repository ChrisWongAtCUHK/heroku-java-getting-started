package com.heroku.java.repositories;

import com.heroku.java.models.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// can add new funcs like finding quotes with particular word
@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {

    @Query("SELECT q FROM Quote q WHERE q.quote LIKE %?1%")
    List<Quote> getContainingQuote(String word);     // dont need to define method bc in repository
}

// select quote0_.quoteID as quoteid1_0_, quote0_.quote_string as quote_st2_0_ from quotes quote0_
// jql java query language spring data turns into objects
// sql injection cannot happen in jql
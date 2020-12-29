package com.example.service;

import com.example.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.repository.CountryRepository;

@Service
public class CountryService extends AbstractService<Country, Integer> {

  private final CountryRepository countryRepository;

  public CountryService(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }


  @Override
  protected JpaRepository<Country, Integer> getRepository() {
    return countryRepository;
  }

}

package com.lucas.service.service;

import com.lucas.service.mapper.CountryMapper;

import com.zpark.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Lucas
 * @Date 2019/12/17 14:16
 * @Version 1.0
 */
@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryMapper countryMapper;

    @Override
    public List<Country> queryAll() {
        return countryMapper.selectAll();
    }
}

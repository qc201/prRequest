package com.qchen.pr_form.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qchen.pr_form.entity.Reporter;
import com.qchen.pr_form.repository.ReporterRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class ReporterServiceImpl implements ReporterService{

    ReporterRepository reporterRepository;
    @Override
    public Reporter getReporter(Long id) {
         return reporterRepository.findById(id).get();
    }

    @Override
    public Reporter saveReporter(Reporter reporter) {
        return reporterRepository.save(reporter);
    }

    @Override
    public List<Reporter> getReporters() {
        return (List<Reporter>) reporterRepository.findAll();
    }

    @Override
    public void deleteReporter(Long id) {
        reporterRepository.deleteById(id);
        
    }
}

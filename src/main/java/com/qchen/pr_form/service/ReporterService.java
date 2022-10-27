package com.qchen.pr_form.service;

import java.util.List;

import com.qchen.pr_form.entity.Reporter;

public interface ReporterService {
    Reporter getReporter(Long id);
    Reporter saveReporter(Reporter reporter);
    void deleteReporter(Long id);
    List<Reporter> getReporters();
}

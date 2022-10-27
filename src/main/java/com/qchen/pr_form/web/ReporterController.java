package com.qchen.pr_form.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qchen.pr_form.entity.Reporter;
import com.qchen.pr_form.service.ReporterService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/reporter")
@AllArgsConstructor
public class ReporterController {
    ReporterService reporterService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Reporter> getReporger(@PathVariable Long id) {
        return new ResponseEntity<>(reporterService.getReporter(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reporter> saveReporter(@RequestBody Reporter reporter) {
        return new ResponseEntity<>(reporterService.saveReporter(reporter), HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Reporter>> getReporters() {
        return new ResponseEntity<>(reporterService.getReporters(), HttpStatus.OK);
    }
   
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteReporter(@PathVariable Long id) {
        reporterService.deleteReporter(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
    
    
}

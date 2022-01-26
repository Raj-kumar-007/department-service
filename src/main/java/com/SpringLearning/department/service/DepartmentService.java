package com.SpringLearning.department.service;

import com.SpringLearning.department.entity.Department;
import com.SpringLearning.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside the saveDepartment function in DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside the findDepartmentById function in DepartmentService");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}

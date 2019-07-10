package andy.zero.service;

import andy.one.entity.Employee;
import andy.one.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;


    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    EntityManager entityManager;

    public long add(String name) {
        Employee entity = new Employee();
        entity.setName(name);
        repo.save(entity);

        long id = entity.getId();
        if (id <= 0)
            throw new RuntimeException("添加员工失败");

        return id;
    }


    public List<Employee> findByNameLike(String pattern) {
        return repo.findByNameLike(pattern);
    }
}

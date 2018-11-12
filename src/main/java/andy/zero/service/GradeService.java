package andy.zero.service;

import andy.zero.entity.Grade;
import andy.zero.repo.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    GradeRepository repo;

    public long add(String name) {
        Grade entity = new Grade();
        entity.setName(name);
        repo.save(entity);

        long id = entity.getId();
        if (id <= 0)
            throw new RuntimeException("添加班级失败");

        return id;
    }


    public List<Grade> findByNameLike(String pattern) {
        return repo.findByNameLike(pattern);
    }
}

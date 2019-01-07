package andy.zero.service;

import andy.zero.entity.Grade;
import andy.zero.repo.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    org.springframework.aop.framework.DefaultAopProxyFactory defaultAopProxyFactory;
    private GradeRepository repo;

    /**
     * 该set方法用于方便观察调试 GradeRepository 的注入对象
     * @param repo
     */
    @Autowired
    public void setGradeRepository(GradeRepository repo){
        this.repo=repo;
    }

    @Transactional
    @Override
    public long add(String name) {
        Grade entity = new Grade();
        entity.setName(name);
        repo.save(entity);

        long id = entity.getId();
        if (id <= 0)
            throw new RuntimeException("添加班级失败");

        return id;
    }

    @Override
    public List<Grade> findByNameLike(String pattern) {
        return repo.findByNameLike(pattern);
    }

}

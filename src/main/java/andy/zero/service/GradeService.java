package andy.zero.service;

import andy.zero.entity.Grade;

import java.util.List;


public interface GradeService {
    long add(String name);

    List<Grade> findByNameLike(String pattern);
}

package com.example.practice.teacher;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/*@Service
public class teacherDAOImpl{
    @Autowired
    teacherDAO teacherDAO;


    public List<teacherDTO> getTeachers() {
        return teacherDAO.getTeachers();
    }


    public void insertTeacher(teacherDTO teacher) {

    }
}
*/
@Component
public class teacherDAOImpl implements teacherDAO{
    protected static final String namespace = "com.example.practice.teacher.teacherDAOImpl.";
    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<teacherDTO> getTeachers(){
        return sqlSession.selectList(namespace+"getTeachers");
    }

    @Override
    public void insertTeacher(teacherDTO teacher) {
        sqlSession.insert(namespace+"insertTeacher",teacher);
    }
}
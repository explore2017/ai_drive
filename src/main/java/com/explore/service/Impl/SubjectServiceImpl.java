package com.explore.service.Impl;


import com.explore.common.ServerResponse;
import com.explore.dao.SubjectMapper;
import com.explore.pojo.Subject;
import com.explore.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements ISubjectService {

    @Autowired
    SubjectMapper subjectMapper;

    @Override
    public ServerResponse addSubject(Subject subject) {
        int count = subjectMapper.insertSelective(subject);
        if(count==1)
            return ServerResponse.createBySuccessMessage("增加成功");
        return ServerResponse.createByErrorMessage("增加失败");
    }

    @Override
    public ServerResponse showSubject() {
        List<Subject> subjects = subjectMapper.showSubject();
        return ServerResponse.createBySuccess(subjects);
    }

    @Override
    public ServerResponse reviseSubject(Subject subject) {
        int count = subjectMapper.updateByPrimaryKeySelective(subject);
        if(count==1)
            return ServerResponse.createBySuccessMessage("修改成功");
        return ServerResponse.createByErrorMessage("修改失败");
    }

    @Override
    public ServerResponse deleteExam(Integer id) {
        int count = subjectMapper.deleteByPrimaryKey(id);
        if(count==1)
            return ServerResponse.createBySuccessMessage("删除成功");
        return ServerResponse.createByErrorMessage("删除失败");
    }
}

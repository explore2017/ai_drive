package com.explore.service.Impl;

import com.explore.common.Const;
import com.explore.common.ServerResponse;
import com.explore.dao.*;
import com.explore.pojo.Campus;
import com.explore.pojo.Conf;
import com.explore.service.IConfService;
import com.explore.vo.CampusVo;
import com.explore.vo.ConfResponse;
import com.explore.vo.ConfVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author PinTeh
 * @date 2019/5/25
 */
@Service
public class ConfServiceImpl implements IConfService {

    @Autowired
    private ConfMapper confMapper;
    @Autowired
    private CampusMapper campusMapper;
    @Autowired
    private VehicleMapper vehicleMapper;
    @Autowired
    private CoachMapper coachMapper;
    @Autowired
    private SourceMapper sourceMapper;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public ServerResponse save(Conf conf) {
        conf.setCreateTime(new Date());
        conf.setUpdateTime(new Date());
        int count = confMapper.insert(conf);
        if (count==1){
            return ServerResponse.createBySuccessMessage("配置成功");
        }
        return ServerResponse.createByErrorMessage("配置失败");
    }

    @Override
    public ServerResponse update(Conf conf) {
        conf.setUpdateTime(new Date());
        int count  = confMapper.updateByPrimaryKeySelective(conf);
        if (count==1){
            return ServerResponse.createBySuccessMessage("更新成功");
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }

    @Override
    public ServerResponse delete(Integer id) {
        int count  = confMapper.deleteByPrimaryKey(id);
        if (count==1){
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }

    @Override
    public ServerResponse sources() {
        ConfResponse confResponse = new ConfResponse();
        List<Campus> allCampus = campusMapper.getAllCampus();
        List<CampusVo> campusVos = new ArrayList<>();
        for (Campus campus : allCampus) {
            List<ConfVo> confVos = new ArrayList<>();
            //设置车辆
            ConfVo confVo1 = new ConfVo();
            confVo1.setCode(Const.CONF_TYPE.VEHICLE.getCode());
            confVo1.setDesc(Const.CONF_TYPE.VEHICLE.getDesc());
            confVo1.setMax(confMapper.selectMaxCountByTypeAndCampusId(campus.getId(),Const.CONF_TYPE.VEHICLE.getCode()));
            confVo1.setCurrent(vehicleMapper.selectAllCountByCampusId(campus.getId()));
            confVos.add(confVo1);
            //设置资源
            ConfVo confVo2 = new ConfVo();
            confVo2.setCode(Const.CONF_TYPE.SOURCE.getCode());
            confVo2.setDesc(Const.CONF_TYPE.SOURCE.getDesc());
            confVo2.setMax(confMapper.selectMaxCountByTypeAndCampusId(campus.getId(),Const.CONF_TYPE.SOURCE.getCode()));
            confVo2.setCurrent(sourceMapper.selectAllCountByCampusId(campus.getId()));
            confVos.add(confVo2);

            CampusVo campusVo = new CampusVo();
            campusVo.setCampus(campus);
            campusVo.setConfVos(confVos);
            campusVos.add(campusVo);
        }
        confResponse.setCampusVos(campusVos);
        return ServerResponse.createBySuccess(confResponse);
    }

    @Override
    public ServerResponse emp() {
        ConfResponse confResponse = new ConfResponse();
        List<Campus> allCampus = campusMapper.getAllCampus();
        List<CampusVo> campusVos = new ArrayList<>();
        for (Campus campus : allCampus) {
            List<ConfVo> confVos = new ArrayList<>();
            //设置员工
            ConfVo confVo1 = new ConfVo();
            confVo1.setCode(Const.CONF_TYPE.STAFF.getCode());
            confVo1.setDesc(Const.CONF_TYPE.STAFF.getDesc());
            confVo1.setMax(confMapper.selectMaxCountByTypeAndCampusId(campus.getId(),Const.CONF_TYPE.STAFF.getCode()));
            confVo1.setCurrent(staffMapper.selectAllCountByCampusId(campus.getId()));
            confVos.add(confVo1);
            //设置教练
            ConfVo confVo2 = new ConfVo();
            confVo2.setCode(Const.CONF_TYPE.COACH.getCode());
            confVo2.setDesc(Const.CONF_TYPE.COACH.getDesc());
            confVo2.setMax(confMapper.selectMaxCountByTypeAndCampusId(campus.getId(),Const.CONF_TYPE.COACH.getCode()));
            confVo2.setCurrent(coachMapper.selectAllCountByCampusId(campus.getId()));
            confVos.add(confVo2);
            //设置学员
            ConfVo confVo3 = new ConfVo();
            confVo3.setCode(Const.CONF_TYPE.STUDENT.getCode());
            confVo3.setDesc(Const.CONF_TYPE.STUDENT.getDesc());
            confVo3.setMax(confMapper.selectMaxCountByTypeAndCampusId(campus.getId(),Const.CONF_TYPE.STUDENT.getCode()));
            confVo3.setCurrent(studentMapper.selectAllCountByCampusId(campus.getId()));
            confVos.add(confVo3);

            CampusVo campusVo = new CampusVo();
            campusVo.setCampus(campus);
            campusVo.setConfVos(confVos);
            campusVos.add(campusVo);
        }
        confResponse.setCampusVos(campusVos);
        return ServerResponse.createBySuccess(confResponse);
    }
}

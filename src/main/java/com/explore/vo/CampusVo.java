package com.explore.vo;

import com.explore.pojo.Campus;
import lombok.Data;

import java.util.List;

/**
 * @author PinTeh
 * @date 2019/5/25
 */
@Data
public class CampusVo{
    private Campus campus;
    private List<ConfVo> confVos;
}

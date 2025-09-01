package org.oooooomy.controller;

import org.oooooomy.model.vo.ScheduleInventoryVO;
import org.oooooomy.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 班次每日库存表 前端控制器
 * 主要是面向用户的查询接口
 * </p>
 *
 * @author Gao YuanMing
 * @since 2025-08-06
 */
@RestController
@RequestMapping("/schedule/inventory")
public class ScheduleInventoryController {

    /**
     * 学生端根据日期，起始站点查询库存
     *
     * @param day 日期
     * @return R<List<ScheduleInventoryVO>>
     */
    @GetMapping("/getByDay")
    public R<List<ScheduleInventoryVO>> getScheduleById(@RequestParam LocalDate day) {
        return null;
    }

}

package org.oooooomy.controller;

import jakarta.annotation.Resource;
import org.oooooomy.service.ScheduleInventoryService;
import org.oooooomy.service.ScheduleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 班次信息表 前端控制器
 * </p>
 *
 * @author Gao YuanMing
 * @since 2025-08-06
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    //TODO 查询某天的班次
    @Resource
    private ScheduleService scheduleService;

    @Resource
    private ScheduleInventoryService scheduleInventoryService;

}

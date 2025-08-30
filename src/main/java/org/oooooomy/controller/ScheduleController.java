package org.oooooomy.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.oooooomy.model.entity.Schedule;
import org.oooooomy.service.ScheduleService;
import org.oooooomy.utils.R;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 分页查询班次
     *
     * @return R<Page<Schedule>>
     */
    @GetMapping
    public R<Page<Schedule>> getAllSchedules(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<Schedule> page = new Page<>(pageNum, pageSize);
        Page<Schedule> result = scheduleService.page(page);
        return R.ok(result);
    }

    /**
     * 根据id查询班次
     *
     * @param id 查询的班次id
     * @return R<Schedule>
     */
    @GetMapping("/{id}")
    public R<Schedule> getScheduleById(@PathVariable int id) {
        Schedule schedule = scheduleService.getById(id);
        return R.ok(schedule);
    }

    /**
     * 删除班次
     *
     * @param id 删除的班次id
     * @return R<Void>
     */
    @DeleteMapping("/{id}")
    public R<Void> deleteScheduleById(@PathVariable int id) {
        scheduleService.removeById(id);
        return R.ok();
    }

    /**
     * 更新班次
     *
     * @param schedule 班次
     * @return R<Schedule>
     */
    @PutMapping
    public R<Schedule> updateScheduleById(@RequestBody Schedule schedule) {
        scheduleService.updateById(schedule);
        return R.ok(schedule);
    }

}

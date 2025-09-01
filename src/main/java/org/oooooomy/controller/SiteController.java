package org.oooooomy.controller;

import jakarta.annotation.Resource;
import org.oooooomy.model.entity.Site;
import org.oooooomy.service.SiteService;
import org.oooooomy.utils.R;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 站点信息表 前端控制器
 * </p>
 *
 * @author Gao YuanMing
 * @since 2025-08-06
 */
@RestController
@RequestMapping("/site")
public class SiteController {

    @Resource
    private SiteService siteService;

    /**
     * 查询所有站点
     *
     * @return R<List<Site>>
     */
    @GetMapping
    public R<List<Site>> getSite() {
        List<Site> sites = siteService.list();
        return R.ok(sites);
    }

    /**
     * 新增站点
     *
     * @param site 站点
     * @return R<Site>
     */
    @PostMapping
    public R<Site> saveSite(@RequestBody Site site) {
        siteService.save(site);
        return R.ok(site);
    }

    /**
     * 删除站点id
     *
     * @param id 站点id
     * @return R<Void>
     */
    @DeleteMapping("/{id}")
    public R<Void> deleteSite(@PathVariable String id) {
        siteService.removeById(Long.valueOf(id));
        return R.ok();
    }

    /**
     * 更新站点信息
     *
     * @param site 站点信息
     * @return R<Site>
     */
    @PutMapping
    public R<Site> updateSite(@RequestBody Site site) {
        siteService.updateById(site);
        return R.ok(site);
    }

}

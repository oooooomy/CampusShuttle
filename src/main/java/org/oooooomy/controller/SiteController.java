package org.oooooomy.controller;

import jakarta.annotation.Resource;
import org.oooooomy.model.entity.Site;
import org.oooooomy.service.SiteService;
import org.oooooomy.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/listSites")
    public R<List<Site>> getSite() {
        List<Site> sites = siteService.list();
        return R.ok(sites);
    }

}

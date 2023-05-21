package net.yunzhanyi.admin.controller.poetry;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.yunzhanyi.admin.body.PoetryBody;
import net.yunzhanyi.admin.service.PoetryService;
import net.yunzhanyi.common.core.vo.TableDataInfo;
import net.yunzhanyi.domain.pojo.Poetry;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 诗歌控制器
 * @author bestct
 * @date 2023/05/05
 */
@RestController
@RequestMapping("/poetry")
public class PoetryController {

    @Autowired
    private PoetryService poetryService;


    @PostMapping("/list")
    public TableDataInfo poetry(@RequestBody PoetryBody body) {
        PageHelper.startPage(body.getPageNum(), body.getPageSize());
        Poetry poetry = new Poetry();
        BeanUtils.copyProperties(body,poetry);
        System.out.println(poetry);
        List<Poetry> poetryList = poetryService.getList(poetry);
        return TableDataInfo.getDataTable(poetryList,new PageInfo<>(poetryList).getTotal());
    }
}

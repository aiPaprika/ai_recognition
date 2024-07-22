
package ${package.Controller};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;


import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};


#if(${restControllerStyle})
import org.springframework.web.bind.annotation.RestController;
#else
import org.springframework.stereotype.Controller;
#end
#if(${superControllerClassPackage})
import ${superControllerClassPackage};
#end

/**
 * <p>
 * $!{table.comment} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
#if(${restControllerStyle})
@RestController
#else
@Controller
#end
@RequestMapping("#if(${package.ModuleName})/${package.ModuleName}#end/#if(${controllerMappingHyphenStyle})${controllerMappingHyphen}#else${table.entityPath}#end")
#if(${kotlin})
class ${table.controllerName}#if(${superControllerClass}) : ${superControllerClass}()#end


#else
#if(${superControllerClass})
public class ${table.controllerName} extends ${superControllerClass} {
#else
public class ${table.controllerName} {
#end
    @Resource
    private ${table.serviceName} ${table.entityPath}Service;

    //新增或者更新
    @PostMapping
    public ResponseVO<${entity}> save(@RequestBody ${entity} ${table.entityPath}) {
        ${table.entityPath}Service.saveOrUpdate(${table.entityPath});
        return Result.success();
    }


    //删除
    @DeleteMapping("/{id}")
    public ResponseVO<${entity}> delete(@PathVariable Integer id) {
        ${table.entityPath}Service.removeById(id);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public ResponseVO<${entity}> deleteBatch(@RequestBody List<Integer> ids) {//批量删除
        ${table.entityPath}Service.removeByIds(ids);
        return Result.success();
    }

    //查询所有数据
    @GetMapping
    public ResponseVO<${entity}> findAll() {
        return Result.success(${table.entityPath}Service.list());
    }

    @GetMapping("/{id}")
    public ResponseVO<${entity}> findOne(@PathVariable Integer id) {
        return Result.success(${table.entityPath}Service.getById(id));
    }

    @GetMapping("/page")
    public ResponseVO<${table.entity}> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return Result.success(${table.entityPath}Service.page(new Page<>(pageNum, pageSize), queryWrapper));
    }
}

#end
package yody.hacka22.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yody.hacka22.dao.DesignDao;
import yody.hacka22.entity.Design;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("design")
public class DesignController {
    @Autowired
    private DesignDao designDao;

    @PostMapping("save")
    public String save(@RequestBody Design design) {
        designDao.save(design);
        return OK.toString();
    }

    @GetMapping("find")
    public Design getById(@RequestParam("id") String id) {
        return designDao.findById(id).get();
    }
}

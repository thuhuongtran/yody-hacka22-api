package yody.hacka22.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yody.hacka22.dao.DesignShirtDao;
import yody.hacka22.entity.DesignShirt;

import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin
@RequestMapping("shirt")
public class DesignShirtController {
    @Autowired
    private DesignShirtDao designShirtDao;

    @PostMapping("save")
    public String save(@RequestBody DesignShirt designShirt) {
        designShirtDao.save(designShirt);
        return OK.toString();
    }

    @GetMapping("find")
    public DesignShirt getById(@RequestParam("id") String id) {
        return designShirtDao.findById(id).get();
    }
}

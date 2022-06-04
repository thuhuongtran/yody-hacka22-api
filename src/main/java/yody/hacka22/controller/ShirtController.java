package yody.hacka22.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yody.hacka22.dao.ShirtDao;
import yody.hacka22.entity.Shirt;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("shirt")
public class ShirtController {
    @Autowired
    private ShirtDao shirtDao;

    @PostMapping("save")
    public String save(@RequestBody Shirt shirt) {
        shirtDao.save(shirt);
        return OK.toString();
    }

    @GetMapping("find")
    public Shirt getById(@RequestParam("id") String id) {
        return shirtDao.findById(id).get();
    }
}

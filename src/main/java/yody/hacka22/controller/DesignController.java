package yody.hacka22.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yody.hacka22.dao.DesignDao;
import yody.hacka22.entity.Design;
import yody.hacka22.repository.DesignRepository;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("design")
public class DesignController {
    @Autowired
    private DesignDao designDao;
    @Autowired
    private DesignRepository designRepository;

    @PostMapping("save")
    public ResponseEntity<Design> save(@RequestBody Design design) {
        Design response = designDao.save(design);
        if (response != null){
            return ResponseEntity.ok(response);
        }
        return null;
    }

    @GetMapping("find")
    public Design getById(@RequestParam("id") String id) {
        return designDao.findById(id).get();
    }

    @GetMapping("search-decor-image")
    public List<Design> findDecoratedImageByTags(@RequestParam("tags") List<String> tags) {
        return designRepository.searchDesignImageByTags(tags);
    }
}

package yody.hacka22.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import yody.hacka22.dao.DesignDao;
import yody.hacka22.dao.PhotoDao;
import yody.hacka22.entity.Design;
import yody.hacka22.entity.Photo;
import yody.hacka22.repository.DesignRepository;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("design")
public class DesignController {
    @Autowired
    private DesignDao designDao;
    @Autowired
    private DesignRepository designRepository;

    @Autowired
    PhotoDao photoDao;

    @PostMapping("save")
    public ResponseEntity<Design> save(@RequestBody Design design) {
        Design response = designDao.save(design);
        if (response != null) {
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

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @Transactional
    public ResponseEntity<Design> fileUpload(@RequestParam("file") MultipartFile file, @RequestBody Design design) throws IOException {
        // save photo
        Photo photo = new Photo();
        photo.setBytes(file.getBytes());
        Photo response = photoDao.save(photo);

        // save design
        design.setImageBase64(Base64.getEncoder().encodeToString(response.getBytes()));
        Design designResponse = designDao.save(design);
        if (response != null) {
            return ResponseEntity.ok(designResponse);
        }
        return null;
    }

    @GetMapping("list")
    public List<Design> listAllDesigns() {
        return designDao.findAll();
    }

}

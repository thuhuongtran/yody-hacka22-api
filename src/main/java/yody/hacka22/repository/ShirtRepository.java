package yody.hacka22.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import yody.hacka22.dao.ShirtDao;

import java.util.List;

@Repository
public class ShirtRepository {
    @Autowired
    private ShirtDao shirtDao;

    public String searchDesignDecoratedImageByTag(List<String> tags) {
        return "";
    }
}

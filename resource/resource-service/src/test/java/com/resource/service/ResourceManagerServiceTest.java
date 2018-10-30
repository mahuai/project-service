package com.resource.service;


import com.resource.api.entity.request.QueryRequest;
import com.resource.api.entity.request.UploadRequest;
import com.resource.api.entity.response.FileResponse;
import com.resource.api.entity.response.ResourceResponse;
import com.resource.api.exception.ResourceManagerException;
import com.resource.api.service.ResourceManagerService;
import com.resource.service.enmu.ImageType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResourceManagerServiceTest {


    private static final String[] IMAGE_SUFFIX = new String[]{"jpg", "png", "jpeg"};

    @Autowired
    private ResourceManagerService resourceManagerService;

    @Autowired
    private GridFsOperations operations;
    @Autowired
    private MongoDbFactory mongoDbFactory;
    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Test
    public void uploadTest() {
        ResourceResponse resourceResponse = null;
        try {
            UploadRequest request = new UploadRequest("d://image.jpg", "image.jpg", "image/jpeg", new UploadRequest.Metadata(ImageType.CASE_TYPE.getType(), "home case"));
            resourceResponse = resourceManagerService.uploadFile(request);
        } catch (ResourceManagerException e) {
            e.printStackTrace();
        }
        System.out.println("ObjectId----------------->: " + resourceResponse.getObjectId());
        System.out.println("save success");
    }


    @Test
    public void queryTest() {
        QueryRequest queryRequest = new QueryRequest(GridFsCriteria.whereFilename(), "image.jpg");
        List<FileResponse> fileList = resourceManagerService.getConditionsByFiles(queryRequest);
        if (fileList != null) {
            fileList.forEach(file -> {
                System.out.println(file.getFileName());
            });
        }
    }
}


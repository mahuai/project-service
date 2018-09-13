package com.resource.service;


import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.resource.api.entity.request.UploadRequest;
import com.resource.api.entity.response.ResourceResponse;
import com.resource.api.exception.ResourceManagerException;
import com.resource.api.service.ResourceManagerService;
import com.resource.service.enmu.ImageType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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
            UploadRequest request = new UploadRequest("d://image.jpg","image.jpg","image/jpeg", new UploadRequest.Metadata(ImageType.CASE_TYPE.getType(), "home case"));
            resourceResponse = resourceManagerService.uploadFile(request);
        } catch (ResourceManagerException e) {
            e.printStackTrace();
        }
        System.out.println("ObjectId----------------->: " + resourceResponse.getObjectId());
        System.out.println("save success");
    }


    @Test
    public void queryTest() {
//        GridFSFindIterable iterable= operations.find(new Query(GridFsCriteria.whereMetaData("type").is(ImageType.CASE_TYPE.getType())));

        GridFSFile file = operations.findOne(new Query(GridFsCriteria.whereMetaData("type").is(1)));
        GridFSDownloadStream stream = null;

        HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
        try {
            if (file != null) {
                GridFSBucket bucket = GridFSBuckets.create(mongoDbFactory.getDb());
                stream = bucket.openDownloadStream(file.getObjectId());
                response.setContentType("image/png");
                OutputStream out = response.getOutputStream();
                /** chunk size */
                int size = file.getChunkSize();
                int len = (int) file.getLength();
                /** loop time */
                int cnt = len / size + (len % size == 0 ? 0 : 1);
                byte[] bts = new byte[Math.min(len, size)];

                while (cnt-- > 0) {
                    int tmp = stream.read(bts);
                    out.write(bts, 0, tmp);
                }
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

